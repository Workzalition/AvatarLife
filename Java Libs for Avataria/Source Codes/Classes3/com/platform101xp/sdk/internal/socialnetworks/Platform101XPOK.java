package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.internal.Platform101XPSNPost;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Odnoklassniki;
import ru.ok.android.sdk.OkAuthListener;
import ru.ok.android.sdk.OkListener;
import ru.ok.android.sdk.util.OkAuthType;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPOK implements Platform101XPSocialNetwork, Platform101XPSocialFunction {
    private static final int CANCEL_ERROR_CODE = -1;
    public static final String SN_PROVIDER = "Odnoklassniki";
    private Platform101XPConfigManager configManager;
    protected Odnoklassniki odnoklassniki;
    private String okAppId;
    private String okAppKey;
    private String okRedirectUrl;
    private Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener;
    private final String LOG_TAG = "101XP SDK OK";
    private boolean enabled = false;
    private boolean valid_token = false;
    private String app_users = "";
    private ArrayList<Platform101XPSNPost> postsList = new ArrayList<>();
    private final String snPostMetaPrefix = "ru.ok.sdk.okPost";
    private Context context = Platform101XP.getCurrentActivity();

    public String getProvider() {
        return SN_PROVIDER;
    }

    public boolean isEnabledJoinToGroup() {
        return false;
    }

    public boolean isNeedGetSocialFriends() {
        return false;
    }

    public void joinToGroup() {
    }

    public void onCreate(Activity activity) {
    }

    public void onDestroy(Activity activity) {
    }

    public void onResume(Activity activity) {
    }

    public void sendApplicationInvite() {
    }

    @Inject
    public Platform101XPOK(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        this.configManager = platform101XPConfigManager;
        this.socialNetworkListener = socialNetworkListener;
        checkEnabled();
        if (!isEnabled()) {
            return;
        }
        try {
            this.odnoklassniki = Odnoklassniki.createInstance(this.context, this.okAppId, this.okAppKey);
            loadSNPosts();
            validateToken();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void authorize() {
        if (!isEnabled()) {
            return;
        }
        try {
            this.odnoklassniki.requestAuthorization(Platform101XP.getCurrentActivity(), this.okRedirectUrl, OkAuthType.ANY, new String[]{"VALUABLE_ACCESS", "LONG_ACCESS_TOKEN"});
        } catch (Exception e) {
            Log.d("101XP SDK", new Platform101XPError(e).getApiError().message);
        }
    }

    public void logout() {
        if (!isEnabled()) {
            return;
        }
        try {
            this.odnoklassniki.clearTokens();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 75502 || i == 75512) {
            sendInviteResult();
        }
        if (!isEnabled() || !this.odnoklassniki.isActivityRequestOAuth(i)) {
            return;
        }
        this.odnoklassniki.onAuthActivityResult(i, i2, intent, getAuthListener());
    }

    private void sendInviteResult() {
        this.socialNetworkListener.onInviteResult(this, (Platform101XPError) null);
    }

    private void sendInviteError(Platform101XPError platform101XPError) {
        this.socialNetworkListener.onInviteResult(this, platform101XPError);
    }

    public void updateConfigData() {
        if (this.configManager != null) {
            checkEnabled();
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    private void checkEnabled() {
        String str;
        this.okAppId = this.configManager.getString(Platform101XPConfigKeyHolder.okAppId, "");
        this.okAppKey = this.configManager.getString(Platform101XPConfigKeyHolder.okAppKey, "");
        this.okRedirectUrl = this.configManager.getString(Platform101XPConfigKeyHolder.okAppRedirectUrl, "");
        String str2 = this.okAppId;
        this.enabled = str2 != null && !str2.isEmpty() && (str = this.okAppKey) != null && !str.isEmpty();
    }

    public boolean isEnabledSendPost() {
        return this.configManager.getInt("ru.ok.sdk.okPostCount", 0) != 0 && this.valid_token;
    }

    public void loadSNPosts() {
        if (isEnabledSendPost()) {
            try {
                Integer valueOf = Integer.valueOf(this.configManager.getInt("ru.ok.sdk.okPostCount", 0));
                for (int i = 1; i <= valueOf.intValue(); i++) {
                    Platform101XPConfigManager platform101XPConfigManager = this.configManager;
                    String string = platform101XPConfigManager.getString("ru.ok.sdk.okPost" + i + ".Text", "");
                    Platform101XPConfigManager platform101XPConfigManager2 = this.configManager;
                    String string2 = platform101XPConfigManager2.getString("ru.ok.sdk.okPost" + i + ".Url", "");
                    Platform101XPConfigManager platform101XPConfigManager3 = this.configManager;
                    String string3 = platform101XPConfigManager3.getString("ru.ok.sdk.okPost" + i + ".Img", "");
                    if (!string.isEmpty() && !string2.isEmpty() && !string3.isEmpty()) {
                        this.postsList.add(new Platform101XPSNPost(string.toString(), string2.toString(), string3.toString()));
                        Log.d("101XP SDK OK", "ru.ok.sdk.okPost" + i + " post added");
                    } else {
                        Log.d("101XP SDK OK", "ru.ok.sdk.okPost" + i + " post data is null");
                        new Exception("101XP SDK OKru.ok.sdk.okPost" + i + " post data is null");
                    }
                }
                return;
            } catch (Exception e) {
                Log.d("101XP SDK OK", e.getMessage());
                return;
            }
        }
        new Exception("101XP SDK OK nothing to post");
    }

    public void sendPost(Integer num) {
        if (!isEnabledSendPost() || this.postsList.size() < num.intValue()) {
            return;
        }
        Platform101XPSNPost platform101XPSNPost = this.postsList.get(num.intValue() - 1);
        try {
            Odnoklassniki odnoklassniki = this.odnoklassniki;
            Activity currentActivity = Platform101XP.getCurrentActivity();
            odnoklassniki.performPosting(currentActivity, "{\"media\":[{\"type\":\"text\",\"text\":\"" + platform101XPSNPost.getText() + "\"}]}", false, (HashMap) null);
        } catch (Exception e) {
            Log.d("101XP SDK", new Platform101XPError(e).getApiError().message);
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    protected final class GetUploadPhoto extends AsyncTask<Void, Void, String> {
        public void onPostExecute(String str) {
        }

        protected GetUploadPhoto() {
            Platform101XPOK.this = r1;
        }

        public String doInBackground(Void... voidArr) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("count", TapjoyAuctionFlags.AUCTION_TYPE_FIRST_PRICE);
                return Platform101XPOK.this.odnoklassniki.request("photosV2.getUploadUrl", hashMap, (Set) null);
            } catch (Exception e) {
                Log.e(Platform101XPOK.SN_PROVIDER, "Failed to get photo url", e);
                return null;
            }
        }
    }

    public boolean isEnabledInviteFriends() {
        return this.valid_token;
    }

    public void inviteFriendsShowDialog() {
        if (isEnabledInviteFriends()) {
            try {
                new GetAppUsersTask().execute(new Void[0]);
            } catch (Exception e) {
                sendInviteError(new Platform101XPError(e));
            }
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public final class GetFriendsTask extends AsyncTask<Void, Void, String> {
        protected GetFriendsTask() {
            Platform101XPOK.this = r1;
        }

        public String doInBackground(Void... voidArr) {
            try {
                return Platform101XPOK.this.odnoklassniki.request("friends.get", (Map) null, (Set) null);
            } catch (Exception e) {
                Log.e(Platform101XPOK.SN_PROVIDER, "Failed to get friends", e);
                return null;
            }
        }

        public void onPostExecute(String str) {
            if (str != null) {
                try {
                    Platform101XPOK.this.onFriendsGet(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    protected final class GetAppUsersTask extends AsyncTask<Void, Void, String> {
        protected GetAppUsersTask() {
            Platform101XPOK.this = r1;
        }

        public String doInBackground(Void... voidArr) {
            try {
                return Platform101XPOK.this.odnoklassniki.request("friends.getAppUsers", (Map) null, (Set) null);
            } catch (Exception e) {
                Log.e(Platform101XPOK.SN_PROVIDER, "Failed to get AppUsers", e);
                return null;
            }
        }

        public void onPostExecute(String str) {
            if (str != null) {
                try {
                    Platform101XPOK.this.onAppUsersGet(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public class GetUsersInfoTask extends AsyncTask<HashMap<String, String>, Void, String> {
        protected GetUsersInfoTask() {
            Platform101XPOK.this = r1;
        }

        public void onPostExecute(String str) {
            if (str != null) {
                try {
                    Platform101XPOK.this.onGetUsersInfo(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public String doInBackground(HashMap<String, String>... hashMapArr) {
            try {
                return Platform101XPOK.this.odnoklassniki.request("users.getInfo", hashMapArr[0], (Set) null);
            } catch (Exception e) {
                Log.e(Platform101XPOK.SN_PROVIDER, "Failed to get UserInfo", e);
                return null;
            }
        }
    }

    public void onFriendsGet(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray(str);
        String str2 = "";
        int i = 0;
        while (i < jSONArray.length()) {
            str2 = str2 + jSONArray.getString(i);
            if (i < jSONArray.length() - 1) {
                str2 = str2 + ",";
            }
            i++;
        }
        if (i > 0) {
            hashMap.put("uids", str2);
            hashMap.put("fields", "first_name,last_name,pic_1");
            hashMap.put("emptyPictures", "false");
            new GetUsersInfoTask().execute(hashMap);
            return;
        }
        sendInviteError(new Platform101XPError(new Exception("no users to invite")));
    }

    public void onAppUsersGet(String str) throws JSONException {
        Log.d("101XP SDK OK", str);
        this.app_users = new JSONObject(str).getString("uids");
        new GetFriendsTask().execute(new Void[0]);
    }

    public void onGetUsersInfo(String str) throws JSONException {
        Log.d("101XP SDK OK", str);
        JSONArray jSONArray = new JSONArray(str);
        Intent intent = new Intent(Platform101XP.getApplicationContext(), Platform101XPInviteActivity.class);
        intent.putExtra("friends_response", jSONArray.toString());
        intent.putExtra(IronSourceConstants.EVENTS_PROVIDER, getProvider());
        intent.putExtra("app_users", this.app_users);
        intent.putExtra(TapjoyAuctionFlags.AUCTION_TYPE, Platform101XPSNType.OK.ordinal());
        Platform101XP.getCurrentActivity().startActivity(intent);
    }

    void validateToken() {
        this.odnoklassniki.checkValidTokens(new OkListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPOK.1
            public void onSuccess(JSONObject jSONObject) {
                Platform101XPOK.this.valid_token = true;
            }

            public void onError(String str) {
                Platform101XPOK.this.valid_token = false;
            }
        });
    }

    private OkAuthListener getAuthListener() {
        return new OkAuthListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPOK.2
            public void onCancel(String str) {
                Platform101XPOK.this.socialNetworkListener.onResult(this, (String) null, new Platform101XPError(-1, str, Platform101XPError.ErrorType.ERROR_CANCELED));
            }

            public void onSuccess(JSONObject jSONObject) {
                try {
                    Platform101XPOK.this.socialNetworkListener.onResult(this, jSONObject.getString(Platform101XPTokenManager.KEY_ACCESS_TOKEN), (Platform101XPError) null);
                    Platform101XPOK.this.validateToken();
                } catch (Exception e) {
                    Platform101XPOK.this.socialNetworkListener.onResult(this, (String) null, new Platform101XPError(e));
                }
            }

            public void onError(String str) {
                Platform101XPOK.this.socialNetworkListener.onResult(this, (String) null, new Platform101XPError(new Exception(str)));
            }
        };
    }

    public void getSocialFriends(Platform101XPSNManager.SocialFriendsResultListener socialFriendsResultListener) {
        socialFriendsResultListener.onGetFriendsResult((List) null, new Platform101XPError(new Exception("Getting social friends is't available in this social network!")));
    }

    public void showAuthorizeWarning() {
        Log.d("101XP SDK", "For Odnoklassniki not implemented");
    }
}
