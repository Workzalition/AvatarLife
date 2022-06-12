package com.platform101xp.sdk;

import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelAccount;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$33 implements Platform101XPHttpRequest.HttpRequestListener {
    final /* synthetic */ Platform101XPToken val$token;

    Platform101XP$33(Platform101XPToken platform101XPToken) {
        this.val$token = platform101XPToken;
    }

    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        if (platform101XPError != null && platform101XPError.getErrorType().equals(Platform101XPError.ErrorType.ERROR_CONNECTION)) {
            Platform101XP.access$1300((Platform101XPToken) null, platform101XPError);
        } else if (platform101XPModel != null) {
            Platform101XPModelAccount platform101XPModelAccount = (Platform101XPModelAccount) platform101XPModel;
            Platform101XP.access$4800(platform101XPModelAccount.displayName, Platform101XP.access$1100(Platform101XP.access$000()).getCurrentAccountId(), platform101XPModelAccount.email, platform101XPModelAccount.photoUrl, platform101XPModelAccount.properties);
            if (Platform101XP.access$000() == null || Platform101XP.access$300(Platform101XP.access$000()) == null || Platform101XP.access$1100(Platform101XP.access$000()) == null || Platform101XP.access$4200(Platform101XP.access$000()) == null) {
                return;
            }
            long currentAccountId = Platform101XP.access$1100(Platform101XP.access$000()).getCurrentAccountId();
            long currentUserGameId = Platform101XP.access$1100(Platform101XP.access$000()).getCurrentUserGameId();
            String provider = this.val$token.getProvider();
            String userName = Platform101XP.access$4200(Platform101XP.access$000()).getUserName();
            String serializeCurrentToken = Platform101XP.access$1100(Platform101XP.access$000()).serializeCurrentToken();
            if (Platform101XP.access$300(Platform101XP.access$000()).checkContainsAccount(currentAccountId)) {
                return;
            }
            Platform101XP.access$300(Platform101XP.access$000()).writeLatestAccount(currentAccountId, currentUserGameId, provider, userName, serializeCurrentToken);
        } else {
            Platform101XP.access$4800(Platform101XP.getCurrentActivity().getString(R.string.welcome_player), Platform101XP.access$1100(Platform101XP.access$000()).getCurrentAccountId(), (String) null, "", (Map) null);
        }
    }
}
