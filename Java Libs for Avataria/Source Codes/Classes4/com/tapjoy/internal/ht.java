package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class ht extends hs {
    public static final bd<ht> d = new bd<ht>() { // from class: com.tapjoy.internal.ht.1
        @Override // com.tapjoy.internal.bd
        public final /* synthetic */ ht a(bi biVar) {
            return new ht(biVar);
        }
    };
    public ArrayList<ic> a = new ArrayList<>();
    public Map<String, Object> b;
    public float c;

    public ht(bi biVar) {
        biVar.h();
        String str = null;
        String str2 = null;
        while (biVar.j()) {
            String l = biVar.l();
            if ("layouts".equals(l)) {
                biVar.a(this.a, ic.d);
            } else if ("meta".equals(l)) {
                this.b = biVar.d();
            } else if ("max_show_time".equals(l)) {
                this.c = (float) biVar.p();
            } else if ("ad_content".equals(l)) {
                str = biVar.b();
            } else if ("redirect_url".equals(l)) {
                str2 = biVar.b();
            } else {
                biVar.s();
            }
        }
        biVar.i();
        ArrayList<ic> arrayList = this.a;
        if (arrayList != null) {
            Iterator<ic> it = arrayList.iterator();
            while (it.hasNext()) {
                ic next = it.next();
                if (next.c != null) {
                    Iterator<ib> it2 = next.c.iterator();
                    while (it2.hasNext()) {
                        ib next2 = it2.next();
                        if (next2.i == null) {
                            next2.i = str;
                        }
                        if (next2.h == null) {
                            next2.h = str2;
                        }
                    }
                }
            }
        }
    }
}
