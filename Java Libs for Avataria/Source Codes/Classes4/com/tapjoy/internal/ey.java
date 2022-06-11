package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import com.tapjoy.internal.ek;
import com.unity3d.ads.metadata.MediationMetaData;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ey extends ei<ey, a> {
    public static final ek<ey> c = new b();
    public static final ez d = ez.APP;
    public final ez e;
    public final String f;
    public final String g;

    public ey(ez ezVar, String str, String str2, iw iwVar) {
        super(c, iwVar);
        this.e = ezVar;
        this.f = str;
        this.g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ey)) {
            return false;
        }
        ey eyVar = (ey) obj;
        return a().equals(eyVar.a()) && this.e.equals(eyVar.e) && this.f.equals(eyVar.f) && ep.a(this.g, eyVar.g);
    }

    public final int hashCode() {
        int i = this.b;
        if (i == 0) {
            int hashCode = ((((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37;
            String str = this.g;
            int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
            this.b = hashCode2;
            return hashCode2;
        }
        return i;
    }

    @Override // com.tapjoy.internal.ei
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.e);
        sb.append(", name=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", category=");
            sb.append(this.g);
        }
        StringBuilder replace = sb.replace(0, 2, "EventGroup{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends ei.a<ey, a> {
        public ez c;
        public String d;
        public String e;

        public final ey b() {
            ez ezVar = this.c;
            if (ezVar == null || this.d == null) {
                throw ep.a(ezVar, SharedKt.PARAM_TYPE, this.d, MediationMetaData.KEY_NAME);
            }
            return new ey(this.c, this.d, this.e, super.a());
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static final class b extends ek<ey> {
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(ey eyVar) {
            ey eyVar2 = eyVar;
            return ez.e.a(1, (int) eyVar2.e) + ek.p.a(2, (int) eyVar2.f) + (eyVar2.g != null ? ek.p.a(3, (int) eyVar2.g) : 0) + eyVar2.a().c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ ey a(el elVar) {
            return b(elVar);
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, ey eyVar) {
            ey eyVar2 = eyVar;
            ez.e.a(emVar, 1, eyVar2.e);
            ek.p.a(emVar, 2, eyVar2.f);
            if (eyVar2.g != null) {
                ek.p.a(emVar, 3, eyVar2.g);
            }
            emVar.a(eyVar2.a());
        }

        b() {
            super(eh.LENGTH_DELIMITED, ey.class);
        }

        private static ey b(el elVar) {
            a aVar = new a();
            long a = elVar.a();
            while (true) {
                int b = elVar.b();
                if (b == -1) {
                    elVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    try {
                        aVar.c = ez.e.a(elVar);
                    } catch (ek.a e) {
                        aVar.a(b, eh.VARINT, Long.valueOf(e.a));
                    }
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
