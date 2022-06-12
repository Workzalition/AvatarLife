package com.platform101xp.sdk;

import com.android.billingclient.api.Purchase;
import java.util.ArrayList;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPPurchase {
    private Purchase internalPurchase;
    private Integer transactionId;

    public Platform101XPPurchase(Integer num, Object obj) {
        this.transactionId = num;
        this.internalPurchase = (Purchase) obj;
    }

    public String getOrderId() {
        return this.internalPurchase.getOrderId();
    }

    public String getPackageName() {
        return this.internalPurchase.getPackageName();
    }

    public String getProductId() {
        return !this.internalPurchase.getSkus().isEmpty() ? (String) this.internalPurchase.getSkus().get(0) : "";
    }

    public ArrayList<String> getProductIds() {
        return this.internalPurchase.getSkus();
    }

    public String getToken() {
        return this.internalPurchase.getPurchaseToken();
    }

    public Object getInternalPurchase() {
        return this.internalPurchase;
    }

    public Integer getTransactionId() {
        return this.transactionId;
    }

    public String getSignature() {
        return this.internalPurchase.getSignature();
    }

    public String getOriginalJson() {
        return this.internalPurchase.getOriginalJson();
    }
}
