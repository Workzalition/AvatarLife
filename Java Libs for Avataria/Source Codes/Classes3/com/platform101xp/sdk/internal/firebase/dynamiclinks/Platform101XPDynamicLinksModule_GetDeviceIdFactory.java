package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetDeviceIdFactory implements Factory<String> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetDeviceIdFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public String get() {
        return getDeviceId(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetDeviceIdFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetDeviceIdFactory(platform101XPDynamicLinksModule);
    }

    public static String getDeviceId(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (String) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getDeviceId());
    }
}
