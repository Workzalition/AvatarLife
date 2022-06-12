package com.platform101xp.sdk.api.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPModelStoreProducts implements Platform101XPModel {
    public List<JSONObject> products;

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        List<JSONObject> list = this.products;
        if (list == null) {
            this.products = new ArrayList();
        } else {
            list.clear();
        }
        JSONArray jSONArray = jSONObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
        for (int i = 0; i < jSONArray.length(); i++) {
            this.products.add(jSONArray.getJSONObject(i));
        }
    }
}
