package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.is;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class hg extends hi {
    private static final String h = "hg";
    private static hg i;
    final String a;
    final hw b;
    private final hb j;
    private c k;
    private boolean l;
    private long m;
    private Context n;
    private boolean o = false;

    public static void a() {
        hg hgVar = i;
        if (hgVar != null) {
            hgVar.e();
        }
    }

    public hg(hb hbVar, String str, hw hwVar, Context context) {
        this.j = hbVar;
        this.a = str;
        this.b = hwVar;
        this.n = context;
    }

    public final void b() {
        hw hwVar = this.b;
        if (hwVar.a != null) {
            hwVar.a.b();
        }
        if (hwVar.b != null) {
            hwVar.b.b();
        }
        hwVar.c.b();
        if (hwVar.e != null) {
            hwVar.e.b();
        }
        if (hwVar.f != null) {
            hwVar.f.b();
        }
        if (hwVar.m == null || hwVar.m.a == null) {
            return;
        }
        hwVar.m.a.b();
    }

    public final boolean c() {
        hw hwVar = this.b;
        if (hwVar.c == null || hwVar.c.b == null) {
            return false;
        }
        if (hwVar.m != null && hwVar.m.a != null && hwVar.m.a.b == null) {
            return false;
        }
        if (hwVar.b != null && hwVar.f != null && hwVar.b.b != null && hwVar.f.b != null) {
            return true;
        }
        return (hwVar.a == null || hwVar.e == null || hwVar.a.b == null || hwVar.e.b == null) ? false : true;
    }

    public final void a(final hc hcVar, final fx fxVar) {
        Activity a = a.a(this.n);
        if (a != null && !a.isFinishing()) {
            try {
                a(a, hcVar, fxVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a2 = gt.a();
        try {
            TJContentActivity.start(hb.a().e, new TJContentActivity.AbstractContentProducer() { // from class: com.tapjoy.internal.hg.1
                public final void show(Activity activity) {
                    try {
                        hg.this.a(activity, hcVar, fxVar);
                    } catch (WindowManager.BadTokenException unused2) {
                        gy.b("Failed to show the content for \"{}\" caused by invalid activity", hg.this.a);
                        hcVar.a(hg.this.a, hg.this.f, null);
                    }
                }

                public final void dismiss(Activity activity) {
                    hg.this.e();
                }
            }, (a2 == null || (a2.getWindow().getAttributes().flags & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0) ? false : true);
        } catch (ActivityNotFoundException unused2) {
            if (a2 != null && !a2.isFinishing()) {
                try {
                    a(a2, hcVar, fxVar);
                    return;
                } catch (WindowManager.BadTokenException unused3) {
                    gy.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
                    hcVar.a(this.a, this.f, null);
                }
            }
            gy.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
            hcVar.a(this.a, this.f, null);
        }
    }

    public void a(final Activity activity, final hc hcVar, fx fxVar) {
        if (this.l) {
            TapjoyLog.e(h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.l = true;
        i = this;
        this.g = fxVar.a;
        c cVar = new c(activity);
        this.k = cVar;
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tapjoy.internal.hg.2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                hcVar.d(hg.this.a);
            }
        });
        this.k.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tapjoy.internal.hg.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                String obj;
                hg unused = hg.i = null;
                hi.a(activity, hg.this.b.g);
                hg.this.j.a(hg.this.b.k, SystemClock.elapsedRealtime() - hg.this.m);
                if (!hg.this.d) {
                    hcVar.a(hg.this.a, hg.this.f, hg.this.b.h);
                }
                if (hg.this.o && hg.this.b.k != null && hg.this.b.k.containsKey("action_id") && (obj = hg.this.b.k.get("action_id").toString()) != null && obj.length() > 0) {
                    hb hbVar = hg.this.j;
                    if (hbVar.b != null) {
                        hk hkVar = hbVar.b;
                        String a = hk.a();
                        String a2 = hkVar.b.a();
                        String a3 = hkVar.a.a();
                        if (a3 == null || !a.equals(a3)) {
                            hkVar.a.a(a);
                            a2 = "";
                        }
                        if (!(a2.length() == 0)) {
                            obj = !a2.contains(obj) ? a2.concat(",".concat(String.valueOf(obj))) : a2;
                        }
                        hkVar.b.a(obj);
                    }
                }
                Activity activity2 = activity;
                if (activity2 instanceof TJContentActivity) {
                    activity2.finish();
                }
            }
        });
        this.k.setCanceledOnTouchOutside(false);
        ir irVar = new ir(activity, this.b, new is(activity, this.b, new is.a() { // from class: com.tapjoy.internal.hg.4
            @Override // com.tapjoy.internal.is.a
            public final void a() {
                hg.this.k.cancel();
            }

            @Override // com.tapjoy.internal.is.a
            public final void a(hu huVar) {
                fv fvVar;
                if ((hg.this.g instanceof fv) && (fvVar = (fv) hg.this.g) != null && fvVar.b != null) {
                    fvVar.b.a();
                }
                hg.this.j.a(hg.this.b.k, huVar.b);
                hi.a(activity, huVar.d);
                if (!js.c(huVar.e)) {
                    hg.this.e.a(activity, huVar.e, js.b(huVar.f));
                    hg.this.d = true;
                }
                hcVar.a(hg.this.a, huVar.g);
                if (huVar.c) {
                    hg.this.k.dismiss();
                }
            }

            @Override // com.tapjoy.internal.is.a
            public final void b() {
                hg hgVar = hg.this;
                hgVar.o = !hgVar.o;
            }
        }));
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(irVar, new FrameLayout.LayoutParams(-2, -2, 17));
        this.k.setContentView(frameLayout);
        try {
            this.k.show();
            this.k.a();
            if ((activity.getWindow().getAttributes().flags & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
                this.k.getWindow().setFlags(LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY, LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
            }
            this.m = SystemClock.elapsedRealtime();
            this.j.a(this.b.k);
            fxVar.b();
            fr frVar = this.g;
            if (frVar != null) {
                frVar.b();
            }
            hcVar.c(this.a);
        } catch (WindowManager.BadTokenException e) {
            throw e;
        }
    }

    public void e() {
        c cVar = this.k;
        if (cVar != null) {
            cVar.dismiss();
        }
    }
}
