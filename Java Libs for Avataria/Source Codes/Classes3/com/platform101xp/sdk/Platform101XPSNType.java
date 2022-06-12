package com.platform101xp.sdk;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public enum Platform101XPSNType {
    PORTAL,
    FACEBOOK,
    VK,
    OK,
    GOOGLE;
    
    private static Platform101XPSNType[] allValues = values();

    public int getValue() {
        return ordinal();
    }

    public static Platform101XPSNType fromOrdinal(int i) {
        return allValues[i];
    }
}
