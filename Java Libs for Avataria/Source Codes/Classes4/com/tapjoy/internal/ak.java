package com.tapjoy.internal;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ak {

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a<K, V> implements an<K, V> {
        private final al<K, V> a;

        public a(al<K, V> alVar) {
            this.a = alVar;
        }

        @Override // com.tapjoy.internal.ai
        public final V a(K k) {
            aj a;
            V v;
            synchronized (this.a) {
                a = this.a.a(k, false);
            }
            if (a != null) {
                synchronized (a) {
                    v = (V) a.a();
                }
                return v;
            }
            return null;
        }

        @Override // com.tapjoy.internal.ai
        public final void a(K k, V v) {
            aj a;
            synchronized (this.a) {
                a = this.a.a(k, true);
            }
            synchronized (a) {
                a.a(v);
            }
        }
    }
}
