package com.platform101xp.sdk.internal.rewarded_ad;

import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class DaggerPlatform101XPRewardAdComponent implements Platform101XPRewardAdComponent {
    private final DaggerPlatform101XPRewardAdComponent platform101XPRewardAdComponent;
    private final Platform101XPRewardAdModule platform101XPRewardAdModule;

    private DaggerPlatform101XPRewardAdComponent(Platform101XPRewardAdModule platform101XPRewardAdModule) {
        this.platform101XPRewardAdComponent = this;
        this.platform101XPRewardAdModule = platform101XPRewardAdModule;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardAdComponent
    public Platform101XPRewardedAdManager getRewardedAdManager() {
        return injectPlatform101XPRewardedAdManager(Platform101XPRewardedAdManager_Factory.newInstance());
    }

    private Platform101XPRewardedAdManager injectPlatform101XPRewardedAdManager(Platform101XPRewardedAdManager platform101XPRewardedAdManager) {
        Platform101XPRewardedAdManager_MembersInjector.injectRewardedAd(platform101XPRewardedAdManager, Platform101XPRewardAdModule_GetRewardedAdFactory.getRewardedAd(this.platform101XPRewardAdModule));
        return platform101XPRewardedAdManager;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Builder {
        private Platform101XPRewardAdModule platform101XPRewardAdModule;

        private Builder() {
        }

        public Builder platform101XPRewardAdModule(Platform101XPRewardAdModule platform101XPRewardAdModule) {
            this.platform101XPRewardAdModule = (Platform101XPRewardAdModule) Preconditions.checkNotNull(platform101XPRewardAdModule);
            return this;
        }

        public Platform101XPRewardAdComponent build() {
            Preconditions.checkBuilderRequirement(this.platform101XPRewardAdModule, Platform101XPRewardAdModule.class);
            return new DaggerPlatform101XPRewardAdComponent(this.platform101XPRewardAdModule);
        }
    }
}
