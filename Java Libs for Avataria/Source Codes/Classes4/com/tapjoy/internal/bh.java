package com.tapjoy.internal;

import java.io.Writer;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bh implements bg {
    public final String a;

    public bh(String str) {
        this.a = str;
    }

    @Override // com.tapjoy.internal.bg
    public final void a(Writer writer) {
        writer.write(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bh)) {
            return false;
        }
        return this.a.equals(((bh) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
