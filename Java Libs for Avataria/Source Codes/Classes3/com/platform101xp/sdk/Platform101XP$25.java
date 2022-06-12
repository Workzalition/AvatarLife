package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.token.Platform101XPTokenIds;
import kotlin.Pair;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$25 implements Platform101XPHttpRequest.HttpRequestListener {
    Platform101XP$25() {
    }

    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        String str = platform101XPModel != null ? ((Platform101XPModelToken) platform101XPModel).access : null;
        if (str != null) {
            Platform101XP.access$1002(Platform101XP.access$000(), true);
            Pair<Platform101XPToken, Platform101XPTokenIds> deserializeToken = Platform101XP.access$1100(Platform101XP.access$000()).deserializeToken(str);
            Platform101XP.access$1100(Platform101XP.access$000()).updateCurrentToken(str);
            Platform101XP.access$3900();
            if (Platform101XP.access$000() != null && Platform101XP.access$300(Platform101XP.access$000()) != null) {
                Platform101XP.access$300(Platform101XP.access$000()).saveUserToken(Platform101XP.access$1100(Platform101XP.access$000()).serializeToken(deserializeToken), new Platform101XPFirebaseDbManager.DataResultListener() { // from class: com.platform101xp.sdk.Platform101XP$25.1
                    @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataResultListener
                    public void onActionResult(Platform101XPError platform101XPError2) {
                        if (platform101XPError2 != null) {
                            Log.d("101XP SDK", platform101XPError2.toString());
                        }
                    }
                });
            }
        }
        Platform101XP.access$1300(Platform101XP.getToken(), platform101XPError);
    }
}
