package com.tapjoy.internal;

import com.tapjoy.internal.ei;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fd extends ei<fd, a> {
    public static final ek<fd> c = new b();
    public final String d;
    public final String e;
    public final String f;

    public fd(String str, String str2, String str3) {
        this(str, str2, str3, iw.b);
    }

    public fd(String str, String str2, String str3, iw iwVar) {
        super(c, iwVar);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fd)) {
            return false;
        }
        fd fdVar = (fd) obj;
        return a().equals(fdVar.a()) && ep.a(this.d, fdVar.d) && ep.a(this.e, fdVar.e) && ep.a(this.f, fdVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.d;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.e;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.f;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            int i3 = hashCode3 + i2;
            this.b = i3;
            return i3;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", fq7Change=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", fq30Change=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", pushId=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "Meta{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fd, a> {
        public String c;
        public String d;
        public String e;

        public final fd b() {
            return new fd(this.c, this.d, this.e, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fd> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fd fdVar) {
            fd fdVar2 = fdVar;
            int i = 0;
            int a = (fdVar2.d != null ? ek.p.a(1, (int) fdVar2.d) : 0) + (fdVar2.e != null ? ek.p.a(2, (int) fdVar2.e) : 0);
            if (fdVar2.f != null) {
                i = ek.p.a(3, (int) fdVar2.f);
            }
            return a + i + fdVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fd fdVar) {
            fd fdVar2 = fdVar;
            if (fdVar2.d != null) {
                ek.p.a(emVar, 1, fdVar2.d);
            }
            if (fdVar2.e != null) {
                ek.p.a(emVar, 2, fdVar2.e);
            }
            if (fdVar2.f != null) {
                ek.p.a(emVar, 3, fdVar2.f);
            }
            emVar.a(fdVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fd.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fd a(el elVar) {
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
                    aVar.d = ek.p.a(elVar);
                } else if (b == 3) {
                    aVar.e = ek.p.a(elVar);
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
