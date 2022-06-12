package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.dialogs.Platform101XPWarningActionsListener;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$23 implements Platform101XPWarningActionsListener {
    final /* synthetic */ Platform101XPSNType val$snType;
    final /* synthetic */ Platform101XPWarningDialogs.WarningType val$warningType;

    Platform101XP$23(Platform101XPSNType platform101XPSNType, Platform101XPWarningDialogs.WarningType warningType) {
        this.val$snType = platform101XPSNType;
        this.val$warningType = warningType;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPWarningActionsListener
    public void onBindYesClick() {
        if (this.val$snType != null) {
            Platform101XP.getSnManager().authorize(this.val$snType);
        } else {
            Platform101XP.access$2900();
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPWarningActionsListener
    public void onExitClick() {
        Platform101XP.logout();
        if (Platform101XP.access$3700(Platform101XP.access$000())) {
            Platform101XP.getCurrentActivity().finish();
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPWarningActionsListener
    public void onCancelClick() {
        if (this.val$snType == null) {
            if (this.val$warningType != Platform101XPWarningDialogs.WarningType.ACCOUNT_HAS_BIND_WARNING) {
                Platform101XP.showProfile();
            } else if (this.val$warningType == Platform101XPWarningDialogs.WarningType.ACCOUNT_HAS_BIND_WARNING) {
                Platform101XP.access$800(Platform101XP.access$000()).dismissDialogs();
            } else if (Platform101XP.access$1000(Platform101XP.access$000()) && Platform101XP.access$3800(Platform101XP.access$000())) {
                Platform101XP.access$1700();
            } else {
                Platform101XP.access$2900();
            }
        } else {
            Platform101XP.showProfile();
        }
        Platform101XP.access$2500("Warning Dialog");
    }
}
