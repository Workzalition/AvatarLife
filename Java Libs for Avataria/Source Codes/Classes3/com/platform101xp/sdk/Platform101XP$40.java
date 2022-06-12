package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.Platform101XPEmulatorDetector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$40 implements Platform101XPEmulatorDetector.ListenerDetector {
    Map<String, Object> eventValue = new HashMap();
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$40(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.internal.Platform101XPEmulatorDetector.ListenerDetector
    public void onSuccess(boolean z) {
        this.eventValue.put("is_emulator", Boolean.valueOf(z));
        Platform101XP.analyticsTrack("sdk_detect_emulator", this.eventValue);
    }
}
