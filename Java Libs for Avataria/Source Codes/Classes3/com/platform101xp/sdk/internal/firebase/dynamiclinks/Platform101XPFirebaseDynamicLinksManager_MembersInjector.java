package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.Platform101XPLinkInvite;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinksManager_MembersInjector implements MembersInjector<Platform101XPFirebaseDynamicLinksManager> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<Platform101XPFirebaseDynamicLinks> dynamicLinksProvider;
    private final Provider<Platform101XPLinkAuthorize> linkAuthorizeProvider;
    private final Provider<Platform101XPLinkInvite> linkInviteProvider;

    public Platform101XPFirebaseDynamicLinksManager_MembersInjector(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPLinkInvite> provider2, Provider<Platform101XPLinkAuthorize> provider3, Provider<Platform101XPAnalytics> provider4) {
        this.dynamicLinksProvider = provider;
        this.linkInviteProvider = provider2;
        this.linkAuthorizeProvider = provider3;
        this.analyticsProvider = provider4;
    }

    public static MembersInjector<Platform101XPFirebaseDynamicLinksManager> create(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPLinkInvite> provider2, Provider<Platform101XPLinkAuthorize> provider3, Provider<Platform101XPAnalytics> provider4) {
        return new Platform101XPFirebaseDynamicLinksManager_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager) {
        injectDynamicLinks(platform101XPFirebaseDynamicLinksManager, (Platform101XPFirebaseDynamicLinks) this.dynamicLinksProvider.get());
        injectLinkInvite(platform101XPFirebaseDynamicLinksManager, (Platform101XPLinkInvite) this.linkInviteProvider.get());
        injectLinkAuthorize(platform101XPFirebaseDynamicLinksManager, (Platform101XPLinkAuthorize) this.linkAuthorizeProvider.get());
        injectAnalytics(platform101XPFirebaseDynamicLinksManager, (Platform101XPAnalytics) this.analyticsProvider.get());
    }

    public static void injectDynamicLinks(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager, Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks) {
        platform101XPFirebaseDynamicLinksManager.dynamicLinks = platform101XPFirebaseDynamicLinks;
    }

    public static void injectLinkInvite(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager, Platform101XPLinkInvite platform101XPLinkInvite) {
        platform101XPFirebaseDynamicLinksManager.linkInvite = platform101XPLinkInvite;
    }

    public static void injectLinkAuthorize(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager, Platform101XPLinkAuthorize platform101XPLinkAuthorize) {
        platform101XPFirebaseDynamicLinksManager.linkAuthorize = platform101XPLinkAuthorize;
    }

    public static void injectAnalytics(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager, Platform101XPAnalytics platform101XPAnalytics) {
        platform101XPFirebaseDynamicLinksManager.analytics = platform101XPAnalytics;
    }
}
