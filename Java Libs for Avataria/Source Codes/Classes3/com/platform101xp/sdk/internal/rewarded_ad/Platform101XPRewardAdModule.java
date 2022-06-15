package com.platform101xp.sdk.internal.rewarded_ad;

import com.platform101xp.sdk.Platform101XPListener;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPRewardAdModule {
    private final Platform101XPListener platform101XPListener;

    public Platform101XPRewardAdModule(Platform101XPListener platform101XPListener) {
        this.platform101XPListener = platform101XPListener;
    }

    @Provides
    public Platform101XPRewardedAd getRewardedAd() {
        return new Platform101XPSomeAdSource();
    }
}
