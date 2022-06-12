package com.platform101xp.sdk.api.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSkinColorsModel implements Platform101XPModel {
    private Map<String, String> styleColors;

    @Override // com.platform101xp.sdk.api.model.Platform101XPModel
    public void parse(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.styleColors = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String string = jSONObject.getString(next);
            Map<String, String> map = this.styleColors;
            map.put(next, "#" + string);
        }
    }

    public Map<String, String> getStyleColors() {
        return this.styleColors;
    }
}
