package com.platform101xp.sdk.internal.dialogs;

import android.app.Dialog;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetAllDialogsFactory implements Factory<Dialog[]> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetAllDialogsFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Dialog[] get() {
        return getAllDialogs(this.module);
    }

    public static Platform101XPDialogModule_GetAllDialogsFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetAllDialogsFactory(platform101XPDialogModule);
    }

    public static Dialog[] getAllDialogs(Platform101XPDialogModule platform101XPDialogModule) {
        return (Dialog[]) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getAllDialogs());
    }
}
