package com.platform101xp.sdk;

import android.app.Dialog;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$39 implements Runnable {
    final /* synthetic */ Platform101XPDialogs.OnUserCancelAction val$cancelAction;

    Platform101XP$39(Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        this.val$cancelAction = onUserCancelAction;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog inviteDialog = Platform101XP.access$800(Platform101XP.access$000()).getFactory().getInviteDialog(Platform101XP.getSnManager(), this.val$cancelAction);
        if (inviteDialog != null) {
            inviteDialog.show();
        }
    }
}
