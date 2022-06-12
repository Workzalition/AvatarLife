package com.platform101xp.sdk;

import android.app.Dialog;
import android.util.Log;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$11 implements Platform101XPGoogleBillingManager.Listener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$11(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager.Listener
    public void onInitializeResult(Platform101XPError platform101XPError) {
        if (Platform101XP.access$700(this.this$0) != null) {
            Platform101XP.access$700(this.this$0).onBillingInitializeResult(platform101XPError);
        }
        if (platform101XPError == null) {
            Platform101XP.getProducts((List) null);
        }
    }

    @Override // com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager.Listener
    public void onGetProductsResult(List<Platform101XPProduct> list, Platform101XPError platform101XPError) {
        if (Platform101XP.access$700(this.this$0) != null) {
            Platform101XP.access$700(this.this$0).onGetProductsResult(list, platform101XPError);
        }
    }

    @Override // com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager.Listener
    public void onPurchaseProductResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError) {
        if (platform101XPError != null && platform101XPError.getErrorType().equals(Platform101XPError.ErrorType.ERROR_OPERATION_IN_PROGRESS) && Platform101XP.access$800(this.this$0) != null) {
            Platform101XP.access$900(this.this$0, new Runnable() { // from class: com.platform101xp.sdk.Platform101XP$11.1
                @Override // java.lang.Runnable
                public void run() {
                    Dialog warningDialog = Platform101XP.access$800(Platform101XP$11.this.this$0).getFactory().getWarningDialog(Platform101XPWarningDialogs.WarningType.TO_MANY_OPERATIONS_WARNING, null);
                    if (warningDialog != null) {
                        warningDialog.show();
                    }
                }
            });
        }
        if (Platform101XP.access$700(this.this$0) != null) {
            Platform101XP.access$700(this.this$0).onPurchaseProductResult(platform101XPPurchase, platform101XPError);
        }
    }

    @Override // com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager.Listener
    public void onFinishPurchaseResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError) {
        if (platform101XPError != null) {
            Log.d("101XP SDK", "FinishPurchaseResult error:" + platform101XPError);
        }
        Platform101XP.access$700(this.this$0).onFinishPurchaseResult(platform101XPPurchase, platform101XPError);
    }
}
