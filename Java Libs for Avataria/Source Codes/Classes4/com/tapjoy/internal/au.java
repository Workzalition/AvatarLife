package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class au<K, V> extends AbstractMap<K, V> {
    private final HashMap<K, br<K, V>> a = new HashMap<>();
    private final bs<K, V> b = new bs<>();

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        b();
        return this.a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.clear();
        do {
        } while (this.b.a() != null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        b();
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        b();
        for (br<K, V> brVar : this.a.values()) {
            if (obj.equals(brVar.get())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        b();
        return (V) a(this.a.get(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        b();
        return (V) a(this.a.put(k, new br<>(k, v, this.b)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        return (V) a(this.a.remove(obj));
    }

    private static V a(br<K, V> brVar) {
        if (brVar != null) {
            return (V) brVar.get();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        b();
        return this.a.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        b();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        b();
        throw new UnsupportedOperationException();
    }

    private void b() {
        while (true) {
            br<K, V> a = this.b.a();
            if (a != null) {
                this.a.remove(a.a);
            } else {
                return;
            }
        }
    }

    public static <K, V> au<K, V> a() {
        return new au<>();
    }
}
