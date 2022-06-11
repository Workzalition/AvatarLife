package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fs {
    private static final gb<Void> a = new gb<Void>() { // from class: com.tapjoy.internal.fs.1
        @Override // com.tapjoy.internal.gb
        protected final /* bridge */ /* synthetic */ String a(Void r1) {
            return "InsufficientCurrency";
        }

        @Override // com.tapjoy.internal.gb
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Void r4) {
            return TJPlacementManager.createPlacement(context, "InsufficientCurrency", true, tJPlacementListener);
        }
    };

    public static void a() {
        a.c(null);
    }
}
