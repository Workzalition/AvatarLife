package com.platform101xp.sdk.internal.rewarded_ad;

import com.platform101xp.sdk.Platform101XP;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSomeAdSource implements Platform101XPRewardedAd {
    private boolean isEnabled = false;

    private void checkEnabled() {
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public boolean isOfferwallAvailable() throws ClassNotFoundException, NoClassDefFoundError {
        return false;
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public boolean isRewardedVideoLoaded() throws ClassNotFoundException, NoClassDefFoundError {
        return false;
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public void onPause() throws ClassNotFoundException, NoClassDefFoundError {
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public void onResume() throws ClassNotFoundException, NoClassDefFoundError {
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public void setUserId(String str) throws ClassNotFoundException, NoClassDefFoundError {
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public void showOfferwallAd(String str) throws ClassNotFoundException, NoClassDefFoundError {
    }

    @Override // com.platform101xp.sdk.internal.rewarded_ad.Platform101XPRewardedAd
    public void showRewardedAd() throws ClassNotFoundException, NoClassDefFoundError {
    }

    @Inject
    public Platform101XPSomeAdSource() {
        checkEnabled();
    }

    private void initialize() throws ClassNotFoundException, NoClassDefFoundError {
        Platform101XP.getCurrentActivity();
    }
}
