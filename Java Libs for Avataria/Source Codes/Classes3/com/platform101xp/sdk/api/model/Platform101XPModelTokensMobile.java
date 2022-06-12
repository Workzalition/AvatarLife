package com.platform101xp.sdk.api.model;

import com.tapjoy.TapjoyConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Platform101XPModelTokensMobile.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/platform101xp/sdk/api/model/Platform101XPModelTokensMobile;", "Lcom/platform101xp/sdk/api/model/Platform101XPModel;", "()V", TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, "", "getMobile", "()Ljava/lang/String;", "setMobile", "(Ljava/lang/String;)V", "portal", "getPortal", "setPortal", "parse", "", "object", "Lorg/json/JSONObject;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPModelTokensMobile implements Platform101XPModel {
    private String mobile;
    private String portal;

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }

    public final String getPortal() {
        return this.portal;
    }

    public final void setPortal(String str) {
        this.portal = str;
    }

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        this.mobile = String.valueOf(jSONObject == null ? null : jSONObject.optJSONObject(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE));
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject("portal");
        }
        this.portal = String.valueOf(jSONObject2);
    }
}
