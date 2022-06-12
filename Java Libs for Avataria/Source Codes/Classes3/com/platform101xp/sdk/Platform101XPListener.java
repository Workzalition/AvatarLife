package com.platform101xp.sdk;

import com.platform101xp.sdk.entities.Platform101XPSocialFriend;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface Platform101XPListener {
    void onAuthorizeResult(Platform101XPToken platform101XPToken, Platform101XPError platform101XPError);

    void onBillingInitializeResult(Platform101XPError platform101XPError);

    void onFinishPurchaseResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError);

    void onGetAnalyticsConversionData(Map map);

    void onGetProductsResult(List<Platform101XPProduct> list, Platform101XPError platform101XPError);

    void onGetSocialFriendsResult(List<Platform101XPSocialFriend> list, Platform101XPError platform101XPError);

    void onInitializeResult(Platform101XPError platform101XPError);

    void onInviteResult(Platform101XPError platform101XPError);

    void onLogout();

    void onMessageReceived(Platform101XPMessage platform101XPMessage);

    void onOfferwallAdCredits(Map<String, String> map, Platform101XPError platform101XPError);

    void onOfferwallAdLoaded();

    void onPurchaseProductResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError);

    void onRewardedAdLoaded();

    void onRewardedAdShowed(int i, String str, Platform101XPError platform101XPError);

    void onRewardedInvite(String str);

    boolean onRewardedInviteLinkRecipient(String str, String str2);

    void onRewardedInviteLinkSender(String str);
}
