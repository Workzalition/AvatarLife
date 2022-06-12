package com.platform101xp.sdk;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$31 implements Runnable {
    final /* synthetic */ Platform101XPError val$error;

    Platform101XP$31(Platform101XPError platform101XPError) {
        this.val$error = platform101XPError;
    }

    @Override // java.lang.Runnable
    public void run() {
        Platform101XP.access$700(Platform101XP.access$000()).onAuthorizeResult(null, this.val$error);
    }
}
