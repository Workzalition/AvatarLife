package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gh$a {
    final String a;
    private final TreeMap<String, Object> b = new TreeMap<>();
    private final Map<String, Long> c = new HashMap();
    private volatile long d;

    gh$a(String str) {
        this.a = str;
    }

    public final gh$a a() {
        try {
            this.d = SystemClock.elapsedRealtime();
        } catch (NullPointerException unused) {
            this.d = -1L;
        }
        return this;
    }

    public final gh$a b() {
        long j = this.d;
        if (j != -1) {
            try {
                a("spent_time", SystemClock.elapsedRealtime() - j);
            } catch (NullPointerException unused) {
            }
        }
        return this;
    }

    public final gh$a a(String str, Object obj) {
        this.b.put(str, obj);
        return this;
    }

    public final gh$a a(Map<String, Object> map) {
        if (map != null) {
            this.b.putAll(map);
        }
        return this;
    }

    public final gh$a a(String str) {
        this.b.put("failure", str);
        return this;
    }

    public final gh$a b(String str) {
        this.b.put("misuse", str);
        return this;
    }

    public final gh$a a(String str, long j) {
        this.c.put(str, Long.valueOf(j));
        return this;
    }

    public final gh$a b(Map<String, Long> map) {
        if (map != null) {
            this.c.putAll(map);
        }
        return this;
    }

    public final void c() {
        String str = this.a;
        Map<String, Long> map = null;
        String a = this.b.size() > 0 ? bc.a((Object) this.b) : null;
        if (this.c.size() > 0) {
            map = this.c;
        }
        gh.a(str, a, map);
    }
}
