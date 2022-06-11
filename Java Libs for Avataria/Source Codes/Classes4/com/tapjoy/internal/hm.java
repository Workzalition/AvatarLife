package com.tapjoy.internal;

import android.os.SystemClock;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class hm {
    protected static a a;
    private static hm b;

    protected abstract void a(a aVar);

    protected abstract boolean b();

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static class a {
        public final String a;
        public final String b;
        public final long c = SystemClock.elapsedRealtime();
        public final fj d = new fj(60000);

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static void a(hm hmVar) {
        synchronized (hm.class) {
            b = hmVar;
            a aVar = a;
            if (aVar != null) {
                a = null;
                hmVar.a(aVar);
            }
        }
    }

    public static void a(String str, String str2) {
        synchronized (hm.class) {
            a aVar = new a(str, str2);
            hm hmVar = b;
            if (hmVar != null) {
                a = null;
                hmVar.a(aVar);
            } else {
                a = aVar;
            }
        }
    }

    public static boolean c() {
        hm hmVar = b;
        if (hmVar == null || !hmVar.b()) {
            a aVar = a;
            return aVar != null && !aVar.d.a();
        }
        return true;
    }
}
