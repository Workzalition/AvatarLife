package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule_GetAppContextFactory implements Factory<Context> {
    private final Platform101XPConfigModule module;

    public Platform101XPConfigModule_GetAppContextFactory(Platform101XPConfigModule platform101XPConfigModule) {
        this.module = platform101XPConfigModule;
    }

    public Context get() {
        return getAppContext(this.module);
    }

    public static Platform101XPConfigModule_GetAppContextFactory create(Platform101XPConfigModule platform101XPConfigModule) {
        return new Platform101XPConfigModule_GetAppContextFactory(platform101XPConfigModule);
    }

    public static Context getAppContext(Platform101XPConfigModule platform101XPConfigModule) {
        return (Context) Preconditions.checkNotNullFromProvides(platform101XPConfigModule.getAppContext());
    }
}
