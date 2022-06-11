package com.tapjoy.internal;

import com.tapjoy.TapjoyLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class fr {
    private static final String b = "fr";
    public final Map<String, Object> a;
    private final Map<String, gh$a> c = new HashMap();

    public fr(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put("placement", str);
        hashMap.put("placement_type", str2);
        hashMap.put("content_type", str3);
    }

    public final gh$a a(String str, Map<String, Object> map, Map<String, Long> map2) {
        gh$a b2 = gh.e(str).a().a(this.a).a(map).b(map2);
        this.c.put(str, b2);
        return b2;
    }

    public final gh$a b(String str, Map<String, Object> map, Map<String, Long> map2) {
        gh$a a = a(str);
        if (a == null) {
            String str2 = b;
            TapjoyLog.e(str2, "Error when calling endTrackingEvent -- " + str + " tracking has not been started.");
        } else {
            a.a(this.a).a(map).b(map2).b().c();
        }
        return a;
    }

    private gh$a a(String str) {
        if (!ag.a(str)) {
            return this.c.remove(str);
        }
        return null;
    }

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final void c() {
        this.c.clear();
    }

    public final gh$a a() {
        return a("Content.rendered", null, null);
    }

    public final gh$a b() {
        return b("Content.rendered", null, null);
    }
}
