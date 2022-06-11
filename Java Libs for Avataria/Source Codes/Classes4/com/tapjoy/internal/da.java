package com.tapjoy.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class da {
    private final boolean a = false;
    private final Float b = null;
    private final boolean c = false;
    private final cz d;

    public da(cz czVar) {
        this.d = czVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.a);
            if (this.a) {
                jSONObject.put("skipOffset", this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put("position", this.d);
        } catch (JSONException e) {
            Cdo.a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }
}
