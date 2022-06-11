package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class gb<R> {
    volatile gb<R>.a b;

    protected abstract TJPlacement a(Context context, TJPlacementListener tJPlacementListener, R r);

    protected abstract String a(R r);

    public final boolean c(R r) {
        if (!a()) {
            return false;
        }
        gb<R>.a aVar = null;
        synchronized (this) {
            if (this.b == null) {
                aVar = b(r);
                this.b = aVar;
            }
        }
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    protected gb<R>.a b(R r) {
        return new a(this, r);
    }

    public boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    public boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            ft.e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            ft.e.deleteObserver(observer);
        }
        if (!hb.a().e()) {
            ft.c.addObserver(observer);
            if (!hb.a().e()) {
                return false;
            }
            ft.c.deleteObserver(observer);
            return true;
        }
        return true;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class a implements TJPlacementListener, Observer {
        private final R b;
        private final fj c;
        private volatile boolean d;
        private TJPlacement e;

        public final void onClick(TJPlacement tJPlacement) {
        }

        public final void onContentDismiss(TJPlacement tJPlacement) {
        }

        public final void onContentShow(TJPlacement tJPlacement) {
        }

        public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        }

        public final void onRequestSuccess(TJPlacement tJPlacement) {
        }

        public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
        }

        a(gb gbVar, R r) {
            this(r, new fj(10000L));
        }

        public a(R r, fj fjVar) {
            gb.this = r1;
            this.b = r;
            this.c = fjVar;
        }

        final void a() {
            synchronized (this) {
                if (this.d) {
                    return;
                }
                if (this.c.a()) {
                    a("Timed out");
                    return;
                }
                if (!TapjoyConnectCore.isConnected()) {
                    ft.a.addObserver(this);
                    if (!TapjoyConnectCore.isConnected()) {
                        return;
                    }
                    ft.a.deleteObserver(this);
                }
                TJPlacement tJPlacement = this.e;
                if (tJPlacement == null) {
                    if (!gb.this.a()) {
                        a("Cannot request");
                        return;
                    }
                    TJPlacement a = gb.this.a(TapjoyConnectCore.getContext(), this, this.b);
                    this.e = a;
                    a.requestContent();
                } else if (!tJPlacement.isContentReady()) {
                } else {
                    if (!gb.this.a((Observer) this)) {
                        return;
                    }
                    this.e.showContent();
                    a(null);
                }
            }
        }

        private void a(String str) {
            synchronized (this) {
                String a = gb.this.a((gb) this.b);
                if (str == null) {
                    TapjoyLog.i("SystemPlacement", "Placement " + a + " is presented now");
                } else {
                    TapjoyLog.i("SystemPlacement", "Cannot show placement " + a + " now (" + str + ")");
                }
                this.d = true;
                this.e = null;
                ft.a.deleteObserver(this);
                ft.e.deleteObserver(this);
                ft.c.deleteObserver(this);
            }
            gb.a(gb.this, this);
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            a();
        }

        public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            a(tJError.message);
        }

        public final void onContentReady(TJPlacement tJPlacement) {
            a();
        }
    }

    static /* synthetic */ void a(gb gbVar, a aVar) {
        synchronized (gbVar) {
            if (gbVar.b == aVar) {
                gbVar.b = null;
            }
        }
    }
}
