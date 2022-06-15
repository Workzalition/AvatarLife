package com.platform101xp.sdk.internal.support;

import android.app.Activity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSupportModule_GetActivityFactory implements Factory<Activity> {
    private final Platform101XPSupportModule module;

    public Platform101XPSupportModule_GetActivityFactory(Platform101XPSupportModule platform101XPSupportModule) {
        this.module = platform101XPSupportModule;
    }

    public Activity get() {
        return getActivity(this.module);
    }

    public static Platform101XPSupportModule_GetActivityFactory create(Platform101XPSupportModule platform101XPSupportModule) {
        return new Platform101XPSupportModule_GetActivityFactory(platform101XPSupportModule);
    }

    public static Activity getActivity(Platform101XPSupportModule platform101XPSupportModule) {
        return (Activity) Preconditions.checkNotNullFromProvides(platform101XPSupportModule.getActivity());
    }
}
