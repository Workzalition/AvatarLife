package com.platform101xp.sdk.internal.dialogs;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetContextFactory implements Factory<Context> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetContextFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Context get() {
        return getContext(this.module);
    }

    public static Platform101XPDialogModule_GetContextFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetContextFactory(platform101XPDialogModule);
    }

    public static Context getContext(Platform101XPDialogModule platform101XPDialogModule) {
        return (Context) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getContext());
    }
}
