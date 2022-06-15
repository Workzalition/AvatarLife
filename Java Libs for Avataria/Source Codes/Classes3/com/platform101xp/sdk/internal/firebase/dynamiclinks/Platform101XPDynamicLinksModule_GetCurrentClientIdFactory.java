package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetCurrentClientIdFactory implements Factory<String> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetCurrentClientIdFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public String get() {
        return getCurrentClientId(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetCurrentClientIdFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetCurrentClientIdFactory(platform101XPDynamicLinksModule);
    }

    public static String getCurrentClientId(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (String) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getCurrentClientId());
    }
}
