package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fg extends ei<fg, a> {
    public static final ek<fg> c = new b();
    public final List<ff> d;

    public fg(List<ff> list) {
        this(list, iw.b);
    }

    public fg(List<ff> list, iw iwVar) {
        super(c, iwVar);
        this.d = ep.a("pushes", (List) list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fg)) {
            return false;
        }
        fg fgVar = (fg) obj;
        return a().equals(fgVar.a()) && this.d.equals(fgVar.d);
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
            sb.append(", pushes=");
            sb.append(this.d);
        }
        StringBuilder replace = sb.replace(0, 2, "PushList{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fg, a> {
        public List<ff> c = ep.a();

        public final fg b() {
            return new fg(this.c, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fg> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fg fgVar) {
            fg fgVar2 = fgVar;
            return ff.c.a().a(1, (int) fgVar2.d) + fgVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fg fgVar) {
            fg fgVar2 = fgVar;
            ff.c.a().a(emVar, 1, fgVar2.d);
            emVar.a(fgVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fg.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fg a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c.add(ff.c.a(elVar));
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
