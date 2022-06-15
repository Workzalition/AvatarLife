package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFacebook_Factory implements Factory<Platform101XPFacebook> {
    private final Provider<Platform101XPConfigManager> currentConfigManagerProvider;
    private final Provider<Platform101XPDialogFactory> dialogsFactoryProvider;
    private final Provider<Platform101XPSocialNetwork.SocialNetworkListener> listenerProvider;

    public Platform101XPFacebook_Factory(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPDialogFactory> provider3) {
        this.listenerProvider = provider;
        this.currentConfigManagerProvider = provider2;
        this.dialogsFactoryProvider = provider3;
    }

    public Platform101XPFacebook get() {
        Platform101XPFacebook newInstance = newInstance((Platform101XPSocialNetwork.SocialNetworkListener) this.listenerProvider.get(), (Platform101XPConfigManager) this.currentConfigManagerProvider.get());
        Platform101XPFacebook_MembersInjector.injectDialogsFactory(newInstance, (Platform101XPDialogFactory) this.dialogsFactoryProvider.get());
        return newInstance;
    }

    public static Platform101XPFacebook_Factory create(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPDialogFactory> provider3) {
        return new Platform101XPFacebook_Factory(provider, provider2, provider3);
    }

    public static Platform101XPFacebook newInstance(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        return new Platform101XPFacebook(socialNetworkListener, platform101XPConfigManager);
    }
}
