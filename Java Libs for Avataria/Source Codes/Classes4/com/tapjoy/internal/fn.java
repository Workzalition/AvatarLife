package com.tapjoy.internal;

import com.tapjoy.TapjoyLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class fn extends fr {
    private static final String b = "fn";

    public fn(String str, String str2) {
        super(str, str2, "ad");
    }

    public final gh$a a(String str, JSONObject jSONObject) {
        return a(str, a(jSONObject), b(jSONObject));
    }

    public final gh$a b(String str, JSONObject jSONObject) {
        return b(str, a(jSONObject), b(jSONObject));
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                TapjoyLog.d(b, "Unable to getAdUnitDimensions. Invalid params: ".concat(String.valueOf(e)));
            }
        }
        return hashMap;
    }

    public static Map<String, Long> b(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("values");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Long.valueOf(jSONObject2.getLong(next)));
                }
            } catch (JSONException e) {
                TapjoyLog.d(b, "Unable to getAdUnitValues. Invalid params: ".concat(String.valueOf(e)));
            }
        }
        return hashMap;
    }
}
