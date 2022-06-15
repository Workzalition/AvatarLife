package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetConfigFactory implements Factory<Platform101XPConfigManager> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetConfigFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public Platform101XPConfigManager get() {
        return getConfig(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetConfigFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetConfigFactory(platform101XPDynamicLinksModule);
    }

    public static Platform101XPConfigManager getConfig(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (Platform101XPConfigManager) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getConfig());
    }
}
