package com.platform101xp.sdk.internal.report;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPVersion;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPCrashReport {
    private static final String TAG = "CRASH_REPORT";
    private boolean crashlyticsCollectionEnabled;
    private boolean reportEnabled;
    private FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();
    private Context context = Platform101XP.getApplicationContext();

    public Platform101XPCrashReport(Platform101XPConfigManager platform101XPConfigManager) {
        this.crashlyticsCollectionEnabled = platform101XPConfigManager.getBool(Platform101XPConfigKeyHolder.firebaseCrachlyticsEnabled, false);
        try {
            initialize();
        } catch (ClassNotFoundException e) {
            Log.d(TAG, e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d(TAG, e2.getMessage());
        }
    }

    public boolean isReportEnabled() {
        return this.reportEnabled;
    }

    public void setReportEnabled(boolean z) {
        this.reportEnabled = z;
    }

    private void initialize() throws ClassNotFoundException, NoClassDefFoundError {
        setReportEnabled(true);
        if (!this.crashlyticsCollectionEnabled) {
            this.crashlytics.setCrashlyticsCollectionEnabled(true);
        }
        prepareSdkInfo();
    }

    public void setUserIdentity(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.crashlytics.setUserId(str);
    }

    public void sendExceptionReport(Throwable th) {
        if (!isReportEnabled()) {
            return;
        }
        trySendException(th);
    }

    public void sendLog(String str, String str2) {
        if (!isReportEnabled()) {
            return;
        }
        trySendCrashLog(str, str2);
    }

    private void trySendException(Throwable th) {
        this.crashlytics.recordException(th);
    }

    private void trySendCrashLog(String str, String str2) {
        if (str2 == null) {
            str2 = "message is null";
        }
        Log.d(str, str2);
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        firebaseCrashlytics.log("D/" + str + ": " + str2);
    }

    private void prepareSdkInfo() {
        this.crashlytics.setCustomKey("SDK version", Platform101XPVersion.VERSION);
        this.crashlytics.setCustomKey("Network State:", getNetworkState());
    }

    private String getNetworkState() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getDetailedState().name() : "Network off";
    }
}
