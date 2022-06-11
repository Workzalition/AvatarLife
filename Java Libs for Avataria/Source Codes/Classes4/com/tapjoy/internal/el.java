package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class el {
    final iv a;
    public eh b;
    private int e;
    private long c = 0;
    private long d = LongCompanionObject.MAX_VALUE;
    private int f = 2;
    private int g = -1;
    private long h = -1;

    public el(iv ivVar) {
        this.a = ivVar;
    }

    public final long a() {
        if (this.f != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.e + 1;
        this.e = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.h;
        this.h = -1L;
        this.f = 6;
        return j;
    }

    public final void a(long j) {
        if (this.f != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i = this.e - 1;
        this.e = i;
        if (i < 0 || this.h != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.c != this.d && i != 0) {
            throw new IOException("Expected to end at " + this.d + " but was " + this.c);
        }
        this.d = j;
    }

    public final int b() {
        int i = this.f;
        if (i == 7) {
            this.f = 2;
            return this.g;
        } else if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        } else {
            while (this.c < this.d && !this.a.b()) {
                int h = h();
                if (h == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                int i2 = h >> 3;
                this.g = i2;
                int i3 = h & 7;
                if (i3 == 0) {
                    this.b = eh.VARINT;
                    this.f = 0;
                    return this.g;
                } else if (i3 == 1) {
                    this.b = eh.FIXED64;
                    this.f = 1;
                    return this.g;
                } else if (i3 == 2) {
                    this.b = eh.LENGTH_DELIMITED;
                    this.f = 2;
                    int h2 = h();
                    if (h2 < 0) {
                        throw new ProtocolException("Negative length: ".concat(String.valueOf(h2)));
                    }
                    if (this.h != -1) {
                        throw new IllegalStateException();
                    }
                    long j = this.d;
                    this.h = j;
                    long j2 = this.c + h2;
                    this.d = j2;
                    if (j2 > j) {
                        throw new EOFException();
                    }
                    return this.g;
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    if (i3 == 5) {
                        this.b = eh.FIXED32;
                        this.f = 5;
                        return this.g;
                    }
                    throw new ProtocolException("Unexpected field encoding: ".concat(String.valueOf(i3)));
                } else {
                    a(i2);
                }
            }
            return -1;
        }
    }

    private void a(int i) {
        while (this.c < this.d && !this.a.b()) {
            int h = h();
            if (h == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = h >> 3;
            int i3 = h & 7;
            if (i3 == 0) {
                this.f = 0;
                d();
            } else if (i3 == 1) {
                this.f = 1;
                f();
            } else if (i3 == 2) {
                long h2 = h();
                this.c += h2;
                this.a.d(h2);
            } else if (i3 == 3) {
                a(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 == 5) {
                this.f = 5;
                e();
            } else {
                throw new ProtocolException("Unexpected field encoding: ".concat(String.valueOf(i3)));
            }
        }
        throw new EOFException();
    }

    public final int c() {
        int i = this.f;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f);
        }
        int h = h();
        b(0);
        return h;
    }

    private int h() {
        int i;
        this.c++;
        byte d = this.a.d();
        if (d >= 0) {
            return d;
        }
        int i2 = d & ByteCompanionObject.MAX_VALUE;
        this.c++;
        byte d2 = this.a.d();
        if (d2 >= 0) {
            i = d2 << 7;
        } else {
            i2 |= (d2 & ByteCompanionObject.MAX_VALUE) << 7;
            this.c++;
            byte d3 = this.a.d();
            if (d3 >= 0) {
                i = d3 << 14;
            } else {
                i2 |= (d3 & ByteCompanionObject.MAX_VALUE) << 14;
                this.c++;
                byte d4 = this.a.d();
                if (d4 < 0) {
                    int i3 = i2 | ((d4 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.c++;
                    byte d5 = this.a.d();
                    int i4 = i3 | (d5 << 28);
                    if (d5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.c++;
                        if (this.a.d() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i = d4 << 21;
            }
        }
        return i2 | i;
    }

    public final long d() {
        byte d;
        int i = this.f;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.c++;
            j |= (d & ByteCompanionObject.MAX_VALUE) << i2;
            if ((this.a.d() & ByteCompanionObject.MIN_VALUE) == 0) {
                b(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final int e() {
        int i = this.f;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f);
        }
        this.a.a(4L);
        this.c += 4;
        int f = this.a.f();
        b(5);
        return f;
    }

    public final long f() {
        int i = this.f;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f);
        }
        this.a.a(8L);
        this.c += 8;
        long g = this.a.g();
        b(1);
        return g;
    }

    private void b(int i) {
        if (this.f == i) {
            this.f = 6;
            return;
        }
        long j = this.c;
        long j2 = this.d;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.d + " but was " + this.c);
        } else if (j == j2) {
            this.d = this.h;
            this.h = -1L;
            this.f = 6;
        } else {
            this.f = 7;
        }
    }

    public final long g() {
        if (this.f != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f);
        }
        long j = this.d - this.c;
        this.a.a(j);
        this.f = 6;
        this.c = this.d;
        this.d = this.h;
        this.h = -1L;
        return j;
    }
}
