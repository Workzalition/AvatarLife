package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$14 implements Platform101XPEulaDialog.AuthorizeListener {
    Platform101XP$14() {
    }

    @Override // com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog.AuthorizeListener
    public void doAuthorizeAction(boolean z) {
        Platform101XP.access$2202(false);
        if (Platform101XP.access$000() != null) {
            if (z) {
                Platform101XP.access$2300(Platform101XP.access$000());
            } else {
                Platform101XP.access$2400(Platform101XP.access$000());
            }
        }
    }
}
