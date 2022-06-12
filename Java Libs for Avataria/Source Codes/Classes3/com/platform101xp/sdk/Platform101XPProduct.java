package com.platform101xp.sdk;

import com.android.billingclient.api.SkuDetails;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProduct {
    private SkuDetails internalProduct;

    public Platform101XPProduct(Object obj) {
        this.internalProduct = (SkuDetails) obj;
    }

    public String getProductId() {
        SkuDetails skuDetails = this.internalProduct;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getSku();
    }

    public String getProductType() {
        SkuDetails skuDetails = this.internalProduct;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getType();
    }

    public String getPrice() {
        if (this.internalProduct == null) {
            return null;
        }
        return getCurrencyCode() + " " + getPriceValue();
    }

    public String getPriceValue() {
        if (this.internalProduct == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##", DecimalFormatSymbols.getInstance(Locale.US));
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        return decimalFormat.format(((float) this.internalProduct.getPriceAmountMicros()) / 1000000.0f);
    }

    public String getTitle() {
        SkuDetails skuDetails = this.internalProduct;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getTitle();
    }

    public String getDescription() {
        SkuDetails skuDetails = this.internalProduct;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getDescription();
    }

    public String getCurrencyCode() {
        SkuDetails skuDetails = this.internalProduct;
        if (skuDetails == null) {
            return null;
        }
        return skuDetails.getPriceCurrencyCode();
    }

    public SkuDetails getInternalProduct() {
        return this.internalProduct;
    }
}
