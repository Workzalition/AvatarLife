package com.tapjoy.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dx {
    final HashMap<View, String> a = new HashMap<>();
    final HashMap<View, a> b = new HashMap<>();
    final HashMap<String, View> c = new HashMap<>();
    final HashSet<View> d = new HashSet<>();
    final HashSet<String> e = new HashSet<>();
    final HashSet<String> f = new HashSet<>();
    final HashMap<String, String> g = new HashMap<>();
    boolean h;

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static class a {
        public final de a;
        public final ArrayList<String> b = new ArrayList<>();

        public a(de deVar, String str) {
            this.a = deVar;
            a(str);
        }

        public final void a(String str) {
            this.b.add(str);
        }
    }

    public final void a(cx cxVar) {
        for (de deVar : cxVar.b) {
            View view = (View) deVar.a.get();
            if (view != null) {
                a aVar = this.b.get(view);
                if (aVar != null) {
                    aVar.a(cxVar.f);
                } else {
                    this.b.put(view, new a(deVar, cxVar.f));
                }
            }
        }
    }
}
