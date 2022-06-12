package com.platform101xp.sdk;

import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelData;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$13 implements Platform101XPHttpRequest.HttpRequestListener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$13(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        String string = Platform101XP.access$2000(this.this$0).getString("com.platform101xp.sdk.geo_ip");
        if (platform101XPError != null) {
            Platform101XP.access$1200("Get user position request: " + platform101XPError);
        } else {
            string = ((Platform101XPModelData) platform101XPModel).getData();
            Platform101XP.access$2000(this.this$0).setString("com.platform101xp.sdk.geo_ip", string);
        }
        Platform101XP.access$2100(this.this$0).handleUserPosition(string);
    }
}
