package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public enum cq {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String d;

    cq(String str) {
        this.d = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.d;
    }
}
