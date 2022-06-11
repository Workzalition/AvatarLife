package com.tapjoy.internal;

import java.io.File;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class gz implements Runnable {
    final hn a;
    by b;
    private final Object c;
    private final Thread d;
    private boolean e;

    public gz(File file) {
        hn hnVar = new hn(file);
        this.a = hnVar;
        this.c = hnVar;
        Integer.valueOf(hnVar.a());
        Thread thread = new Thread(this, "5Rocks");
        this.d = thread;
        thread.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0090 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gz.run():void");
    }

    private void a(long j) {
        if (j > 0) {
            synchronized (this.c) {
                this.e = false;
                Long.valueOf(j);
                this.c.wait(j);
            }
            return;
        }
        synchronized (this.c) {
            this.e = false;
            if (this.b == null || this.a.b()) {
                this.c.wait();
            }
        }
    }

    final void a(boolean z) {
        synchronized (this.c) {
            this.e = z;
            this.c.notify();
        }
    }

    public final void a() {
        if (this.b == null || this.a.b()) {
            return;
        }
        a(true);
    }
}
