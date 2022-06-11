package com.tapjoy.internal;

import com.tapjoy.internal.ei;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fc extends ei<fc, a> {
    public static final ek<fc> c = new b();
    public final fb d;
    public final ev e;
    public final fi f;

    public fc(fb fbVar, ev evVar, fi fiVar) {
        this(fbVar, evVar, fiVar, iw.b);
    }

    public fc(fb fbVar, ev evVar, fi fiVar, iw iwVar) {
        super(c, iwVar);
        this.d = fbVar;
        this.e = evVar;
        this.f = fiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fc)) {
            return false;
        }
        fc fcVar = (fc) obj;
        return a().equals(fcVar.a()) && ep.a(this.d, fcVar.d) && ep.a(this.e, fcVar.e) && ep.a(this.f, fcVar.f);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = a().hashCode() * 37;
            fb fbVar = this.d;
            int i2 = 0;
            int hashCode2 = (hashCode + (fbVar != null ? fbVar.hashCode() : 0)) * 37;
            ev evVar = this.e;
            int hashCode3 = (hashCode2 + (evVar != null ? evVar.hashCode() : 0)) * 37;
            fi fiVar = this.f;
            if (fiVar != null) {
                i2 = fiVar.hashCode();
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
            sb.append(", info=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", app=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", user=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "InfoSet{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<fc, a> {
        public fb c;
        public ev d;
        public fi e;

        public final fc b() {
            return new fc(this.c, this.d, this.e, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<fc> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(fc fcVar) {
            fc fcVar2 = fcVar;
            int i = 0;
            int a = (fcVar2.d != null ? fb.c.a(1, (int) fcVar2.d) : 0) + (fcVar2.e != null ? ev.c.a(2, (int) fcVar2.e) : 0);
            if (fcVar2.f != null) {
                i = fi.c.a(3, (int) fcVar2.f);
            }
            return a + i + fcVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, fc fcVar) {
            fc fcVar2 = fcVar;
            if (fcVar2.d != null) {
                fb.c.a(emVar, 1, fcVar2.d);
            }
            if (fcVar2.e != null) {
                ev.c.a(emVar, 2, fcVar2.e);
            }
            if (fcVar2.f != null) {
                fi.c.a(emVar, 3, fcVar2.f);
            }
            emVar.a(fcVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, fc.class);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ fc a(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c = fb.c.a(elVar);
                } else if (b == 2) {
                    aVar.d = ev.c.a(elVar);
                } else if (b == 3) {
                    aVar.e = fi.c.a(elVar);
                } else {
                    eh ehVar = elVar.b;
                    aVar.a(b, ehVar, ehVar.a().a(elVar));
                }
            }
        }
    }
}
