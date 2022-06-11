package com.tapjoy.internal;

import cz.msebera.android.httpclient.message.TokenParser;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bj extends bi {
    public static final bi$a a = new bi$a() { // from class: com.tapjoy.internal.bj.1
        @Override // com.tapjoy.internal.bi$a
        public final bi a(Reader reader) {
            return new bj(reader);
        }

        @Override // com.tapjoy.internal.bi$a
        public final bi a(String str) {
            return new bj(new StringReader(str));
        }
    };
    private final Reader c;
    private bn k;
    private String l;
    private String m;
    private int n;
    private int o;
    private final ce b = new ce();
    private boolean d = false;
    private final char[] e = new char[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private final List<bl> j = new ArrayList();
    private boolean p = false;

    public bj(Reader reader) {
        a(bl.EMPTY_DOCUMENT);
        Objects.requireNonNull(reader, "in == null");
        this.c = reader;
    }

    public final void f() {
        a(bn.BEGIN_ARRAY);
    }

    public final void g() {
        a(bn.END_ARRAY);
    }

    public final void h() {
        a(bn.BEGIN_OBJECT);
    }

    public final void i() {
        a(bn.END_OBJECT);
    }

    private void a(bn bnVar) {
        k();
        if (this.k != bnVar) {
            throw new IllegalStateException("Expected " + bnVar + " but was " + k());
        }
        t();
    }

    public final boolean j() {
        k();
        return (this.k == bn.END_OBJECT || this.k == bn.END_ARRAY) ? false : true;
    }

    public final bn k() {
        bn bnVar = this.k;
        if (bnVar != null) {
            return bnVar;
        }
        int[] iArr = AnonymousClass2.a;
        List<bl> list = this.j;
        switch (iArr[list.get(list.size() - 1).ordinal()]) {
            case 1:
                b(bl.NONEMPTY_DOCUMENT);
                bn v = v();
                if (this.d || this.k == bn.BEGIN_ARRAY || this.k == bn.BEGIN_OBJECT) {
                    return v;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.k);
            case 2:
                return a(true);
            case 3:
                return a(false);
            case 4:
                return b(true);
            case 5:
                int y = y();
                if (y != 58) {
                    if (y == 61) {
                        z();
                        if (this.f < this.g || a(1)) {
                            char[] cArr = this.e;
                            int i = this.f;
                            if (cArr[i] == '>') {
                                this.f = i + 1;
                            }
                        }
                    } else {
                        throw e("Expected ':'");
                    }
                }
                b(bl.NONEMPTY_OBJECT);
                return v();
            case 6:
                return b(false);
            case 7:
                try {
                    bn v2 = v();
                    if (this.d) {
                        return v2;
                    }
                    throw e("Expected EOF");
                } catch (EOFException unused) {
                    bn bnVar2 = bn.END_DOCUMENT;
                    this.k = bnVar2;
                    return bnVar2;
                }
            case 8:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: com.tapjoy.internal.bj$2 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bl.values().length];
            a = iArr;
            try {
                iArr[bl.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bl.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bl.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[bl.EMPTY_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[bl.DANGLING_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[bl.NONEMPTY_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[bl.NONEMPTY_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[bl.CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private bn t() {
        k();
        bn bnVar = this.k;
        this.k = null;
        this.m = null;
        this.l = null;
        return bnVar;
    }

    public final String l() {
        k();
        if (this.k != bn.NAME) {
            throw new IllegalStateException("Expected a name but was " + k());
        }
        String str = this.l;
        t();
        return str;
    }

    public final String m() {
        k();
        if (this.k != bn.STRING && this.k != bn.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + k());
        }
        String str = this.m;
        t();
        return str;
    }

    public final boolean n() {
        k();
        if (this.k != bn.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.k);
        }
        boolean z = this.m == "true";
        t();
        return z;
    }

    public final void o() {
        k();
        if (this.k != bn.NULL) {
            throw new IllegalStateException("Expected null but was " + this.k);
        }
        t();
    }

    public final double p() {
        k();
        if (this.k != bn.STRING && this.k != bn.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + this.k);
        }
        double parseDouble = Double.parseDouble(this.m);
        t();
        return parseDouble;
    }

    public final long q() {
        long j;
        k();
        if (this.k != bn.STRING && this.k != bn.NUMBER) {
            throw new IllegalStateException("Expected a long but was " + this.k);
        }
        try {
            j = Long.parseLong(this.m);
        } catch (NumberFormatException unused) {
            double parseDouble = Double.parseDouble(this.m);
            long j2 = (long) parseDouble;
            if (j2 != parseDouble) {
                throw new NumberFormatException(this.m);
            }
            j = j2;
        }
        t();
        return j;
    }

    public final int r() {
        int i;
        k();
        if (this.k != bn.STRING && this.k != bn.NUMBER) {
            throw new IllegalStateException("Expected an int but was " + this.k);
        }
        try {
            i = Integer.parseInt(this.m);
        } catch (NumberFormatException unused) {
            double parseDouble = Double.parseDouble(this.m);
            int i2 = (int) parseDouble;
            if (i2 != parseDouble) {
                throw new NumberFormatException(this.m);
            }
            i = i2;
        }
        t();
        return i;
    }

    public final void close() {
        this.m = null;
        this.k = null;
        this.j.clear();
        this.j.add(bl.CLOSED);
        this.c.close();
    }

    public final void s() {
        k();
        if (this.k == bn.END_ARRAY || this.k == bn.END_OBJECT) {
            throw new IllegalStateException("Expected a value but was " + this.k);
        }
        this.p = true;
        int i = 0;
        do {
            try {
                bn t = t();
                if (t != bn.BEGIN_ARRAY && t != bn.BEGIN_OBJECT) {
                    if (t == bn.END_ARRAY || t == bn.END_OBJECT) {
                        i--;
                        continue;
                    }
                }
                i++;
            } finally {
                this.p = false;
            }
        } while (i != 0);
    }

    private bl u() {
        List<bl> list = this.j;
        return list.remove(list.size() - 1);
    }

    private void a(bl blVar) {
        this.j.add(blVar);
    }

    private void b(bl blVar) {
        List<bl> list = this.j;
        list.set(list.size() - 1, blVar);
    }

    private bn a(boolean z) {
        if (z) {
            b(bl.NONEMPTY_ARRAY);
        } else {
            int y = y();
            if (y != 44) {
                if (y != 59) {
                    if (y == 93) {
                        u();
                        bn bnVar = bn.END_ARRAY;
                        this.k = bnVar;
                        return bnVar;
                    }
                    throw e("Unterminated array");
                }
                z();
            }
        }
        int y2 = y();
        if (y2 != 44 && y2 != 59) {
            if (y2 != 93) {
                this.f--;
                return v();
            } else if (z) {
                u();
                bn bnVar2 = bn.END_ARRAY;
                this.k = bnVar2;
                return bnVar2;
            }
        }
        z();
        this.f--;
        this.m = "null";
        bn bnVar3 = bn.NULL;
        this.k = bnVar3;
        return bnVar3;
    }

    private bn b(boolean z) {
        if (z) {
            if (y() == 125) {
                u();
                bn bnVar = bn.END_OBJECT;
                this.k = bnVar;
                return bnVar;
            }
            this.f--;
        } else {
            int y = y();
            if (y != 44 && y != 59) {
                if (y == 125) {
                    u();
                    bn bnVar2 = bn.END_OBJECT;
                    this.k = bnVar2;
                    return bnVar2;
                }
                throw e("Unterminated object");
            }
        }
        int y2 = y();
        if (y2 != 34) {
            if (y2 == 39) {
                z();
            } else {
                z();
                this.f--;
                String c = c(false);
                this.l = c;
                if (c.length() == 0) {
                    throw e("Expected name");
                }
                b(bl.DANGLING_NAME);
                bn bnVar3 = bn.NAME;
                this.k = bnVar3;
                return bnVar3;
            }
        }
        this.l = a((char) y2);
        b(bl.DANGLING_NAME);
        bn bnVar32 = bn.NAME;
        this.k = bnVar32;
        return bnVar32;
    }

    private bn v() {
        int y = y();
        if (y != 34) {
            if (y != 39) {
                if (y == 91) {
                    a(bl.EMPTY_ARRAY);
                    bn bnVar = bn.BEGIN_ARRAY;
                    this.k = bnVar;
                    return bnVar;
                } else if (y == 123) {
                    a(bl.EMPTY_OBJECT);
                    bn bnVar2 = bn.BEGIN_OBJECT;
                    this.k = bnVar2;
                    return bnVar2;
                } else {
                    this.f--;
                    return C();
                }
            }
            z();
        }
        this.m = a((char) y);
        bn bnVar3 = bn.STRING;
        this.k = bnVar3;
        return bnVar3;
    }

    private boolean a(int i) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            i2 = this.f;
            if (i5 >= i2) {
                break;
            }
            if (this.e[i5] == '\n') {
                this.h++;
                this.i = 1;
            } else {
                this.i++;
            }
            i5++;
        }
        int i6 = this.g;
        if (i6 != i2) {
            int i7 = i6 - i2;
            this.g = i7;
            char[] cArr = this.e;
            System.arraycopy(cArr, i2, cArr, 0, i7);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            char[] cArr2 = this.e;
            int i8 = this.g;
            int read = reader.read(cArr2, i8, cArr2.length - i8);
            if (read == -1) {
                return false;
            }
            i3 = this.g + read;
            this.g = i3;
            if (this.h == 1 && (i4 = this.i) == 1 && i3 > 0 && this.e[0] == 65279) {
                this.f++;
                this.i = i4 - 1;
                continue;
            }
        } while (i3 < i);
        return true;
    }

    private int w() {
        int i = this.h;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (this.e[i2] == '\n') {
                i++;
            }
        }
        return i;
    }

    private int x() {
        int i = this.i;
        for (int i2 = 0; i2 < this.f; i2++) {
            i = this.e[i2] == '\n' ? 1 : i + 1;
        }
        return i;
    }

    private int y() {
        while (true) {
            if (this.f < this.g || a(1)) {
                char[] cArr = this.e;
                int i = this.f;
                int i2 = i + 1;
                this.f = i2;
                char c = cArr[i];
                if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                    if (c == '#') {
                        z();
                        A();
                    } else if (c != '/') {
                        return c;
                    } else {
                        if (i2 == this.g && !a(1)) {
                            return c;
                        }
                        z();
                        char[] cArr2 = this.e;
                        int i3 = this.f;
                        char c2 = cArr2[i3];
                        if (c2 == '*') {
                            this.f = i3 + 1;
                            if (!d("*/")) {
                                throw e("Unterminated comment");
                            }
                            this.f += 2;
                        } else if (c2 != '/') {
                            return c;
                        } else {
                            this.f = i3 + 1;
                            A();
                        }
                    }
                }
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    private void z() {
        if (this.d) {
            return;
        }
        throw e("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void A() {
        char c;
        do {
            if (this.f >= this.g && !a(1)) {
                return;
            }
            char[] cArr = this.e;
            int i = this.f;
            this.f = i + 1;
            c = cArr[i];
            if (c == '\r') {
                return;
            }
        } while (c != '\n');
    }

    private boolean d(String str) {
        while (true) {
            if (this.f + str.length() > this.g && !a(str.length())) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if (this.e[this.f + i] == str.charAt(i)) {
                }
            }
            return true;
            this.f++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
        r0.append(r6.e, r1, r6.f - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(char r7) {
        /*
            r6 = this;
            r0 = 0
        L1:
            int r1 = r6.f
        L3:
            int r2 = r6.f
            int r3 = r6.g
            r4 = 1
            if (r2 >= r3) goto L4e
            char[] r3 = r6.e
            int r5 = r2 + 1
            r6.f = r5
            char r2 = r3[r2]
            if (r2 != r7) goto L30
            boolean r7 = r6.p
            if (r7 == 0) goto L1b
            java.lang.String r7 = "skipped!"
            return r7
        L1b:
            if (r0 != 0) goto L26
            com.tapjoy.internal.ce r7 = r6.b
            int r5 = r5 - r1
            int r5 = r5 - r4
            java.lang.String r7 = r7.a(r3, r1, r5)
            return r7
        L26:
            int r5 = r5 - r1
            int r5 = r5 - r4
            r0.append(r3, r1, r5)
            java.lang.String r7 = r0.toString()
            return r7
        L30:
            r3 = 92
            if (r2 != r3) goto L3
            if (r0 != 0) goto L3b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L3b:
            char[] r2 = r6.e
            int r3 = r6.f
            int r3 = r3 - r1
            int r3 = r3 - r4
            r0.append(r2, r1, r3)
            char r1 = r6.B()
            r0.append(r1)
            int r1 = r6.f
            goto L3
        L4e:
            if (r0 != 0) goto L55
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L55:
            char[] r2 = r6.e
            int r3 = r6.f
            int r3 = r3 - r1
            r0.append(r2, r1, r3)
            boolean r1 = r6.a(r4)
            if (r1 == 0) goto L64
            goto L1
        L64:
            java.lang.String r7 = "Unterminated string"
            java.io.IOException r7 = r6.e(r7)
            goto L6c
        L6b:
            throw r7
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bj.a(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
        z();
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(boolean r8) {
        /*
            r7 = this;
            r0 = -1
            r7.n = r0
            r0 = 0
            r7.o = r0
            r1 = 0
            r3 = r1
        L8:
            r2 = 0
        L9:
            int r4 = r7.f
            int r5 = r4 + r2
            int r6 = r7.g
            if (r5 >= r6) goto L54
            char[] r5 = r7.e
            int r4 = r4 + r2
            char r4 = r5[r4]
            r5 = 9
            if (r4 == r5) goto L67
            r5 = 10
            if (r4 == r5) goto L67
            r5 = 12
            if (r4 == r5) goto L67
            r5 = 13
            if (r4 == r5) goto L67
            r5 = 32
            if (r4 == r5) goto L67
            r5 = 35
            if (r4 == r5) goto L50
            r5 = 44
            if (r4 == r5) goto L67
            r5 = 47
            if (r4 == r5) goto L50
            r5 = 61
            if (r4 == r5) goto L50
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L67
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L67
            r5 = 58
            if (r4 == r5) goto L67
            r5 = 59
            if (r4 == r5) goto L50
            switch(r4) {
                case 91: goto L67;
                case 92: goto L50;
                case 93: goto L67;
                default: goto L4d;
            }
        L4d:
            int r2 = r2 + 1
            goto L9
        L50:
            r7.z()
            goto L67
        L54:
            char[] r4 = r7.e
            int r4 = r4.length
            if (r2 >= r4) goto L69
            int r4 = r2 + 1
            boolean r4 = r7.a(r4)
            if (r4 != 0) goto L9
            char[] r4 = r7.e
            int r5 = r7.g
            r4[r5] = r0
        L67:
            r0 = r2
            goto L88
        L69:
            if (r3 != 0) goto L70
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L70:
            char[] r4 = r7.e
            int r5 = r7.f
            r3.append(r4, r5, r2)
            int r4 = r7.o
            int r4 = r4 + r2
            r7.o = r4
            int r4 = r7.f
            int r4 = r4 + r2
            r7.f = r4
            r2 = 1
            boolean r2 = r7.a(r2)
            if (r2 != 0) goto L8
        L88:
            if (r8 == 0) goto L91
            if (r3 != 0) goto L91
            int r8 = r7.f
            r7.n = r8
            goto Lb0
        L91:
            boolean r8 = r7.p
            if (r8 == 0) goto L98
            java.lang.String r1 = "skipped!"
            goto Lb0
        L98:
            if (r3 != 0) goto La5
            com.tapjoy.internal.ce r8 = r7.b
            char[] r1 = r7.e
            int r2 = r7.f
            java.lang.String r1 = r8.a(r1, r2, r0)
            goto Lb0
        La5:
            char[] r8 = r7.e
            int r1 = r7.f
            r3.append(r8, r1, r0)
            java.lang.String r1 = r3.toString()
        Lb0:
            int r8 = r7.o
            int r8 = r8 + r0
            r7.o = r8
            int r8 = r7.f
            int r8 = r8 + r0
            r7.f = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bj.c(boolean):java.lang.String");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" near ");
        StringBuilder sb2 = new StringBuilder();
        int min = Math.min(this.f, 20);
        sb2.append(this.e, this.f - min, min);
        sb2.append(this.e, this.f, Math.min(this.g - this.f, 20));
        sb.append((Object) sb2);
        return sb.toString();
    }

    private char B() {
        if (this.f == this.g && !a(1)) {
            throw e("Unterminated escape sequence");
        }
        char[] cArr = this.e;
        int i = this.f;
        int i2 = i + 1;
        this.f = i2;
        char c = cArr[i];
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return TokenParser.CR;
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            return c;
        }
        if (i2 + 4 > this.g && !a(4)) {
            throw e("Unterminated escape sequence");
        }
        String a2 = this.b.a(this.e, this.f, 4);
        this.f += 4;
        return (char) Integer.parseInt(a2, 16);
    }

    private bn C() {
        this.m = c(true);
        if (this.o == 0) {
            throw e("Expected literal value");
        }
        bn D = D();
        this.k = D;
        if (D == bn.STRING) {
            z();
        }
        return this.k;
    }

    private bn D() {
        int i = this.n;
        if (i == -1) {
            return bn.STRING;
        }
        int i2 = this.o;
        if (i2 == 4) {
            char[] cArr = this.e;
            if (('n' == cArr[i] || 'N' == cArr[i]) && (('u' == cArr[i + 1] || 'U' == cArr[i + 1]) && (('l' == cArr[i + 2] || 'L' == cArr[i + 2]) && ('l' == cArr[i + 3] || 'L' == cArr[i + 3])))) {
                this.m = "null";
                return bn.NULL;
            }
        }
        if (i2 == 4) {
            char[] cArr2 = this.e;
            if (('t' == cArr2[i] || 'T' == cArr2[i]) && (('r' == cArr2[i + 1] || 'R' == cArr2[i + 1]) && (('u' == cArr2[i + 2] || 'U' == cArr2[i + 2]) && ('e' == cArr2[i + 3] || 'E' == cArr2[i + 3])))) {
                this.m = "true";
                return bn.BOOLEAN;
            }
        }
        if (i2 == 5) {
            char[] cArr3 = this.e;
            if (('f' == cArr3[i] || 'F' == cArr3[i]) && (('a' == cArr3[i + 1] || 'A' == cArr3[i + 1]) && (('l' == cArr3[i + 2] || 'L' == cArr3[i + 2]) && (('s' == cArr3[i + 3] || 'S' == cArr3[i + 3]) && ('e' == cArr3[i + 4] || 'E' == cArr3[i + 4]))))) {
                this.m = "false";
                return bn.BOOLEAN;
            }
        }
        this.m = this.b.a(this.e, i, i2);
        return a(this.e, this.n, this.o);
    }

    private static bn a(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        char c;
        char c2 = cArr[i];
        if (c2 == '-') {
            int i5 = i + 1;
            i3 = i5;
            c2 = cArr[i5];
        } else {
            i3 = i;
        }
        if (c2 == '0') {
            i4 = i3 + 1;
            c = cArr[i4];
        } else if (c2 >= '1' && c2 <= '9') {
            i4 = i3 + 1;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        } else {
            return bn.STRING;
        }
        if (c == '.') {
            i4++;
            c = cArr[i4];
            while (c >= '0' && c <= '9') {
                i4++;
                c = cArr[i4];
            }
        }
        if (c == 'e' || c == 'E') {
            int i6 = i4 + 1;
            char c3 = cArr[i6];
            if (c3 == '+' || c3 == '-') {
                i6++;
                c3 = cArr[i6];
            }
            if (c3 >= '0' && c3 <= '9') {
                i4 = i6 + 1;
                char c4 = cArr[i4];
                while (c4 >= '0' && c4 <= '9') {
                    i4++;
                    c4 = cArr[i4];
                }
            } else {
                return bn.STRING;
            }
        }
        if (i4 == i + i2) {
            return bn.NUMBER;
        }
        return bn.STRING;
    }

    private IOException e(String str) {
        throw new bp(str + " at line " + w() + " column " + x());
    }
}
