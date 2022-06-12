package com.platform101xp.sdk;

import android.app.Dialog;
import com.platform101xp.sdk.internal.Platform101XPApplicationReview;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$37 implements Runnable {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$37(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog reviewDialog = Platform101XP.access$5100(Platform101XP.access$000()).getReviewDialog(String.valueOf(Platform101XP.access$1100(Platform101XP.access$000()).getCurrentUserGameId()));
        if (Platform101XP.access$000() == null || Platform101XP.access$5100(Platform101XP.access$000()) == null || Platform101XP.access$1100(Platform101XP.access$000()) == null || reviewDialog == null) {
            return;
        }
        reviewDialog.show();
        Platform101XP.analyticsTrack("rate-window-open", (Map) null);
        Platform101XPSettings.saveLong(Platform101XPApplicationReview.REVIEW_TIME_KEY, System.currentTimeMillis());
    }
}
