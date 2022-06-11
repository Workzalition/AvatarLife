package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public enum ez implements en {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);
    
    public static final ek<ez> e = new eg<ez>() { // from class: com.tapjoy.internal.ez.a
        @Override // com.tapjoy.internal.eg
        public final /* bridge */ /* synthetic */ ez a(int i) {
            return ez.a(i);
        }
    };
    private final int f;

    ez(int i) {
        this.f = i;
    }

    public static ez a(int i) {
        if (i != 0) {
            if (i == 1) {
                return CAMPAIGN;
            }
            if (i == 2) {
                return CUSTOM;
            }
            if (i == 3) {
                return USAGES;
            }
            return null;
        }
        return APP;
    }

    @Override // com.tapjoy.internal.en
    public final int a() {
        return this.f;
    }
}
