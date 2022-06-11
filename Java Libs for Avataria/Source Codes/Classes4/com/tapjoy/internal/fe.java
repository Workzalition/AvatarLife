package com.tapjoy.internal;

import com.tapjoy.internal.ei;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fe extends ei<fe, a> {
    public static final ek<fe> c = new b();
    public static final Integer d = 1;
    public static final Double e = Double.valueOf(0.0d);
    public static final Integer f = 0;
    public static final Long g = 0L;
    public final String h;
    public final Integer i;
    public final Double j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final Integer p;
    public final Long q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;

    public fe(String str, Integer num, Double d2, String str2, String str3, String str4, String str5, String str6, Integer num2, Long l, String str7, String str8, String str9, String str10, iw iwVar) {
        super(c, iwVar);
        this.h = str;
        this.i = num;
        this.j = d2;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = num2;
        this.q = l;
        this.r = str7;
        this.s = str8;
        this.t = str9;
        this.u = str10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        return a().equals(feVar.a()) && this.h.equals(feVar.h) && ep.a(this.i, feVar.i) && ep.a(this.j, feVar.j) && ep.a(this.k, feVar.k) && ep.a(this.l, feVar.l) && ep.a(this.m, feVar.m) && ep.a(this.n, feVar.n) && ep.a(this.o, feVar.o) && ep.a(this.p, feVar.p) && ep.a(this.q, feVar.q) && ep.a(this.r, feVar.r) && ep.a(this.s, feVar.s) && ep.a(this.t, feVar.t) && ep.a(this.u, feVar.u);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = ((a().hashCode() * 37) + this.h.hashCode()) * 37;
            Integer num = this.i;
            int i2 = 0;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Double d2 = this.j;
            int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
            String str = this.k;
            int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.l;
            int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.m;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.n;
            int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.o;
            int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
            Integer num2 = this.p;
            int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
            Long l = this.q;
            int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 37;
            String str6 = this.r;
            int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
            String str7 = this.s;
            int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.t;
            int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.u;
            if (str9 != null) {
                i2 = str9.hashCode();
            }
            int i3 = hashCode13 + i2;
            this.b = i3;
            return i3;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", productId=");
        sb.append(this.h);
        if (this.i != null) {
            sb.append(", productQuantity=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", productPrice=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", productPriceCurrency=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", productType=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", productTitle=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", productDescription=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", transactionId=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", transactionState=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", transactionDate=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", campaignId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", currencyPrice=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", receipt=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", signature=");
            sb.append(this.u);
        }
        StringBuilder replace = sb.replace(0, 2, "Purchase{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fe, a> {
        public String c;
        public Integer d;
        public Double e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public Integer k;
        public Long l;
        public String m;
        public String n;
        public String o;
        public String p;

        public final fe b() {
            String str = this.c;
            if (str == null) {
                throw ep.a(str, "productId");
            }
            return new fe(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fe> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fe feVar) {
            fe feVar2 = feVar;
            int i = 0;
            int a = ek.p.a(1, (int) feVar2.h) + (feVar2.i != null ? ek.d.a(2, (int) feVar2.i) : 0) + (feVar2.j != null ? ek.o.a(3, (int) feVar2.j) : 0) + (feVar2.k != null ? ek.p.a(4, (int) feVar2.k) : 0) + (feVar2.l != null ? ek.p.a(5, (int) feVar2.l) : 0) + (feVar2.m != null ? ek.p.a(6, (int) feVar2.m) : 0) + (feVar2.n != null ? ek.p.a(7, (int) feVar2.n) : 0) + (feVar2.o != null ? ek.p.a(8, (int) feVar2.o) : 0) + (feVar2.p != null ? ek.d.a(9, (int) feVar2.p) : 0) + (feVar2.q != null ? ek.i.a(10, (int) feVar2.q) : 0) + (feVar2.r != null ? ek.p.a(11, (int) feVar2.r) : 0) + (feVar2.s != null ? ek.p.a(12, (int) feVar2.s) : 0) + (feVar2.t != null ? ek.p.a(13, (int) feVar2.t) : 0);
            if (feVar2.u != null) {
                i = ek.p.a(14, (int) feVar2.u);
            }
            return a + i + feVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fe feVar) {
            fe feVar2 = feVar;
            ek.p.a(emVar, 1, feVar2.h);
            if (feVar2.i != null) {
                ek.d.a(emVar, 2, feVar2.i);
            }
            if (feVar2.j != null) {
                ek.o.a(emVar, 3, feVar2.j);
            }
            if (feVar2.k != null) {
                ek.p.a(emVar, 4, feVar2.k);
            }
            if (feVar2.l != null) {
                ek.p.a(emVar, 5, feVar2.l);
            }
            if (feVar2.m != null) {
                ek.p.a(emVar, 6, feVar2.m);
            }
            if (feVar2.n != null) {
                ek.p.a(emVar, 7, feVar2.n);
            }
            if (feVar2.o != null) {
                ek.p.a(emVar, 8, feVar2.o);
            }
            if (feVar2.p != null) {
                ek.d.a(emVar, 9, feVar2.p);
            }
            if (feVar2.q != null) {
                ek.i.a(emVar, 10, feVar2.q);
            }
            if (feVar2.r != null) {
                ek.p.a(emVar, 11, feVar2.r);
            }
            if (feVar2.s != null) {
                ek.p.a(emVar, 12, feVar2.s);
            }
            if (feVar2.t != null) {
                ek.p.a(emVar, 13, feVar2.t);
            }
            if (feVar2.u != null) {
                ek.p.a(emVar, 14, feVar2.u);
            }
            emVar.a(feVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fe.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fe a(el elVar) {
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
                        aVar.d = ek.d.a(elVar);
                        break;
                    case 3:
                        aVar.e = ek.o.a(elVar);
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
                        aVar.i = ek.p.a(elVar);
                        break;
                    case 8:
                        aVar.j = ek.p.a(elVar);
                        break;
                    case 9:
                        aVar.k = ek.d.a(elVar);
                        break;
                    case 10:
                        aVar.l = ek.i.a(elVar);
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
                    default:
                        eh ehVar = elVar.b;
                        aVar.a(b, ehVar, ehVar.a().a(elVar));
                        break;
                }
            }
        }
    }
}
