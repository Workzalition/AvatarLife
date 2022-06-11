package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ex extends ei<ex, a> {
    public static final ek<ex> c = new b();
    public final List<ew> d;

    public ex(List<ew> list, iw iwVar) {
        super(c, iwVar);
        this.d = ep.a("events", (List) list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ex)) {
            return false;
        }
        ex exVar = (ex) obj;
        return a().equals(exVar.a()) && this.d.equals(exVar.d);
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
            sb.append(", events=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "EventBatch{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<ex, a> {
        public List<ew> c = ep.a();

        public final ex b() {
            return new ex(this.c, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<ex> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(ex exVar) {
            ex exVar2 = exVar;
            return ew.c.a().a(1, (int) exVar2.d) + exVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, ex exVar) {
            ex exVar2 = exVar;
            ew.c.a().a(emVar, 1, exVar2.d);
            emVar.a(exVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, ex.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ ex a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c.add(ew.c.a(elVar));
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
