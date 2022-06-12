package com.platform101xp.sdk.api.method;

import com.platform101xp.sdk.Platform101XPToken;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModelEmpty;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.api.model.Platform101XPModelTokensMobile;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.Platform101XPUtils;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigData;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApiAuth {
    private static final String PARAMETER_SIGN = "LNBMrFMDSiQvgMRk4ejCmYddoJYJjRBuOiGEOIeqoR4NmbURvUhxzCvE9FPJYonT";

    public static String getParameterSign() {
        return PARAMETER_SIGN;
    }

    private String getBaseURL() {
        return Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? "https://portal-auth-stage.101xp.com/" : "https://auth.101xp.com/";
    }

    public Platform101XPHttpRequest signin(String str, String str2, String str3, String str4, boolean z) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str);
        platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID, str2);
        platform101XPParameters.addParameter("username", str3);
        platform101XPParameters.addParameter("password", str4);
        if (z) {
            platform101XPParameters.addParameter("grant_type", "mobile_password");
        }
        platform101XPParameters.addParameter("locale", Platform101XPUtils.getLocale());
        return new Platform101XPHttpRequest(getBaseURL() + "signin", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelToken.class);
    }

    public Platform101XPHttpRequest guestSignin(String str, String str2, String str3, boolean z) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str);
        platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID, str2);
        platform101XPParameters.addParameter("fingerprint", str3);
        platform101XPParameters.addParameter("sign", PARAMETER_SIGN);
        platform101XPParameters.addParameter("locale", Platform101XPUtils.getLocale());
        if (z) {
            platform101XPParameters.addParameter("grant_type", "mobile_guest");
        }
        return new Platform101XPHttpRequest(getBaseURL() + "signin/guest", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelToken.class);
    }

    public Platform101XPHttpRequest signup(String str, String str2, String str3, String[] strArr, boolean z, String str4) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID, str);
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str4);
        platform101XPParameters.addParameter("email", str2);
        platform101XPParameters.addParameter("username", str3);
        platform101XPParameters.addParameter("password", strArr[0]);
        platform101XPParameters.addParameter("password_confirm", strArr[1]);
        platform101XPParameters.addParameter("locale", Platform101XPUtils.getLocale());
        if (z) {
            platform101XPParameters.addParameter("generate", "yes");
        }
        return new Platform101XPHttpRequest(getBaseURL() + "signup", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelEmpty.class);
    }

    public Platform101XPHttpRequest refresh(String str, Platform101XPToken platform101XPToken, boolean z) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str);
        platform101XPParameters.addParameter("refresh_token", platform101XPToken.getRefreshToken().getId());
        platform101XPParameters.addParameter("locale", Platform101XPUtils.getLocale());
        if (z) {
            platform101XPParameters.addParameter("grant_type", "mobile_refresh");
        }
        return new Platform101XPHttpRequest(getBaseURL() + "refresh", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelToken.class);
    }

    public Platform101XPHttpRequest socialAuth(String str, String str2, String str3, String str4, String str5, boolean z) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPConfigKeyHolder.clientId, str2);
        platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID, str3);
        platform101XPParameters.addParameter("token", str4);
        platform101XPParameters.addParameter("sign", PARAMETER_SIGN);
        platform101XPParameters.addParameter("locale", Platform101XPUtils.getLocale());
        platform101XPParameters.addParameter("wgl", "0");
        if (str5 != null && !str5.isEmpty()) {
            platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, str5);
        }
        if (z) {
            platform101XPParameters.addParameter("grant_type", "mobile_social");
        }
        return new Platform101XPHttpRequest(getBaseURL() + "socialauth/connect/" + str + "/guest", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelToken.class);
    }

    public Platform101XPHttpRequest logout(Platform101XPToken platform101XPToken) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, platform101XPToken.getAccessToken().getId());
        return new Platform101XPHttpRequest(getBaseURL() + "logout", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.DELETE, Platform101XPModelEmpty.class);
    }

    public Platform101XPHttpRequest tokensMobile(String str) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, str);
        return new Platform101XPHttpRequest(getBaseURL() + "tokens/mobile", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelTokensMobile.class);
    }

    public Platform101XPHttpRequest checkToken(Platform101XPToken platform101XPToken) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(Platform101XPTokenManager.KEY_ACCESS_TOKEN, platform101XPToken.getAccessToken().getId());
        return new Platform101XPHttpRequest(getBaseURL() + "auth/check", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelEmpty.class);
    }
}
