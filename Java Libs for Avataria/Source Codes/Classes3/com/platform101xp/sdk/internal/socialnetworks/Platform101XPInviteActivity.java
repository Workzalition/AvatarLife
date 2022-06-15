package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.widget.GameRequestDialog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.api.model.Platform101XPModelInvite;
import com.platform101xp.sdk.api.model.Platform101XPModelInviteFB;
import com.platform101xp.sdk.api.model.Platform101XPModelInviteOK;
import com.platform101xp.sdk.api.model.Platform101XPModelInviteVK;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.tapjoy.TapjoyAuctionFlags;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.VKApiCallback;
import com.vk.api.sdk.requests.VKRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.ok.android.sdk.Odnoklassniki;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPInviteActivity extends Activity {
    private static final String INVITE_STRING = "com.facebook.sdk.InviteString";
    private String inviteMessage;
    private String provider;
    private Platform101XPSNType snType;
    private ArrayList<Platform101XPModelInvite> invitesList = new ArrayList<>();
    private final String LOG_TAG = "101XP SDK Invite";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_invite);
        this.provider = getIntent().getStringExtra(IronSourceConstants.EVENTS_PROVIDER);
        this.snType = Platform101XPSNType.fromOrdinal(getIntent().getIntExtra(TapjoyAuctionFlags.AUCTION_TYPE, -1));
        this.inviteMessage = getIntent().getStringExtra(Platform101XPConfigKeyHolder.inviteMessage);
        setProviderView(this.provider);
        parseFriendInvites(getIntent().getStringExtra("friends_response"), getIntent().getStringExtra("app_users"));
        refreshList();
    }

    private void setProviderView(String str) {
        try {
            if (this.snType == null) {
                return;
            }
            Button button = (Button) findViewById(R.id.button_title);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.invite_title_bar);
            if (this.snType == Platform101XPSNType.VK) {
                button.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.header_logo_vk, 0, 0, 0);
                linearLayout.setBackgroundResource(R.drawable.gradient_title_vk);
            }
            if (this.snType == Platform101XPSNType.FACEBOOK) {
                button.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.header_logo_fb, 0, 0, 0);
                linearLayout.setBackgroundResource(R.drawable.gradient_title_fb);
            }
            if (this.snType != Platform101XPSNType.OK) {
                return;
            }
            button.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.header_logo_ok, 0, 0, 0);
            linearLayout.setBackgroundResource(R.drawable.gradient_title_ok);
        } catch (Exception e) {
            Log.d("101XP SDK Invite", e.getMessage().toString());
        }
    }

    private void parseFriendInvites(String str, String str2) {
        Platform101XPSNType platform101XPSNType = this.snType;
        if (platform101XPSNType != null) {
            if (platform101XPSNType == Platform101XPSNType.VK) {
                parseFriendInvitesVK(str);
            }
            if (this.snType == Platform101XPSNType.FACEBOOK) {
                parseFriendInvitesFB(str);
            }
            if (this.snType != Platform101XPSNType.OK) {
                return;
            }
            parseFriendInvitesOK(str, str2);
        }
    }

    private void parseFriendInvitesVK(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Platform101XPModelInviteVK platform101XPModelInviteVK = new Platform101XPModelInviteVK();
                platform101XPModelInviteVK.parse(jSONObject);
                this.invitesList.add(platform101XPModelInviteVK);
            }
        } catch (Exception e) {
            Log.d("101XP SDK Invite", e.getMessage());
        }
    }

    private void parseFriendInvitesFB(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Platform101XPModelInviteFB platform101XPModelInviteFB = new Platform101XPModelInviteFB();
                platform101XPModelInviteFB.parse(jSONObject);
                this.invitesList.add(platform101XPModelInviteFB);
            }
        } catch (Exception e) {
            Log.d("101XP SDK Invite", e.getMessage());
        }
    }

    private void parseFriendInvitesOK(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Platform101XPModelInviteOK platform101XPModelInviteOK = new Platform101XPModelInviteOK();
                platform101XPModelInviteOK.parse(jSONObject);
                if (str2.indexOf(platform101XPModelInviteOK.uId) > -1) {
                    platform101XPModelInviteOK.invited = true;
                }
                this.invitesList.add(platform101XPModelInviteOK);
            }
        } catch (Exception e) {
            Log.d("101XP SDK Invite", e.getMessage());
        }
    }

    private void refreshList() {
        inviteAdapter inviteadapter = new inviteAdapter(this, this.invitesList);
        ListView listView = (ListView) findViewById(R.id.inviteListView);
        ((TextView) findViewById(R.id.friends_count)).setText(this.invitesList.size() + " ДРУЗЕЙ");
        ((ImageButton) findViewById(R.id.button_close)).setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPInviteActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Platform101XPInviteActivity.this.setResult(-1, new Intent());
                Platform101XPInviteActivity.this.finish();
            }
        });
        listView.setAdapter((ListAdapter) inviteadapter);
        listView.setClickable(true);
        listView.setItemsCanFocus(false);
    }

    public void inviteFriend(View view, String str) {
        Platform101XPSNType platform101XPSNType = this.snType;
        if (platform101XPSNType != null) {
            if (platform101XPSNType == Platform101XPSNType.VK) {
                inviteFriendVK(view, str);
            }
            if (this.snType == Platform101XPSNType.FACEBOOK) {
                inviteFriendFB(view, str);
            }
            if (this.snType != Platform101XPSNType.OK) {
                return;
            }
            inviteFriendOK(view, str);
            ((ImageButton) view.findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.button_accepted);
            ((ImageButton) view.findViewById(R.id.inviteButton)).setClickable(false);
        }
    }

    public void inviteFriendVK(final View view, String str) {
        VKRequest vKRequest = new VKRequest("apps.sendRequest");
        vKRequest.addParam(Platform101XPAnalyticsFirebase.PROPERTY_USER_ID, str);
        vKRequest.addParam(TapjoyAuctionFlags.AUCTION_TYPE, "invite");
        VK.execute(vKRequest, new VKApiCallback<String>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPInviteActivity.2
            public void fail(Exception exc) {
                Log.d("101XP SDK Invite", exc.getMessage());
            }

            public void success(String str2) {
                Log.d("101XP SDK Invite", "VK invite Friend result: " + str2);
                try {
                    if (str2 != null) {
                        ((ImageButton) view.findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.button_accepted);
                        ((ImageButton) view.findViewById(R.id.inviteButton)).setClickable(false);
                        Intent intent = new Intent();
                        intent.putExtra("response", str2);
                        Platform101XP.onActivityResult(75501, -1, intent);
                    } else {
                        Log.d("101XP SDK Invite", "VK invite Friend result is null");
                        Intent intent2 = new Intent();
                        intent2.putExtra("response", "VK invite Friend result is null");
                        Platform101XP.onActivityResult(75511, 0, intent2);
                    }
                } catch (Exception e) {
                    Log.d("101XP SDK Invite", e.getMessage());
                    Intent intent3 = new Intent();
                    intent3.putExtra("response", e.getMessage());
                    Platform101XP.onActivityResult(75511, 0, intent3);
                }
            }
        });
    }

    public void inviteFriendFB(View view, String str) {
        AccessToken.getCurrentAccessToken();
        CallbackManager create = CallbackManager.Factory.create();
        GameRequestDialog gameRequestDialog = new GameRequestDialog(this);
        gameRequestDialog.registerCallback(create, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPInviteActivity.3
            public void onSuccess(GameRequestDialog.Result result) {
                Log.d("101XP SDK Invite", result.toString());
            }

            public void onCancel() {
                Log.d("101XP SDK Invite", "cancel");
            }

            public void onError(FacebookException facebookException) {
                Log.d("101XP SDK Invite", "err");
            }
        });
        gameRequestDialog.show(new GameRequestContent.Builder().setMessage(this.inviteMessage).setTo(str).build());
    }

    public void inviteFriendOK(View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("uids", str);
        hashMap.put("devices", "ANDROID, IOS");
        new InviteFriendOKTask().execute(hashMap);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.provider.equals(Platform101XPFacebook.SN_PROVIDER)) {
            if (i2 == -1) {
                Platform101XP.onActivityResult(75503, i, intent);
                ((ImageButton) findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.button_accepted);
                ((ImageButton) findViewById(R.id.inviteButton)).setClickable(false);
                return;
            }
            Platform101XP.onActivityResult(75513, i, intent);
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class InviteFriendOKTask extends AsyncTask<HashMap<String, String>, Void, String> {
        protected InviteFriendOKTask() {
            Platform101XPInviteActivity.this = r1;
        }

        public String doInBackground(HashMap<String, String>... hashMapArr) {
            try {
                return Odnoklassniki.getInstance().request("friends.appInvite", hashMapArr[0], (Set) null);
            } catch (Exception e) {
                Log.e(Platform101XPOK.SN_PROVIDER, "Failed to get friends", e);
                return null;
            }
        }

        public void onPostExecute(String str) {
            if (str != null) {
                try {
                    Log.d("101XP SDK Invite", str);
                    Intent intent = new Intent();
                    intent.putExtra("response", str);
                    if (str.indexOf("error_msg") > -1) {
                        Platform101XP.onActivityResult(75512, -1, intent);
                    } else {
                        Platform101XP.onActivityResult(75502, -1, intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class inviteAdapter extends BaseAdapter {
        Context ctx;
        LayoutInflater lInflater;
        ArrayList<Platform101XPModelInvite> objects;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        inviteAdapter(Context context, ArrayList<Platform101XPModelInvite> arrayList) {
            Platform101XPInviteActivity.this = r1;
            this.ctx = context;
            this.objects = arrayList;
            this.lInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.objects.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.objects.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.lInflater.inflate(R.layout.cell_invite, viewGroup, false);
            }
            final Platform101XPModelInvite inviteItem = getInviteItem(i);
            ((TextView) view.findViewById(R.id.inviteListName)).setText(inviteItem.lastName + " " + inviteItem.firstName);
            if (Platform101XPInviteActivity.this.provider != null && Platform101XPInviteActivity.this.provider.equals(Platform101XPOK.SN_PROVIDER)) {
                ((ImageButton) view.findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.ok_button_invite);
            } else {
                ((ImageButton) view.findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.blue_button_invite);
            }
            if (inviteItem.invited) {
                ((ImageButton) view.findViewById(R.id.inviteButton)).setBackgroundResource(R.mipmap.button_accepted);
                ((ImageButton) view.findViewById(R.id.inviteButton)).setClickable(false);
            } else {
                ((ImageButton) view.findViewById(R.id.inviteButton)).setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPInviteActivity.inviteAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Platform101XPInviteActivity.this.inviteFriend(view2, inviteItem.uId);
                    }
                });
            }
            if (Platform101XP.getCurrentActivity() != null) {
                Picasso.get().load(inviteItem.picture).transform(new RoundedTransformation(90, 0)).into((ImageView) view.findViewById(R.id.userImage));
            }
            return view;
        }

        Platform101XPModelInvite getInviteItem(int i) {
            return (Platform101XPModelInvite) getItem(i);
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    class CircleTransform implements Transformation {
        @Override // com.squareup.picasso.Transformation
        public String key() {
            return "circle";
        }

        CircleTransform() {
            Platform101XPInviteActivity.this = r1;
        }

        @Override // com.squareup.picasso.Transformation
        public Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float f = min / 2.0f;
            canvas.drawCircle(f, f, f, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class RoundedTransformation implements Transformation {
        private final int margin;
        private final int radius;

        @Override // com.squareup.picasso.Transformation
        public String key() {
            return "rounded";
        }

        public RoundedTransformation(int i, int i2) {
            Platform101XPInviteActivity.this = r1;
            this.radius = i;
            this.margin = i2;
        }

        @Override // com.squareup.picasso.Transformation
        public Bitmap transform(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i = this.margin;
            RectF rectF = new RectF(i, i, bitmap.getWidth() - this.margin, bitmap.getHeight() - this.margin);
            int i2 = this.radius;
            canvas.drawRoundRect(rectF, i2, i2, paint);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
    }
}
