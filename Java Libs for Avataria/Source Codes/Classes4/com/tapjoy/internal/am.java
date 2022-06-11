package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class am<K, V> extends al<K, V> {
    private final LinkedHashMap<K, ah<K, V>> a = new LinkedHashMap<>(0, 0.75f, true);
    private int b = 10;

    private void a() {
        int size = this.a.size() - this.b;
        if (size > 0) {
            Iterator<Map.Entry<K, ah<K, V>>> it = this.a.entrySet().iterator();
            while (size > 0 && it.hasNext()) {
                size--;
                it.next();
                it.remove();
            }
        }
    }

    public final void a(K k, V v) {
        am.super.a(k, v);
        a();
    }

    protected final aj<V> a(K k, boolean z) {
        ah<K, V> ahVar = this.a.get(k);
        if (ahVar != null || !z) {
            return ahVar;
        }
        ah<K, V> ahVar2 = new ah<>(k);
        this.a.put(k, ahVar2);
        a();
        return ahVar2;
    }
}
