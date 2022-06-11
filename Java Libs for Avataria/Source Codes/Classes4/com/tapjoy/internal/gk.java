package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gk {
    public static final gk a = new gk(0, 0, 0, 0.0d);
    public final long b;
    public final long c;
    public final double d;
    public long e;
    private final long f;

    public gk(long j, long j2, long j3, double d) {
        this.f = j;
        this.b = j2;
        this.c = j3;
        this.d = d;
        this.e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            gk gkVar = (gk) obj;
            if (this.f == gkVar.f && this.b == gkVar.b && this.c == gkVar.c && this.d == gkVar.d && this.e == gkVar.e) {
                return true;
            }
        }
        return false;
    }
}
