package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.internal.di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dk implements di {
    private final di a;

    public dk(di diVar) {
        this.a = diVar;
    }

    @Override // com.tapjoy.internal.di
    public final JSONObject a(View view) {
        return dn.a(0, 0, 0, 0);
    }

    @Override // com.tapjoy.internal.di
    public final void a(View view, JSONObject jSONObject, di.a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        dc a = dc.a();
        if (a != null) {
            Collection<cx> unmodifiableCollection = Collections.unmodifiableCollection(a.b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (cx cxVar : unmodifiableCollection) {
                View c = cxVar.c();
                if (c != null && dq.b(c) && (rootView = c.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = dq.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && dq.a((View) arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar.a((View) it.next(), this.a, jSONObject);
        }
    }
}
