package com.platform101xp.sdk;

import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$35 implements Function0<Unit> {
    final /* synthetic */ Platform101XPProduct val$product;

    Platform101XP$35(Platform101XPProduct platform101XPProduct) {
        this.val$product = platform101XPProduct;
    }

    public Unit invoke() {
        String valueOf = String.valueOf(Platform101XP.access$1100(Platform101XP.access$000()).getCurrentUserGameId());
        Platform101XP.access$1200("Purchase product: " + this.val$product.getProductId() + " user_id = " + valueOf);
        Platform101XP.access$4900(Platform101XP.access$000()).put(Platform101XPAnalyticsFirebase.PROPERTY_USER_ID, valueOf);
        Platform101XP.access$5000(Platform101XP.access$000()).purchaseProduct(this.val$product, Platform101XP.access$4900(Platform101XP.access$000()));
        return Unit.INSTANCE;
    }
}
