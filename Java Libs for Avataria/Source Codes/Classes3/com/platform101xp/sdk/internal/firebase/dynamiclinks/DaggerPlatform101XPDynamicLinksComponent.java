package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import com.platform101xp.sdk.internal.Platform101XPLinkInvite;
import com.platform101xp.sdk.internal.Platform101XPLinkInvite_Factory;
import com.platform101xp.sdk.internal.Platform101XPLinkInvite_MembersInjector;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPDynamicLinksComponent implements Platform101XPDynamicLinksComponent {
    private final DaggerPlatform101XPDynamicLinksComponent platform101XPDynamicLinksComponent;
    private final Platform101XPDynamicLinksModule platform101XPDynamicLinksModule;

    private DaggerPlatform101XPDynamicLinksComponent(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
        this.platform101XPDynamicLinksComponent = this;
        this.platform101XPDynamicLinksModule = platform101XPDynamicLinksModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks() {
        return injectPlatform101XPFirebaseDynamicLinks(Platform101XPFirebaseDynamicLinks_Factory.newInstance(Platform101XPDynamicLinksModule_GetCurrentActivityFactory.getCurrentActivity(this.platform101XPDynamicLinksModule)));
    }

    private Platform101XPLinkInvite platform101XPLinkInvite() {
        return injectPlatform101XPLinkInvite(Platform101XPLinkInvite_Factory.newInstance());
    }

    private Platform101XPLinkAuthorize platform101XPLinkAuthorize() {
        return injectPlatform101XPLinkAuthorize(Platform101XPLinkAuthorize_Factory.newInstance());
    }

    @Override // com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPDynamicLinksComponent
    public Platform101XPFirebaseDynamicLinksManager getDynamicLinksManager() {
        return injectPlatform101XPFirebaseDynamicLinksManager(Platform101XPFirebaseDynamicLinksManager_Factory.newInstance());
    }

    private Platform101XPFirebaseDynamicLinks injectPlatform101XPFirebaseDynamicLinks(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks) {
        Platform101XPFirebaseDynamicLinks_MembersInjector.injectSetActivity(platform101XPFirebaseDynamicLinks, Platform101XPDynamicLinksModule_GetCurrentActivityFactory.getCurrentActivity(this.platform101XPDynamicLinksModule));
        return platform101XPFirebaseDynamicLinks;
    }

    private Platform101XPLinkInvite injectPlatform101XPLinkInvite(Platform101XPLinkInvite platform101XPLinkInvite) {
        Platform101XPLinkInvite_MembersInjector.injectDynamicLinks(platform101XPLinkInvite, platform101XPFirebaseDynamicLinks());
        Platform101XPLinkInvite_MembersInjector.injectConfigManager(platform101XPLinkInvite, Platform101XPDynamicLinksModule_GetConfigFactory.getConfig(this.platform101XPDynamicLinksModule));
        return platform101XPLinkInvite;
    }

    private Platform101XPLinkAuthorize injectPlatform101XPLinkAuthorize(Platform101XPLinkAuthorize platform101XPLinkAuthorize) {
        Platform101XPLinkAuthorize_MembersInjector.injectTokenManager(platform101XPLinkAuthorize, Platform101XPDynamicLinksModule_GetTokenManagerInstanceFactory.getTokenManagerInstance(this.platform101XPDynamicLinksModule));
        Platform101XPLinkAuthorize_MembersInjector.injectClientId(platform101XPLinkAuthorize, Platform101XPDynamicLinksModule_GetCurrentClientIdFactory.getCurrentClientId(this.platform101XPDynamicLinksModule));
        Platform101XPLinkAuthorize_MembersInjector.injectDeviceId(platform101XPLinkAuthorize, Platform101XPDynamicLinksModule_GetDeviceIdFactory.getDeviceId(this.platform101XPDynamicLinksModule));
        Platform101XPLinkAuthorize_MembersInjector.injectAnalytics(platform101XPLinkAuthorize, Platform101XPDynamicLinksModule_GetAnalyticsFactory.getAnalytics(this.platform101XPDynamicLinksModule));
        return platform101XPLinkAuthorize;
    }

    private Platform101XPFirebaseDynamicLinksManager injectPlatform101XPFirebaseDynamicLinksManager(Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager) {
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectDynamicLinks(platform101XPFirebaseDynamicLinksManager, platform101XPFirebaseDynamicLinks());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectLinkInvite(platform101XPFirebaseDynamicLinksManager, platform101XPLinkInvite());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectLinkAuthorize(platform101XPFirebaseDynamicLinksManager, platform101XPLinkAuthorize());
        Platform101XPFirebaseDynamicLinksManager_MembersInjector.injectAnalytics(platform101XPFirebaseDynamicLinksManager, Platform101XPDynamicLinksModule_GetAnalyticsFactory.getAnalytics(this.platform101XPDynamicLinksModule));
        return platform101XPFirebaseDynamicLinksManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPDynamicLinksModule platform101XPDynamicLinksModule;

        private Builder() {
        }

        public Builder platform101XPDynamicLinksModule(Platform101XPDynamicLinksModule platform101XPDynamicLinksModule) {
            this.platform101XPDynamicLinksModule = (Platform101XPDynamicLinksModule) Preconditions.checkNotNull(platform101XPDynamicLinksModule);
            return this;
        }

        public Platform101XPDynamicLinksComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPDynamicLinksModule, Platform101XPDynamicLinksModule.class);
            return new DaggerPlatform101XPDynamicLinksComponent(this.platform101XPDynamicLinksModule);
        }
    }
}
