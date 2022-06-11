package com.tapjoy.internal;

import com.tapjoy.internal.il;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class hj implements ca<il.a> {
    public final hb a;
    private final Map<String, hi> b = Collections.synchronizedMap(new HashMap());
    private final Map<String, il> c = jw.a();
    private Set<String> d = null;

    public hj(hb hbVar) {
        this.a = hbVar;
    }

    final void a() {
        synchronized (this) {
            this.d = null;
        }
    }

    public void a(bv<il.a> bvVar, il.a aVar) {
        if (bvVar instanceof il) {
            if (aVar.b != null) {
                List<String> list = aVar.b;
                synchronized (this) {
                    this.d = list instanceof Collection ? new HashSet(ju.a(list)) : jx.a(list.iterator());
                }
            }
            il ilVar = (il) bvVar;
            String str = ilVar.c;
            boolean z = ilVar.d;
            this.c.remove(str);
            if (!z) {
                this.b.put(str, aVar.a);
            }
            hi hiVar = aVar.a;
            hc hcVar = this.a.o;
            if (hiVar instanceof hh) {
                gy.a("No content for \"{}\"", str);
                hcVar.a(str);
                return;
            }
            gy.a("New content for \"{}\" is ready", str);
            if (z) {
                hiVar.a(hcVar, new fx());
                return;
            } else {
                hcVar.b(str);
                return;
            }
        }
        throw new IllegalStateException(bvVar.getClass().getName());
    }

    @Override // com.tapjoy.internal.ca
    public final void a(bv<il.a> bvVar) {
        a(bvVar, new il.a(new hh(), null));
    }
}
