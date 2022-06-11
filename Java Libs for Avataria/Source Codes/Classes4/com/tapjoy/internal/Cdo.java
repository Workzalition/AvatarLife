package com.tapjoy.internal;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.tapjoy.internal.do */
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class Cdo {
    public static void a(String str) {
        if (!cg.a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void a(String str, Exception exc) {
        if (cg.a.booleanValue()) {
            TextUtils.isEmpty(str);
        }
        Log.e("OMIDLIB", str, exc);
    }
}
