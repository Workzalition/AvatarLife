package com.platform101xp.sdk.api.method;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModelPurchase;
import com.platform101xp.sdk.api.model.Platform101XPModelStoreProducts;
import com.platform101xp.sdk.api.model.Platform101XPModelTransaction;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.Platform101XPUtils;
import com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigData;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApiBilling {
    private String getBaseURL() {
        return Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? "https://mobile-billing-stage.101xp.com/" : "https://mobile-billing.101xp.com/";
    }

    public Platform101XPHttpRequest submitPurchase(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter("productId", str2);
        platform101XPParameters.addParameter("packageName", str3);
        platform101XPParameters.addParameter("token", str4);
        platform101XPParameters.addParameter("itemType", str5);
        platform101XPParameters.addParameter(Platform101XPGoogleBillingManager.PAYLOAD_IS_TEST, GetIsTestParameter());
        if (map != null) {
            for (String str6 : map.keySet()) {
                if (map.get(str6) == null) {
                    Log.e("101XP SDK", str6 + " is null!");
                } else {
                    platform101XPParameters.addParameter(str6, map.get(str6));
                }
            }
        }
        return new Platform101XPHttpRequest(getBaseURL() + str, platform101XPParameters, Platform101XPHttpRequest.HttpMethod.POST, Platform101XPModelTransaction.class);
    }

    public Platform101XPHttpRequest checkPurchase(int i, String str) {
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter("token", str);
        platform101XPParameters.addParameter(Platform101XPGoogleBillingManager.PAYLOAD_IS_TEST, GetIsTestParameter());
        return new Platform101XPHttpRequest(getBaseURL() + "transactions/" + i, platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelPurchase.class);
    }

    public Platform101XPHttpRequest getStoreItems(String str) {
        String locale = Platform101XPUtils.getLocale();
        if (locale != "ru") {
            locale = "en";
        }
        Platform101XPParameters platform101XPParameters = new Platform101XPParameters();
        platform101XPParameters.addParameter("packageName", str);
        platform101XPParameters.addParameter("locale", locale);
        return new Platform101XPHttpRequest(getBaseURL() + FirebaseAnalytics.Param.ITEMS, platform101XPParameters, Platform101XPHttpRequest.HttpMethod.GET, Platform101XPModelStoreProducts.class);
    }

    private String GetIsTestParameter() {
        return Platform101XPSettings.loadBoolean(Platform101XPConfigData.TEST_BILLING_KEY, false) ? TapjoyAuctionFlags.AUCTION_TYPE_FIRST_PRICE : "0";
    }
}
