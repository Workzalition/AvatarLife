package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPSkinManager;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$6 implements Platform101XPSkinManager.SkinManagerLoadResultListener {
    Platform101XP$6() {
    }

    @Override // com.platform101xp.sdk.internal.Platform101XPSkinManager.SkinManagerLoadResultListener
    public void onSkinLoadResult(Platform101XPError platform101XPError) {
        Log.d("101XP SDK", platform101XPError != null ? platform101XPError.toString() : "Platform101XPSkinManager all skin images loading done!");
    }
}
