package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class hc implements gq {
    private static final hc a = new hc() { // from class: com.tapjoy.internal.hc.1
        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void a(String str) {
        }

        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void a(String str, gn gnVar) {
        }

        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void a(String str, String str2, gn gnVar) {
        }

        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void b(String str) {
        }

        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void c(String str) {
        }

        @Override // com.tapjoy.internal.hc, com.tapjoy.internal.gq
        public final void d(String str) {
        }
    };
    private final gq b;
    private final av c;

    /* synthetic */ hc(byte b) {
        this();
    }

    public static hc a(gq gqVar) {
        if (gqVar != null) {
            return new hc(gqVar);
        }
        return a;
    }

    private hc() {
        this.b = null;
        this.c = null;
    }

    private hc(gq gqVar) {
        Handler handler;
        this.b = gqVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            jr.a(myLooper);
            handler = myLooper == Looper.getMainLooper() ? t.a() : new Handler(myLooper);
        } else {
            handler = null;
        }
        if (handler != null) {
            this.c = t.a(handler);
            handler.getLooper();
        } else if (Thread.currentThread() == gt.b()) {
            this.c = gt.a;
        } else {
            this.c = t.a(t.a());
        }
    }

    @Override // com.tapjoy.internal.gq
    public void a(final String str) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.2
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.a(str);
            }
        });
    }

    @Override // com.tapjoy.internal.gq
    public void b(final String str) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.3
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.b(str);
            }
        });
    }

    @Override // com.tapjoy.internal.gq
    public void c(final String str) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.4
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.c(str);
            }
        });
    }

    @Override // com.tapjoy.internal.gq
    public void d(final String str) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.5
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.d(str);
            }
        });
    }

    @Override // com.tapjoy.internal.gq
    public void a(final String str, final gn gnVar) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.6
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.a(str, gnVar);
            }
        });
    }

    @Override // com.tapjoy.internal.gq
    public void a(final String str, final String str2, final gn gnVar) {
        this.c.a(new Runnable() { // from class: com.tapjoy.internal.hc.7
            @Override // java.lang.Runnable
            public final void run() {
                hc.this.b.a(str, str2, gnVar);
            }
        });
    }
}
