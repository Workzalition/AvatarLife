package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPOK_Factory implements Factory<Platform101XPOK> {
    private final Provider<Platform101XPConfigManager> currentConfigManagerProvider;
    private final Provider<Platform101XPSocialNetwork.SocialNetworkListener> listenerProvider;

    public Platform101XPOK_Factory(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2) {
        this.listenerProvider = provider;
        this.currentConfigManagerProvider = provider2;
    }

    public Platform101XPOK get() {
        return newInstance((Platform101XPSocialNetwork.SocialNetworkListener) this.listenerProvider.get(), (Platform101XPConfigManager) this.currentConfigManagerProvider.get());
    }

    public static Platform101XPOK_Factory create(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPOK_Factory(provider, provider2);
    }

    public static Platform101XPOK newInstance(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        return new Platform101XPOK(socialNetworkListener, platform101XPConfigManager);
    }
}
