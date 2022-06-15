package com.platform101xp.sdk.internal.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPPurchase;
import com.platform101xp.sdk.internal.AnalyticsConversionDataListener;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAnalyticsAppsFlyer implements Platform101XPAnalyticsComponent {
    public static final String CURRENCY_KEY = "af_currency";
    private static final String EULA_ACCEPTED_KEY = "com.platform101xp.sdk.license_accepted_key";
    private static final String INSTALL_EVENT = "install";
    private static final String IS_APP_INSTALL_KEY = "install_key";
    public static final String REVENUE_KEY = "af_revenue";
    private static final String WIDGET_VERSION = "widget_version";
    private Activity activity;
    private String billingPublicKey;
    private Platform101XPConfigManager configManager;
    private AnalyticsConversionDataListener dataListener;
    private Boolean isAppsFlyerEnabled;
    private boolean isAppsFlyerTrackEnabled;
    private boolean isDebugLogEnabled;
    private String widgetVersion;

    public Platform101XPAnalyticsAppsFlyer(Activity activity, AnalyticsConversionDataListener analyticsConversionDataListener, Platform101XPConfigManager platform101XPConfigManager) {
        this.isAppsFlyerEnabled = false;
        this.activity = activity;
        this.configManager = platform101XPConfigManager;
        this.isAppsFlyerEnabled = Boolean.valueOf(platform101XPConfigManager.getBool(Platform101XPConfigKeyHolder.appsflyerEnabled, !platform101XPConfigManager.getString(Platform101XPConfigKeyHolder.appsflyerDevKey, "").isEmpty()));
        this.isAppsFlyerTrackEnabled = this.configManager.getBool(Platform101XPConfigKeyHolder.appsflyerTrackEnabled, true);
        this.isDebugLogEnabled = this.configManager.getBool(Platform101XPConfigKeyHolder.appsflyerDebugLogEnabled, false);
        this.billingPublicKey = this.configManager.getString(Platform101XPConfigKeyHolder.billingPublicKey, "");
        this.dataListener = analyticsConversionDataListener;
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void initialize() {
        if (this.activity == null || !this.isAppsFlyerEnabled.booleanValue()) {
            return;
        }
        try {
            Log.d("101XP SDK", "AppsFlyer isDebugLogEnabled = " + this.isDebugLogEnabled);
            AppsFlyerLib.getInstance().setDebugLog(this.isDebugLogEnabled);
            setConfigDevKey();
            trackDeferredDeepLinkingInstall();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
            this.isAppsFlyerEnabled = false;
        }
    }

    private void setConfigDevKey() {
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.appsflyerDevKey, "");
        Activity activity = this.activity;
        if (activity != null) {
            appsFlyerStartTrack(activity.getApplication(), string);
        }
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void track(String str, Map map) {
        Log.d("101XP SDK", "AppsFlyer track, event: " + str + ", map: " + map);
        if (!this.isAppsFlyerEnabled.booleanValue() || !this.isAppsFlyerTrackEnabled) {
            return;
        }
        if (map != null) {
            map.put("widget_version", this.widgetVersion);
        }
        appsFlyerTrackEvent(str, map);
        Log.d("101XP SDK", "Tracking from Platform101XPAnalyticsAppsFlyer");
    }

    public String getAppsFlyerId() {
        if (this.activity == null || !this.isAppsFlyerEnabled.booleanValue()) {
            return null;
        }
        return appsFlyerGetId(this.activity.getApplicationContext());
    }

    private void trackDeferredDeepLinkingInstall() {
        if (!this.isAppsFlyerEnabled.booleanValue()) {
            return;
        }
        AppsFlyerLib.getInstance().registerConversionListener(Platform101XP.getCurrentActivity(), new AppsFlyerConversionListener() { // from class: com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onConversionDataSuccess(java.util.Map<java.lang.String, java.lang.Object> r4) {
                /*
                    r3 = this;
                    java.util.HashMap r0 = new java.util.HashMap
                    r0.<init>()
                    r0.putAll(r4)
                    java.lang.String r1 = com.platform101xp.sdk.Platform101XP.getDeviceId()
                    java.lang.String r2 = "android_id"
                    r0.put(r2, r1)
                    java.lang.String r1 = com.platform101xp.sdk.Platform101XP.getDeviceId()
                    java.lang.String r1 = com.zendesk.util.DigestUtils.sha1(r1)
                    java.lang.String r2 = "sha1_android_id"
                    r0.put(r2, r1)
                    android.content.Context r1 = com.platform101xp.sdk.Platform101XP.getApplicationContext()     // Catch: com.google.android.gms.common.GooglePlayServicesRepairableException -> L2b com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L30 java.io.IOException -> L35
                    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r1 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r1)     // Catch: com.google.android.gms.common.GooglePlayServicesRepairableException -> L2b com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L30 java.io.IOException -> L35
                    java.lang.String r1 = r1.getId()     // Catch: com.google.android.gms.common.GooglePlayServicesRepairableException -> L2b com.google.android.gms.common.GooglePlayServicesNotAvailableException -> L30 java.io.IOException -> L35
                    goto L3a
                L2b:
                    r1 = move-exception
                    r1.printStackTrace()
                    goto L39
                L30:
                    r1 = move-exception
                    r1.printStackTrace()
                    goto L39
                L35:
                    r1 = move-exception
                    r1.printStackTrace()
                L39:
                    r1 = 0
                L3a:
                    java.lang.String r2 = "advertising_id"
                    r0.put(r2, r1)
                    java.lang.String r1 = com.zendesk.util.DigestUtils.sha1(r1)
                    java.lang.String r2 = "sha1_advertising_id"
                    r0.put(r2, r1)
                    java.lang.String r1 = "af_r"
                    boolean r2 = r4.containsKey(r1)
                    if (r2 == 0) goto L57
                    java.lang.Object r2 = r4.get(r1)
                    r0.put(r1, r2)
                L57:
                    java.lang.String r1 = "sha1_el"
                    boolean r2 = r4.containsKey(r1)
                    if (r2 == 0) goto L66
                    java.lang.Object r4 = r4.get(r1)
                    r0.put(r1, r4)
                L66:
                    r4 = 0
                    java.lang.String r1 = "install_key"
                    boolean r4 = com.platform101xp.sdk.internal.Platform101XPSettings.loadBoolean(r1, r4)
                    r2 = 1
                    r4 = r4 ^ r2
                    if (r4 == 0) goto L8e
                    com.platform101xp.sdk.internal.Platform101XPSettings.saveBoolean(r1, r2)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Deferred Deeplinking data loaded: "
                    r1.append(r2)
                    java.lang.String r2 = r0.toString()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "101XP SDK"
                    android.util.Log.d(r2, r1)
                L8e:
                    com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer r1 = com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer.this
                    com.platform101xp.sdk.internal.AnalyticsConversionDataListener r1 = com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer.access$000(r1)
                    r1.onInstallConversionDataLoaded(r0, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer.AnonymousClass1.onConversionDataSuccess(java.util.Map):void");
            }

            public void onConversionDataFail(String str) {
                Log.d("101XP SDK", "Deferred Deeplinking conversion failure: " + str);
            }

            public void onAppOpenAttribution(Map<String, String> map) {
                Log.d("101XP SDK", "Deferred Deeplinking App open attribution: " + map.toString());
            }

            public void onAttributionFailure(String str) {
                Log.d("101XP SDK", "Deferred Deeplinking attribution failure: " + str);
            }
        });
    }

    private void appsFlyerTrackEvent(String str, Map map) {
        AppsFlyerLib.getInstance().logEvent(this.activity.getApplication(), str, map);
    }

    private String appsFlyerGetId(Context context) {
        return AppsFlyerLib.getInstance().getAppsFlyerUID(context);
    }

    private void appsFlyerStartTrack(Application application, String str) {
        AppsFlyerLib.getInstance().init(str, (AppsFlyerConversionListener) null, this.activity);
        AppsFlyerLib.getInstance().start(application, str);
    }

    public void validateAndTrackPurchase(Platform101XPPurchase platform101XPPurchase, Map<String, String> map) {
        if (this.billingPublicKey.isEmpty()) {
            Log.d("101XP SDK", "Appsflyer can't validate and track purchase! Billing public key is empty.");
        } else {
            AppsFlyerLib.getInstance().validateAndLogInAppPurchase(this.activity, this.billingPublicKey, platform101XPPurchase.getSignature(), platform101XPPurchase.getOriginalJson(), map.get(REVENUE_KEY), map.get(CURRENCY_KEY), map);
        }
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void setWidgetVersion(String str) {
        this.widgetVersion = str;
    }
}
