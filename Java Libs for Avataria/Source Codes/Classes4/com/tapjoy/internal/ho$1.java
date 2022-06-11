package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.ew;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
final class ho$1 implements Runnable {
    final /* synthetic */ ho a;

    ho$1(ho hoVar) {
        this.a = hoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.b.compareAndSet(true, false)) {
            gy.a("The session ended");
            ha haVar = this.a.a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - haVar.c;
            he heVar = haVar.a;
            synchronized (heVar) {
                long a = heVar.c.i.a() + elapsedRealtime;
                heVar.c.i.a(a);
                heVar.b.i = Long.valueOf(a);
            }
            ew.a a2 = haVar.a(ez.APP, "session");
            a2.i = Long.valueOf(elapsedRealtime);
            haVar.a(a2);
            haVar.c = 0L;
            he heVar2 = haVar.a;
            long longValue = a2.e.longValue();
            synchronized (heVar2) {
                SharedPreferences.Editor a3 = heVar2.c.a();
                heVar2.c.j.a(a3, longValue);
                heVar2.c.k.a(a3, elapsedRealtime);
                a3.apply();
                heVar2.b.j = Long.valueOf(longValue);
                heVar2.b.k = Long.valueOf(elapsedRealtime);
            }
            final gz gzVar = haVar.b;
            if (gzVar.b != null) {
                gzVar.a();
                new io() { // from class: com.tapjoy.internal.gz.1
                    @Override // com.tapjoy.internal.io
                    public final boolean a() {
                        return !gzVar.a.b();
                    }
                }.run();
            }
            gzVar.a.flush();
            ft.d.notifyObservers();
        }
    }
}
