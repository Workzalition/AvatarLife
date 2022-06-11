package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fi extends ei<fi, a> {
    public static final Double l;
    public static final Double n;
    public final Long A;
    public final String B;
    public final Integer C;
    public final Double D;
    public final Long E;
    public final Double F;
    public final String G;
    public final Boolean H;
    public final String I;
    public final Integer J;
    public final Integer K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final List<String> Q;
    public final Boolean R;
    public final Long s;
    public final String t;
    public final Integer u;
    public final Integer v;
    public final List<ff> w;
    public final Integer x;
    public final Long y;
    public final Long z;
    public static final ek<fi> c = new b();
    public static final Long d = 0L;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    public static final Long h = 0L;
    public static final Long i = 0L;
    public static final Long j = 0L;
    public static final Integer k = 0;
    public static final Long m = 0L;
    public static final Boolean o = Boolean.FALSE;
    public static final Integer p = 0;
    public static final Integer q = 0;
    public static final Boolean r = Boolean.FALSE;

    static {
        Double valueOf = Double.valueOf(0.0d);
        l = valueOf;
        n = valueOf;
    }

    public fi(Long l2, String str, Integer num, Integer num2, List<ff> list, Integer num3, Long l3, Long l4, Long l5, String str2, Integer num4, Double d2, Long l6, Double d3, String str3, Boolean bool, String str4, Integer num5, Integer num6, String str5, String str6, String str7, String str8, String str9, List<String> list2, Boolean bool2, iw iwVar) {
        super(c, iwVar);
        this.s = l2;
        this.t = str;
        this.u = num;
        this.v = num2;
        this.w = ep.a("pushes", (List) list);
        this.x = num3;
        this.y = l3;
        this.z = l4;
        this.A = l5;
        this.B = str2;
        this.C = num4;
        this.D = d2;
        this.E = l6;
        this.F = d3;
        this.G = str3;
        this.H = bool;
        this.I = str4;
        this.J = num5;
        this.K = num6;
        this.L = str5;
        this.M = str6;
        this.N = str7;
        this.O = str8;
        this.P = str9;
        this.Q = ep.a("tags", (List) list2);
        this.R = bool2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fi)) {
            return false;
        }
        fi fiVar = (fi) obj;
        return a().equals(fiVar.a()) && ep.a(this.s, fiVar.s) && ep.a(this.t, fiVar.t) && ep.a(this.u, fiVar.u) && ep.a(this.v, fiVar.v) && this.w.equals(fiVar.w) && ep.a(this.x, fiVar.x) && ep.a(this.y, fiVar.y) && ep.a(this.z, fiVar.z) && ep.a(this.A, fiVar.A) && ep.a(this.B, fiVar.B) && ep.a(this.C, fiVar.C) && ep.a(this.D, fiVar.D) && ep.a(this.E, fiVar.E) && ep.a(this.F, fiVar.F) && ep.a(this.G, fiVar.G) && ep.a(this.H, fiVar.H) && ep.a(this.I, fiVar.I) && ep.a(this.J, fiVar.J) && ep.a(this.K, fiVar.K) && ep.a(this.L, fiVar.L) && ep.a(this.M, fiVar.M) && ep.a(this.N, fiVar.N) && ep.a(this.O, fiVar.O) && ep.a(this.P, fiVar.P) && this.Q.equals(fiVar.Q) && ep.a(this.R, fiVar.R);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            Long l2 = this.s;
            int i3 = 0;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str = this.t;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
            Integer num = this.u;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.v;
            int hashCode5 = (((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37) + this.w.hashCode()) * 37;
            Integer num3 = this.x;
            int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Long l3 = this.y;
            int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
            Long l4 = this.z;
            int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
            Long l5 = this.A;
            int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
            String str2 = this.B;
            int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
            Integer num4 = this.C;
            int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
            Double d2 = this.D;
            int hashCode12 = (hashCode11 + (d2 != null ? d2.hashCode() : 0)) * 37;
            Long l6 = this.E;
            int hashCode13 = (hashCode12 + (l6 != null ? l6.hashCode() : 0)) * 37;
            Double d3 = this.F;
            int hashCode14 = (hashCode13 + (d3 != null ? d3.hashCode() : 0)) * 37;
            String str3 = this.G;
            int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
            Boolean bool = this.H;
            int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
            String str4 = this.I;
            int hashCode17 = (hashCode16 + (str4 != null ? str4.hashCode() : 0)) * 37;
            Integer num5 = this.J;
            int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
            Integer num6 = this.K;
            int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
            String str5 = this.L;
            int hashCode20 = (hashCode19 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.M;
            int hashCode21 = (hashCode20 + (str6 != null ? str6.hashCode() : 0)) * 37;
            String str7 = this.N;
            int hashCode22 = (hashCode21 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.O;
            int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.P;
            int hashCode24 = (((hashCode23 + (str9 != null ? str9.hashCode() : 0)) * 37) + this.Q.hashCode()) * 37;
            Boolean bool2 = this.R;
            if (bool2 != null) {
                i3 = bool2.hashCode();
            }
            int i4 = hashCode24 + i3;
            this.b = i4;
            return i4;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.s != null) {
            sb.append(", installed=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", referrer=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", fq7=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", fq30=");
            sb.append(this.v);
        }
        if (!this.w.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", sessionTotalCount=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", sessionTotalDuration=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", sessionLastTime=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", sessionLastDuration=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", purchaseCurrency=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", purchaseTotalCount=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", purchaseTotalPrice=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", purchaseLastTime=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", purchaseLastPrice=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", idfa=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", idfaOptout=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", userId=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", userLevel=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", friendCount=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", uv1=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", uv2=");
            sb.append(this.M);
        }
        if (this.N != null) {
            sb.append(", uv3=");
            sb.append(this.N);
        }
        if (this.O != null) {
            sb.append(", uv4=");
            sb.append(this.O);
        }
        if (this.P != null) {
            sb.append(", uv5=");
            sb.append(this.P);
        }
        if (!this.Q.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.Q);
        }
        if (this.R != null) {
            sb.append(", pushOptout=");
            sb.append(this.R);
        }
        StringBuilder replace = sb.replace(0, 2, "User{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fi, a> {
        public Boolean B;
        public Long c;
        public String d;
        public Integer e;
        public Integer f;
        public Integer h;
        public Long i;
        public Long j;
        public Long k;
        public String l;
        public Integer m;
        public Double n;
        public Long o;
        public Double p;
        public String q;
        public Boolean r;
        public String s;
        public Integer t;
        public Integer u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;
        public List<ff> g = ep.a();
        public List<String> A = ep.a();

        public final fi b() {
            return new fi(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fi> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fi fiVar) {
            fi fiVar2 = fiVar;
            int i = 0;
            int a = (fiVar2.s != null ? ek.i.a(1, (int) fiVar2.s) : 0) + (fiVar2.t != null ? ek.p.a(2, (int) fiVar2.t) : 0) + (fiVar2.u != null ? ek.d.a(13, (int) fiVar2.u) : 0) + (fiVar2.v != null ? ek.d.a(14, (int) fiVar2.v) : 0) + ff.c.a().a(15, (int) fiVar2.w) + (fiVar2.x != null ? ek.d.a(16, (int) fiVar2.x) : 0) + (fiVar2.y != null ? ek.i.a(17, (int) fiVar2.y) : 0) + (fiVar2.z != null ? ek.i.a(18, (int) fiVar2.z) : 0) + (fiVar2.A != null ? ek.i.a(19, (int) fiVar2.A) : 0) + (fiVar2.B != null ? ek.p.a(20, (int) fiVar2.B) : 0) + (fiVar2.C != null ? ek.d.a(3, (int) fiVar2.C) : 0) + (fiVar2.D != null ? ek.o.a(21, (int) fiVar2.D) : 0) + (fiVar2.E != null ? ek.i.a(4, (int) fiVar2.E) : 0) + (fiVar2.F != null ? ek.o.a(22, (int) fiVar2.F) : 0) + (fiVar2.G != null ? ek.p.a(23, (int) fiVar2.G) : 0) + (fiVar2.H != null ? ek.c.a(24, (int) fiVar2.H) : 0) + (fiVar2.I != null ? ek.p.a(5, (int) fiVar2.I) : 0) + (fiVar2.J != null ? ek.d.a(6, (int) fiVar2.J) : 0) + (fiVar2.K != null ? ek.d.a(7, (int) fiVar2.K) : 0) + (fiVar2.L != null ? ek.p.a(8, (int) fiVar2.L) : 0) + (fiVar2.M != null ? ek.p.a(9, (int) fiVar2.M) : 0) + (fiVar2.N != null ? ek.p.a(10, (int) fiVar2.N) : 0) + (fiVar2.O != null ? ek.p.a(11, (int) fiVar2.O) : 0) + (fiVar2.P != null ? ek.p.a(12, (int) fiVar2.P) : 0) + ek.p.a().a(26, (int) fiVar2.Q);
            if (fiVar2.R != null) {
                i = ek.c.a(25, (int) fiVar2.R);
            }
            return a + i + fiVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fi fiVar) {
            fi fiVar2 = fiVar;
            if (fiVar2.s != null) {
                ek.i.a(emVar, 1, fiVar2.s);
            }
            if (fiVar2.t != null) {
                ek.p.a(emVar, 2, fiVar2.t);
            }
            if (fiVar2.u != null) {
                ek.d.a(emVar, 13, fiVar2.u);
            }
            if (fiVar2.v != null) {
                ek.d.a(emVar, 14, fiVar2.v);
            }
            ff.c.a().a(emVar, 15, fiVar2.w);
            if (fiVar2.x != null) {
                ek.d.a(emVar, 16, fiVar2.x);
            }
            if (fiVar2.y != null) {
                ek.i.a(emVar, 17, fiVar2.y);
            }
            if (fiVar2.z != null) {
                ek.i.a(emVar, 18, fiVar2.z);
            }
            if (fiVar2.A != null) {
                ek.i.a(emVar, 19, fiVar2.A);
            }
            if (fiVar2.B != null) {
                ek.p.a(emVar, 20, fiVar2.B);
            }
            if (fiVar2.C != null) {
                ek.d.a(emVar, 3, fiVar2.C);
            }
            if (fiVar2.D != null) {
                ek.o.a(emVar, 21, fiVar2.D);
            }
            if (fiVar2.E != null) {
                ek.i.a(emVar, 4, fiVar2.E);
            }
            if (fiVar2.F != null) {
                ek.o.a(emVar, 22, fiVar2.F);
            }
            if (fiVar2.G != null) {
                ek.p.a(emVar, 23, fiVar2.G);
            }
            if (fiVar2.H != null) {
                ek.c.a(emVar, 24, fiVar2.H);
            }
            if (fiVar2.I != null) {
                ek.p.a(emVar, 5, fiVar2.I);
            }
            if (fiVar2.J != null) {
                ek.d.a(emVar, 6, fiVar2.J);
            }
            if (fiVar2.K != null) {
                ek.d.a(emVar, 7, fiVar2.K);
            }
            if (fiVar2.L != null) {
                ek.p.a(emVar, 8, fiVar2.L);
            }
            if (fiVar2.M != null) {
                ek.p.a(emVar, 9, fiVar2.M);
            }
            if (fiVar2.N != null) {
                ek.p.a(emVar, 10, fiVar2.N);
            }
            if (fiVar2.O != null) {
                ek.p.a(emVar, 11, fiVar2.O);
            }
            if (fiVar2.P != null) {
                ek.p.a(emVar, 12, fiVar2.P);
            }
            ek.p.a().a(emVar, 26, fiVar2.Q);
            if (fiVar2.R != null) {
                ek.c.a(emVar, 25, fiVar2.R);
            }
            emVar.a(fiVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fi.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fi a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                }
                switch (b) {
                    case 1:
                        aVar.c = ek.i.a(elVar);
                        break;
                    case 2:
                        aVar.d = ek.p.a(elVar);
                        break;
                    case 3:
                        aVar.m = ek.d.a(elVar);
                        break;
                    case 4:
                        aVar.o = ek.i.a(elVar);
                        break;
                    case 5:
                        aVar.s = ek.p.a(elVar);
                        break;
                    case 6:
                        aVar.t = ek.d.a(elVar);
                        break;
                    case 7:
                        aVar.u = ek.d.a(elVar);
                        break;
                    case 8:
                        aVar.v = ek.p.a(elVar);
                        break;
                    case 9:
                        aVar.w = ek.p.a(elVar);
                        break;
                    case 10:
                        aVar.x = ek.p.a(elVar);
                        break;
                    case 11:
                        aVar.y = ek.p.a(elVar);
                        break;
                    case 12:
                        aVar.z = ek.p.a(elVar);
                        break;
                    case 13:
                        aVar.e = ek.d.a(elVar);
                        break;
                    case 14:
                        aVar.f = ek.d.a(elVar);
                        break;
                    case 15:
                        aVar.g.add(ff.c.a(elVar));
                        break;
                    case 16:
                        aVar.h = ek.d.a(elVar);
                        break;
                    case 17:
                        aVar.i = ek.i.a(elVar);
                        break;
                    case 18:
                        aVar.j = ek.i.a(elVar);
                        break;
                    case 19:
                        aVar.k = ek.i.a(elVar);
                        break;
                    case 20:
                        aVar.l = ek.p.a(elVar);
                        break;
                    case 21:
                        aVar.n = ek.o.a(elVar);
                        break;
                    case 22:
                        aVar.p = ek.o.a(elVar);
                        break;
                    case 23:
                        aVar.q = ek.p.a(elVar);
                        break;
                    case 24:
                        aVar.r = ek.c.a(elVar);
                        break;
                    case 25:
                        aVar.B = ek.c.a(elVar);
                        break;
                    case 26:
                        aVar.A.add(ek.p.a(elVar));
                        break;
                    default:
                        eh ehVar = elVar.b;
                        aVar.a(b, ehVar, ehVar.a().a(elVar));
                        break;
                }
            }
        }
    }
}
