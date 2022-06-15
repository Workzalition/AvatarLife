package com.platform101xp.sdk.internal.billing;

import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Platform101XPGoogleBillingManager.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
final class Platform101XPGoogleBillingManager$getProducts$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<String> $productId;
    final /* synthetic */ Platform101XPGoogleBillingManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPGoogleBillingManager$getProducts$1(List<String> list, Platform101XPGoogleBillingManager platform101XPGoogleBillingManager) {
        super(0);
        this.$productId = list;
        this.this$0 = platform101XPGoogleBillingManager;
    }

    public final void invoke() {
        Platform101XPAndroidBillingClient platform101XPAndroidBillingClient;
        Platform101XPGoogleBillingManager.Listener listener;
        ArrayList arrayList = new ArrayList();
        Collection collection = this.$productId;
        if (collection == null) {
            collection = this.this$0.createSkuList();
        }
        arrayList.addAll(collection);
        if (arrayList.isEmpty()) {
            listener = this.this$0.billingListener;
            listener.onGetProductsResult(null, new Platform101XPError(new Exception("Empty the sku list: com.platform101xp.sdk.billing.sku")));
            return;
        }
        platform101XPAndroidBillingClient = this.this$0.androidBillingClient;
        platform101XPAndroidBillingClient.querySkuDetails(arrayList);
    }
}
