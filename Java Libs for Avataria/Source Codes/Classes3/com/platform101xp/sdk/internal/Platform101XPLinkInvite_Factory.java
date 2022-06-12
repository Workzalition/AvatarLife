package com.platform101xp.sdk.internal;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinkInvite_Factory implements Factory<Platform101XPLinkInvite> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Platform101XPFirebaseDynamicLinks> dynamicLinksProvider;

    public Platform101XPLinkInvite_Factory(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPConfigManager> provider2) {
        this.dynamicLinksProvider = provider;
        this.configManagerProvider = provider2;
    }

    public Platform101XPLinkInvite get() {
        Platform101XPLinkInvite newInstance = newInstance();
        Platform101XPLinkInvite_MembersInjector.injectDynamicLinks(newInstance, (Platform101XPFirebaseDynamicLinks) this.dynamicLinksProvider.get());
        Platform101XPLinkInvite_MembersInjector.injectConfigManager(newInstance, (Platform101XPConfigManager) this.configManagerProvider.get());
        return newInstance;
    }

    public static Platform101XPLinkInvite_Factory create(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPLinkInvite_Factory(provider, provider2);
    }

    public static Platform101XPLinkInvite newInstance() {
        return new Platform101XPLinkInvite();
    }
}
