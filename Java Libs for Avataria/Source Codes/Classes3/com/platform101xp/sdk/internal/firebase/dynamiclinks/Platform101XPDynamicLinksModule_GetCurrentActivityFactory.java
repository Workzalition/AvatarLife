package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.app.Activity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDynamicLinksModule_GetCurrentActivityFactory implements Factory<Activity> {
    private final Platform101XPDynamicLinksModule module;

    public Platform101XPDynamicLinksModule_GetCurrentActivityFactory(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.module = platform101XPDynamicLinksModule;
    }

    public Activity get() {
        return getCurrentActivity(this.module);
    }

    public static Platform101XPDynamicLinksModule_GetCurrentActivityFactory create(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return new Platform101XPDynamicLinksModule_GetCurrentActivityFactory(platform101XPDynamicLinksModule);
    }

    public static Activity getCurrentActivity(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        return (Activity) Preconditions.checkNotNullFromProvides(platform101XPDynamicLinksModule.getCurrentActivity());
    }
}
