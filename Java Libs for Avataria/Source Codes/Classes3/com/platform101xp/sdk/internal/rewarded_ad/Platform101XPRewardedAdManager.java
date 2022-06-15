package com.platform101xp.sdk.internal.rewarded_ad;

import android.util.Log;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPRewardedAdManager {
    @Inject
    Platform101XPRewardedAd rewardedAd;

    public void onResume() {
        try {
            this.rewardedAd.onResume();
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
        }
    }

    public void onPause() {
        try {
            this.rewardedAd.onPause();
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
        }
    }

    public void showRewardedAd() {
        try {
            this.rewardedAd.showRewardedAd();
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
        }
    }

    public boolean isRewardedVideoLoaded() {
        try {
            return this.rewardedAd.isRewardedVideoLoaded();
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
            return false;
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
            return false;
        }
    }

    public boolean isOfferwallAvailable() {
        try {
            return this.rewardedAd.isOfferwallAvailable();
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
            return false;
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
            return false;
        }
    }

    public void showOfferwallAd(String str) {
        try {
            this.rewardedAd.showOfferwallAd(str);
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
        }
    }

    public void setUserId(String str) {
        try {
            this.rewardedAd.setUserId(str);
        } catch (ClassNotFoundException e) {
            Log.d("101XP SDK", e.getMessage());
        } catch (NoClassDefFoundError e2) {
            Log.d("101XP SDK", e2.getMessage());
        }
    }
}
