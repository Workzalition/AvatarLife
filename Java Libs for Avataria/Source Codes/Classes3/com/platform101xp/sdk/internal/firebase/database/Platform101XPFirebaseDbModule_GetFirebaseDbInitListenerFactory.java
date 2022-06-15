package com.platform101xp.sdk.internal.firebase.database;

import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory implements Factory<Platform101XPFirebaseDbManager.InitDbResultListener> {
    private final Platform101XPFirebaseDbModule module;

    public Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        this.module = platform101XPFirebaseDbModule;
    }

    public Platform101XPFirebaseDbManager.InitDbResultListener get() {
        return getFirebaseDbInitListener(this.module);
    }

    public static Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory create(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return new Platform101XPFirebaseDbModule_GetFirebaseDbInitListenerFactory(platform101XPFirebaseDbModule);
    }

    public static Platform101XPFirebaseDbManager.InitDbResultListener getFirebaseDbInitListener(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return (Platform101XPFirebaseDbManager.InitDbResultListener) Preconditions.checkNotNullFromProvides(platform101XPFirebaseDbModule.getFirebaseDbInitListener());
    }
}
