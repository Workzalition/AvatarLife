package com.tapjoy.internal;

import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ar {
    public static <E> void a(List<E> list, int i) {
        if (i >= 0) {
            if (i <= 0) {
                return;
            }
            int size = list.size();
            if (i > size) {
                throw new IndexOutOfBoundsException();
            }
            if (i == size) {
                list.clear();
                return;
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                list.remove(0);
                i = i2;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
