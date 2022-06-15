package com.platform101xp.sdk.internal.billing;

import android.util.Log;
import com.android.billingclient.api.Purchase;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Platform101XPGoogleBillingManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager$restoreProducts$1", f = "Platform101XPGoogleBillingManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
final class Platform101XPGoogleBillingManager$restoreProducts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Platform101XPGoogleBillingManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPGoogleBillingManager$restoreProducts$1(Platform101XPGoogleBillingManager platform101XPGoogleBillingManager, Continuation<? super Platform101XPGoogleBillingManager$restoreProducts$1> continuation) {
        super(2, continuation);
        this.this$0 = platform101XPGoogleBillingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Platform101XPGoogleBillingManager$restoreProducts$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Platform101XPAndroidBillingClient platform101XPAndroidBillingClient;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            platform101XPAndroidBillingClient = this.this$0.androidBillingClient;
            Purchase.PurchasesResult purchaseResult = platform101XPAndroidBillingClient.getPurchaseResult();
            int responseCode = purchaseResult.getResponseCode();
            if (responseCode == -1) {
                this.this$0.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception("billing service disconnected")));
                Log.d("101XP SDK", " restoreProducts: Start reconnect to billing service");
                this.this$0.connectToPlayBillingService();
            } else if (responseCode == 0) {
                this.this$0.restoreProductsResultOk(purchaseResult);
            } else {
                Exception exc = new Exception(Intrinsics.stringPlus("Restore products is fail, ResponseCode: ", Boxing.boxInt(purchaseResult.getResponseCode())));
                this.this$0.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(exc));
                Platform101XP.sendCrashReport(exc);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
