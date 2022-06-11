package com.tapjoy.internal;

import com.tapjoy.internal.dd;
import java.util.Collections;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dh implements cj, dd.a {
    private static dh c;
    public float a = 0.0f;
    public ck b;
    private final cl d;
    private final ci e;
    private dc f;

    private dh(cl clVar, ci ciVar) {
        this.d = clVar;
        this.e = ciVar;
    }

    public static dh a() {
        if (c == null) {
            c = new dh(new cl(), new ci());
        }
        return c;
    }

    @Override // com.tapjoy.internal.dd.a
    public final void a(boolean z) {
        if (z) {
            dw.a();
            dw.b();
            return;
        }
        dw.a();
        dw.c();
    }

    @Override // com.tapjoy.internal.cj
    public final void a(float f) {
        this.a = f;
        if (this.f == null) {
            this.f = dc.a();
        }
        for (cx cxVar : Collections.unmodifiableCollection(this.f.b)) {
            cxVar.c.a(f);
        }
    }
}
