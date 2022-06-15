package com.platform101xp.sdk.internal.dialogs;

import android.app.Activity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetActivityFactory implements Factory<Activity> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetActivityFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Activity get() {
        return getActivity(this.module);
    }

    public static Platform101XPDialogModule_GetActivityFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetActivityFactory(platform101XPDialogModule);
    }

    public static Activity getActivity(Platform101XPDialogModule platform101XPDialogModule) {
        return (Activity) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getActivity());
    }
}
