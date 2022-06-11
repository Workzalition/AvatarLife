package com.tapjoy.internal;

import java.lang.ref.WeakReference;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bt<T> {
    public WeakReference<T> a;

    public final T a() {
        WeakReference<T> weakReference = this.a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(T t) {
        this.a = new WeakReference<>(t);
    }
}
