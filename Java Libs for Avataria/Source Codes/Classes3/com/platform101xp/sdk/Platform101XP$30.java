package com.platform101xp.sdk;

import android.app.Dialog;
import android.os.Bundle;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$30 implements Runnable {
    final /* synthetic */ Bundle val$savedInstanceState;

    Platform101XP$30(Bundle bundle) {
        this.val$savedInstanceState = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        Dialog eulaDialog = Platform101XP.access$800(Platform101XP.access$000()).getFactory().getEulaDialog(new Platform101XPEulaDialog.AuthorizeListener() { // from class: com.platform101xp.sdk.Platform101XP$30.1
            @Override // com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog.AuthorizeListener
            public void doAuthorizeAction(boolean z) {
                Platform101XP.access$1802(false);
                if (Platform101XP$30.this.val$savedInstanceState.getBoolean(Platform101XP.access$4500())) {
                    Platform101XP.access$4600(Platform101XPDialogType.DIALOG_MANAGED_AUTHORIZE);
                }
                if (Platform101XP$30.this.val$savedInstanceState.getBoolean(Platform101XP.access$4700())) {
                    Platform101XP.access$4600(Platform101XPDialogType.DIALOG_AUTHORIZE);
                }
                if (Platform101XP$30.this.val$savedInstanceState.getBoolean(Platform101XPEulaDialog.EULA_DIALOG_AUTHORIZE_ACTION)) {
                    Platform101XP.access$2202(false);
                    if (z) {
                        Platform101XP.access$2300(Platform101XP.access$000());
                    } else {
                        Platform101XP.access$2400(Platform101XP.access$000());
                    }
                }
            }
        }, new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.Platform101XP$30.2
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                Platform101XP.access$2500("Eula Dialog");
            }
        });
        if (eulaDialog != null) {
            eulaDialog.show();
        }
    }
}
