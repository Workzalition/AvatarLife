package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Sharer;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.ShareDialog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.entities.Platform101XPSocialFriend;
import com.platform101xp.sdk.internal.Platform101XPSNPost;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONArray;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPFacebook implements Platform101XPSocialNetwork, Platform101XPSocialFunction {
    private static final int API_REQUEST = 25501;
    private static final String INVITE_STRING = "com.facebook.sdk.InviteString";
    private static final String LOG_TAG = "101XP SDK FB";
    public static final String SN_PROVIDER = "Facebook";
    private CallbackManager callbackManager;
    private Platform101XPConfigManager configManager;
    private AccessToken currentToken;
    @Inject
    Platform101XPDialogFactory dialogsFactory;
    private boolean enabled;
    private Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener;
    private boolean isInvite = false;
    private boolean isBlocked = false;
    private ArrayList<Platform101XPSNPost> postsList = new ArrayList<>();
    private final String snPostMetaPrefix = "com.facebook.sdk.fbPost";
    private boolean hasExtraPermission = false;
    private boolean needGetSocialFriends = false;

    public String getProvider() {
        return SN_PROVIDER;
    }

    public boolean isEnabledJoinToGroup() {
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

    @Inject
    public Platform101XPFacebook(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        this.enabled = false;
        this.socialNetworkListener = socialNetworkListener;
        this.configManager = platform101XPConfigManager;
        checkEnabled();
        if (!isEnabled()) {
            return;
        }
        try {
            FacebookSdk.sdkInitialize(Platform101XP.getApplicationContext());
            this.callbackManager = CallbackManager.Factory.create();
            LoginManager.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook.1
                public void onSuccess(LoginResult loginResult) {
                    if (Platform101XPFacebook.this.isInvite) {
                        Platform101XPFacebook.this.sendApplicationInvite();
                    }
                    Platform101XPFacebook.this.currentToken = loginResult.getAccessToken();
                    Platform101XPFacebook.this.socialNetworkListener.onResult(this, Platform101XPFacebook.this.currentToken.getToken(), (Platform101XPError) null);
                }

                public void onCancel() {
                    Platform101XPError platform101XPError = new Platform101XPError(Platform101XPError.ErrorType.ERROR_CANCELED);
                    Platform101XPFacebook.this.isInvite = false;
                    Platform101XPFacebook.this.needGetSocialFriends = false;
                    Platform101XPFacebook.this.socialNetworkListener.onResult(this, (String) null, platform101XPError);
                }

                public void onError(FacebookException facebookException) {
                    Platform101XPError platform101XPError = new Platform101XPError(facebookException);
                    Platform101XPFacebook.this.isInvite = false;
                    Platform101XPFacebook.this.needGetSocialFriends = false;
                    Platform101XPFacebook.this.socialNetworkListener.onResult(this, (String) null, platform101XPError);
                }
            });
            loadSNPosts();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
            this.enabled = false;
        }
    }

    public void authorize() {
        if (!isEnabled()) {
            return;
        }
        checkExtraPermission();
        try {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                this.socialNetworkListener.onResult(this, currentAccessToken.getToken(), (Platform101XPError) null);
            } else {
                LoginManager.getInstance().logInWithReadPermissions(Platform101XP.getCurrentActivity(), this.hasExtraPermission ? Arrays.asList("user_friends, user_photos, public_profile") : Arrays.asList("public_profile"));
            }
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        if (!isEnabled()) {
            return;
        }
        if (!this.needGetSocialFriends) {
            this.currentToken = null;
        }
        try {
            LoginManager.getInstance().logOut();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (i == 75503 || i == 75513) {
                this.socialNetworkListener.onInviteResult(this, (Platform101XPError) null);
            } else if (i == API_REQUEST) {
                this.socialNetworkListener.onInviteResult(this, (Platform101XPError) null);
            } else if (isEnabled()) {
                this.callbackManager.onActivityResult(i, i2, intent);
            }
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void updateConfigData() {
        Platform101XPConfigManager platform101XPConfigManager = this.configManager;
        if (platform101XPConfigManager != null) {
            this.hasExtraPermission = platform101XPConfigManager.getBool(Platform101XPConfigKeyHolder.snExtraPermission, false);
            checkEnabled();
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    private void checkEnabled() {
        Platform101XPConfigManager platform101XPConfigManager = this.configManager;
        String string = platform101XPConfigManager != null ? platform101XPConfigManager.getString(Platform101XPConfigKeyHolder.facebookAppID, "") : null;
        this.enabled = string != null && !string.isEmpty() && !this.isBlocked;
    }

    private void checkExtraPermission() {
        this.hasExtraPermission = this.configManager.getBool(Platform101XPConfigKeyHolder.snExtraPermission, false);
    }

    public boolean isEnabledSendPost() {
        return this.configManager.getInt("com.facebook.sdk.fbPostCount", 0) != 0;
    }

    public void loadSNPosts() {
        if (isEnabledSendPost()) {
            try {
                Integer valueOf = Integer.valueOf(this.configManager.getInt("com.facebook.sdk.fbPostCount", 0));
                Log.d("101XP SDK", "Res fb count -> " + valueOf);
                for (int i = 1; i <= valueOf.intValue(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Res fb i =");
                    sb.append(i);
                    sb.append(" ");
                    Platform101XPConfigManager platform101XPConfigManager = this.configManager;
                    sb.append(platform101XPConfigManager.getString("com.facebook.sdk.fbPost" + i + ".Text", "n"));
                    Log.d("101XP SDK", sb.toString());
                    Platform101XPConfigManager platform101XPConfigManager2 = this.configManager;
                    String string = platform101XPConfigManager2.getString("com.facebook.sdk.fbPost" + i + ".Text", "");
                    Platform101XPConfigManager platform101XPConfigManager3 = this.configManager;
                    String string2 = platform101XPConfigManager3.getString("com.facebook.sdk.fbPost" + i + ".Url", "");
                    Platform101XPConfigManager platform101XPConfigManager4 = this.configManager;
                    String string3 = platform101XPConfigManager4.getString("com.facebook.sdk.fbPost" + i + ".Img", "");
                    if (!string.isEmpty() && !string2.isEmpty() && !string3.isEmpty()) {
                        this.postsList.add(new Platform101XPSNPost(string.toString(), string2.toString(), string3.toString()));
                    } else {
                        Log.d(LOG_TAG, "com.facebook.sdk.fbPost" + i + " post data is null");
                        new Exception("101XP SDK FBcom.facebook.sdk.fbPost" + i + " post data is null");
                    }
                }
                return;
            } catch (Exception e) {
                Log.d(LOG_TAG, e.getMessage());
                return;
            }
        }
        new Exception("101XP SDK FB nothing to post");
    }

    public void sendPost(Integer num) {
        if (AccessToken.getCurrentAccessToken() != null) {
            CallbackManager create = CallbackManager.Factory.create();
            ShareDialog shareDialog = new ShareDialog(Platform101XP.getCurrentActivity());
            shareDialog.registerCallback(create, new FacebookCallback<Sharer.Result>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook.2
                public void onCancel() {
                }

                public void onError(FacebookException facebookException) {
                }

                public void onSuccess(Sharer.Result result) {
                }
            }, (int) API_REQUEST);
            if (!ShareDialog.canShow(ShareLinkContent.class)) {
                return;
            }
            if (this.postsList.size() >= num.intValue()) {
                Platform101XPSNPost platform101XPSNPost = this.postsList.get(num.intValue() - 1);
                Uri parse = Uri.parse(platform101XPSNPost.getUrl());
                Uri parse2 = Uri.parse(platform101XPSNPost.getPicUrl());
                if (!parse.toString().isEmpty() && !parse2.toString().isEmpty()) {
                    shareDialog.show(new ShareLinkContent.Builder().setContentDescription(platform101XPSNPost.getText()).setContentUrl(parse).setImageUrl(parse2).build());
                    return;
                } else if (!parse.toString().isEmpty() && parse2.toString().isEmpty()) {
                    shareDialog.show(new ShareLinkContent.Builder().setContentDescription(platform101XPSNPost.getText()).setContentUrl(parse).build());
                    return;
                } else {
                    Log.d(LOG_TAG, "Post #" + num + " is invalid");
                    new Exception("101XP SDK FBPost #" + num + " is invalid");
                    return;
                }
            }
            Log.d(LOG_TAG, " id=" + num + " out of range post number");
            new Exception("101XP SDK FB id=" + num + " out of range post number");
        }
    }

    public boolean isEnabledInviteFriends() {
        return AccessToken.getCurrentAccessToken() != null;
    }

    public void inviteFriendsShowDialog() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "user_id,name,picture,id");
        bundle.putString("limit", "1000");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/invitable_friends", bundle, HttpMethod.GET, new GraphRequest.Callback() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook.3
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    String string = graphResponse.getJSONObject().getString("data");
                    Intent intent = new Intent(Platform101XP.getApplicationContext(), Platform101XPInviteActivity.class);
                    intent.putExtra("friends_response", string);
                    intent.putExtra(IronSourceConstants.EVENTS_PROVIDER, Platform101XPFacebook.this.getProvider());
                    intent.putExtra(TapjoyAuctionFlags.AUCTION_TYPE, Platform101XPSNType.FACEBOOK.ordinal());
                    intent.putExtra(Platform101XPConfigKeyHolder.inviteMessage, Platform101XPFacebook.this.configManager.getString(Platform101XPFacebook.INVITE_STRING, ""));
                    Platform101XP.getCurrentActivity().startActivity(intent);
                } catch (Exception e) {
                    PrintStream printStream = System.out;
                    printStream.println("Exception=" + e);
                    e.printStackTrace();
                }
            }
        }).executeAsync();
    }

    public void sendApplicationInvite() {
        if (AccessToken.getCurrentAccessToken() == null) {
            this.isInvite = true;
            authorize();
            return;
        }
        String string = this.configManager.getString(INVITE_STRING, "");
        GameRequestDialog gameRequestDialog = new GameRequestDialog(Platform101XP.getCurrentActivity());
        GameRequestContent.Builder message = new GameRequestContent.Builder().setMessage(string);
        GameRequestContent build = message.setData("referral_user_id" + AccessToken.getCurrentAccessToken().getUserId()).build();
        if (!GameRequestDialog.canShow()) {
            return;
        }
        gameRequestDialog.registerCallback(this.callbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook.4
            public void onSuccess(GameRequestDialog.Result result) {
                Log.d("101XP SDK", "OnSuccess: " + result.getRequestRecipients());
                Platform101XPFacebook.this.socialNetworkListener.onInviteResult(Platform101XPFacebook.this, (Platform101XPError) null);
            }

            public void onCancel() {
                Log.d("101XP SDK", "OnCancel");
                Platform101XPFacebook.this.socialNetworkListener.onInviteResult(Platform101XPFacebook.this, (Platform101XPError) null);
            }

            public void onError(FacebookException facebookException) {
                Log.d("101XP SDK", "OnError: " + facebookException);
                Platform101XPFacebook.this.socialNetworkListener.onInviteResult(Platform101XPFacebook.this, new Platform101XPError(facebookException));
            }
        });
        gameRequestDialog.show(build);
        this.isInvite = false;
    }

    public void getSocialFriends(final Platform101XPSNManager.SocialFriendsResultListener socialFriendsResultListener) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "name, picture, id");
        GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook.5
            public void onCompleted(GraphResponse graphResponse) {
                if (graphResponse.getError() != null) {
                    socialFriendsResultListener.onGetFriendsResult((List) null, new Platform101XPError(new Exception(graphResponse.getError().getErrorMessage())));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = graphResponse.getJSONObject().optJSONArray("data");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(new Platform101XPSocialFriend(optJSONArray.optJSONObject(i).optString(TapjoyAuctionFlags.AUCTION_ID), optJSONArray.optJSONObject(i).optString("name"), optJSONArray.optJSONObject(i).optJSONObject("picture").optJSONObject("data").optString(TJAdUnitConstants.String.URL), 0L, 0));
                }
                socialFriendsResultListener.onGetFriendsResult(arrayList, (Platform101XPError) null);
            }
        };
        if (AccessToken.getCurrentAccessToken() != null) {
            this.currentToken = AccessToken.getCurrentAccessToken();
        }
        if (this.currentToken == null) {
            this.needGetSocialFriends = true;
            authorize();
            return;
        }
        this.needGetSocialFriends = false;
        AccessToken accessToken = this.currentToken;
        new GraphRequest(accessToken, "/" + this.currentToken.getUserId() + "/friends", bundle, HttpMethod.GET, callback).executeAsync();
    }

    public boolean isNeedGetSocialFriends() {
        return this.needGetSocialFriends;
    }

    public void showAuthorizeWarning() {
        this.needGetSocialFriends = false;
        this.dialogsFactory.getProgressDialog().dismiss();
        logout();
        Dialog warningDialog = this.dialogsFactory.getWarningDialog(Platform101XPWarningDialogs.WarningType.FACEBOOK_WARNING, null);
        if (warningDialog != null) {
            warningDialog.show();
        }
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }
}
