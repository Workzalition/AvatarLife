package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import com.vungle.warren.model.CacheBustDBAdapter;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ff extends ei<ff, a> {
    public static final ek<ff> c = new b();
    public static final Long d = 0L;
    public static final Long e = 0L;
    public final String f;
    public final Long g;
    public final Long h;

    public ff(String str, Long l) {
        this(str, l, null, iw.b);
    }

    public ff(String str, Long l, Long l2, iw iwVar) {
        super(c, iwVar);
        this.f = str;
        this.g = l;
        this.h = l2;
    }

    public final a b() {
        a aVar = new a();
        aVar.c = this.f;
        aVar.d = this.g;
        aVar.e = this.h;
        aVar.a(a());
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ff)) {
            return false;
        }
        ff ffVar = (ff) obj;
        return a().equals(ffVar.a()) && this.f.equals(ffVar.f) && this.g.equals(ffVar.g) && ep.a(this.h, ffVar.h);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = ((((a().hashCode() * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37;
            Long l = this.h;
            int hashCode2 = hashCode + (l != null ? l.hashCode() : 0);
            this.b = hashCode2;
            return hashCode2;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.f);
        sb.append(", received=");
        sb.append(this.g);
        if (this.h != null) {
            sb.append(", clicked=");
            sb.append(this.h);
        }
        StringBuilder replace = sb.replace(0, 2, "Push{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<ff, a> {
        public String c;
        public Long d;
        public Long e;

        public final ff b() {
            String str = this.c;
            if (str == null || this.d == null) {
                throw ep.a(str, CacheBustDBAdapter.CacheBustColumns.COLUMN_EVENT_ID, this.d, "received");
            }
            return new ff(this.c, this.d, this.e, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<ff> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(ff ffVar) {
            ff ffVar2 = ffVar;
            return ek.p.a(1, (int) ffVar2.f) + ek.i.a(2, (int) ffVar2.g) + (ffVar2.h != null ? ek.i.a(3, (int) ffVar2.h) : 0) + ffVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, ff ffVar) {
            ff ffVar2 = ffVar;
            ek.p.a(emVar, 1, ffVar2.f);
            ek.i.a(emVar, 2, ffVar2.g);
            if (ffVar2.h != null) {
                ek.i.a(emVar, 3, ffVar2.h);
            }
            emVar.a(ffVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, ff.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ ff a(el elVar) {
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
                    aVar.d = ek.i.a(elVar);
                } else if (b == 3) {
                    aVar.e = ek.i.a(elVar);
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
