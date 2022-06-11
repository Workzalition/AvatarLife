package com.tapjoy.internal;

import android.os.SystemClock;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fj {
    public static final fj a = new fj(-1);
    public final long b;
    public long c;

    public fj(long j) {
        this.b = j;
        this.c = SystemClock.elapsedRealtime();
    }

    public fj() {
        this.b = 3600000L;
        try {
            this.c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.c = -1L;
        }
    }

    public final boolean a() {
        try {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    public final boolean a(long j) {
        try {
            return (SystemClock.elapsedRealtime() - this.c) + j > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }
}
