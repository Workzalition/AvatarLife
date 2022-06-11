package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dw implements di.a {
    private int e;
    private long i;
    private static dw c = new dw();
    public static Handler a = new Handler(Looper.getMainLooper());
    private static Handler d = null;
    private static final Runnable j = new Runnable() { // from class: com.tapjoy.internal.dw.2
        @Override // java.lang.Runnable
        public final void run() {
            dw.b(dw.a());
        }
    };
    private static final Runnable k = new Runnable() { // from class: com.tapjoy.internal.dw.3
        @Override // java.lang.Runnable
        public final void run() {
            if (dw.d != null) {
                dw.d.post(dw.j);
                dw.d.postDelayed(dw.k, 200L);
            }
        }
    };
    public List<Object> b = new ArrayList();
    private dx g = new dx();
    private dj f = new dj();
    private ee h = new ee(new ea());

    dw() {
    }

    public static dw a() {
        return c;
    }

    private void a(long j2) {
        if (this.b.size() > 0) {
            Iterator<Object> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j2);
            }
        }
    }

    private void a(View view, di diVar, JSONObject jSONObject, int i) {
        diVar.a(view, jSONObject, this, i == ef.a);
    }

    public static void b() {
        if (d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            d = handler;
            handler.post(j);
            d.postDelayed(k, 200L);
        }
    }

    public static void c() {
        Handler handler = d;
        if (handler != null) {
            handler.removeCallbacks(k);
            d = null;
        }
    }

    @Override // com.tapjoy.internal.di.a
    public final void a(View view, di diVar, JSONObject jSONObject) {
        String str;
        boolean z = false;
        if (!(dq.c(view) == null)) {
            return;
        }
        dx dxVar = this.g;
        int i = dxVar.d.contains(view) ? ef.a : dxVar.h ? ef.b : ef.c;
        if (i == ef.c) {
            return;
        }
        JSONObject a2 = diVar.a(view);
        dn.a(jSONObject, a2);
        dx dxVar2 = this.g;
        if (dxVar2.a.size() == 0) {
            str = null;
        } else {
            String str2 = dxVar2.a.get(view);
            if (str2 != null) {
                dxVar2.a.remove(view);
            }
            str = str2;
        }
        if (str != null) {
            dn.a(a2, str);
            this.g.h = true;
            z = true;
        }
        if (!z) {
            dx dxVar3 = this.g;
            dx.a aVar = dxVar3.b.get(view);
            if (aVar != null) {
                dxVar3.b.remove(view);
            }
            if (aVar != null) {
                dn.a(a2, aVar);
            }
            a(view, diVar, a2, i);
        }
        this.e++;
    }

    static /* synthetic */ void b(dw dwVar) {
        String str;
        dwVar.e = 0;
        dwVar.i = System.nanoTime();
        dx dxVar = dwVar.g;
        dc a2 = dc.a();
        if (a2 != null) {
            for (cx cxVar : Collections.unmodifiableCollection(a2.b)) {
                View c2 = cxVar.c();
                if (cxVar.d()) {
                    String str2 = cxVar.f;
                    if (c2 != null) {
                        if (!c2.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = c2;
                            while (true) {
                                if (view == null) {
                                    dxVar.d.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String c3 = dq.c(view);
                                if (c3 != null) {
                                    str = c3;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            dxVar.e.add(str2);
                            dxVar.a.put(c2, str2);
                            dxVar.a(cxVar);
                        } else {
                            dxVar.f.add(str2);
                            dxVar.c.put(str2, c2);
                            dxVar.g.put(str2, str);
                        }
                    } else {
                        dxVar.f.add(str2);
                        dxVar.g.put(str2, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        dk dkVar = dwVar.f.b;
        if (dwVar.g.f.size() > 0) {
            Iterator<String> it = dwVar.g.f.iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a3 = dkVar.a(null);
                View view2 = dwVar.g.c.get(next);
                dl dlVar = dwVar.f.a;
                String str3 = dwVar.g.g.get(next);
                if (str3 != null) {
                    JSONObject a4 = dlVar.a(view2);
                    dn.a(a4, next);
                    dn.b(a4, str3);
                    dn.a(a3, a4);
                }
                dn.a(a3);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(next);
                ee eeVar = dwVar.h;
                eeVar.a.a(new ec(eeVar, hashSet2, a3, nanoTime));
            }
        }
        if (dwVar.g.e.size() > 0) {
            JSONObject a5 = dkVar.a(null);
            dwVar.a(null, dkVar, a5, ef.a);
            dn.a(a5);
            ee eeVar2 = dwVar.h;
            eeVar2.a.a(new ed(eeVar2, dwVar.g.e, a5, nanoTime));
        } else {
            dwVar.h.b();
        }
        dx dxVar2 = dwVar.g;
        dxVar2.a.clear();
        dxVar2.b.clear();
        dxVar2.c.clear();
        dxVar2.d.clear();
        dxVar2.e.clear();
        dxVar2.f.clear();
        dxVar2.g.clear();
        dxVar2.h = false;
        dwVar.a(System.nanoTime() - dwVar.i);
    }
}
