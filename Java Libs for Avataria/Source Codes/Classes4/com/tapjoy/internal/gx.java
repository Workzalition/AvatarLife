package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.iq;
import java.util.Iterator;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class gx extends hi {
    private static final String h = "gx";
    private static gx i;
    final String a;
    final ht b;
    private final hb j;
    private boolean k;
    private boolean l;
    private long m;
    private Context n;
    private iq o;
    private Activity p;
    private hc q;
    private Handler r;
    private Runnable s;

    public static void a() {
        gx gxVar = i;
        if (gxVar != null) {
            Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.gx.1
                @Override // java.lang.Runnable
                public final void run() {
                    gx.a(gx.this);
                }
            };
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
                runnable.run();
            } else {
                t.a().post(runnable);
            }
        }
    }

    public gx(hb hbVar, String str, ht htVar, Context context) {
        this.j = hbVar;
        this.a = str;
        this.b = htVar;
        this.n = context;
    }

    public final void b() {
        Iterator<ic> it = this.b.a.iterator();
        while (it.hasNext()) {
            Iterator<ib> it2 = it.next().c.iterator();
            while (it2.hasNext()) {
                ib next = it2.next();
                if (next.l != null) {
                    next.l.b();
                }
                if (next.m != null) {
                    next.m.b();
                }
            }
        }
    }

    public final boolean c() {
        Iterator<ic> it = this.b.a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator<ib> it2 = it.next().c.iterator();
            while (it2.hasNext()) {
                ib next = it2.next();
                if ((next.l != null && !next.l.a()) || (next.m != null && !next.m.a())) {
                    z = false;
                    continue;
                    break;
                }
            }
            z = true;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    public final void a(hc hcVar, fx fxVar) {
        this.q = hcVar;
        Activity a = gt.a();
        this.p = a;
        if (a != null && !a.isFinishing()) {
            try {
                a(this.p, hcVar, fxVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = a.a(this.n);
        this.p = a2;
        if (a2 != null && !a2.isFinishing()) {
            try {
                a(this.p, hcVar, fxVar);
                return;
            } catch (WindowManager.BadTokenException unused2) {
            }
        }
        gy.b("Failed to show the content for \"{}\". No usable activity found.", this.a);
        hcVar.a(this.a, this.f, null);
    }

    private void a(final Activity activity, final hc hcVar, fx fxVar) {
        if (this.k) {
            TapjoyLog.e(h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.k = true;
        this.l = true;
        i = this;
        this.g = fxVar.a;
        this.o = new iq(activity, this.b, new iq.a() { // from class: com.tapjoy.internal.gx.2
            @Override // com.tapjoy.internal.iq.a
            public final void a(ib ibVar) {
                fw fwVar;
                if ((gx.this.g instanceof fw) && (fwVar = (fw) gx.this.g) != null && fwVar.b != null) {
                    fwVar.b.a();
                }
                gx.this.j.a(gx.this.b.b, ibVar.k);
                if (!js.c(ibVar.h)) {
                    gx.this.e.a(activity, ibVar.h, js.b(ibVar.i));
                    gx.this.d = true;
                } else if (!js.c(ibVar.g)) {
                    hi.a(activity, ibVar.g);
                }
                hcVar.a(gx.this.a, null);
                if (ibVar.j) {
                    gx.a(gx.this);
                }
            }

            @Override // com.tapjoy.internal.iq.a
            public final void a() {
                gx.a(gx.this);
            }
        });
        ac.a(activity.getWindow(), this.o, new FrameLayout.LayoutParams(-1, -1, 17));
        this.m = SystemClock.elapsedRealtime();
        this.j.a(this.b.b);
        fxVar.b();
        fr frVar = this.g;
        if (frVar != null) {
            frVar.b();
        }
        hcVar.c(this.a);
        if (this.b.c <= 0.0f) {
            return;
        }
        this.r = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.gx.3
            @Override // java.lang.Runnable
            public final void run() {
                gx.a(gx.this);
            }
        };
        this.s = runnable;
        this.r.postDelayed(runnable, this.b.c * 1000.0f);
    }

    static /* synthetic */ void a(gx gxVar) {
        hc hcVar;
        if (gxVar.l) {
            gxVar.l = false;
            Handler handler = gxVar.r;
            if (handler != null) {
                handler.removeCallbacks(gxVar.s);
                gxVar.s = null;
                gxVar.r = null;
            }
            if (i == gxVar) {
                i = null;
            }
            gxVar.j.a(gxVar.b.b, SystemClock.elapsedRealtime() - gxVar.m);
            if (!gxVar.d && (hcVar = gxVar.q) != null) {
                hcVar.a(gxVar.a, gxVar.f, null);
                gxVar.q = null;
            }
            ViewGroup viewGroup = (ViewGroup) gxVar.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(gxVar.o);
            }
            gxVar.o = null;
            Activity activity = gxVar.p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            gxVar.p = null;
        }
    }
}
