package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.hm;
import java.util.Observer;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fy extends hm {
    private final gb<hm.a> b = new gb<hm.a>() { // from class: com.tapjoy.internal.fy.1
        @Override // com.tapjoy.internal.gb
        public final boolean a() {
            return true;
        }

        @Override // com.tapjoy.internal.gb
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, hm.a aVar) {
            hm.a aVar2 = aVar;
            TJPlacement createPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), aVar2.b, false, tJPlacementListener);
            createPlacement.pushId = aVar2.a;
            return createPlacement;
        }

        @Override // com.tapjoy.internal.gb
        protected final /* bridge */ /* synthetic */ String a(hm.a aVar) {
            hm.a aVar2 = aVar;
            if (aVar2 != null) {
                return aVar2.b;
            }
            return null;
        }

        @Override // com.tapjoy.internal.gb
        protected final /* synthetic */ gb<hm.a>.a b(hm.a aVar) {
            hm.a aVar2 = aVar;
            return new gb.a(aVar2, aVar2.d);
        }

        @Override // com.tapjoy.internal.gb
        public final boolean a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.a(observer);
        }
    };

    public static void a() {
    }

    static {
        hm.a(new fy());
    }

    private fy() {
    }

    @Override // com.tapjoy.internal.hm
    public final boolean b() {
        return this.b.b != null;
    }

    @Override // com.tapjoy.internal.hm
    public final void a(hm.a aVar) {
        this.b.c(aVar);
    }
}
