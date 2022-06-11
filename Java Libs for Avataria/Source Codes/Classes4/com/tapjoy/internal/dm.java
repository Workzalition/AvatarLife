package com.tapjoy.internal;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dm {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        dn.a(jSONObject, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        dn.a(jSONObject, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        dn.a(jSONObject, "os", "Android");
        return jSONObject;
    }
}
