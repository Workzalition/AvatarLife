package com.platform101xp.sdk.internal.socialnetworks;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPGoogle_Factory implements Factory<Platform101XPGoogle> {
    private final Provider<Platform101XPConfigManager> currentConfigManagerProvider;
    private final Provider<Platform101XPDialogFactory> dialogsFactoryProvider;
    private final Provider<Platform101XPSocialNetwork.SocialNetworkListener> listenerProvider;

    public Platform101XPGoogle_Factory(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPDialogFactory> provider3) {
        this.listenerProvider = provider;
        this.currentConfigManagerProvider = provider2;
        this.dialogsFactoryProvider = provider3;
    }

    public Platform101XPGoogle get() {
        Platform101XPGoogle newInstance = newInstance((Platform101XPSocialNetwork.SocialNetworkListener) this.listenerProvider.get(), (Platform101XPConfigManager) this.currentConfigManagerProvider.get());
        Platform101XPGoogle_MembersInjector.injectDialogsFactory(newInstance, (Platform101XPDialogFactory) this.dialogsFactoryProvider.get());
        return newInstance;
    }

    public static Platform101XPGoogle_Factory create(Provider<Platform101XPSocialNetwork.SocialNetworkListener> provider, Provider<Platform101XPConfigManager> provider2, Provider<Platform101XPDialogFactory> provider3) {
        return new Platform101XPGoogle_Factory(provider, provider2, provider3);
    }

    public static Platform101XPGoogle newInstance(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        return new Platform101XPGoogle(socialNetworkListener, platform101XPConfigManager);
    }
}
