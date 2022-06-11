package com.xp101;

import android.app.Activity;
import android.util.Log;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.platform101xp.sdk.Platform101XP;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class AdManager {
    private static AdManager m_instance;
    ImpressionDataListener mImpressionDataListener;
    InterstitialListener mInterstitialListener;
    RewardedVideoManualListener mRewardedVideoListener;
    private boolean m_interstitialAdLoading;
    private boolean m_interstitialAdONAIR;
    private boolean m_requestedShowRewardedAd;
    private boolean m_rewardedAdLoading;
    private boolean m_rewardedAdONAIR;
    private final String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-1127643830321591/3426118231";
    private final String REWARDED_AD_UNIT_ID = "ca-app-pub-1127643830321591/5477211289";
    private final String IS_AD_UNIT_ID = "13c7433e9";

    /* JADX INFO: Access modifiers changed from: private */
    public static native void didFailToShowAd();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void didHideAd();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void didShowAd();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void requestManualReward();

    public static AdManager getInstance() {
        if (m_instance == null) {
            synchronized (AdManager.class) {
                if (m_instance == null) {
                    m_instance = new AdManager();
                }
            }
        }
        return m_instance;
    }

    public void initialize(Activity activity) {
        IntegrationHelper.validateIntegration(activity);
        startIronSourceInitTask(activity);
        IronSource.getAdvertiserId(activity);
        IronSource.shouldTrackNetworkState(activity, true);
    }

    private void startIronSourceInitTask(Activity activity) {
        initIronSource("13c7433e9", IronSource.getAdvertiserId(activity), activity);
    }

    private void initIronSource(String str, String str2, Activity activity) {
        RewardedVideoManualListener rewardedVideoManualListener = new RewardedVideoManualListener() { // from class: com.xp101.AdManager.1
            public void onRewardedVideoAdClicked(Placement placement) {
            }

            public void onRewardedVideoAdEnded() {
            }

            public void onRewardedVideoAdStarted() {
            }

            public void onRewardedVideoAvailabilityChanged(boolean z) {
            }

            public void onRewardedVideoAdReady() {
                AdManager.this.m_rewardedAdLoading = false;
                if (!AdManager.this.m_requestedShowRewardedAd) {
                    return;
                }
                AdManager.this.showRewardedAd();
            }

            public void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError) {
                Log.d("AVA - ADS", "onRewardedVideoAdLoadFailed: " + ironSourceError);
                AdManager.this.m_rewardedAdLoading = false;
                if (AdManager.this.m_requestedShowRewardedAd) {
                    AdManager.this.showInterstitialAd();
                    AdManager.this.m_requestedShowRewardedAd = false;
                }
            }

            public void onRewardedVideoAdOpened() {
                AdManager.this.m_requestedShowRewardedAd = false;
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didShowAd();
                    }
                });
            }

            public void onRewardedVideoAdClosed() {
                AdManager.this.m_rewardedAdONAIR = false;
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didHideAd();
                    }
                });
                AdManager.this.requestRewardedAd();
            }

            public void onRewardedVideoAdRewarded(Placement placement) {
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.requestManualReward();
                    }
                });
            }

            public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
                Log.d("AVA - ADS", "onRewardedAdFailedToShow: " + ironSourceError);
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didFailToShowAd();
                    }
                });
                AdManager.this.m_rewardedAdONAIR = false;
                AdManager.this.m_requestedShowRewardedAd = false;
            }
        };
        this.mRewardedVideoListener = rewardedVideoManualListener;
        IronSource.setManualLoadRewardedVideo(rewardedVideoManualListener);
        InterstitialListener interstitialListener = new InterstitialListener() { // from class: com.xp101.AdManager.2
            public void onInterstitialAdClicked() {
            }

            public void onInterstitialAdOpened() {
            }

            public void onInterstitialAdReady() {
                AdManager.this.m_interstitialAdLoading = false;
                AdManager.this.showInterstitialAd();
            }

            public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
                Log.d("AVA - ADS", "onAdFailedToLoad: " + ironSourceError);
                AdManager.this.m_interstitialAdLoading = false;
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didFailToShowAd();
                    }
                });
            }

            public void onInterstitialAdClosed() {
                AdManager.this.m_interstitialAdONAIR = false;
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didHideAd();
                        AdManager.requestManualReward();
                    }
                });
            }

            public void onInterstitialAdShowSucceeded() {
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didShowAd();
                    }
                });
            }

            public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
                Log.d("AVA - ADS", "onInterstitialAdShowFailed: " + ironSourceError);
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.AdManager.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdManager.didFailToShowAd();
                    }
                });
                AdManager.this.m_interstitialAdONAIR = false;
            }
        };
        this.mInterstitialListener = interstitialListener;
        IronSource.setInterstitialListener(interstitialListener);
        ImpressionDataListener impressionDataListener = new ImpressionDataListener() { // from class: com.xp101.AdManager.3
            public void onImpressionSuccess(ImpressionData impressionData) {
            }
        };
        this.mImpressionDataListener = impressionDataListener;
        IronSource.addImpressionDataListener(impressionDataListener);
        IronSource.setUserId(str2);
        IronSource.init(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume(Activity activity) {
        IronSource.onResume(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPause(Activity activity) {
        IronSource.onPause(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestRewardedAd() {
        if (Platform101XP.getCurrentActivity() == null) {
            return;
        }
        this.m_requestedShowRewardedAd = false;
        this.m_rewardedAdLoading = true;
        IronSource.loadRewardedVideo();
    }

    void requestInterstitialAd() {
        this.m_interstitialAdLoading = true;
        IronSource.loadInterstitial();
    }

    void showInterstitialAd() {
        if (Platform101XP.getCurrentActivity() != null && !this.m_interstitialAdONAIR && !this.m_rewardedAdONAIR) {
            if (!IronSource.isInterstitialReady()) {
                if (this.m_interstitialAdLoading) {
                    return;
                }
                requestInterstitialAd();
                return;
            }
            this.m_interstitialAdONAIR = true;
            IronSource.showInterstitial();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showRewardedAd() {
        if (Platform101XP.getCurrentActivity() != null && !this.m_rewardedAdONAIR && !this.m_interstitialAdONAIR) {
            if (!IronSource.isRewardedVideoAvailable()) {
                if (!this.m_rewardedAdLoading) {
                    requestRewardedAd();
                }
                this.m_requestedShowRewardedAd = true;
                return;
            }
            this.m_rewardedAdONAIR = true;
            IronSource.showRewardedVideo();
        }
    }
}
