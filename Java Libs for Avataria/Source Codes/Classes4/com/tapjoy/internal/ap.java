package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ap<E> extends ao<E> implements as<E>, Closeable, Flushable {
    private final as<E> a;
    private final LinkedList<E> b = new LinkedList<>();
    private final LinkedList<E> c = new LinkedList<>();
    private int d;
    private boolean e;

    public static <E> ap<E> a(as<E> asVar) {
        return new ap<>(asVar);
    }

    private ap(as<E> asVar) {
        this.a = asVar;
        int size = asVar.size();
        this.d = size;
        this.e = size == 0;
    }

    protected final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
            as<E> asVar = this.a;
            if (!(asVar instanceof Closeable)) {
                return;
            }
            ((Closeable) asVar).close();
        } catch (Throwable th) {
            if (this.a instanceof Closeable) {
                ((Closeable) this.a).close();
            }
            throw th;
        }
    }

    @Override // java.io.Flushable
    public final void flush() {
        if (!this.c.isEmpty()) {
            this.a.addAll(this.c);
            if (this.e) {
                this.b.addAll(this.c);
            }
            this.c.clear();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.d;
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        this.c.add(e);
        this.d++;
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        E e;
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            e = this.b.remove();
            this.a.b(1);
        } else if (this.e) {
            e = this.c.remove();
        } else {
            e = this.a.remove();
            if (this.d == this.c.size() + 1) {
                this.e = true;
            }
        }
        this.d--;
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            return this.b.element();
        }
        if (this.e) {
            return this.c.element();
        }
        E peek = this.a.peek();
        this.b.add(peek);
        if (this.d == this.b.size() + this.c.size()) {
            this.e = true;
        }
        return peek;
    }

    @Override // com.tapjoy.internal.as
    public final E a(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.b.size();
        if (i < size) {
            return this.b.get(i);
        }
        if (this.e) {
            return this.c.get(i - size);
        }
        if (i < this.a.size()) {
            E e = null;
            while (size <= i) {
                e = this.a.a(size);
                this.b.add(e);
                size++;
            }
            if (i + 1 + this.c.size() == this.d) {
                this.e = true;
            }
            return e;
        }
        return this.c.get(i - this.a.size());
    }

    @Override // com.tapjoy.internal.as
    public final void b(int i) {
        if (i <= 0 || i > this.d) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.b.size()) {
            ar.a(this.b, i);
            this.a.b(i);
        } else {
            this.b.clear();
            int size = (this.c.size() + i) - this.d;
            if (size < 0) {
                this.a.b(i);
            } else {
                this.a.clear();
                this.e = true;
                if (size > 0) {
                    ar.a(this.c, size);
                }
            }
        }
        this.d -= i;
    }
}
