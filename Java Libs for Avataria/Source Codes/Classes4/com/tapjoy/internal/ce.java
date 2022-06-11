package com.tapjoy.internal;

import kotlin.io.ConstantsKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ce {
    private final String[] a = new String[ConstantsKt.MINIMUM_BLOCK_SIZE];

    private static boolean a(String str, char[] cArr, int i, int i2) {
        if (str.length() != i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (cArr[i + i3] != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public final String a(char[] cArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 = (i3 * 31) + cArr[i4];
        }
        int i5 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        String[] strArr = this.a;
        int length = (i5 ^ ((i5 >>> 7) ^ (i5 >>> 4))) & (strArr.length - 1);
        String str = strArr[length];
        if (str == null || !a(str, cArr, i, i2)) {
            String str2 = new String(cArr, i, i2);
            this.a[length] = str2;
            return str2;
        }
        return str;
    }
}
