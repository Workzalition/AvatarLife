package com.platform101xp.sdk.internal.configs;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule_GetMetaMatcherFactory implements Factory<Platform101XPConfigMetaMatcher> {
    private final Platform101XPConfigModule module;

    public Platform101XPConfigModule_GetMetaMatcherFactory(Platform101XPConfigModule platform101XPConfigModule) {
        this.module = platform101XPConfigModule;
    }

    public Platform101XPConfigMetaMatcher get() {
        return getMetaMatcher(this.module);
    }

    public static Platform101XPConfigModule_GetMetaMatcherFactory create(Platform101XPConfigModule platform101XPConfigModule) {
        return new Platform101XPConfigModule_GetMetaMatcherFactory(platform101XPConfigModule);
    }

    public static Platform101XPConfigMetaMatcher getMetaMatcher(Platform101XPConfigModule platform101XPConfigModule) {
        return (Platform101XPConfigMetaMatcher) Preconditions.checkNotNullFromProvides(platform101XPConfigModule.getMetaMatcher());
    }
}
