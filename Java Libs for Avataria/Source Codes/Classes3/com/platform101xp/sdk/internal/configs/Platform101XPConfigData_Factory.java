package com.platform101xp.sdk.internal.configs;

import com.platform101xp.sdk.internal.Platform101XPSettings;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigData_Factory implements Factory<Platform101XPConfigData> {
    private final Provider<Platform101XPSettings> p0Provider;
    private final Provider<Platform101XPSettings> settingsProvider;

    public Platform101XPConfigData_Factory(Provider<Platform101XPSettings> provider, Provider<Platform101XPSettings> provider2) {
        this.settingsProvider = provider;
        this.p0Provider = provider2;
    }

    public Platform101XPConfigData get() {
        Platform101XPConfigData newInstance = newInstance((Platform101XPSettings) this.settingsProvider.get());
        Platform101XPConfigData_MembersInjector.injectSetSettings(newInstance, (Platform101XPSettings) this.p0Provider.get());
        return newInstance;
    }

    public static Platform101XPConfigData_Factory create(Provider<Platform101XPSettings> provider, Provider<Platform101XPSettings> provider2) {
        return new Platform101XPConfigData_Factory(provider, provider2);
    }

    public static Platform101XPConfigData newInstance(Platform101XPSettings platform101XPSettings) {
        return new Platform101XPConfigData(platform101XPSettings);
    }
}
