package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gg {
    private static final gg d;
    private static gg e;
    private Context h;
    private Boolean f = null;
    public String a = null;
    private Boolean g = null;
    public String b = null;
    public boolean c = false;

    static {
        gg ggVar = new gg();
        d = ggVar;
        e = ggVar;
    }

    public static gg a() {
        return e;
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.h == null) {
                this.h = context;
            }
        }
        gg ggVar = e;
        Context context2 = ggVar.h;
        if (context2 != null) {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("tjcPrefrences", 0);
            if (ggVar.f == null && sharedPreferences.contains("gdpr")) {
                ggVar.f = Boolean.valueOf(sharedPreferences.getBoolean("gdpr", false));
            }
            if (ggVar.a == null) {
                ggVar.a = sharedPreferences.getString("cgdpr", "");
            }
            if (ggVar.g == null && sharedPreferences.contains("below_consent_age")) {
                ggVar.g = Boolean.valueOf(sharedPreferences.getBoolean("below_consent_age", false));
            }
            if (ggVar.b == null) {
                ggVar.b = sharedPreferences.getString("us_privacy", "");
            }
        }
        if (this.c) {
            this.c = false;
            gg ggVar2 = e;
            if (ggVar2.h != null) {
                if (ggVar2.f != null) {
                    ggVar2.d();
                }
                if (ggVar2.a != null) {
                    ggVar2.e();
                }
                if (ggVar2.g != null) {
                    ggVar2.f();
                }
                if (ggVar2.b != null) {
                    ggVar2.c();
                }
            }
        }
    }

    public final void a(boolean z) {
        this.f = Boolean.valueOf(z);
        if (!d()) {
            this.c = true;
        }
    }

    public final void a(String str) {
        if (ag.a(str)) {
            return;
        }
        this.a = str;
        if (e()) {
            return;
        }
        this.c = true;
    }

    private boolean d() {
        Context context = this.h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("tjcPrefrences", 0).edit();
            edit.putBoolean("gdpr", this.f.booleanValue());
            edit.apply();
            return true;
        }
        return false;
    }

    private boolean e() {
        Context context = this.h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("tjcPrefrences", 0).edit();
            edit.putString("cgdpr", this.a);
            edit.apply();
            return true;
        }
        return false;
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        Boolean bool = this.f;
        String str = "1";
        if (bool != null) {
            TapjoyUtil.safePut(hashMap, "gdpr", bool.booleanValue() ? str : "0", true);
        }
        if (!ag.a(this.a)) {
            TapjoyUtil.safePut(hashMap, "cgdpr", this.a, true);
        }
        Boolean bool2 = this.g;
        if (bool2 != null) {
            if (!bool2.booleanValue()) {
                str = "0";
            }
            TapjoyUtil.safePut(hashMap, "below_consent_age", str, true);
        }
        if (!ag.a(this.b)) {
            TapjoyUtil.safePut(hashMap, "us_privacy", this.b, true);
        }
        return hashMap;
    }

    public final void b(boolean z) {
        this.g = Boolean.valueOf(z);
        if (!f()) {
            this.c = true;
        }
    }

    private boolean f() {
        Context context = this.h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("tjcPrefrences", 0).edit();
            edit.putBoolean("below_consent_age", this.g.booleanValue());
            edit.apply();
            return true;
        }
        return false;
    }

    public final boolean c() {
        Context context = this.h;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("tjcPrefrences", 0).edit();
            edit.putString("us_privacy", this.b);
            edit.apply();
            return true;
        }
        return false;
    }
}
