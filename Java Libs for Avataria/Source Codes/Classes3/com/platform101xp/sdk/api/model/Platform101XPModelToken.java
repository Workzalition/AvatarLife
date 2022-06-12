package com.platform101xp.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelToken implements Platform101XPModel {
    public String access;

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        this.access = jSONObject.getJSONObject("access").toString();
    }
}
