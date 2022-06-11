package com.tapjoy.internal;

import com.tapjoy.TapjoyURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fz {
    String a;
    String b;
    String c;
    TapjoyURLConnection d;
    private Map<String, String> e = new HashMap();
    private boolean f;

    public fz(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.a = str;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.e.put(next, jSONObject.optString(next));
        }
        this.b = jSONObject2.optString("show");
        this.c = jSONObject2.optString("error");
        this.d = new TapjoyURLConnection();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tapjoy.internal.fz$1] */
    public final void a() {
        if (js.c(this.b) || this.f) {
            return;
        }
        this.f = true;
        final HashMap hashMap = new HashMap(this.e);
        new Thread() { // from class: com.tapjoy.internal.fz.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                super.run();
                TapjoyURLConnection tapjoyURLConnection = fz.this.d;
                tapjoyURLConnection.getResponseFromURL(fz.this.a + fz.this.b, (Map) null, (Map) null, hashMap);
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.tapjoy.internal.fz$2] */
    public final void a(String str) {
        if (!js.c(this.c)) {
            final HashMap hashMap = new HashMap(this.e);
            hashMap.put("error", str);
            new Thread() { // from class: com.tapjoy.internal.fz.2
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    TapjoyURLConnection tapjoyURLConnection = fz.this.d;
                    tapjoyURLConnection.getResponseFromURL(fz.this.a + fz.this.c, (Map) null, (Map) null, hashMap);
                }
            }.start();
        }
    }
}
