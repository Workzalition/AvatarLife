package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import com.tapjoy.internal.ek;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.List;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ew extends ei<ew, a> {
    public static final ek<ew> c = new b();
    public static final ez d = ez.APP;
    public static final Long e = 0L;
    public static final Long f = 0L;
    public static final Long g = 0L;
    public static final Long h = 0L;
    public static final Integer i = 0;
    public static final Integer j = 0;
    public static final Integer k = 0;
    public static final Long l = 0L;
    public static final Long m = 0L;
    public final fe A;
    public final String B;
    public final String C;
    public final fd D;
    public final String E;
    public final String F;
    public final String G;
    public final List<fa> H;
    public final String I;
    public final Integer J;
    public final Long K;
    public final Long L;
    public final ez n;
    public final String o;
    public final Long p;
    public final Long q;
    public final String r;
    public final Long s;
    public final Long t;
    public final fb u;
    public final ev v;
    public final fi w;
    public final Integer x;
    public final Integer y;
    public final ey z;

    public ew(ez ezVar, String str, Long l2, Long l3, String str2, Long l4, Long l5, fb fbVar, ev evVar, fi fiVar, Integer num, Integer num2, ey eyVar, fe feVar, String str3, String str4, fd fdVar, String str5, String str6, String str7, List<fa> list, String str8, Integer num3, Long l6, Long l7, iw iwVar) {
        super(c, iwVar);
        this.n = ezVar;
        this.o = str;
        this.p = l2;
        this.q = l3;
        this.r = str2;
        this.s = l4;
        this.t = l5;
        this.u = fbVar;
        this.v = evVar;
        this.w = fiVar;
        this.x = num;
        this.y = num2;
        this.z = eyVar;
        this.A = feVar;
        this.B = str3;
        this.C = str4;
        this.D = fdVar;
        this.E = str5;
        this.F = str6;
        this.G = str7;
        this.H = ep.a("values", (List) list);
        this.I = str8;
        this.J = num3;
        this.K = l6;
        this.L = l7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ew)) {
            return false;
        }
        ew ewVar = (ew) obj;
        return a().equals(ewVar.a()) && this.n.equals(ewVar.n) && this.o.equals(ewVar.o) && this.p.equals(ewVar.p) && ep.a(this.q, ewVar.q) && ep.a(this.r, ewVar.r) && ep.a(this.s, ewVar.s) && ep.a(this.t, ewVar.t) && ep.a(this.u, ewVar.u) && ep.a(this.v, ewVar.v) && ep.a(this.w, ewVar.w) && ep.a(this.x, ewVar.x) && ep.a(this.y, ewVar.y) && ep.a(this.z, ewVar.z) && ep.a(this.A, ewVar.A) && ep.a(this.B, ewVar.B) && ep.a(this.C, ewVar.C) && ep.a(this.D, ewVar.D) && ep.a(this.E, ewVar.E) && ep.a(this.F, ewVar.F) && ep.a(this.G, ewVar.G) && this.H.equals(ewVar.H) && ep.a(this.I, ewVar.I) && ep.a(this.J, ewVar.J) && ep.a(this.K, ewVar.K) && ep.a(this.L, ewVar.L);
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = ((((((a().hashCode() * 37) + this.n.hashCode()) * 37) + this.o.hashCode()) * 37) + this.p.hashCode()) * 37;
            Long l2 = this.q;
            int i3 = 0;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str = this.r;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
            Long l3 = this.s;
            int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
            Long l4 = this.t;
            int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
            fb fbVar = this.u;
            int hashCode6 = (hashCode5 + (fbVar != null ? fbVar.hashCode() : 0)) * 37;
            ev evVar = this.v;
            int hashCode7 = (hashCode6 + (evVar != null ? evVar.hashCode() : 0)) * 37;
            fi fiVar = this.w;
            int hashCode8 = (hashCode7 + (fiVar != null ? fiVar.hashCode() : 0)) * 37;
            Integer num = this.x;
            int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.y;
            int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
            ey eyVar = this.z;
            int hashCode11 = (hashCode10 + (eyVar != null ? eyVar.hashCode() : 0)) * 37;
            fe feVar = this.A;
            int hashCode12 = (hashCode11 + (feVar != null ? feVar.hashCode() : 0)) * 37;
            String str2 = this.B;
            int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.C;
            int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
            fd fdVar = this.D;
            int hashCode15 = (hashCode14 + (fdVar != null ? fdVar.hashCode() : 0)) * 37;
            String str4 = this.E;
            int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.F;
            int hashCode17 = (hashCode16 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.G;
            int hashCode18 = (((hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 37) + this.H.hashCode()) * 37;
            String str7 = this.I;
            int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
            Integer num3 = this.J;
            int hashCode20 = (hashCode19 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Long l5 = this.K;
            int hashCode21 = (hashCode20 + (l5 != null ? l5.hashCode() : 0)) * 37;
            Long l6 = this.L;
            if (l6 != null) {
                i3 = l6.hashCode();
            }
            int i4 = hashCode21 + i3;
            this.b = i4;
            return i4;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.n);
        sb.append(", name=");
        sb.append(this.o);
        sb.append(", time=");
        sb.append(this.p);
        if (this.q != null) {
            sb.append(", systemTime=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", instanceId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", elapsedRealtime=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", duration=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", info=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", app=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", user=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", xxx_session_seq=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", eventSeq=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", eventPrev=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", purchase=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", exception=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", metaBase=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", meta=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", category=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", p1=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", p2=");
            sb.append(this.G);
        }
        if (!this.H.isEmpty()) {
            sb.append(", values=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", dimensions=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", count=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", firstTime=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", lastTime=");
            sb.append(this.L);
        }
        StringBuilder replace = sb.replace(0, 2, "Event{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<ew, a> {
        public Long A;
        public ez c;
        public String d;
        public Long e;
        public Long f;
        public String g;
        public Long h;
        public Long i;
        public fb j;
        public ev k;
        public fi l;
        public Integer m;
        public Integer n;
        public ey o;
        public fe p;
        public String q;
        public String r;
        public fd s;
        public String t;
        public String u;
        public String v;
        public List<fa> w = ep.a();
        public String x;
        public Integer y;
        public Long z;

        public final ew b() {
            ez ezVar = this.c;
            if (ezVar == null || this.d == null || this.e == null) {
                throw ep.a(ezVar, SharedKt.PARAM_TYPE, this.d, MediationMetaData.KEY_NAME, this.e, "time");
            }
            return new ew(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<ew> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(ew ewVar) {
            ew ewVar2 = ewVar;
            int i = 0;
            int a = ez.e.a(1, (int) ewVar2.n) + ek.p.a(2, (int) ewVar2.o) + ek.i.a(3, (int) ewVar2.p) + (ewVar2.q != null ? ek.i.a(19, (int) ewVar2.q) : 0) + (ewVar2.r != null ? ek.p.a(20, (int) ewVar2.r) : 0) + (ewVar2.s != null ? ek.i.a(21, (int) ewVar2.s) : 0) + (ewVar2.t != null ? ek.i.a(4, (int) ewVar2.t) : 0) + (ewVar2.u != null ? fb.c.a(5, (int) ewVar2.u) : 0) + (ewVar2.v != null ? ev.c.a(6, (int) ewVar2.v) : 0) + (ewVar2.w != null ? fi.c.a(7, (int) ewVar2.w) : 0) + (ewVar2.x != null ? ek.d.a(8, (int) ewVar2.x) : 0) + (ewVar2.y != null ? ek.d.a(9, (int) ewVar2.y) : 0) + (ewVar2.z != null ? ey.c.a(10, (int) ewVar2.z) : 0) + (ewVar2.A != null ? fe.c.a(11, (int) ewVar2.A) : 0) + (ewVar2.B != null ? ek.p.a(12, (int) ewVar2.B) : 0) + (ewVar2.C != null ? ek.p.a(13, (int) ewVar2.C) : 0) + (ewVar2.D != null ? fd.c.a(18, (int) ewVar2.D) : 0) + (ewVar2.E != null ? ek.p.a(14, (int) ewVar2.E) : 0) + (ewVar2.F != null ? ek.p.a(15, (int) ewVar2.F) : 0) + (ewVar2.G != null ? ek.p.a(16, (int) ewVar2.G) : 0) + fa.c.a().a(17, (int) ewVar2.H) + (ewVar2.I != null ? ek.p.a(22, (int) ewVar2.I) : 0) + (ewVar2.J != null ? ek.d.a(23, (int) ewVar2.J) : 0) + (ewVar2.K != null ? ek.i.a(24, (int) ewVar2.K) : 0);
            if (ewVar2.L != null) {
                i = ek.i.a(25, (int) ewVar2.L);
            }
            return a + i + ewVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ ew a(el elVar) {
            return b(elVar);
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, ew ewVar) {
            ew ewVar2 = ewVar;
            ez.e.a(emVar, 1, ewVar2.n);
            ek.p.a(emVar, 2, ewVar2.o);
            ek.i.a(emVar, 3, ewVar2.p);
            if (ewVar2.q != null) {
                ek.i.a(emVar, 19, ewVar2.q);
            }
            if (ewVar2.r != null) {
                ek.p.a(emVar, 20, ewVar2.r);
            }
            if (ewVar2.s != null) {
                ek.i.a(emVar, 21, ewVar2.s);
            }
            if (ewVar2.t != null) {
                ek.i.a(emVar, 4, ewVar2.t);
            }
            if (ewVar2.u != null) {
                fb.c.a(emVar, 5, ewVar2.u);
            }
            if (ewVar2.v != null) {
                ev.c.a(emVar, 6, ewVar2.v);
            }
            if (ewVar2.w != null) {
                fi.c.a(emVar, 7, ewVar2.w);
            }
            if (ewVar2.x != null) {
                ek.d.a(emVar, 8, ewVar2.x);
            }
            if (ewVar2.y != null) {
                ek.d.a(emVar, 9, ewVar2.y);
            }
            if (ewVar2.z != null) {
                ey.c.a(emVar, 10, ewVar2.z);
            }
            if (ewVar2.A != null) {
                fe.c.a(emVar, 11, ewVar2.A);
            }
            if (ewVar2.B != null) {
                ek.p.a(emVar, 12, ewVar2.B);
            }
            if (ewVar2.C != null) {
                ek.p.a(emVar, 13, ewVar2.C);
            }
            if (ewVar2.D != null) {
                fd.c.a(emVar, 18, ewVar2.D);
            }
            if (ewVar2.E != null) {
                ek.p.a(emVar, 14, ewVar2.E);
            }
            if (ewVar2.F != null) {
                ek.p.a(emVar, 15, ewVar2.F);
            }
            if (ewVar2.G != null) {
                ek.p.a(emVar, 16, ewVar2.G);
            }
            fa.c.a().a(emVar, 17, ewVar2.H);
            if (ewVar2.I != null) {
                ek.p.a(emVar, 22, ewVar2.I);
            }
            if (ewVar2.J != null) {
                ek.d.a(emVar, 23, ewVar2.J);
            }
            if (ewVar2.K != null) {
                ek.i.a(emVar, 24, ewVar2.K);
            }
            if (ewVar2.L != null) {
                ek.i.a(emVar, 25, ewVar2.L);
            }
            emVar.a(ewVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, ew.class);
        }

        private static ew b(el elVar) {
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
                        try {
                            aVar.c = ez.e.a(elVar);
                            break;
                        } catch (ek.a e) {
                            aVar.a(b, eh.VARINT, Long.valueOf(e.a));
                            break;
                        }
                    case 2:
                        aVar.d = ek.p.a(elVar);
                        break;
                    case 3:
                        aVar.e = ek.i.a(elVar);
                        break;
                    case 4:
                        aVar.i = ek.i.a(elVar);
                        break;
                    case 5:
                        aVar.j = fb.c.a(elVar);
                        break;
                    case 6:
                        aVar.k = ev.c.a(elVar);
                        break;
                    case 7:
                        aVar.l = fi.c.a(elVar);
                        break;
                    case 8:
                        aVar.m = ek.d.a(elVar);
                        break;
                    case 9:
                        aVar.n = ek.d.a(elVar);
                        break;
                    case 10:
                        aVar.o = ey.c.a(elVar);
                        break;
                    case 11:
                        aVar.p = fe.c.a(elVar);
                        break;
                    case 12:
                        aVar.q = ek.p.a(elVar);
                        break;
                    case 13:
                        aVar.r = ek.p.a(elVar);
                        break;
                    case 14:
                        aVar.t = ek.p.a(elVar);
                        break;
                    case 15:
                        aVar.u = ek.p.a(elVar);
                        break;
                    case 16:
                        aVar.v = ek.p.a(elVar);
                        break;
                    case 17:
                        aVar.w.add(fa.c.a(elVar));
                        break;
                    case 18:
                        aVar.s = fd.c.a(elVar);
                        break;
                    case 19:
                        aVar.f = ek.i.a(elVar);
                        break;
                    case 20:
                        aVar.g = ek.p.a(elVar);
                        break;
                    case 21:
                        aVar.h = ek.i.a(elVar);
                        break;
                    case 22:
                        aVar.x = ek.p.a(elVar);
                        break;
                    case 23:
                        aVar.y = ek.d.a(elVar);
                        break;
                    case 24:
                        aVar.z = ek.i.a(elVar);
                        break;
                    case 25:
                        aVar.A = ek.i.a(elVar);
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
