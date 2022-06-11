package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class dt {
    public cm a;
    public cy b;
    public int c;
    public long d;
    private ds e = new ds(null);

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};
    }

    public dt() {
        d();
    }

    private boolean e() {
        return this.e.get() != null;
    }

    public void a() {
    }

    public final void a(float f) {
        dg.a().a(c(), f);
    }

    public final void a(WebView webView) {
        this.e = new ds(webView);
    }

    public void a(cx cxVar, cp cpVar) {
        a(cxVar, cpVar, null);
    }

    public final void a(String str) {
        dg.a().a(c(), str, (JSONObject) null);
    }

    public final void a(String str, JSONObject jSONObject) {
        dg.a().a(c(), str, jSONObject);
    }

    public final void a(boolean z) {
        if (e()) {
            dg.a().c(c(), z ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.e.clear();
    }

    public final WebView c() {
        return (WebView) this.e.get();
    }

    public final void a(cx cxVar, cp cpVar, JSONObject jSONObject) {
        String str = cxVar.f;
        JSONObject jSONObject2 = new JSONObject();
        dn.a(jSONObject2, "environment", "app");
        dn.a(jSONObject2, "adSessionType", cpVar.h);
        dn.a(jSONObject2, "deviceInfo", dm.a());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        dn.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        dn.a(jSONObject3, "partnerName", cpVar.a.a);
        dn.a(jSONObject3, "partnerVersion", cpVar.a.b);
        dn.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        dn.a(jSONObject4, "libraryVersion", "1.3.16-tapjoy");
        dn.a(jSONObject4, "appId", df.a().a.getApplicationContext().getPackageName());
        dn.a(jSONObject2, "app", jSONObject4);
        if (cpVar.g != null) {
            dn.a(jSONObject2, "contentUrl", cpVar.g);
        }
        if (cpVar.f != null) {
            dn.a(jSONObject2, "customReferenceData", cpVar.f);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (cw cwVar : Collections.unmodifiableList(cpVar.c)) {
            dn.a(jSONObject5, cwVar.a, cwVar.c);
        }
        dg.a().a(c(), str, jSONObject2, jSONObject5, jSONObject);
    }

    public final void d() {
        this.d = System.nanoTime();
        this.c = a.a;
    }
}
