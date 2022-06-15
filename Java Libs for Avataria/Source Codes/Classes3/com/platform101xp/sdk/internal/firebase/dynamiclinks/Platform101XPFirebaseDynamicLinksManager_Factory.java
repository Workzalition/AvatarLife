package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.Platform101XPLinkInvite;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinksManager_Factory implements Factory<Platform101XPFirebaseDynamicLinksManager> {
    private final Provider<Platform101XPAnalytics> analyticsProvider;
    private final Provider<Platform101XPFirebaseDynamicLinks> dynamicLinksProvider;
    private final Provider<Platform101XPLinkAuthorize> linkAuthorizeProvider;
    private final Provider<Platform101XPLinkInvite> linkInviteProvider;

    public Platform101XPFirebaseDynamicLinksManager_Factory(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPLinkInvite> provider2, Provider<Platform101XPLinkAuthorize> provider3, Provider<Platform101XPAnalytics> provider4) {
        this.dynamicLinksProvider = provider;
        this.linkInviteProvider = provider2;
        this.linkAuthorizeProvider = provider3;
        this.analyticsProvider = provider4;
    }

    public Platform101XPFirebaseDynamicLinksManager get() {
        Platform101XPFirebaseDynamicLinksManager newInstance = newInstance();
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectDynamicLinks(newInstance, (Platform101XPFirebaseDynamicLinks) this.dynamicLinksProvider.get());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectLinkInvite(newInstance, (Platform101XPLinkInvite) this.linkInviteProvider.get());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectLinkAuthorize(newInstance, (Platform101XPLinkAuthorize) this.linkAuthorizeProvider.get());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectAnalytics(newInstance, (Platform101XPAnalytics) this.analyticsProvider.get());
        return newInstance;
    }

    public static Platform101XPFirebaseDynamicLinksManager_Factory create(Provider<Platform101XPFirebaseDynamicLinks> provider, Provider<Platform101XPLinkInvite> provider2, Provider<Platform101XPLinkAuthorize> provider3, Provider<Platform101XPAnalytics> provider4) {
        return new Platform101XPFirebaseDynamicLinksManager_Factory(provider, provider2, provider3, provider4);
    }

    public static Platform101XPFirebaseDynamicLinksManager newInstance() {
        return new Platform101XPFirebaseDynamicLinksManager();
    }
}
