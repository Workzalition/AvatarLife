package com.tapjoy.internal;

import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class d {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;

    public d(String str) {
        bi b = bi.b(str);
        b.h();
        while (b.j()) {
            String l = b.l();
            if ("productId".equals(l)) {
                this.a = b.m();
            } else if (SharedKt.PARAM_TYPE.equals(l)) {
                this.b = b.m();
            } else if ("price".equals(l)) {
                this.c = b.m();
            } else if ("title".equals(l)) {
                this.d = b.m();
            } else if ("description".equals(l)) {
                this.e = b.m();
            } else if ("price_currency_code".equals(l)) {
                this.f = b.m();
            } else if ("price_amount_micros".equals(l)) {
                this.g = b.q();
            } else {
                b.s();
            }
        }
        b.i();
    }
}
