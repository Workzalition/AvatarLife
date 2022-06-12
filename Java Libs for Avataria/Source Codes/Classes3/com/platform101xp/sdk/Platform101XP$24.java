package com.platform101xp.sdk;

import android.app.Dialog;
import com.platform101xp.sdk.internal.dialogs.Platform101XPWarningActionsListener;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$24 implements Runnable {
    final /* synthetic */ Platform101XPWarningActionsListener val$warningActionsListener;
    final /* synthetic */ Platform101XPWarningDialogs.WarningType val$warningType;

    Platform101XP$24(Platform101XPWarningDialogs.WarningType warningType, Platform101XPWarningActionsListener platform101XPWarningActionsListener) {
        this.val$warningType = warningType;
        this.val$warningActionsListener = platform101XPWarningActionsListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog warningDialog = Platform101XP.access$800(Platform101XP.access$000()).getFactory().getWarningDialog(this.val$warningType, this.val$warningActionsListener);
        if (warningDialog != null) {
            warningDialog.show();
        }
    }
}
