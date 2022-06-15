package com.platform101xp.sdk.internal.configs;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule_GetListenerFactory implements Factory<Platform101XPConfigResultListener> {
    private final Platform101XPConfigModule module;

    public Platform101XPConfigModule_GetListenerFactory(Platform101XPConfigModule platform101XPConfigModule) {
        this.module = platform101XPConfigModule;
    }

    public Platform101XPConfigResultListener get() {
        return getListener(this.module);
    }

    public static Platform101XPConfigModule_GetListenerFactory create(Platform101XPConfigModule platform101XPConfigModule) {
        return new Platform101XPConfigModule_GetListenerFactory(platform101XPConfigModule);
    }

    public static Platform101XPConfigResultListener getListener(Platform101XPConfigModule platform101XPConfigModule) {
        return (Platform101XPConfigResultListener) Preconditions.checkNotNullFromProvides(platform101XPConfigModule.getListener());
    }
}
