package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class gd {
    private final ReentrantLock a;
    b c;
    a e;
    private final Condition f;
    private a h;
    volatile int b = c.a;
    private final LinkedList<TJConnectListener> g = new LinkedList<>();
    long d = 1000;

    protected abstract boolean a(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener);

    public gd() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.f = reentrantLock.newCondition();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class c extends Enum<c> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(Context context, String str, Hashtable<String, ?> hashtable, TJConnectListener tJConnectListener) {
        this.a.lock();
        if (tJConnectListener != null) {
            try {
                this.g.addLast(fo.a(tJConnectListener, TJConnectListener.class));
            } finally {
                this.a.unlock();
            }
        }
        a aVar = new a(context, str, hashtable);
        int i = AnonymousClass3.a[this.b - 1];
        if (i == 1) {
            a(true);
        } else if (i == 2) {
            this.e = aVar;
            ft.b.addObserver(new Observer() { // from class: com.tapjoy.internal.gd.1
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    ft.b.deleteObserver(this);
                    if (Boolean.TRUE.equals(obj) || gd.this.e == null || gd.this.e.a == null) {
                        return;
                    }
                    gd.this.c = new b(gd.this, (byte) 0);
                    gd.this.c.e();
                }
            });
            if (a(aVar.a, aVar.b, aVar.c, new TJConnectListener() { // from class: com.tapjoy.internal.gd.2
                public final void onConnectSuccess() {
                    gd gdVar = gd.this;
                    int i2 = c.e;
                    int i3 = c.b;
                    gdVar.a(i2);
                    gd.this.a(true);
                }

                public final void onConnectFailure() {
                    gd.this.a(false);
                }
            })) {
                int i2 = c.b;
                int i3 = c.a;
                a(i2);
            } else {
                this.g.clear();
                return false;
            }
        } else if (i == 3 || i == 4) {
            this.h = aVar;
        } else if (i == 5) {
            this.h = aVar;
            b();
        } else {
            a(c.a);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.gd$3 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.a().length];
            a = iArr;
            try {
                iArr[c.e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.a - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.b - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.c - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.d - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    final void a(int i) {
        this.a.lock();
        try {
            this.b = i;
        } finally {
            this.a.unlock();
        }
    }

    final a a() {
        this.a.lock();
        try {
            a aVar = this.h;
            if (aVar != null) {
                this.e = aVar;
                this.h = null;
            }
            return this.e;
        } finally {
            this.a.unlock();
        }
    }

    public final void a(boolean z) {
        this.a.lock();
        try {
            if (this.g.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.g);
            this.g.clear();
            this.a.unlock();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TJConnectListener tJConnectListener = (TJConnectListener) it.next();
                if (z) {
                    tJConnectListener.onConnectSuccess();
                } else {
                    tJConnectListener.onConnectFailure();
                }
            }
        } finally {
            this.a.unlock();
        }
    }

    final void b() {
        this.a.lock();
        try {
            this.d = 1000L;
            this.f.signal();
        } finally {
            this.a.unlock();
        }
    }

    final boolean a(long j) {
        this.a.lock();
        try {
            int i = c.d;
            int i2 = c.c;
            a(i);
            if (this.f.await(j, TimeUnit.MILLISECONDS)) {
                this.d = 1000L;
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            int i3 = c.c;
            int i4 = c.d;
            a(i3);
            this.a.unlock();
            throw th;
        }
        int i5 = c.c;
        int i6 = c.d;
        a(i5);
        this.a.unlock();
        return false;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class a {
        public final Context a;
        public final String b;
        public final Hashtable<String, ?> c;

        public a(Context context, String str, Hashtable<String, ?> hashtable) {
            Context context2;
            gd.this = r1;
            if (context != null) {
                context2 = context instanceof Application ? context : context.getApplicationContext();
            } else {
                context2 = null;
            }
            this.a = context2 != null ? context2 : context;
            this.b = str;
            this.c = hashtable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class b extends kc {
        private boolean b;
        private boolean c;
        private Context d;
        private BroadcastReceiver e;

        private b() {
            gd.this = r1;
            this.e = new BroadcastReceiver() { // from class: com.tapjoy.internal.gd.b.2
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    gd.this.b();
                }
            };
        }

        /* synthetic */ b(gd gdVar, byte b) {
            this();
        }

        @Override // com.tapjoy.internal.kc
        public final void a() {
            this.b = true;
            gd.this.b();
        }

        @Override // com.tapjoy.internal.kc
        public final void b() {
            gd gdVar = gd.this;
            int i = c.c;
            int i2 = c.b;
            gdVar.a(i);
        }

        @Override // com.tapjoy.internal.kc
        public final void c() {
            if (gd.this.c == this) {
                gd.this.c = null;
            }
            if (gd.this.b == c.c) {
                gd gdVar = gd.this;
                int i = c.a;
                int i2 = c.c;
                gdVar.a(i);
            }
        }

        @Override // com.tapjoy.internal.kc
        public final void d() {
            this.d = gd.this.a().a;
            this.d.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            while (!this.b) {
                try {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    ft.b.addObserver(new Observer() { // from class: com.tapjoy.internal.gd.b.1
                        @Override // java.util.Observer
                        public final void update(Observable observable, Object obj) {
                            ft.b.deleteObserver(this);
                            b.this.c = Boolean.TRUE.equals(obj);
                            countDownLatch.countDown();
                        }
                    });
                    a a = gd.this.a();
                    if (!gd.this.a(a.a, a.b, a.c, null)) {
                        gd.this.a(false);
                        return;
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException unused) {
                    }
                    if (!this.c) {
                        gd.this.a(false);
                        long max = Math.max(gd.this.d, 1000L);
                        gd.this.d = Math.min(max << 2, 3600000L);
                        gd.this.a(max);
                    } else {
                        gd gdVar = gd.this;
                        int i = c.e;
                        int i2 = c.c;
                        gdVar.a(i);
                        gd.this.a(true);
                        return;
                    }
                } finally {
                    h();
                }
            }
        }

        private void h() {
            this.d.unregisterReceiver(this.e);
        }
    }
}
