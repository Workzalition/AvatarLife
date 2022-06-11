package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class hl {
    public final n A;
    public final g B;
    final g C;
    final n D;
    final Context a;
    final SharedPreferences b;
    final n c;
    final n d;
    final j e;
    final j f;
    final n g;
    final j h;
    final k i;
    final k j;
    final k k;
    final n l;
    final j m;
    final i n;
    final k o;
    final i p;
    final n q;
    final n r;
    final j s;
    final j t;
    final n u;
    final n v;
    final n w;
    final n x;
    final n y;
    final n z;

    public static hl a(Context context) {
        return new hl(context);
    }

    private hl(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("fiverocks", 0);
        this.b = sharedPreferences;
        this.c = new n(sharedPreferences, "sdk");
        this.d = new n(sharedPreferences, "ir");
        this.e = new j(sharedPreferences, "fql", 0);
        this.f = new j(sharedPreferences, "fq", 0);
        this.g = new n(sharedPreferences, "push");
        this.h = new j(sharedPreferences, "ss", 0);
        this.i = new k(sharedPreferences, "std");
        this.j = new k(sharedPreferences, "slt");
        this.k = new k(sharedPreferences, "sld");
        this.l = new n(sharedPreferences, "ptc");
        this.m = new j(sharedPreferences, "pc", 0);
        this.n = new i(sharedPreferences, "ptp");
        this.o = new k(sharedPreferences, "lpt");
        this.p = new i(sharedPreferences, "plp");
        this.q = new n(sharedPreferences, "adv");
        this.r = new n(sharedPreferences, "ui");
        this.s = new j(sharedPreferences, "ul", -1);
        this.t = new j(sharedPreferences, "uf", -1);
        this.u = new n(sharedPreferences, "uv1");
        this.v = new n(sharedPreferences, "uv2");
        this.w = new n(sharedPreferences, "uv3");
        this.x = new n(sharedPreferences, "uv4");
        this.y = new n(sharedPreferences, "uv5");
        this.z = new n(sharedPreferences, "utags");
        this.A = new n(sharedPreferences, "idfa");
        this.B = new g(sharedPreferences, "idfa.optout");
        this.C = new g(sharedPreferences, "push.optout");
        this.D = new n(sharedPreferences, "appId");
    }

    public final SharedPreferences.Editor a() {
        return this.b.edit();
    }

    public final String b() {
        String string = this.b.getString("ir", null);
        if (string != null) {
            if (string.length() <= 0) {
                return null;
            }
            return string;
        }
        File file = new File(hb.c(this.a), "referrer");
        if (file.exists()) {
            try {
                string = bb.a(file, af.c);
            } catch (IOException unused) {
            }
        }
        this.b.edit().putString("ir", string != null ? string : "").apply();
        if (string != null && string.length() > 0) {
            return string;
        }
        return null;
    }

    public final void a(boolean z) {
        m.a(this.b, "gcm.onServer", z);
    }
}
