package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class ao<E> extends AbstractQueue<E> implements as<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Iterator<E>() { // from class: com.tapjoy.internal.ao.1
            private int b = 0;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.b < ao.this.size();
            }

            @Override // java.util.Iterator
            public final E next() {
                ao aoVar = ao.this;
                int i = this.b;
                this.b = i + 1;
                return aoVar.a(i);
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.b == 1) {
                    ao.this.b(1);
                    this.b = 0;
                    return;
                }
                throw new UnsupportedOperationException("For the first element only");
            }
        };
    }
}
