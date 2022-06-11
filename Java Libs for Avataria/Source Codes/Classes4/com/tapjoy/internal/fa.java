package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import com.unity3d.ads.metadata.MediationMetaData;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fa extends ei<fa, a> {
    public static final ek<fa> c = new b();
    public static final Long d = 0L;
    public final String e;
    public final Long f;

    public fa(String str, Long l) {
        this(str, l, iw.b);
    }

    public fa(String str, Long l, iw iwVar) {
        super(c, iwVar);
        this.e = str;
        this.f = l;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fa)) {
            return false;
        }
        fa faVar = (fa) obj;
        return a().equals(faVar.a()) && this.e.equals(faVar.e) && this.f.equals(faVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = (((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", name=");
        sb.append(this.e);
        sb.append(", value=");
        sb.append(this.f);
        StringBuilder replace = sb.replace(0, 2, "EventValue{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fa, a> {
        public String c;
        public Long d;

        public final fa b() {
            String str = this.c;
            if (str == null || this.d == null) {
                throw ep.a(str, MediationMetaData.KEY_NAME, this.d, "value");
            }
            return new fa(this.c, this.d, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fa> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fa faVar) {
            fa faVar2 = faVar;
            return ek.p.a(1, (int) faVar2.e) + ek.i.a(2, (int) faVar2.f) + faVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fa faVar) {
            fa faVar2 = faVar;
            ek.p.a(emVar, 1, faVar2.e);
            ek.i.a(emVar, 2, faVar2.f);
            emVar.a(faVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fa.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fa a(el elVar) {
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
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
