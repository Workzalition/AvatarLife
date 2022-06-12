package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$29 implements Platform101XPHttpRequest.HttpRequestListener {
    Platform101XP$29() {
    }

    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        if (platform101XPError != null) {
            Platform101XP.access$1200(platform101XPError.toString());
            return;
        }
        Log.d("101XP SDK", "Logout request done!");
        Platform101XP.access$4400(Platform101XP.access$000(), "sdk_account_logout");
    }
}
