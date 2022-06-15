package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.Platform101XPSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetCurrentSettingsFactory implements Factory<Platform101XPSettings> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetCurrentSettingsFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Platform101XPSettings get() {
        return getCurrentSettings(this.module);
    }

    public static Platform101XPDialogModule_GetCurrentSettingsFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetCurrentSettingsFactory(platform101XPDialogModule);
    }

    public static Platform101XPSettings getCurrentSettings(Platform101XPDialogModule platform101XPDialogModule) {
        return (Platform101XPSettings) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getCurrentSettings());
    }
}
