package com.platform101xp.sdk.internal.configs;

import com.platform101xp.sdk.internal.Platform101XPSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigModule_GetCurrentSettingsFactory implements Factory<Platform101XPSettings> {
    private final Platform101XPConfigModule module;

    public Platform101XPConfigModule_GetCurrentSettingsFactory(Platform101XPConfigModule platform101XPConfigModule) {
        this.module = platform101XPConfigModule;
    }

    public Platform101XPSettings get() {
        return getCurrentSettings(this.module);
    }

    public static Platform101XPConfigModule_GetCurrentSettingsFactory create(Platform101XPConfigModule platform101XPConfigModule) {
        return new Platform101XPConfigModule_GetCurrentSettingsFactory(platform101XPConfigModule);
    }

    public static Platform101XPSettings getCurrentSettings(Platform101XPConfigModule platform101XPConfigModule) {
        return (Platform101XPSettings) Preconditions.checkNotNullFromProvides(platform101XPConfigModule.getCurrentSettings());
    }
}
