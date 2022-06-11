package com.tapjoy.internal;

import com.vungle.warren.model.AdvertisementDBAdapter;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fx {
    public fr a;
    public volatile gh$a b;
    public int c;
    public volatile gh$a d;
    public volatile gh$a e;

    public final void a() {
        fr frVar = this.a;
        if (frVar != null) {
            frVar.c();
        }
    }

    public final void b() {
        a(16);
        gh$a gh_a = this.d;
        if (gh_a != null) {
            this.d = null;
            gh_a.b().c();
        }
    }

    public final synchronized void a(int i) {
        int i2;
        gh$a gh_a = this.b;
        if (gh_a != null && (i2 = this.c) < i) {
            int i3 = i | i2;
            this.c = i3;
            gh_a.a(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, Integer.valueOf(i3)).b().c();
        }
    }
}
