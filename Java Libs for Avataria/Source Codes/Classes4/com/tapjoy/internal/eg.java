package com.tapjoy.internal;

import com.tapjoy.internal.ek;
import com.tapjoy.internal.en;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class eg<E extends en> extends ek<E> {
    protected abstract E a(int i);

    @Override // com.tapjoy.internal.ek
    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return em.a(((en) obj).a());
    }

    @Override // com.tapjoy.internal.ek
    public final /* synthetic */ void a(em emVar, Object obj) {
        emVar.c(((en) obj).a());
    }

    public eg(Class<E> cls) {
        super(eh.VARINT, cls);
    }

    @Override // com.tapjoy.internal.ek
    public final /* synthetic */ Object a(el elVar) {
        int c = elVar.c();
        E a = a(c);
        if (a != null) {
            return a;
        }
        throw new ek.a(c, this.a);
    }
}
