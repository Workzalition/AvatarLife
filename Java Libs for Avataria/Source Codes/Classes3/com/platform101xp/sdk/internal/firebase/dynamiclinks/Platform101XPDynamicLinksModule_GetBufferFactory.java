package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsBuffer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetBufferFactory implements Factory<Platform101XPAnalyticsBuffer> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetBufferFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public Platform101XPAnalyticsBuffer get() {
        return getBuffer(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetBufferFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetBufferFactory(platform101XPDynamicLinksModule);
    }

    public static Platform101XPAnalyticsBuffer getBuffer(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (Platform101XPAnalyticsBuffer) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getBuffer());
    }
}
