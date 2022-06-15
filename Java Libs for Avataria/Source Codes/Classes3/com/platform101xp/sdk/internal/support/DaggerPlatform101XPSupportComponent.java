package com.platform101xp.sdk.internal.support;

import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPSupportComponent implements Platform101XPSupportComponent {
    private final DaggerPlatform101XPSupportComponent platform101XPSupportComponent;
    private final Platform101XPSupportModule platform101XPSupportModule;

    private DaggerPlatform101XPSupportComponent(Platform101XPSupportModule platform101XPSupportModule) {
        this.platform101XPSupportComponent = this;
        this.platform101XPSupportModule = platform101XPSupportModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Platform101XPHelpdesk platform101XPHelpdesk() {
        return injectPlatform101XPHelpdesk(Platform101XPHelpdesk_Factory.newInstance());
    }

    private Platform101XPZendesk platform101XPZendesk() {
        return injectPlatform101XPZendesk(Platform101XPZendesk_Factory.newInstance());
    }

    @Override // com.platform101xp.sdk.internal.support.Platform101XPSupportComponent
    public Platform101XPSupportManager getSupportManager() {
        return injectPlatform101XPSupportManager(Platform101XPSupportManager_Factory.newInstance());
    }

    private Platform101XPHelpdesk injectPlatform101XPHelpdesk(Platform101XPHelpdesk platform101XPHelpdesk) {
        Platform101XPHelpdesk_MembersInjector.injectCurrentActivity(platform101XPHelpdesk, Platform101XPSupportModule_GetActivityFactory.getActivity(this.platform101XPSupportModule));
        Platform101XPHelpdesk_MembersInjector.injectConfigManager(platform101XPHelpdesk, Platform101XPSupportModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSupportModule));
        return platform101XPHelpdesk;
    }

    private Platform101XPZendesk injectPlatform101XPZendesk(Platform101XPZendesk platform101XPZendesk) {
        Platform101XPZendesk_MembersInjector.injectCurrentActivity(platform101XPZendesk, Platform101XPSupportModule_GetActivityFactory.getActivity(this.platform101XPSupportModule));
        Platform101XPZendesk_MembersInjector.injectConfigManager(platform101XPZendesk, Platform101XPSupportModule_GetConfigManagerFactory.getConfigManager(this.platform101XPSupportModule));
        return platform101XPZendesk;
    }

    private Platform101XPSupportManager injectPlatform101XPSupportManager(Platform101XPSupportManager platform101XPSupportManager) {
        Platform101XPSupportManager_MembersInjector.injectSupportHelpdesk(platform101XPSupportManager, platform101XPHelpdesk());
        Platform101XPSupportManager_MembersInjector.injectSupportZendesk(platform101XPSupportManager, platform101XPZendesk());
        return platform101XPSupportManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPSupportModule platform101XPSupportModule;

        private Builder() {
        }

        public Builder platform101XPSupportModule(Platform101XPSupportModule platform101XPSupportModule) {
            this.platform101XPSupportModule = (Platform101XPSupportModule) Preconditions.checkNotNull(platform101XPSupportModule);
            return this;
        }

        public Platform101XPSupportComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPSupportModule, Platform101XPSupportModule.class);
            return new DaggerPlatform101XPSupportComponent(this.platform101XPSupportModule);
        }
    }
}
