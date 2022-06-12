package com.platform101xp.sdk;

import com.platform101xp.sdk.api.method.Platform101XPApiAnalytics;
import com.platform101xp.sdk.api.method.Platform101XPApiAuth;
import com.platform101xp.sdk.api.method.Platform101XPApiBilling;
import com.platform101xp.sdk.api.method.Platform101XPApiData;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApi {
    public static Platform101XPApiAuth auth() {
        return new Platform101XPApiAuth();
    }

    public static Platform101XPApiData data() {
        return new Platform101XPApiData();
    }

    public static Platform101XPApiBilling billing() {
        return new Platform101XPApiBilling();
    }

    public static Platform101XPApiAnalytics apiAnalytics() {
        return new Platform101XPApiAnalytics();
    }
}
