package com.platform101xp.sdk.internal.configs;

import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule_GetMetaManagerFactory implements Factory<Platform101XPMetaManager> {
    private final Platform101XPConfigModule module;

    public Platform101XPConfigModule_GetMetaManagerFactory(Platform101XPConfigModule platform101XPConfigModule) {
        this.module = platform101XPConfigModule;
    }

    public Platform101XPMetaManager get() {
        return getMetaManager(this.module);
    }

    public static Platform101XPConfigModule_GetMetaManagerFactory create(Platform101XPConfigModule platform101XPConfigModule) {
        return new Platform101XPConfigModule_GetMetaManagerFactory(platform101XPConfigModule);
    }

    public static Platform101XPMetaManager getMetaManager(Platform101XPConfigModule platform101XPConfigModule) {
        return (Platform101XPMetaManager) Preconditions.checkNotNullFromProvides(platform101XPConfigModule.getMetaManager());
    }
}
