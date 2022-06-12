package com.platform101xp.sdk;

import android.app.Dialog;
import com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$22 implements Runnable {
    final /* synthetic */ Platform101XPAuthorizeActionsListener val$authorizeActionsListener;

    Platform101XP$22(Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener) {
        this.val$authorizeActionsListener = platform101XPAuthorizeActionsListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog authorizeDialogs = Platform101XP.access$800(Platform101XP.access$000()).getFactory().getAuthorizeDialogs(this.val$authorizeActionsListener, Platform101XP.isLoggedIn() && Platform101XP.isGuest(), Platform101XP.access$3600(Platform101XP.access$000()), Platform101XP.access$300(Platform101XP.access$000()).getLatestAccounts());
        if (authorizeDialogs != null) {
            authorizeDialogs.show();
        }
    }
}
