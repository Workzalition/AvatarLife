package com.platform101xp.sdk;

import android.app.Dialog;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$28 implements Runnable {
    final /* synthetic */ Platform101XP this$0;
    final /* synthetic */ String val$page;

    Platform101XP$28(Platform101XP platform101XP, String str) {
        this.this$0 = platform101XP;
        this.val$page = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog profileDialogs = Platform101XP.access$800(Platform101XP.access$000()).getFactory().getProfileDialogs(Platform101XP.isGuest(), Platform101XP.access$4200(Platform101XP.access$000()), Platform101XP.access$600(Platform101XP.access$000()).getCurrentSupport(), Platform101XP.access$4300(Platform101XP.access$000()), Platform101XP.access$1100(Platform101XP.access$000()).getCurrentUserGameId(), Platform101XP.getToken().getAccessToken().getId(), Platform101XP.access$300(Platform101XP.access$000()).getLatestAccounts(), this.val$page);
        if (profileDialogs != null) {
            Platform101XP access$000 = Platform101XP.access$000();
            Platform101XP.access$4000(access$000, "sdk_open" + this.val$page);
            profileDialogs.show();
        }
    }
}
