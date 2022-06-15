package com.platform101xp.sdk.internal.rewarded_ad;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPRewardedAdManager_MembersInjector implements MembersInjector<Platform101XPRewardedAdManager> {
    private final Provider<Platform101XPRewardedAd> rewardedAdProvider;

    public Platform101XPRewardedAdManager_MembersInjector(Provider<Platform101XPRewardedAd> provider) {
        this.rewardedAdProvider = provider;
    }

    public static MembersInjector<Platform101XPRewardedAdManager> create(Provider<Platform101XPRewardedAd> provider) {
        return new Platform101XPRewardedAdManager_MembersInjector(provider);
    }

    public void injectMembers(Platform101XPRewardedAdManager platform101XPRewardedAdManager) {
        injectRewardedAd(platform101XPRewardedAdManager, (Platform101XPRewardedAd) this.rewardedAdProvider.get());
    }

    public static void injectRewardedAd(Platform101XPRewardedAdManager platform101XPRewardedAdManager, Platform101XPRewardedAd platform101XPRewardedAd) {
        platform101XPRewardedAdManager.rewardedAd = platform101XPRewardedAd;
    }
}
