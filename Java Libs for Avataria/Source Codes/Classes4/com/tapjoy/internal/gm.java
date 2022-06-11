package com.tapjoy.internal;

import kotlinx.coroutines.scheduling.WorkQueueKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gm {
    public long a;
    public long b;
    public long c;

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gm.a(java.lang.String, int):boolean");
    }

    private static long a(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & WorkQueueKt.BUFFER_CAPACITY) == 128) {
            i2 = (i2 & WorkQueueKt.MASK) + WorkQueueKt.BUFFER_CAPACITY;
        }
        if ((i3 & WorkQueueKt.BUFFER_CAPACITY) == 128) {
            i3 = (i3 & WorkQueueKt.MASK) + WorkQueueKt.BUFFER_CAPACITY;
        }
        if ((i4 & WorkQueueKt.BUFFER_CAPACITY) == 128) {
            i4 = (i4 & WorkQueueKt.MASK) + WorkQueueKt.BUFFER_CAPACITY;
        }
        if ((i5 & WorkQueueKt.BUFFER_CAPACITY) == 128) {
            i5 = (i5 & WorkQueueKt.MASK) + WorkQueueKt.BUFFER_CAPACITY;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    private static long b(byte[] bArr, int i) {
        return ((a(bArr, i) - 2208988800L) * 1000) + ((a(bArr, i + 4) * 1000) / 4294967296L);
    }
}
