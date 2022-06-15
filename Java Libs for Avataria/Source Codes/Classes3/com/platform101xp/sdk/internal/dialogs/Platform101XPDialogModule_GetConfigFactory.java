package com.platform101xp.sdk.internal.dialogs;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPDialogModule_GetConfigFactory implements Factory<Platform101XPConfigManager> {
    private final Platform101XPDialogModule module;

    public Platform101XPDialogModule_GetConfigFactory(Platform101XPDialogModule platform101XPDialogModule) {
        this.module = platform101XPDialogModule;
    }

    public Platform101XPConfigManager get() {
        return getConfig(this.module);
    }

    public static Platform101XPDialogModule_GetConfigFactory create(Platform101XPDialogModule platform101XPDialogModule) {
        return new Platform101XPDialogModule_GetConfigFactory(platform101XPDialogModule);
    }

    public static Platform101XPConfigManager getConfig(Platform101XPDialogModule platform101XPDialogModule) {
        return (Platform101XPConfigManager) Preconditions.checkNotNullFromProvides(platform101XPDialogModule.getConfig());
    }
}
