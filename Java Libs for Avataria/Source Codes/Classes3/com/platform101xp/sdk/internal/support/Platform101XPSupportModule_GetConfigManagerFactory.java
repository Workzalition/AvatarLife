package com.platform101xp.sdk.internal.support;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSupportModule_GetConfigManagerFactory implements Factory<Platform101XPConfigManager> {
    private final Platform101XPSupportModule module;

    public Platform101XPSupportModule_GetConfigManagerFactory(Platform101XPSupportModule platform101XPSupportModule) {
        this.module = platform101XPSupportModule;
    }

    public Platform101XPConfigManager get() {
        return getConfigManager(this.module);
    }

    public static Platform101XPSupportModule_GetConfigManagerFactory create(Platform101XPSupportModule platform101XPSupportModule) {
        return new Platform101XPSupportModule_GetConfigManagerFactory(platform101XPSupportModule);
    }

    public static Platform101XPConfigManager getConfigManager(Platform101XPSupportModule platform101XPSupportModule) {
        return (Platform101XPConfigManager) Preconditions.checkNotNullFromProvides(platform101XPSupportModule.getConfigManager());
    }
}
