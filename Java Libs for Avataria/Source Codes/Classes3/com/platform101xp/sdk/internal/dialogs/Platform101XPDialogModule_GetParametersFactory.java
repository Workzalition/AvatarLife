package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogParameters;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetParametersFactory implements Factory<Platform101XPWebDialogParameters> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetParametersFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Platform101XPWebDialogParameters get() {
        return getParameters(this.module);
    }

    public static Platform101XPDialogModule_GetParametersFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetParametersFactory(platform101XPDialogModule);
    }

    public static Platform101XPWebDialogParameters getParameters(Platform101XPDialogModule platform101XPDialogModule) {
        return (Platform101XPWebDialogParameters) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getParameters());
    }
}
