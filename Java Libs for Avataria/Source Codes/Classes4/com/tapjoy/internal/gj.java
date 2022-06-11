package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gj extends gi {
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public gj(File file, ha haVar) {
        super(file, haVar);
    }

    protected final void finalize() {
        try {
            this.b.shutdown();
            this.b.awaitTermination(1L, TimeUnit.SECONDS);
        } finally {
            gj.super.finalize();
        }
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class a implements Runnable {
        private int b;
        private long c;
        private String d;
        private String e;
        private Map<String, Long> f;

        a(int i, long j, String str, String str2, Map<String, Long> map) {
            gj.this = r1;
            this.b = i;
            this.c = j;
            this.d = str;
            this.e = str2;
            this.f = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                int i = this.b;
                if (i == 1) {
                    gj.super.a(this.c);
                } else if (i == 2) {
                    gj.super.a();
                } else if (i != 3) {
                } else {
                    gj.super.a(this.c, this.d, this.e, this.f);
                }
            } catch (Throwable unused) {
                gj.super.a();
            }
        }
    }

    protected final void a(long j) {
        try {
            this.b.execute(new a(1, j, null, null, null));
        } catch (Throwable unused) {
        }
    }

    protected final void a() {
        try {
            this.b.execute(new a(2, 0L, null, null, null));
        } catch (Throwable unused) {
        }
    }

    protected final void a(long j, String str, String str2, Map<String, Long> map) {
        try {
            this.b.execute(new a(3, j, str, str2, map != null ? new HashMap(map) : null));
        } catch (Throwable unused) {
        }
    }
}
