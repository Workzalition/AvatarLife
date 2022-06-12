package com.platform101xp.sdk.api.method;

import com.platform101xp.sdk.Platform101XPToken;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModelAccount;
import com.platform101xp.sdk.api.model.Platform101XPModelData;
import com.platform101xp.sdk.api.model.Platform101XPModelSocialFriends;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigData;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import com.tapjoy.TapjoyConstants;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApiData {
    private String getBaseURL() {
        return Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? "https://portal-api-stage.101xp.com/" : "https://api.101xp.com/";
    }

    public Platform101XPHttpRequest account(Platform101XPToken platform101XPToken) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, platform101XPToken.getAccessToken().getId());
        return new Platform101XPHttpRequest(getBaseURL() + "account", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelAccount.class);
    }

    public Platform101XPHttpRequest socialFriends(Platform101XPToken platform101XPToken, String str, String str2) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, platform101XPToken.getAccessToken().getId());
        platform101XPParameters.addParameter(TapjoyConstants.TJC_PLATFORM, platform101XPToken.getProvider().toLowerCase());
        platform101XPParameters.addArrayParameter("ids[]", str.split(","));
        platform101XPParameters.addParameter("game_id", str2);
        return new Platform101XPHttpRequest(getBaseURL() + "users/social-friends", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelSocialFriends.class);
    }

    public Platform101XPHttpRequest changeFlashToken(String str, String str2, String str3, boolean z) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter("token", str);
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str2);
        platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID, str3);
        if (z) {
            platform101XPParameters.addParameter("grant_type", "mobile_app_auth");
        }
        return new Platform101XPHttpRequest(getBaseURL() + "flash/tokens", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelToken.class);
    }

    public Platform101XPHttpRequest geoIp() {
        return new Platform101XPHttpRequest("https://101xp.com/geoip", null, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelData.class);
    }
}
