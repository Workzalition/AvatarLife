package com.platform101xp.sdk.api.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelTransaction implements Platform101XPModel {
    private String token;
    public int transactionId;

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        this.transactionId = jSONObject.getInt(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.token = jSONObject.optString("token");
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        return "transactionId = " + this.transactionId + " token: " + this.token;
    }
}
