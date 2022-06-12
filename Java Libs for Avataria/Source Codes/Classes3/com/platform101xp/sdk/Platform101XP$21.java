package com.platform101xp.sdk;

import android.view.View;
import com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$21 implements Platform101XPAuthorizeActionsListener {
    Platform101XP$21() {
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener
    public void onAuthorizeClick(View view) {
        Platform101XPSNType platform101XPSNType = (Platform101XPSNType) view.getTag();
        Platform101XP.access$3300(platform101XPSNType.getValue());
        if (Platform101XP.access$1000(Platform101XP.access$000()) && Platform101XP.getToken() != null && !Platform101XP.access$800(Platform101XP.access$000()).isWebDialogs()) {
            Platform101XP.access$1500(Platform101XPWarningDialogs.WarningType.AUTHORIZE_ACTION_WARNING, platform101XPSNType);
            return;
        }
        Platform101XP.access$800(Platform101XP.access$000()).getFactory().getProgressDialog().show();
        Platform101XP.getSnManager().authorize(platform101XPSNType);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener
    public void onGuestClick() {
        Platform101XP.access$800(Platform101XP.access$000()).getFactory().getProgressDialog().show();
        Platform101XP.access$3400();
        Platform101XP.access$1700();
        Platform101XP.access$800(Platform101XP.access$000()).dismissCurrentDialog(Platform101XPDialogType.DIALOG_AUTHORIZE);
        Platform101XP.access$800(Platform101XP.access$000()).dismissCurrentDialog(Platform101XPDialogType.DIALOG_MANAGED_AUTHORIZE);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener
    public void onCancelClick() {
        Platform101XP.access$2500("Authorize Dialog");
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener
    public void onUserUpdate(String str) {
        Platform101XP.access$3500(Platform101XP.access$000(), str);
    }
}
