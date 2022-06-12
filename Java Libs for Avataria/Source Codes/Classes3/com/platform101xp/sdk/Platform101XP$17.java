package com.platform101xp.sdk;

import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$17 implements Platform101XPHttpRequest.HttpRequestListener {
    final /* synthetic */ Platform101XP this$0;
    final /* synthetic */ boolean val$guestSession;
    final /* synthetic */ Platform101XPToken val$token;

    Platform101XP$17(Platform101XP platform101XP, Platform101XPToken platform101XPToken, boolean z) {
        this.this$0 = platform101XP;
        this.val$token = platform101XPToken;
        this.val$guestSession = z;
    }

    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        if (platform101XPError == null) {
            Platform101XP.access$1300(this.val$token, (Platform101XPError) null);
        } else if (this.val$token.isDeviceToken()) {
            Platform101XP.logout();
            if (this.val$guestSession) {
                Platform101XP.access$1700();
            } else {
                Platform101XP.access$2900();
            }
        } else {
            Platform101XP.access$2600();
        }
    }
}
