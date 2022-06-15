package com.platform101xp.sdk.internal.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsClickHouse;
import com.platform101xp.sdk.internal.observers.Platform101XPReferrerCatcher;
import com.tapjoy.TapjoyConstants;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPInstallReferrerReceiver extends BroadcastReceiver {
    private String referrer;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.referrer = intent.getStringExtra(TapjoyConstants.TJC_REFERRER);
        Log.d("101XP SDK", "Referrer is : " + this.referrer);
        String str = this.referrer;
        if (str != null && !str.isEmpty()) {
            Platform101XPSettings.saveString(Platform101XPAnalyticsClickHouse.REFERRER_KEY, this.referrer);
        }
        String str2 = this.referrer;
        if (str2 != null && str2.equals("test")) {
            Platform101XPSettings.saveBoolean(Platform101XPAnalyticsClickHouse.IS_APP_INSTALL_FROM_PRODUCTION, false);
        } else {
            Platform101XPSettings.saveBoolean(Platform101XPAnalyticsClickHouse.IS_APP_INSTALL_FROM_PRODUCTION, true);
        }
        Platform101XPReferrerCatcher.getInstance().notifyObservers();
    }
}
