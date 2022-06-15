package com.platform101xp.sdk.internal.observers;

import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsClickHouse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPReferrerCatcher implements Platform101XPReferrerObservable {
    private static Platform101XPReferrerCatcher instance;
    private List<Platform101XPReferrerObserver> observers = new ArrayList();

    private Platform101XPReferrerCatcher() {
    }

    public static Platform101XPReferrerCatcher getInstance() {
        if (instance == null) {
            instance = new Platform101XPReferrerCatcher();
        }
        return instance;
    }

    @Override // com.platform101xp.sdk.internal.observers.Platform101XPReferrerObservable
    public void addReferrerObserver(Platform101XPReferrerObserver platform101XPReferrerObserver) {
        List<Platform101XPReferrerObserver> list = this.observers;
        if (list != null) {
            list.add(platform101XPReferrerObserver);
        }
    }

    @Override // com.platform101xp.sdk.internal.observers.Platform101XPReferrerObservable
    public void deleteReferrerObserver(Platform101XPReferrerObserver platform101XPReferrerObserver) {
        List<Platform101XPReferrerObserver> list = this.observers;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.observers.remove(platform101XPReferrerObserver);
    }

    @Override // com.platform101xp.sdk.internal.observers.Platform101XPReferrerObservable
    public void notifyObservers() {
        Log.d("101XP SDK", "Notify Observers");
        for (Platform101XPReferrerObserver platform101XPReferrerObserver : this.observers) {
            platform101XPReferrerObserver.updateProjectId(Platform101XPSettings.loadBoolean(Platform101XPAnalyticsClickHouse.IS_APP_INSTALL_FROM_PRODUCTION, false));
        }
    }
}
