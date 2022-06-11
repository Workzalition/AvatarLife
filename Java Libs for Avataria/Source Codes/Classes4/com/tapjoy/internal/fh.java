package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fh extends ei<fh, a> {
    public static final ek<fh> c = new b();
    public final List<String> d;

    public fh(List<String> list) {
        this(list, iw.b);
    }

    public fh(List<String> list, iw iwVar) {
        super(c, iwVar);
        this.d = ep.a("elements", (List) list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        return a().equals(fhVar.a()) && this.d.equals(fhVar.d);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = (a().hashCode() * 37) + this.d.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.d.isEmpty()) {
            sb.append(", elements=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "StringList{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fh, a> {
        public List<String> c = ep.a();

        public final fh b() {
            return new fh(this.c, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fh> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fh fhVar) {
            fh fhVar2 = fhVar;
            return ek.p.a().a(1, (int) fhVar2.d) + fhVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fh fhVar) {
            fh fhVar2 = fhVar;
            ek.p.a().a(emVar, 1, fhVar2.d);
            emVar.a(fhVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fh.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fh a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c.add(ek.p.a(elVar));
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
