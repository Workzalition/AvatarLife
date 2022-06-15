package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.platform101xp.sdk.AuthorizationActivity;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import java.util.List;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPPortal implements Platform101XPSocialNetwork {
    private static final Integer SDK_REQUEST_CODE = 13304;
    public static final String SN_PROVIDER = "Portal101XP";
    private String clientId;
    private boolean enabled = false;
    private Context sApplicationContext;
    private Activity sTopActivity;
    private Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener;
    @Inject
    Platform101XPTokenManager tokenManager;

    public String getProvider() {
        return SN_PROVIDER;
    }

    public boolean isNeedGetSocialFriends() {
        return false;
    }

    public void logout() {
    }

    public void updateConfigData() {
    }

    @Inject
    public Platform101XPPortal(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, String str) {
        this.socialNetworkListener = socialNetworkListener;
        this.clientId = str;
        checkEnabled();
    }

    private void checkEnabled() {
        this.enabled = SDK_REQUEST_CODE != null;
    }

    public void authorize() {
        if (!isEnabled()) {
            return;
        }
        Intent intent = new Intent(this.sApplicationContext, AuthorizationActivity.class);
        intent.putExtra(AuthorizationActivity.EXTRA_CLIENT_ID, this.clientId);
        intent.putExtra(AuthorizationActivity.EXTRA_DEVICE_TOKEN_ENABLED, this.tokenManager.isDeviceTokenEnabled());
        this.sTopActivity.startActivityForResult(intent, SDK_REQUEST_CODE.intValue());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != SDK_REQUEST_CODE.intValue()) {
            return;
        }
        if (i2 == -1) {
            if (!intent.hasExtra(AuthorizationActivity.EXTRA_TOKEN)) {
                return;
            }
            this.socialNetworkListener.onResult(this, intent.getStringExtra(AuthorizationActivity.EXTRA_TOKEN), (Platform101XPError) null);
            return;
        }
        this.socialNetworkListener.onResult(this, (String) null, new Platform101XPError(Platform101XPError.ErrorType.ERROR_CANCELED));
    }

    public void onCreate(Activity activity) {
        setActivityContext(activity);
    }

    public void onResume(Activity activity) {
        setActivityContext(activity);
    }

    public void onDestroy(Activity activity) {
        if (this.sTopActivity == activity) {
            this.sTopActivity = null;
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    private void setActivityContext(Activity activity) {
        if (this.sTopActivity != activity) {
            this.sTopActivity = activity;
        }
        if (this.sApplicationContext != null || activity == null) {
            return;
        }
        this.sApplicationContext = activity.getApplicationContext();
    }

    public void getSocialFriends(Platform101XPSNManager.SocialFriendsResultListener socialFriendsResultListener) {
        socialFriendsResultListener.onGetFriendsResult((List) null, new Platform101XPError(new Exception("Getting social friends is't available in this social network!")));
    }

    public void showAuthorizeWarning() {
        Log.d("101XP SDK", "For 101XP Portal not implemented");
    }
}
