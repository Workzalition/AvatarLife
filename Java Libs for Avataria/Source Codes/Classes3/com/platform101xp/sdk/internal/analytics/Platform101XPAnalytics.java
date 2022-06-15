package com.platform101xp.sdk.internal.analytics;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPProduct;
import com.platform101xp.sdk.Platform101XPPurchase;
import com.platform101xp.sdk.internal.AnalyticsConversionDataListener;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAnalytics implements AnalyticsConversionDataListener {
    private static final String EULA_ACCEPTED_KEY = "com.platform101xp.sdk.license_accepted_key";
    private static final String INSTALL_EVENT = "install";
    private static final String NETWORK_CONNECTION = "network";
    public static final String PURCHASE_EVENT = "af_purchase";
    private static final String SAVE_EVENTS_KEY = "save_events";
    private Platform101XPAnalyticsBuffer analyticsBuffer;
    private AnalyticsConversionDataListener analyticsListener;
    private Platform101XPAnalyticsComponent appsFlyerAnalytics;
    private String appsFlyerId;
    private Platform101XPAnalyticsComponent clickHouseAnalytics;
    private List<String> eventsName;
    private Platform101XPAnalyticsComponent firebaseAnalytics;
    private String userGameId;

    public Platform101XPAnalytics(Activity activity, Platform101XPAnalyticsFirebaseMethods platform101XPAnalyticsFirebaseMethods, Platform101XPAnalyticsReferrerListener platform101XPAnalyticsReferrerListener, Platform101XPConfigManager platform101XPConfigManager, Platform101XPAnalyticsBuffer platform101XPAnalyticsBuffer, AnalyticsConversionDataListener analyticsConversionDataListener) {
        Platform101XPAnalyticsAppsFlyer platform101XPAnalyticsAppsFlyer = new Platform101XPAnalyticsAppsFlyer(activity, this, platform101XPConfigManager);
        this.appsFlyerAnalytics = platform101XPAnalyticsAppsFlyer;
        String appsFlyerId = platform101XPAnalyticsAppsFlyer.getAppsFlyerId();
        this.appsFlyerId = appsFlyerId;
        this.clickHouseAnalytics = new Platform101XPAnalyticsClickHouse(appsFlyerId, platform101XPAnalyticsReferrerListener, platform101XPConfigManager);
        this.firebaseAnalytics = new Platform101XPAnalyticsFirebase(platform101XPAnalyticsFirebaseMethods, Platform101XP.getDeviceId(), this.appsFlyerId);
        this.analyticsBuffer = platform101XPAnalyticsBuffer;
        this.analyticsListener = analyticsConversionDataListener;
        createParametersList();
    }

    public void initialize() {
        this.appsFlyerAnalytics.initialize();
        this.clickHouseAnalytics.initialize();
        this.firebaseAnalytics.initialize();
    }

    public void track(String str, Map map) {
        if (Platform101XPSettings.loadBoolean("com.platform101xp.sdk.license_accepted_key", false) && Platform101XPSettings.loadBoolean(NETWORK_CONNECTION, false)) {
            if (Platform101XPSettings.isKeyExist(SAVE_EVENTS_KEY)) {
                Iterator<Pair<String, Map>> it = this.analyticsBuffer.values().iterator();
                while (it.hasNext()) {
                    Pair<String, Map> next = it.next();
                    trackAnalytics((String) next.first, (Map) next.second);
                }
            }
            trackAnalytics(str, map);
            return;
        }
        this.analyticsBuffer.save(str, map);
    }

    private void trackAnalytics(String str, Map map) {
        this.appsFlyerAnalytics.track(str, map);
        this.clickHouseAnalytics.track(str, map);
        this.firebaseAnalytics.track(str, map);
    }

    @Override // com.platform101xp.sdk.internal.AnalyticsConversionDataListener
    public void onInstallConversionDataLoaded(Map map, boolean z) {
        Log.d("101XP SDK", "Received Conversion Data: " + map);
        if (this.clickHouseAnalytics == null || map == null) {
            return;
        }
        this.analyticsListener.onInstallConversionDataLoaded(map, z);
        ((Platform101XPAnalyticsClickHouse) this.clickHouseAnalytics).setAddedEventValues(map);
        if (!z) {
            return;
        }
        Log.d("101XP SDK", "ClickHouse track install event with Conversion Data");
        track("install", map);
    }

    private void createParametersList() {
        ArrayList arrayList = new ArrayList();
        this.eventsName = arrayList;
        arrayList.add("event_type");
        this.eventsName.add(Platform101XPAnalyticsFirebase.PROPERTY_DEVICE_ID);
        this.eventsName.add(TapjoyAuctionFlags.AUCTION_TYPE);
        this.eventsName.add("event_time");
        this.eventsName.add("project_id");
    }

    public String getAppsFlyerId() {
        return this.appsFlyerId;
    }

    public void trackCommerce(Platform101XPPurchase platform101XPPurchase, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
            String orderId = platform101XPPurchase.getOrderId();
            if (orderId != null && !orderId.isEmpty()) {
                hashMap.put("af_order_id", platform101XPPurchase.getOrderId());
            }
            hashMap.put("af_receipt_id", platform101XPPurchase.getTransactionId());
            hashMap.put("af_content_id", platform101XPPurchase.getProductId());
            String str = this.userGameId;
            if (str != null) {
                hashMap.put("af_customer_user_id", str);
            }
            Platform101XPProduct productById = Platform101XP.getProductById(platform101XPPurchase.getProductId());
            if (productById != null) {
                hashMap.put(Platform101XPAnalyticsAppsFlyer.REVENUE_KEY, productById.getPriceValue());
                hashMap.put(Platform101XPAnalyticsAppsFlyer.CURRENCY_KEY, productById.getCurrencyCode());
                ((Platform101XPAnalyticsAppsFlyer) this.appsFlyerAnalytics).validateAndTrackPurchase(platform101XPPurchase, hashMap);
            }
        }
        this.clickHouseAnalytics.track(PURCHASE_EVENT, hashMap);
        this.firebaseAnalytics.track(PURCHASE_EVENT, hashMap);
    }

    public void setUserGameId(long j, long j2) {
        try {
            this.userGameId = String.valueOf(j);
            ((Platform101XPAnalyticsClickHouse) this.clickHouseAnalytics).setUserGameIdValue(j, j2);
            ((Platform101XPAnalyticsFirebase) this.firebaseAnalytics).setUserGameIdProperty(String.valueOf(j), String.valueOf(j2));
        } catch (Exception e) {
            Platform101XP.sendCrashReport(e);
            Log.d("101XP SDK", e.getMessage());
        }
    }

    public void setWidgetVersion(String str) {
        this.appsFlyerAnalytics.setWidgetVersion(str);
        this.clickHouseAnalytics.setWidgetVersion(str);
        this.firebaseAnalytics.setWidgetVersion(str);
    }

    public List<String> getParameters() {
        return this.eventsName;
    }

    public String isOverridingAnalyticsParameters(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str : this.eventsName) {
            if (map.containsKey(str)) {
                return str;
            }
        }
        return null;
    }
}
