package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.configs.Platform101XPConfigResultListener;
import com.platform101xp.sdk.internal.firebase.database.DaggerPlatform101XPFirebaseDBComponent;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbModule;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$1 implements Platform101XPConfigResultListener {
    Platform101XP$1() {
    }

    @Override // com.platform101xp.sdk.internal.configs.Platform101XPConfigResultListener
    public void netConfigResult(Platform101XPError platform101XPError) {
        if (Platform101XP.access$000() == null) {
            Platform101XP.access$100(new Exception("SDK Instance is null!"));
            return;
        }
        if (Platform101XP.access$000() != null) {
            Platform101XP.access$302(Platform101XP.access$000(), DaggerPlatform101XPFirebaseDBComponent.builder().platform101XPFirebaseDbModule(new Platform101XPFirebaseDbModule(Platform101XP.getCurrentActivity(), Platform101XP.getDeviceId(), new Platform101XPFirebaseDbManager.InitDbResultListener() { // from class: com.platform101xp.sdk.Platform101XP$1.1
                @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.InitDbResultListener
                public void onInitResult(Platform101XPError platform101XPError2) {
                    if (Platform101XP.access$000() != null) {
                        Platform101XP.access$200(Platform101XP.access$000(), platform101XPError2);
                    }
                }
            })).build().getFirebaseDbManager());
            Platform101XP.access$300(Platform101XP.access$000()).readLatestAccounts();
            Platform101XP.access$400(Platform101XP.access$000());
        }
        if (platform101XPError != null) {
            Platform101XP.access$100(new Exception(platform101XPError.toString()));
            return;
        }
        Platform101XP.access$500();
        if (Platform101XP.access$600(Platform101XP.access$000()) == null) {
            return;
        }
        Platform101XP.access$600(Platform101XP.access$000()).updateDataFromConfig();
    }
}
