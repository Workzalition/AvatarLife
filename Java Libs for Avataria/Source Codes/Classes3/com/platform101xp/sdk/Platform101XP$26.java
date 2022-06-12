package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import com.platform101xp.sdk.internal.logcathelper.Platform101XPUILogSender;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$26 implements Platform101XPProfileActionsListener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$26(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onUserUpdate(String str) {
        Platform101XP.access$3500(Platform101XP.access$000(), str);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onAuthorizeClick() {
        Platform101XP.access$2900();
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onCancelClick() {
        if (Platform101XP.access$000() != null) {
            Platform101XP.access$4000(Platform101XP.access$000(), "sdk_profile_close");
            if (!Platform101XP.access$1000(Platform101XP.access$000()) && Platform101XP.isLoggedIn()) {
                Platform101XP.showProfile();
            } else {
                Platform101XP.access$2500("Profile Dialog");
            }
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onDismissDialog() {
        Platform101XP.access$4000(Platform101XP.access$000(), "sdk_profile_close");
        Platform101XP.access$4100();
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onLogoutClick(long j) {
        if (Platform101XP.access$000() != null) {
            Platform101XP.access$4000(Platform101XP.access$000(), "sdk_profile_close");
            if (Platform101XP.access$300(Platform101XP.access$000()) != null && j != -1) {
                Platform101XP.access$300(Platform101XP.access$000()).removeLatestAccount(j);
            }
            if (Platform101XP.access$1000(Platform101XP.access$000()) && !Platform101XP.access$800(Platform101XP.access$000()).isWebDialogs()) {
                Platform101XP.access$1500(Platform101XPWarningDialogs.WarningType.GUEST_LOGOUT_WARNING, (Platform101XPSNType) null);
                return;
            }
            Platform101XP.logout();
            Platform101XP.access$3000();
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onCloseClick() {
        Platform101XP.access$2500("Profile Dialog");
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onDeleteLatestAccount(long j) {
        if (j == Platform101XP.access$1100(Platform101XP.access$000()).getCurrentAccountId()) {
            Platform101XP.logout();
        } else {
            Platform101XP.access$300(Platform101XP.access$000()).removeLatestAccount(j);
        }
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onRestoreProduct() {
        Platform101XP.restoreProducts();
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener
    public void onSendLogs() {
        new Platform101XPUILogSender(Platform101XP.getApplicationContext(), Platform101XP.getCurrentActivity()).showLogs(Platform101XP.access$800(Platform101XP.access$000()), new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.Platform101XP$26.1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                Platform101XP.access$2500("logs Dialog");
            }
        });
    }
}
