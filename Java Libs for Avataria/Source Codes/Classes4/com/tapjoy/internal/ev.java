package com.tapjoy.internal;

import com.tapjoy.internal.ei;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ev extends ei<ev, a> {
    public static final ek<ev> c = new b();
    public static final Integer d = 0;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final String i;

    public ev(String str, Integer num, String str2, String str3, String str4, iw iwVar) {
        super(c, iwVar);
        this.e = str;
        this.f = num;
        this.g = str2;
        this.h = str3;
        this.i = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ev)) {
            return false;
        }
        ev evVar = (ev) obj;
        return a().equals(evVar.a()) && ep.a(this.e, evVar.e) && ep.a(this.f, evVar.f) && ep.a(this.g, evVar.g) && ep.a(this.h, evVar.h) && ep.a(this.i, evVar.i);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.e;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            Integer num = this.f;
            int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
            String str2 = this.g;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.h;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.i;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            int i3 = hashCode5 + i2;
            this.b = i3;
            return i3;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", pkgVer=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", pkgRev=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", dataVer=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", installer=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", store=");
            sb.append(this.i);
        }
        StringBuilder replace = sb.replace(0, 2, "App{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<ev, a> {
        public String c;
        public Integer d;
        public String e;
        public String f;
        public String g;

        public final ev b() {
            return new ev(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<ev> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(ev evVar) {
            ev evVar2 = evVar;
            int i = 0;
            int a = (evVar2.e != null ? ek.p.a(1, (int) evVar2.e) : 0) + (evVar2.f != null ? ek.d.a(2, (int) evVar2.f) : 0) + (evVar2.g != null ? ek.p.a(3, (int) evVar2.g) : 0) + (evVar2.h != null ? ek.p.a(4, (int) evVar2.h) : 0);
            if (evVar2.i != null) {
                i = ek.p.a(5, (int) evVar2.i);
            }
            return a + i + evVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, ev evVar) {
            ev evVar2 = evVar;
            if (evVar2.e != null) {
                ek.p.a(emVar, 1, evVar2.e);
            }
            if (evVar2.f != null) {
                ek.d.a(emVar, 2, evVar2.f);
            }
            if (evVar2.g != null) {
                ek.p.a(emVar, 3, evVar2.g);
            }
            if (evVar2.h != null) {
                ek.p.a(emVar, 4, evVar2.h);
            }
            if (evVar2.i != null) {
                ek.p.a(emVar, 5, evVar2.i);
            }
            emVar.a(evVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, ev.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ ev a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c = ek.p.a(elVar);
                } else if (b == 2) {
                    aVar.d = ek.d.a(elVar);
                } else if (b == 3) {
                    aVar.e = ek.p.a(elVar);
                } else if (b == 4) {
                    aVar.f = ek.p.a(elVar);
                } else if (b == 5) {
                    aVar.g = ek.p.a(elVar);
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
