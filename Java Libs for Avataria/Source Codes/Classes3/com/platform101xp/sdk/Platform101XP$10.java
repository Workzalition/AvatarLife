package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPApplicationReviewListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$10 implements Platform101XPApplicationReviewListener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$10(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.internal.Platform101XPApplicationReviewListener
    public void reviewSuccess() {
        Log.d("101XP SDK", "Application review success");
    }

    @Override // com.platform101xp.sdk.internal.Platform101XPApplicationReviewListener
    public void reviewFailed(Exception exc) {
        Log.d("101XP SDK", "Application review failed: " + exc.getMessage());
    }
}
