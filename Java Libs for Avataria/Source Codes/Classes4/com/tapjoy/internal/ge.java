package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class ge {
    private static final ge a;
    private static ge b;

    public abstract Object a(Context context, String str, TJPlacementListener tJPlacementListener);

    public abstract Object b();

    static {
        gf gfVar = new gf();
        a = gfVar;
        b = gfVar;
    }

    public static ge a() {
        return b;
    }
}
