package com.platform101xp.sdk;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$32 implements Runnable {
    final /* synthetic */ Platform101XPError val$error;
    final /* synthetic */ Platform101XPToken val$token;

    Platform101XP$32(Platform101XPToken platform101XPToken, Platform101XPError platform101XPError) {
        this.val$token = platform101XPToken;
        this.val$error = platform101XPError;
    }

    @Override // java.lang.Runnable
    public void run() {
        Platform101XP.access$700(Platform101XP.access$000()).onAuthorizeResult(this.val$token, this.val$error);
    }
}
