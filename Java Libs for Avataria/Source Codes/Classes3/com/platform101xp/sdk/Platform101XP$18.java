package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.token.RefreshTokenListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$18 implements Platform101XPEulaDialog.AuthorizeListener {
    Platform101XP$18() {
    }

    @Override // com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog.AuthorizeListener
    public void doAuthorizeAction(boolean z) {
        Platform101XP.access$2202(false);
        if (z) {
            Platform101XP.access$1002(Platform101XP.access$000(), false);
            Platform101XP.access$2300(Platform101XP.access$000());
        } else if (!Platform101XP.isLoggedIn()) {
            Platform101XP.access$2900();
        } else if (Platform101XP.access$1100(Platform101XP.access$000()).isTokenNeedRefresh()) {
            Platform101XP.access$1100(Platform101XP.access$000()).refreshTokenRequest(Platform101XP.access$1400(Platform101XP.access$000()), Platform101XP.access$800(Platform101XP.access$000()).getFactory(), new RefreshTokenListener() { // from class: com.platform101xp.sdk.Platform101XP$18.1
                @Override // com.platform101xp.sdk.internal.token.RefreshTokenListener
                public void onRefreshTokenResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    Platform101XP.access$800(Platform101XP.access$000()).getFactory().getProgressDialog().dismiss();
                    if (platform101XPModel != null && Platform101XP.getToken() != null) {
                        Platform101XP.access$1100(Platform101XP.access$000()).refreshCurrentToken(((Platform101XPModelToken) platform101XPModel).access);
                        Platform101XP.access$3000();
                        if (Platform101XP.access$000() != null && Platform101XP.access$300(Platform101XP.access$000()) != null) {
                            Platform101XP.access$300(Platform101XP.access$000()).saveUserToken(Platform101XP.access$1100(Platform101XP.access$000()).serializeCurrentToken(), new Platform101XPFirebaseDbManager.DataResultListener() { // from class: com.platform101xp.sdk.Platform101XP.18.1.1
                                @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataResultListener
                                public void onActionResult(Platform101XPError platform101XPError2) {
                                    if (platform101XPError2 != null) {
                                        Log.d("101XP SDK", platform101XPError2.toString());
                                    }
                                }
                            });
                        }
                        Platform101XP.access$700(Platform101XP.access$000()).onAuthorizeResult(Platform101XP.getToken(), platform101XPError);
                    }
                    Platform101XP.access$3100();
                }
            });
        } else {
            Platform101XP.access$3100();
        }
    }
}
