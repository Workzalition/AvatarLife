package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.token.RefreshTokenListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$20 implements RefreshTokenListener {
    Platform101XP$20() {
    }

    @Override // com.platform101xp.sdk.internal.token.RefreshTokenListener
    public void onRefreshTokenResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        if (Platform101XP.access$3200(platform101XPError)) {
            Platform101XP.logout();
            Platform101XP.access$2900();
            return;
        }
        Platform101XPToken platform101XPToken = null;
        if (platform101XPModel != null) {
            platform101XPToken = Platform101XP.getToken();
            if (platform101XPToken != null) {
                Platform101XP.access$1100(Platform101XP.access$000()).refreshCurrentToken(((Platform101XPModelToken) platform101XPModel).access);
            } else {
                platform101XPError = new Platform101XPError(new Exception("Error refresh token, token is null."));
            }
        }
        if (Platform101XP.access$000() != null && Platform101XP.access$300(Platform101XP.access$000()) != null && platform101XPError == null) {
            Platform101XP.access$300(Platform101XP.access$000()).saveUserToken(Platform101XP.access$1100(Platform101XP.access$000()).serializeCurrentToken(), new Platform101XPFirebaseDbManager.DataResultListener() { // from class: com.platform101xp.sdk.Platform101XP$20.1
                @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataResultListener
                public void onActionResult(Platform101XPError platform101XPError2) {
                    if (platform101XPError2 != null) {
                        Log.d("101XP SDK", platform101XPError2.toString());
                    }
                }
            });
        }
        Platform101XP.access$1300(platform101XPToken, platform101XPError);
    }
}
