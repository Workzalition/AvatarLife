package com.platform101xp.sdk.internal.firebase.database;

import android.app.Activity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDbModule_GetActivityFactory implements Factory<Activity> {
    private final Platform101XPFirebaseDbModule module;

    public Platform101XPFirebaseDbModule_GetActivityFactory(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        this.module = platform101XPFirebaseDbModule;
    }

    public Activity get() {
        return getActivity(this.module);
    }

    public static Platform101XPFirebaseDbModule_GetActivityFactory create(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return new Platform101XPFirebaseDbModule_GetActivityFactory(platform101XPFirebaseDbModule);
    }

    public static Activity getActivity(Platform101XPFirebaseDbModule platform101XPFirebaseDbModule) {
        return (Activity) Preconditions.checkNotNullFromProvides(platform101XPFirebaseDbModule.getActivity());
    }
}
