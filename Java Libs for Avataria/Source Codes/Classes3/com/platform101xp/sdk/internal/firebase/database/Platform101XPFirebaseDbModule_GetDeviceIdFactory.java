package com.platform101xp.sdk.internal.firebase.database;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbModule_GetDeviceIdFactory implements Factory<String> {
    private final Platform101XPFirebaseDbModule module;

    public Platform101XPFirebaseDbModule_GetDeviceIdFactory(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        this.module = platform101XPFirebaseDbModule;
    }

    public String get() {
        return getDeviceId(this.module);
    }

    public static Platform101XPFirebaseDbModule_GetDeviceIdFactory create(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return new Platform101XPFirebaseDbModule_GetDeviceIdFactory(platform101XPFirebaseDbModule);
    }

    public static String getDeviceId(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return (String) Preconditions.checkNotNullFromProvides(platform101XPFirebaseDbModule.getDeviceId());
    }
}
