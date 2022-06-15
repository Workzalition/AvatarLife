package com.platform101xp.sdk.internal.rewarded_ad;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPRewardedAdManager_Factory implements Factory<Platform101XPRewardedAdManager> {
    private final Provider<Platform101XPRewardedAd> rewardedAdProvider;

    public Platform101XPRewardedAdManager_Factory(Provider<Platform101XPRewardedAd> provider) {
        this.rewardedAdProvider = provider;
    }

    public Platform101XPRewardedAdManager get() {
        Platform101XPRewardedAdManager newInstance = newInstance();
        Platform101XPRewardedAdManager_MembersInjector.injectRewardedAd(newInstance, (Platform101XPRewardedAd) this.rewardedAdProvider.get());
        return newInstance;
    }

    public static Platform101XPRewardedAdManager_Factory create(Provider<Platform101XPRewardedAd> provider) {
        return new Platform101XPRewardedAdManager_Factory(provider);
    }

    public static Platform101XPRewardedAdManager newInstance() {
        return new Platform101XPRewardedAdManager();
    }
}
