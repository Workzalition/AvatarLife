package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$16 implements Platform101XPFirebaseDbManager.DataChangeListener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$16(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataChangeListener
    public void doAfterGetProviderToken(String str) {
        if (str != null) {
            Platform101XP.access$1100(Platform101XP.access$000()).deserializeInCurrentToken(str);
        }
        if (Platform101XP.getToken() != null) {
            Platform101XP.access$1002(Platform101XP.access$000(), Platform101XP.access$1100(Platform101XP.access$000()).isGuestCurrentToken());
            Platform101XP.access$2600();
            Platform101XPSettings.saveBoolean(Platform101XPGoogle.GOOGLE_FIRST_LAUNCH_KEY, true);
            return;
        }
        Platform101XP.access$800(Platform101XP.access$000()).getFactory().getProgressDialog().dismiss();
        if (Platform101XP.access$2700(this.this$0)) {
            Platform101XP.access$2400(Platform101XP.access$000());
        } else {
            Platform101XP.access$2800(this.this$0);
        }
    }
}
