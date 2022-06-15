package com.platform101xp.sdk.internal.billing;

import android.app.Activity;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPPurchase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPAndroidBillingClient.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010%H\u0016J\u0014\u0010&\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\u0006\u0010*\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/Platform101XPAndroidBillingClient;", "Lcom/android/billingclient/api/BillingClientStateListener;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "()V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "listener", "Lcom/platform101xp/sdk/internal/billing/BillingListener;", "acknowledgePurchase", "", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "resPurchase", "Lcom/platform101xp/sdk/Platform101XPPurchase;", "endConnection", "finishPurchase", "getFlowParams", "Lcom/android/billingclient/api/BillingFlowParams;", "skuDetails", "Lcom/android/billingclient/api/SkuDetails;", "getPurchaseResult", "Lcom/android/billingclient/api/Purchase$PurchasesResult;", "initBillingClient", "initListener", "billingListener", "isReady", "", "launchBillingFlow", "activity", "Landroid/app/Activity;", "flowParams", "onBillingServiceDisconnected", "onBillingSetupFinished", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "onPurchasesUpdated", "purchases", "", "querySkuDetails", "skuList", "", "", "startConnection", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPAndroidBillingClient implements BillingClientStateListener, PurchasesUpdatedListener {
    private BillingClient billingClient;
    private BillingListener listener;

    public final void initListener(BillingListener billingListener) {
        Intrinsics.checkNotNullParameter(billingListener, "billingListener");
        this.listener = billingListener;
    }

    public final void initBillingClient() {
        BillingClient build = BillingClient.newBuilder(Platform101XP.getCurrentActivity()).enablePendingPurchases().setListener((PurchasesUpdatedListener) this).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder(Platform101XP…setListener(this).build()");
        this.billingClient = build;
    }

    public void onBillingServiceDisconnected() {
        BillingListener billingListener = this.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        billingListener.billingDisconnected();
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        BillingListener billingListener = this.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        billingListener.setupFinished(responseCode, debugMessage);
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        BillingListener billingListener = this.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        billingListener.purchaseUpdated(billingResult.getResponseCode(), list);
    }

    public final void startConnection() {
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.startConnection((BillingClientStateListener) this);
    }

    public final BillingFlowParams getFlowParams(SkuDetails skuDetails) {
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        BillingFlowParams build = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setSkuDetails(skuDetails).build()");
        return build;
    }

    public final void finishPurchase(final Platform101XPPurchase platform101XPPurchase) {
        Intrinsics.checkNotNullParameter(platform101XPPurchase, FirebaseAnalytics.Event.PURCHASE);
        ConsumeParams build = ConsumeParams.newBuilder().setPurchaseToken(platform101XPPurchase.getToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setPurchase…n(purchase.token).build()");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.consumeAsync(build, new ConsumeResponseListener() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPAndroidBillingClient$$ExternalSyntheticLambda1
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                Platform101XPAndroidBillingClient.m80finishPurchase$lambda0(Platform101XPAndroidBillingClient.this, platform101XPPurchase, billingResult, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: finishPurchase$lambda-0  reason: not valid java name */
    public static final void m80finishPurchase$lambda0(Platform101XPAndroidBillingClient platform101XPAndroidBillingClient, Platform101XPPurchase platform101XPPurchase, BillingResult billingResult, String str) {
        Intrinsics.checkNotNullParameter(platform101XPAndroidBillingClient, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPPurchase, "$purchase");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(str, "$noName_1");
        BillingListener billingListener = platform101XPAndroidBillingClient.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        billingListener.purchaseFinished(billingResult.getResponseCode(), platform101XPPurchase);
    }

    public final void acknowledgePurchase(Purchase purchase, final Platform101XPPurchase platform101XPPurchase) {
        Intrinsics.checkNotNullParameter(purchase, FirebaseAnalytics.Event.PURCHASE);
        Intrinsics.checkNotNullParameter(platform101XPPurchase, "resPurchase");
        AcknowledgePurchaseParams build = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …ken)\n            .build()");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.acknowledgePurchase(build, new AcknowledgePurchaseResponseListener() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPAndroidBillingClient$$ExternalSyntheticLambda0
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                Platform101XPAndroidBillingClient.m79acknowledgePurchase$lambda1(Platform101XPAndroidBillingClient.this, platform101XPPurchase, billingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: acknowledgePurchase$lambda-1  reason: not valid java name */
    public static final void m79acknowledgePurchase$lambda1(Platform101XPAndroidBillingClient platform101XPAndroidBillingClient, Platform101XPPurchase platform101XPPurchase, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(platform101XPAndroidBillingClient, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPPurchase, "$resPurchase");
        Intrinsics.checkNotNullParameter(billingResult, "it");
        BillingListener billingListener = platform101XPAndroidBillingClient.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        billingListener.purchaseAcknowledged(billingResult.getResponseCode(), platform101XPPurchase);
    }

    public final void querySkuDetails(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "skuList");
        SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        newBuilder.setSkusList(list).setType("inapp");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPAndroidBillingClient$$ExternalSyntheticLambda2
            public final void onSkuDetailsResponse(BillingResult billingResult, List list2) {
                Platform101XPAndroidBillingClient.m81querySkuDetails$lambda2(Platform101XPAndroidBillingClient.this, billingResult, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: querySkuDetails$lambda-2  reason: not valid java name */
    public static final void m81querySkuDetails$lambda2(Platform101XPAndroidBillingClient platform101XPAndroidBillingClient, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(platform101XPAndroidBillingClient, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        BillingListener billingListener = platform101XPAndroidBillingClient.listener;
        if (billingListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            billingListener = null;
        }
        billingListener.productsGot(billingResult.getResponseCode(), list);
    }

    public final void launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(billingFlowParams, "flowParams");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.launchBillingFlow(activity, billingFlowParams);
    }

    public final Purchase.PurchasesResult getPurchaseResult() {
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        Purchase.PurchasesResult queryPurchases = billingClient.queryPurchases("inapp");
        Intrinsics.checkNotNullExpressionValue(queryPurchases, "billingClient.queryPurch…lingClient.SkuType.INAPP)");
        return queryPurchases;
    }

    public final boolean isReady() {
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        return billingClient.isReady();
    }

    public final void endConnection() {
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.endConnection();
    }
}
