package com.platform101xp.sdk.internal.configs;

import com.platform101xp.sdk.internal.Platform101XPSettings;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigData_MembersInjector implements MembersInjector<Platform101XPConfigData> {
    private final Provider<Platform101XPSettings> p0Provider;

    public Platform101XPConfigData_MembersInjector(Provider<Platform101XPSettings> provider) {
        this.p0Provider = provider;
    }

    public static MembersInjector<Platform101XPConfigData> create(Provider<Platform101XPSettings> provider) {
        return new Platform101XPConfigData_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPConfigData platform101XPConfigData) {
        injectSetSettings(platform101XPConfigData, (Platform101XPSettings) this.p0Provider.get());
    }

    public static void injectSetSettings(Platform101XPConfigData platform101XPConfigData, Platform101XPSettings platform101XPSettings) {
        platform101XPConfigData.setSettings(platform101XPSettings);
    }
}
