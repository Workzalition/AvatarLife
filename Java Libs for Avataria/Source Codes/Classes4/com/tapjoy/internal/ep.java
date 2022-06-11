package com.tapjoy.internal;

import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ep {
    public static <T> List<T> a() {
        return new eq(Collections.emptyList());
    }

    public static <T> List<T> a(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof eq) {
            list = ((eq) list).a;
        }
        if (list == Collections.emptyList() || (list instanceof eo)) {
            return list;
        }
        eo eoVar = new eo(list);
        if (!eoVar.contains(null)) {
            return eoVar;
        }
        throw new IllegalArgumentException(str + ".contains(null)");
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static IllegalStateException a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }
}
