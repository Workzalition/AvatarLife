package com.tapjoy.internal;

import com.tapjoy.internal.ei;
import com.tapjoy.internal.ei.a;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class ei<M extends ei<M, B>, B extends a<M, B>> implements Serializable {
    transient int a = 0;
    protected transient int b = 0;
    private final transient ek<M> c;
    private final transient iw d;

    public ei(ek<M> ekVar, iw iwVar) {
        Objects.requireNonNull(ekVar, "adapter == null");
        Objects.requireNonNull(iwVar, "unknownFields == null");
        this.c = ekVar;
        this.d = iwVar;
    }

    public final iw a() {
        iw iwVar = this.d;
        return iwVar != null ? iwVar : iw.b;
    }

    public String toString() {
        return ek.c(this);
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static abstract class a<T extends ei<T, B>, B extends a<T, B>> {
        it a;
        em b;

        public final a<T, B> a(iw iwVar) {
            if (iwVar.c() > 0) {
                if (this.b == null) {
                    it itVar = new it();
                    this.a = itVar;
                    this.b = new em(itVar);
                }
                try {
                    this.b.a(iwVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final a<T, B> a(int i, eh ehVar, Object obj) {
            if (this.b == null) {
                it itVar = new it();
                this.a = itVar;
                this.b = new em(itVar);
            }
            try {
                ehVar.a().a(this.b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final iw a() {
            it itVar = this.a;
            if (itVar == null) {
                return iw.b;
            }
            return new iw(itVar.clone().h());
        }
    }
}
