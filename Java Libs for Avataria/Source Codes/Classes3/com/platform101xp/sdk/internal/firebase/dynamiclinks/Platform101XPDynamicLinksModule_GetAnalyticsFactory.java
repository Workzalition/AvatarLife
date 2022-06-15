package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetAnalyticsFactory implements Factory<Platform101XPAnalytics> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetAnalyticsFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public Platform101XPAnalytics get() {
        return getAnalytics(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetAnalyticsFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetAnalyticsFactory(platform101XPDynamicLinksModule);
    }

    public static Platform101XPAnalytics getAnalytics(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (Platform101XPAnalytics) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getAnalytics());
    }
}
