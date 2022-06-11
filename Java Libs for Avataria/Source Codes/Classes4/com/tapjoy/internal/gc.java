package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.gl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gc {
    private static final gc b;
    private static gc c;
    public final ga a = new ga();
    private Context d;

    static {
        gc gcVar = new gc();
        b = gcVar;
        c = gcVar;
    }

    public static gc a() {
        return c;
    }

    public static ga b() {
        return c.a;
    }

    gc() {
    }

    /* JADX WARN: Finally extract failed */
    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.d == null) {
                this.d = context;
                SharedPreferences c2 = c();
                String string = c().getString("configurations", null);
                if (string != null) {
                    try {
                        bi b2 = bi.b(string);
                        try {
                            Map d = b2.d();
                            b2.close();
                            this.a.a(d);
                        } catch (Throwable th) {
                            b2.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                        c2.edit().remove("configurations").apply();
                    }
                }
                Observer observer = new Observer() { // from class: com.tapjoy.internal.gc.1
                    @Override // java.util.Observer
                    public final void update(Observable observable, Object obj) {
                        Object obj2;
                        gh.a(gc.this.a.a("usage_tracking_enabled", false));
                        Iterator<gl.a> it = gc.this.a.b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            Object a = it.next().a("usage_tracking_exclude");
                            if (a != null && List.class.isInstance(a)) {
                                obj2 = List.class.cast(a);
                                break;
                            }
                        }
                        gh.a((Collection) obj2);
                    }
                };
                this.a.addObserver(observer);
                observer.update(this.a, null);
            }
        }
    }

    public final SharedPreferences c() {
        return this.d.getSharedPreferences("tjcPrefrences", 0);
    }
}
