package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class hp {
    private static String e;
    private static boolean f;
    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
    public static final CountDownLatch b = new CountDownLatch(1);
    private static final Runnable d = new Runnable() { // from class: com.tapjoy.internal.hp.1
        @Override // java.lang.Runnable
        public final void run() {
            if (u.c()) {
                hp.b.countDown();
            } else if (u.a()) {
                hp.b.countDown();
            } else {
                hp.a.schedule(this, 300L, TimeUnit.SECONDS);
            }
        }
    };
    public static final CountDownLatch c = new CountDownLatch(1);

    public static void a() {
        a.execute(d);
    }

    public static void a(String str, boolean z) {
        e = str;
        f = z;
        c.countDown();
    }

    public static String b() {
        return e;
    }

    public static boolean c() {
        return f;
    }
}
