package com.platform101xp.sdk.internal.dialogs;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetIdClientFactory implements Factory<String> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetIdClientFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public String get() {
        return getIdClient(this.module);
    }

    public static Platform101XPDialogModule_GetIdClientFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetIdClientFactory(platform101XPDialogModule);
    }

    public static String getIdClient(Platform101XPDialogModule platform101XPDialogModule) {
        return (String) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getIdClient());
    }
}
