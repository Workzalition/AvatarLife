package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public enum eh {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    final int e;

    eh(int i) {
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.eh$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[eh.values().length];
            a = iArr;
            try {
                iArr[eh.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[eh.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[eh.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[eh.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public final ek<?> a() {
        int i = AnonymousClass1.a[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ek.g;
            }
            if (i == 3) {
                return ek.l;
            }
            if (i == 4) {
                return ek.q;
            }
            throw new AssertionError();
        }
        return ek.j;
    }
}
