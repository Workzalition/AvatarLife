package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetPlatformAnalyticsFactory implements Factory<Platform101XPAnalytics> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetPlatformAnalyticsFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Platform101XPAnalytics get() {
        return getPlatformAnalytics(this.module);
    }

    public static Platform101XPDialogModule_GetPlatformAnalyticsFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetPlatformAnalyticsFactory(platform101XPDialogModule);
    }

    public static Platform101XPAnalytics getPlatformAnalytics(Platform101XPDialogModule platform101XPDialogModule) {
        return (Platform101XPAnalytics) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getPlatformAnalytics());
    }
}
