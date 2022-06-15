package com.platform101xp.sdk.internal.rewarded_ad;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPRewardAdModule_GetRewardedAdFactory implements Factory<Platform101XPRewardedAd> {
    private final Platform101XPRewardAdModule module;

    public Platform101XPRewardAdModule_GetRewardedAdFactory(Platform101XPRewardAdModule platform101XPRewardAdModule) {
        this.module = platform101XPRewardAdModule;
    }

    public Platform101XPRewardedAd get() {
        return getRewardedAd(this.module);
    }

    public static Platform101XPRewardAdModule_GetRewardedAdFactory create(Platform101XPRewardAdModule platform101XPRewardAdModule) {
        return new Platform101XPRewardAdModule_GetRewardedAdFactory(platform101XPRewardAdModule);
    }

    public static Platform101XPRewardedAd getRewardedAd(Platform101XPRewardAdModule platform101XPRewardAdModule) {
        return (Platform101XPRewardedAd) Preconditions.checkNotNullFromProvides(platform101XPRewardAdModule.getRewardedAd());
    }
}
