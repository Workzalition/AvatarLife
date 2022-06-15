package com.platform101xp.sdk.internal.billing;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XPPurchase;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import kotlin.Metadata;

/* compiled from: BillingListener.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/BillingListener;", "", "billingDisconnected", "", "productsGot", IronSourceConstants.EVENTS_RESULT, "", "skuList", "", "Lcom/android/billingclient/api/SkuDetails;", "purchaseAcknowledged", FirebaseAnalytics.Event.PURCHASE, "Lcom/platform101xp/sdk/Platform101XPPurchase;", "purchaseFinished", "purchaseUpdated", "billingResult", "purchases", "", "Lcom/android/billingclient/api/Purchase;", "setupFinished", TJAdUnitConstants.String.MESSAGE, "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public interface BillingListener {
    void billingDisconnected();

    void productsGot(int i, List<? extends SkuDetails> list);

    void purchaseAcknowledged(int i, Platform101XPPurchase platform101XPPurchase);

    void purchaseFinished(int i, Platform101XPPurchase platform101XPPurchase);

    void purchaseUpdated(int i, List<Purchase> list);

    void setupFinished(int i, String str);
}
