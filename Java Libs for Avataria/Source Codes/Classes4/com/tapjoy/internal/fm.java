package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fm {
    private static final fm a = new fm();
    private Application b;
    private Application.ActivityLifecycleCallbacks c;
    private final HashSet<String> d = new HashSet<>();

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 14 && context != null) {
            fm fmVar = a;
            Context applicationContext = context.getApplicationContext();
            if (fmVar.b == null) {
                try {
                    if (applicationContext instanceof Application) {
                        fmVar.b = (Application) applicationContext;
                    } else {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.internal.fm.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        fm.this.b = fm.b();
                                    } catch (Exception e) {
                                        TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                                    }
                                } finally {
                                    countDownLatch.countDown();
                                }
                            }
                        });
                        countDownLatch.await();
                    }
                } catch (Exception e) {
                    TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                }
                if (fmVar.b == null) {
                    return;
                }
            }
            synchronized (fmVar) {
                if (fmVar.c == null) {
                    Activity c = b.c();
                    if (c != null) {
                        fmVar.d.add(b(c));
                    }
                    final HashSet<String> hashSet = fmVar.d;
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.tapjoy.internal.fm.2
                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityDestroyed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityPaused(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityResumed(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStarted(Activity activity) {
                            hashSet.add(fm.b(activity));
                            if (hashSet.size() == 1) {
                                hb.a().f();
                            }
                            b.a(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public final void onActivityStopped(Activity activity) {
                            hashSet.remove(fm.b(activity));
                            if (hashSet.size() <= 0) {
                                hb.a().g();
                            }
                        }
                    };
                    fmVar.c = activityLifecycleCallbacks;
                    fmVar.b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    hb.a().f();
                }
            }
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        fm fmVar = a;
        if (fmVar.b == null) {
            return;
        }
        synchronized (fmVar) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = fmVar.c;
            if (activityLifecycleCallbacks != null) {
                fmVar.b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                fmVar.c = null;
            }
        }
    }

    public static String b(Activity activity) {
        return activity.getClass().getName() + "@" + System.identityHashCode(activity);
    }

    static /* synthetic */ Application b() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }
}
