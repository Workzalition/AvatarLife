package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsReferrerListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$7 implements Platform101XPAnalyticsReferrerListener {
    Platform101XP$7() {
    }

    @Override // com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsReferrerListener
    public void onGetReferrer(String str) {
        if (str != null) {
            Platform101XP.access$700(Platform101XP.access$000()).onRewardedInvite(str);
        }
    }
}
