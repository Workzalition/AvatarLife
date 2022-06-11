package com.tapjoy.internal;

import java.util.Observable;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ft {
    public static final a a = new a();
    public static final a b = new a();
    public static final a c = new a();
    public static final a d = new a();
    public static final a e = new a();

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static class a extends Observable {
        @Override // java.util.Observable
        public final void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        @Override // java.util.Observable
        public final void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }
}
