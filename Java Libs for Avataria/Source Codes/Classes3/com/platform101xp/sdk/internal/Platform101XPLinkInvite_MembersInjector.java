package com.platform101xp.sdk.internal;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinkInvite_MembersInjector implements MembersInjector<Platform101XPLinkInvite> {
    private final Provider<Platform101XPConfigManager> configManagerProvider;
    private final Provider<Platform101XPFirebaseDynamicLinks> dynamicLinksProvider;

    public Platform101XPLinkInvite_MembersInjector(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPConfigManager> provider2) {
        this.dynamicLinksProvider = provider;
        this.configManagerProvider = provider2;
    }

    public static MembersInjector<Platform101XPLinkInvite> create(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPConfigManager> provider2) {
        return new Platform101XPLinkInvite_MembersInjector(provider, provider2);
    }

    public void injectMembers(Platform101XPLinkInvite platform101XPLinkInvite) {
        injectDynamicLinks(platform101XPLinkInvite, (Platform101XPFirebaseDynamicLinks) this.dynamicLinksProvider.get());
        injectConfigManager(platform101XPLinkInvite, (Platform101XPConfigManager) this.configManagerProvider.get());
    }

    public static void injectDynamicLinks(Platform101XPLinkInvite platform101XPLinkInvite, Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks) {
        platform101XPLinkInvite.dynamicLinks = platform101XPFirebaseDynamicLinks;
    }

    public static void injectConfigManager(Platform101XPLinkInvite platform101XPLinkInvite, Platform101XPConfigManager platform101XPConfigManager) {
        platform101XPLinkInvite.configManager = platform101XPConfigManager;
    }
}
