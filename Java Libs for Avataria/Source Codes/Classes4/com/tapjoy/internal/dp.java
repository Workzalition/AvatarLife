package com.tapjoy.internal;

import android.text.TextUtils;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dp {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return;
        }
        throw new IllegalArgumentException(str2);
    }

    public static void a(cx cxVar) {
        if (!cxVar.e) {
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    public static void b(cx cxVar) {
        if (cxVar.d) {
            a(cxVar);
            return;
        }
        throw new IllegalStateException("AdSession is not started");
    }

    public static void c(cx cxVar) {
        if (cu.NATIVE == cxVar.a.a) {
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
