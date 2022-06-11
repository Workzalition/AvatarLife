package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPrivacyPolicy;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
final class gf extends ge {
    @Override // com.tapjoy.internal.ge
    public final Object a(Context context, String str, TJPlacementListener tJPlacementListener) {
        return new TJPlacement(context, str, tJPlacementListener);
    }

    @Override // com.tapjoy.internal.ge
    public final Object b() {
        return TJPrivacyPolicy.getInstance();
    }
}
