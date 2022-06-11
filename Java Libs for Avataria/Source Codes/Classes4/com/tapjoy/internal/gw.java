package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gw {
    public static String a(String str) {
        String trim;
        if (str == null || str.length() == 0 || (trim = str.trim()) == null || trim.length() == 0) {
            return null;
        }
        return trim;
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() != 0) {
            return trim;
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        if (str == null) {
            gy.a(str2, str3, "must not be null");
            return null;
        } else if (str.length() == 0) {
            gy.a(str2, str3, "must not be empty");
            return null;
        } else {
            String trim = str.trim();
            if (trim.length() != 0) {
                return trim;
            }
            gy.a(str2, str3, "must not be blank");
            return null;
        }
    }
}
