package com.platform101xp.sdk.internal.socialnetworks;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSnModule_GetClientIdFactory implements Factory<String> {
    private final Platform101XPSnModule module;

    public Platform101XPSnModule_GetClientIdFactory(Platform101XPSnModule platform101XPSnModule) {
        this.module = platform101XPSnModule;
    }

    public String get() {
        return getClientId(this.module);
    }

    public static Platform101XPSnModule_GetClientIdFactory create(Platform101XPSnModule platform101XPSnModule) {
        return new Platform101XPSnModule_GetClientIdFactory(platform101XPSnModule);
    }

    public static String getClientId(Platform101XPSnModule platform101XPSnModule) {
        return (String) Preconditions.checkNotNullFromProvides(platform101XPSnModule.getClientId());
    }
}
