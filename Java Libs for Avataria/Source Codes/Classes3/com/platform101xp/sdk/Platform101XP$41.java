package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$41 implements Runnable {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$41(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // java.lang.Runnable
    public void run() {
        Platform101XP.access$800(Platform101XP.access$000()).getFactory().getWarningDialog(Platform101XPWarningDialogs.WarningType.USER_NOT_LOGGED_IN_WARNING, null).show();
    }
}
