package com.tapjoy.internal;

import android.os.Looper;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gy {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            w.a(4, "Tapjoy", str, (Throwable) null);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            w.a(4, "Tapjoy", str, objArr);
        }
    }

    public static void b(String str) {
        if (a) {
            w.a("Tapjoy", str);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            w.a("Tapjoy", str, objArr);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            w.a("Tapjoy", "{}: {} {}", new Object[]{str, str2, str3});
        }
    }

    public static boolean a(Object obj, String str) {
        if (obj == null) {
            if (!a) {
                return false;
            }
            b(str);
            return false;
        }
        return true;
    }

    public static boolean a(boolean z, String str) {
        if (!a || z) {
            return z;
        }
        b(str);
        throw new IllegalStateException(str);
    }

    static boolean c(String str) {
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        return a(z, str + ": Must be called on the main/ui thread");
    }

    static void d(String str) {
        if (a) {
            b(str + ": Should be called after initializing the SDK");
        }
    }

    static void e(String str) {
        if (a) {
            b(str + ": Should be called after initializing the SDK");
        }
    }
}
