package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.internal.ft;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fq extends gv implements Observer {
    private boolean d;
    private final Map<String, Integer> b = new HashMap();
    private final fj c = new fj();
    private final gb<Void> e = new gb<Void>() { // from class: com.tapjoy.internal.fq.1
        @Override // com.tapjoy.internal.gb
        protected final /* bridge */ /* synthetic */ String a(Void r1) {
            return "AppLaunch";
        }

        @Override // com.tapjoy.internal.gb
        public final boolean a() {
            return super.a() && !hm.c();
        }

        @Override // com.tapjoy.internal.gb
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Void r4) {
            return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
        }
    };

    public static void a() {
    }

    static {
        gv.a = new fq();
    }

    private fq() {
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        ft.a aVar = ft.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r3 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        if (r5.c.a() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
        r5.e.c(null);
     */
    @Override // com.tapjoy.internal.gv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.app.Activity r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 == 0) goto L55
            int r1 = r6.getTaskId()
            r2 = -1
            r3 = 0
            if (r1 != r2) goto Lc
            goto L53
        Lc:
            android.content.Intent r6 = r6.getIntent()
            if (r6 == 0) goto L53
            java.util.Set r2 = r6.getCategories()
            if (r2 == 0) goto L2e
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L2e
            java.lang.String r2 = r6.getAction()
            java.lang.String r4 = "android.intent.action.MAIN"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L2e
            r2 = 1
            goto L2f
        L2e:
            r2 = 0
        L2f:
            if (r2 != 0) goto L32
            goto L53
        L32:
            android.content.ComponentName r6 = r6.getComponent()
            if (r6 != 0) goto L39
            goto L53
        L39:
            java.lang.String r6 = r6.getClassName()
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r5.b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Object r6 = r2.put(r6, r4)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L52
            int r6 = r6.intValue()
            if (r6 != r1) goto L52
            goto L53
        L52:
            r3 = 1
        L53:
            if (r3 != 0) goto L61
        L55:
            boolean r6 = r5.d
            if (r6 != 0) goto L67
            com.tapjoy.internal.fj r6 = r5.c
            boolean r6 = r6.a()
            if (r6 == 0) goto L67
        L61:
            com.tapjoy.internal.gb<java.lang.Void> r6 = r5.e
            r1 = 0
            r6.c(r1)
        L67:
            r5.d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.fq.a(android.app.Activity):void");
    }
}
