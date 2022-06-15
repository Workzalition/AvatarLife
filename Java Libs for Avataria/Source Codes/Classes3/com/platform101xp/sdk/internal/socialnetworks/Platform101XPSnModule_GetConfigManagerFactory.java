package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSnModule_GetConfigManagerFactory implements Factory<Platform101XPConfigManager> {
    private final Platform101XPSnModule module;

    public Platform101XPSnModule_GetConfigManagerFactory(Platform101XPSnModule platform101XPSnModule) {
        this.module = platform101XPSnModule;
    }

    public Platform101XPConfigManager get() {
        return getConfigManager(this.module);
    }

    public static Platform101XPSnModule_GetConfigManagerFactory create(Platform101XPSnModule platform101XPSnModule) {
        return new Platform101XPSnModule_GetConfigManagerFactory(platform101XPSnModule);
    }

    public static Platform101XPConfigManager getConfigManager(Platform101XPSnModule platform101XPSnModule) {
        return (Platform101XPConfigManager) Preconditions.checkNotNullFromProvides(platform101XPSnModule.getConfigManager());
    }
}
