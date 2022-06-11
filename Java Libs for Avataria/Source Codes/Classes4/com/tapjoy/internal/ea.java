package com.tapjoy.internal;

import com.tapjoy.internal.dz;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ea implements dz.a {
    private final BlockingQueue<Runnable> a;
    private final ThreadPoolExecutor b;
    private final ArrayDeque<dz> c = new ArrayDeque<>();
    private dz d = null;

    public ea() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        dz poll = this.c.poll();
        this.d = poll;
        if (poll != null) {
            poll.a(this.b);
        }
    }

    @Override // com.tapjoy.internal.dz.a
    public final void a() {
        this.d = null;
        b();
    }

    public final void a(dz dzVar) {
        dzVar.d = this;
        this.c.add(dzVar);
        if (this.d == null) {
            b();
        }
    }
}
