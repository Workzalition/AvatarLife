package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ah<K, V> implements aj<V> {
    public final K a;
    protected V b = null;

    public ah(K k) {
        this.a = k;
    }

    @Override // com.tapjoy.internal.aj
    public final V a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.aj
    public final void a(V v) {
        this.b = v;
    }
}
