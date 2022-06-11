package com.tapjoy.internal;

import com.tapjoy.internal.ei;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fb extends ei<fb, a> {
    public static final ek<fb> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;

    public fb(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, iw iwVar) {
        super(c, iwVar);
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = num;
        this.n = num2;
        this.o = num3;
        this.p = str7;
        this.q = str8;
        this.r = str9;
        this.s = str10;
        this.t = str11;
        this.u = str12;
        this.v = str13;
        this.w = str14;
        this.x = str15;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fb)) {
            return false;
        }
        fb fbVar = (fb) obj;
        return a().equals(fbVar.a()) && ep.a(this.g, fbVar.g) && ep.a(this.h, fbVar.h) && ep.a(this.i, fbVar.i) && ep.a(this.j, fbVar.j) && ep.a(this.k, fbVar.k) && ep.a(this.l, fbVar.l) && ep.a(this.m, fbVar.m) && ep.a(this.n, fbVar.n) && ep.a(this.o, fbVar.o) && ep.a(this.p, fbVar.p) && ep.a(this.q, fbVar.q) && ep.a(this.r, fbVar.r) && ep.a(this.s, fbVar.s) && ep.a(this.t, fbVar.t) && ep.a(this.u, fbVar.u) && ep.a(this.v, fbVar.v) && ep.a(this.w, fbVar.w) && ep.a(this.x, fbVar.x);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.g;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.h;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.i;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.j;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.k;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.l;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
            Integer num = this.m;
            int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.n;
            int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
            Integer num3 = this.o;
            int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
            String str7 = this.p;
            int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.q;
            int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.r;
            int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
            String str10 = this.s;
            int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
            String str11 = this.t;
            int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
            String str12 = this.u;
            int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
            String str13 = this.v;
            int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 37;
            String str14 = this.w;
            int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 37;
            String str15 = this.x;
            if (str15 != null) {
                i2 = str15.hashCode();
            }
            int i3 = hashCode18 + i2;
            this.b = i3;
            return i3;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", mac=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", deviceId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", deviceMaker=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", deviceModel=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", osName=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", osVer=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", displayD=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", displayW=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", displayH=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", locale=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", timezone=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", pkgId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", pkgSign=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", sdk=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", countrySim=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", countryNet=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", imei=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", androidId=");
            sb.append(this.x);
        }
        StringBuilder replace = sb.replace(0, 2, "Info{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fb, a> {
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Integer i;
        public Integer j;
        public Integer k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;

        public final fb b() {
            return new fb(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fb> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fb fbVar) {
            fb fbVar2 = fbVar;
            int i = 0;
            int a = (fbVar2.g != null ? ek.p.a(1, (int) fbVar2.g) : 0) + (fbVar2.h != null ? ek.p.a(2, (int) fbVar2.h) : 0) + (fbVar2.i != null ? ek.p.a(3, (int) fbVar2.i) : 0) + (fbVar2.j != null ? ek.p.a(4, (int) fbVar2.j) : 0) + (fbVar2.k != null ? ek.p.a(5, (int) fbVar2.k) : 0) + (fbVar2.l != null ? ek.p.a(6, (int) fbVar2.l) : 0) + (fbVar2.m != null ? ek.d.a(7, (int) fbVar2.m) : 0) + (fbVar2.n != null ? ek.d.a(8, (int) fbVar2.n) : 0) + (fbVar2.o != null ? ek.d.a(9, (int) fbVar2.o) : 0) + (fbVar2.p != null ? ek.p.a(10, (int) fbVar2.p) : 0) + (fbVar2.q != null ? ek.p.a(11, (int) fbVar2.q) : 0) + (fbVar2.r != null ? ek.p.a(12, (int) fbVar2.r) : 0) + (fbVar2.s != null ? ek.p.a(13, (int) fbVar2.s) : 0) + (fbVar2.t != null ? ek.p.a(14, (int) fbVar2.t) : 0) + (fbVar2.u != null ? ek.p.a(15, (int) fbVar2.u) : 0) + (fbVar2.v != null ? ek.p.a(16, (int) fbVar2.v) : 0) + (fbVar2.w != null ? ek.p.a(17, (int) fbVar2.w) : 0);
            if (fbVar2.x != null) {
                i = ek.p.a(18, (int) fbVar2.x);
            }
            return a + i + fbVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fb fbVar) {
            fb fbVar2 = fbVar;
            if (fbVar2.g != null) {
                ek.p.a(emVar, 1, fbVar2.g);
            }
            if (fbVar2.h != null) {
                ek.p.a(emVar, 2, fbVar2.h);
            }
            if (fbVar2.i != null) {
                ek.p.a(emVar, 3, fbVar2.i);
            }
            if (fbVar2.j != null) {
                ek.p.a(emVar, 4, fbVar2.j);
            }
            if (fbVar2.k != null) {
                ek.p.a(emVar, 5, fbVar2.k);
            }
            if (fbVar2.l != null) {
                ek.p.a(emVar, 6, fbVar2.l);
            }
            if (fbVar2.m != null) {
                ek.d.a(emVar, 7, fbVar2.m);
            }
            if (fbVar2.n != null) {
                ek.d.a(emVar, 8, fbVar2.n);
            }
            if (fbVar2.o != null) {
                ek.d.a(emVar, 9, fbVar2.o);
            }
            if (fbVar2.p != null) {
                ek.p.a(emVar, 10, fbVar2.p);
            }
            if (fbVar2.q != null) {
                ek.p.a(emVar, 11, fbVar2.q);
            }
            if (fbVar2.r != null) {
                ek.p.a(emVar, 12, fbVar2.r);
            }
            if (fbVar2.s != null) {
                ek.p.a(emVar, 13, fbVar2.s);
            }
            if (fbVar2.t != null) {
                ek.p.a(emVar, 14, fbVar2.t);
            }
            if (fbVar2.u != null) {
                ek.p.a(emVar, 15, fbVar2.u);
            }
            if (fbVar2.v != null) {
                ek.p.a(emVar, 16, fbVar2.v);
            }
            if (fbVar2.w != null) {
                ek.p.a(emVar, 17, fbVar2.w);
            }
            if (fbVar2.x != null) {
                ek.p.a(emVar, 18, fbVar2.x);
            }
            emVar.a(fbVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fb.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fb a(el elVar) {
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
                        aVar.c = ek.p.a(elVar);
                        break;
                    case 2:
                        aVar.d = ek.p.a(elVar);
                        break;
                    case 3:
                        aVar.e = ek.p.a(elVar);
                        break;
                    case 4:
                        aVar.f = ek.p.a(elVar);
                        break;
                    case 5:
                        aVar.g = ek.p.a(elVar);
                        break;
                    case 6:
                        aVar.h = ek.p.a(elVar);
                        break;
                    case 7:
                        aVar.i = ek.d.a(elVar);
                        break;
                    case 8:
                        aVar.j = ek.d.a(elVar);
                        break;
                    case 9:
                        aVar.k = ek.d.a(elVar);
                        break;
                    case 10:
                        aVar.l = ek.p.a(elVar);
                        break;
                    case 11:
                        aVar.m = ek.p.a(elVar);
                        break;
                    case 12:
                        aVar.n = ek.p.a(elVar);
                        break;
                    case 13:
                        aVar.o = ek.p.a(elVar);
                        break;
                    case 14:
                        aVar.p = ek.p.a(elVar);
                        break;
                    case 15:
                        aVar.q = ek.p.a(elVar);
                        break;
                    case 16:
                        aVar.r = ek.p.a(elVar);
                        break;
                    case 17:
                        aVar.s = ek.p.a(elVar);
                        break;
                    case 18:
                        aVar.t = ek.p.a(elVar);
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
