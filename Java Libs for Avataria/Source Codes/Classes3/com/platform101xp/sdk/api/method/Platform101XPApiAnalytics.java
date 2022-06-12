package com.platform101xp.sdk.api.method;

import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModelEmpty;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApiAnalytics {
    private String getBaseURL() {
        return "https://mobile-monitoring.101xp.com/";
    }

    public Platform101XPHttpRequest track(String str, String str2, String str3, String str4, Map map) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter(TapjoyAuctionFlags.AUCTION_TYPE, "events");
        platform101XPParameters.addParameter("event_time", String.valueOf(System.currentTimeMillis() / 1000));
        platform101XPParameters.addParameter("project_id", str);
        if (str2 != null && !str2.isEmpty() && !str2.equals("0")) {
            platform101XPParameters.addParameter(Platform101XPAnalyticsFirebase.PROPERTY_USER_ID, str2);
        }
        platform101XPParameters.addParameter("deviceId", str3);
        platform101XPParameters.addParameter("event_type", str4);
        for (Object obj : map.keySet()) {
            platform101XPParameters.addParameter(String.valueOf(obj), String.valueOf(map.get(obj)));
        }
        return new Platform101XPHttpRequest(getBaseURL() + "events", platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelEmpty.class);
    }
}
