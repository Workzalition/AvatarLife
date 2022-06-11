package com.tapjoy.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.Collections;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dd implements Application.ActivityLifecycleCallbacks {
    private static dd d = new dd();
    public boolean a;
    public boolean b;
    public a c;

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public interface a {
        void a(boolean z);
    }

    private dd() {
    }

    public static dd a() {
        return d;
    }

    private void a(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (!this.a) {
                return;
            }
            b();
            a aVar = this.c;
            if (aVar == null) {
                return;
            }
            aVar.a(!z);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        View c;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            boolean z = true;
            boolean z2 = runningAppProcessInfo.importance != 100;
            boolean z3 = true;
            for (cx cxVar : Collections.unmodifiableCollection(dc.a().b)) {
                if (cxVar.d() && (c = cxVar.c()) != null && c.hasWindowFocus()) {
                    z3 = false;
                }
            }
            if (!z2 || !z3) {
                z = false;
            }
            a(z);
        }
    }

    public final void b() {
        boolean z = !this.b;
        for (cx cxVar : Collections.unmodifiableCollection(dc.a().a)) {
            cxVar.c.a(z);
        }
    }
}
