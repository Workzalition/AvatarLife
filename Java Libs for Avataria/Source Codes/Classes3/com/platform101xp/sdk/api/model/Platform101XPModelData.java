package com.platform101xp.sdk.api.model;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Platform101XPModelData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/platform101xp/sdk/api/model/Platform101XPModelData;", "Lcom/platform101xp/sdk/api/model/Platform101XPModel;", "()V", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "parse", "", "object", "Lorg/json/JSONObject;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPModelData implements Platform101XPModel {
    private String data;

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        this.data = str;
    }

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) {
        this.data = jSONObject == null ? null : jSONObject.optString("data");
    }
}
