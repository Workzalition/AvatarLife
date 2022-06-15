package com.platform101xp.sdk.internal.firebase.database;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbModule_GetFirebaseDbUtilsFactory implements Factory<Platform101XPFirebaseDbUtils> {
    private final Platform101XPFirebaseDbModule module;

    public Platform101XPFirebaseDbModule_GetFirebaseDbUtilsFactory(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        this.module = platform101XPFirebaseDbModule;
    }

    public Platform101XPFirebaseDbUtils get() {
        return getFirebaseDbUtils(this.module);
    }

    public static Platform101XPFirebaseDbModule_GetFirebaseDbUtilsFactory create(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return new Platform101XPFirebaseDbModule_GetFirebaseDbUtilsFactory(platform101XPFirebaseDbModule);
    }

    public static Platform101XPFirebaseDbUtils getFirebaseDbUtils(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return (Platform101XPFirebaseDbUtils) Preconditions.checkNotNullFromProvides(platform101XPFirebaseDbModule.getFirebaseDbUtils());
    }
}
