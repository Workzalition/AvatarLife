package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPSNManager_Factory implements Factory<Platform101XPSNManager> {
    private final Provider<String> clientIdProvider;
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Platform101XPSocialNetwork.SocialNetworkListener> listenerProvider;
    private final Provider<Platform101XPFacebook> snFacebookProvider;
    private final Provider<Platform101XPGoogle> snGoogleProvider;
    private final Provider<Platform101XPOK> snOkProvider;
    private final Provider<Platform101XPPortal> snPortalProvider;
    private final Provider<Platform101XPVK> snVkProvider;

    public Platform101XPSNManager_Factory(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<String> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPPortal> provider4, Provider<Platform101XPFacebook> provider5, Provider<Platform101XPVK> provider6, Provider<Platform101XPOK> provider7, Provider<Platform101XPGoogle> provider8) {
        this.listenerProvider = provider;
        this.clientIdProvider = provider2;
        this.configManagerProvider = provider3;
        this.snPortalProvider = provider4;
        this.snFacebookProvider = provider5;
        this.snVkProvider = provider6;
        this.snOkProvider = provider7;
        this.snGoogleProvider = provider8;
    }

    public Platform101XPSNManager get() {
        Platform101XPSNManager newInstance = newInstance((Platform101XPSocialNetwork.SocialNetworkListener) this.listenerProvider.get(), (String) this.clientIdProvider.get());
        Platform101XPSNManager_MembersInjector.injectConfigManager(newInstance, (Platform101XPConfigManager) this.configManagerProvider.get());
        Platform101XPSNManager_MembersInjector.injectSnPortal(newInstance, (Platform101XPPortal) this.snPortalProvider.get());
        Platform101XPSNManager_MembersInjector.injectSnFacebook(newInstance, (Platform101XPFacebook) this.snFacebookProvider.get());
        Platform101XPSNManager_MembersInjector.injectSnVk(newInstance, (Platform101XPVK) this.snVkProvider.get());
        Platform101XPSNManager_MembersInjector.injectSnOk(newInstance, (Platform101XPOK) this.snOkProvider.get());
        Platform101XPSNManager_MembersInjector.injectSnGoogle(newInstance, (Platform101XPGoogle) this.snGoogleProvider.get());
        return newInstance;
    }

    public static Platform101XPSNManager_Factory create(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<String> provider2, Provider<Platform101XPConfigManager> provider3, Provider<Platform101XPPortal> provider4, Provider<Platform101XPFacebook> provider5, Provider<Platform101XPVK> provider6, Provider<Platform101XPOK> provider7, Provider<Platform101XPGoogle> provider8) {
        return new Platform101XPSNManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Platform101XPSNManager newInstance(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, String str) {
        return new Platform101XPSNManager(socialNetworkListener, str);
    }
}
