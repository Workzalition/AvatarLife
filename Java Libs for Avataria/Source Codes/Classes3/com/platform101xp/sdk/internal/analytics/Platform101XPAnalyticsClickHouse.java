package com.platform101xp.sdk.internal.analytics;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.firebase.messaging.Constants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPApi;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPVersion;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.internal.Platform101XPRequestsKeeper;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.observers.Platform101XPReferrerCatcher;
import com.platform101xp.sdk.internal.observers.Platform101XPReferrerObserver;
import com.tapjoy.TapjoyConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAnalyticsClickHouse implements Platform101XPReferrerObserver, Platform101XPAnalyticsComponent {
    public static final String INSTALL_EVENT = "install";
    private static final String INSTALL_TIME_KEY = "install_time_click_house_key";
    public static final String IS_APP_INSTALL_FROM_PRODUCTION = "install_from_production";
    private static final String MOBILE_ID_KEY = "mobile_id";
    public static final String REFERRER_KEY = "referrer_key";
    private static final String SDK_VERSION_KEY = "sdk_version";
    private static final String USER_ID_KEY = "user_id";
    private static final String WIDGET_VERSION = "widget_version";
    private Map addedEventValues;
    private String appsFlyerId;
    private Platform101XPConfigManager configManager;
    private String installTime;
    private Platform101XPAnalyticsReferrerListener inviteReferrerListener;
    private String widgetVersion;
    private Boolean isProjectIdExist = false;
    private String projectId = null;
    private String referrerValue = null;
    private String userGameIdValue = null;
    private String accountId = null;
    private String advertisingId = null;
    private Platform101XPRequestsKeeper requestsKeeper = Platform101XPRequestsKeeper.getInstance();

    public Platform101XPAnalyticsClickHouse(String str, Platform101XPAnalyticsReferrerListener platform101XPAnalyticsReferrerListener, Platform101XPConfigManager platform101XPConfigManager) {
        this.appsFlyerId = null;
        Platform101XPReferrerCatcher.getInstance().addReferrerObserver(this);
        this.appsFlyerId = str;
        this.inviteReferrerListener = platform101XPAnalyticsReferrerListener;
        this.configManager = platform101XPConfigManager;
        setInstallTime();
        determineAdvertisingInfo();
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void initialize() {
        updateProjectId(isInstalledFromProduction());
        String str = this.projectId;
        this.isProjectIdExist = Boolean.valueOf(str != null && !str.isEmpty());
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void track(String str, Map map) {
        Log.d("101XP SDK", "ClickHouse track, event: " + str + ", map: " + map + ", isProjectIdExist: " + this.isProjectIdExist);
        if (this.isProjectIdExist.booleanValue()) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                flattenEventMap(hashMap, map);
            }
            Map map2 = this.addedEventValues;
            if (map2 != null) {
                flattenEventMap(hashMap, map2);
            }
            String str2 = this.appsFlyerId;
            if (str2 != null && !str2.isEmpty()) {
                hashMap.put(Platform101XPAnalyticsFirebase.PROPERTY_APPFLYER_ID, this.appsFlyerId);
            }
            String str3 = this.installTime;
            if (str3 != null && !str3.isEmpty()) {
                hashMap.put("install_time", this.installTime);
            }
            String str4 = this.userGameIdValue;
            if (str4 != null && !str4.isEmpty()) {
                if (hashMap.containsKey("mobile_id")) {
                    hashMap.remove("mobile_id");
                }
                hashMap.put("mobile_id", this.userGameIdValue);
            }
            hashMap.put(Constants.MessagePayloadKeys.FROM, TapjoyConstants.TJC_SDK_PLACEMENT);
            if (hashMap.containsKey("user_id")) {
                hashMap.remove("user_id");
            }
            String str5 = this.advertisingId;
            if (str5 != null && !str5.isEmpty()) {
                hashMap.put("ad_id", this.advertisingId);
            }
            hashMap.put("user_id", this.accountId);
            hashMap.put("widget_version", this.widgetVersion);
            hashMap.put(SDK_VERSION_KEY, Platform101XPVersion.VERSION);
            final Platform101XPHttpRequest track = Platform101XPApi.apiAnalytics().track(this.projectId, this.userGameIdValue, Platform101XP.getDeviceId(), str, hashMap);
            track.execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsClickHouse.1
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    if (platform101XPError != null) {
                        Log.d("101XP SDK", "Error sending analytics: " + platform101XPError.toString());
                        Platform101XPAnalyticsClickHouse.this.requestsKeeper.addRequestToPool(track);
                    }
                }
            });
            Log.d("101XP SDK", "Tracking from Platform101XPAnalyticsClickHouse, resultEventMap:" + hashMap);
        }
    }

    @Override // com.platform101xp.sdk.internal.observers.Platform101XPReferrerObserver
    public void updateProjectId(boolean z) {
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.analyticsProjectId, "");
        String string2 = this.configManager.getString(Platform101XPConfigKeyHolder.analyticsProjectDevId, "");
        if (!z) {
            string = string2;
        }
        this.projectId = string;
        Log.d("101XP SDK", "ProjectId was updated, current value is:" + this.projectId);
    }

    private boolean isInstalledFromProduction() {
        return Platform101XPSettings.loadBoolean(IS_APP_INSTALL_FROM_PRODUCTION, true);
    }

    public void setAddedEventValues(Map map) {
        Map map2 = this.addedEventValues;
        if (map2 != null) {
            map2.clear();
        }
        this.addedEventValues = map;
        String loadString = Platform101XPSettings.loadString(REFERRER_KEY);
        this.referrerValue = loadString;
        this.inviteReferrerListener.onGetReferrer(loadString);
        Log.d("101XP SDK", "Referrer value: " + this.referrerValue);
        String str = this.referrerValue;
        if (str == null || str.isEmpty()) {
            return;
        }
        this.addedEventValues.put(TapjoyConstants.TJC_REFERRER, this.referrerValue);
    }

    private void setInstallTime() {
        String loadString = Platform101XPSettings.loadString(INSTALL_TIME_KEY);
        this.installTime = loadString;
        if (loadString == null || loadString.isEmpty()) {
            try {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(Platform101XP.getCurrentActivity().getPackageManager().getPackageInfo(Platform101XP.getCurrentActivity().getPackageName(), 4096).firstInstallTime));
                this.installTime = format;
                if (format == null && format.isEmpty()) {
                    return;
                }
                Platform101XPSettings.saveString(INSTALL_TIME_KEY, this.installTime);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUserGameIdValue(long j, long j2) {
        this.userGameIdValue = String.valueOf(j);
        this.accountId = String.valueOf(j2);
    }

    private void flattenEventMap(Map map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Map) {
                flattenEventMap(map, (Map) value);
            } else {
                map.put(entry.getKey(), value);
            }
        }
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsComponent
    public void setWidgetVersion(String str) {
        this.widgetVersion = str;
    }

    private void determineAdvertisingInfo() {
        AsyncTask.execute(new Runnable() { // from class: com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsClickHouse.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(Platform101XP.getApplicationContext());
                    if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        Platform101XPAnalyticsClickHouse.this.setAdvertisingId(advertisingIdInfo.getId());
                    } else {
                        Log.d("101XP SDK", "Advertising id already exists");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setAdvertisingId(String str) {
        this.advertisingId = str;
    }
}
