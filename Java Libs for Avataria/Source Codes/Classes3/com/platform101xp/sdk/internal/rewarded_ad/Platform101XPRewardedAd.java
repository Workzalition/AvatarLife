package com.platform101xp.sdk.internal.rewarded_ad;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPRewardedAd {
    boolean isOfferwallAvailable() throws ClassNotFoundException, NoClassDefFoundError;

    boolean isRewardedVideoLoaded() throws ClassNotFoundException, NoClassDefFoundError;

    void onPause() throws ClassNotFoundException, NoClassDefFoundError;

    void onResume() throws ClassNotFoundException, NoClassDefFoundError;

    void setUserId(String str) throws ClassNotFoundException, NoClassDefFoundError;

    void showOfferwallAd(String str) throws ClassNotFoundException, NoClassDefFoundError;

    void showRewardedAd() throws ClassNotFoundException, NoClassDefFoundError;
}
