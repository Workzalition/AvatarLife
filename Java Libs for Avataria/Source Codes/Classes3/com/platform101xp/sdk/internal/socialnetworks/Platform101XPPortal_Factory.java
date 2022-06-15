package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPPortal_Factory implements Factory<Platform101XPPortal> {
    private final Provider<String> clientIdProvider;
    private final Provider<Platform101XPSocialNetwork.SocialNetworkListener> listenerProvider;
    private final Provider<Platform101XPTokenManager> tokenManagerProvider;

    public Platform101XPPortal_Factory(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<String> provider2, Provider<Platform101XPTokenManager> provider3) {
        this.listenerProvider = provider;
        this.clientIdProvider = provider2;
        this.tokenManagerProvider = provider3;
    }

    public Platform101XPPortal get() {
        Platform101XPPortal newInstance = newInstance((Platform101XPSocialNetwork.SocialNetworkListener) this.listenerProvider.get(), (String) this.clientIdProvider.get());
        Platform101XPPortal_MembersInjector.injectTokenManager(newInstance, (Platform101XPTokenManager) this.tokenManagerProvider.get());
        return newInstance;
    }

    public static Platform101XPPortal_Factory create(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<String> provider2, Provider<Platform101XPTokenManager> provider3) {
        return new Platform101XPPortal_Factory(provider, provider2, provider3);
    }

    public static Platform101XPPortal newInstance(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, String str) {
        return new Platform101XPPortal(socialNetworkListener, str);
    }
}
