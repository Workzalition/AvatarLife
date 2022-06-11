package com.tapjoy.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class ek<E> {
    public static final ek<Integer> g;
    public static final ek<Integer> h;
    public static final ek<Long> l;
    public static final ek<Long> m;
    final Class<?> a;
    ek<List<E>> b;
    private final eh r;
    public static final ek<Boolean> c = new ek<Boolean>(eh.VARINT, Boolean.class) { // from class: com.tapjoy.internal.ek.1
        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ int a(Boolean bool) {
            return 1;
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Boolean bool) {
            emVar.c(bool.booleanValue() ? 1 : 0);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Boolean a(el elVar) {
            int c2 = elVar.c();
            if (c2 == 0) {
                return Boolean.FALSE;
            }
            if (c2 == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(c2)));
        }
    };
    public static final ek<Integer> d = new ek<Integer>(eh.VARINT, Integer.class) { // from class: com.tapjoy.internal.ek.7
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Integer num) {
            int intValue = num.intValue();
            if (intValue >= 0) {
                return em.a(intValue);
            }
            return 10;
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Integer num) {
            int intValue = num.intValue();
            if (intValue >= 0) {
                emVar.c(intValue);
            } else {
                emVar.c(intValue);
            }
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Integer a(el elVar) {
            return Integer.valueOf(elVar.c());
        }
    };
    public static final ek<Integer> e = new ek<Integer>(eh.VARINT, Integer.class) { // from class: com.tapjoy.internal.ek.8
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Integer num) {
            return em.a(num.intValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Integer num) {
            emVar.c(num.intValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Integer a(el elVar) {
            return Integer.valueOf(elVar.c());
        }
    };
    public static final ek<Integer> f = new ek<Integer>(eh.VARINT, Integer.class) { // from class: com.tapjoy.internal.ek.9
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Integer num) {
            return em.a(em.b(num.intValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Integer num) {
            emVar.c(em.b(num.intValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Integer a(el elVar) {
            int c2 = elVar.c();
            return Integer.valueOf((-(c2 & 1)) ^ (c2 >>> 1));
        }
    };
    public static final ek<Long> i = new ek<Long>(eh.VARINT, Long.class) { // from class: com.tapjoy.internal.ek.11
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Long l2) {
            return em.a(l2.longValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Long l2) {
            emVar.c(l2.longValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Long a(el elVar) {
            return Long.valueOf(elVar.d());
        }
    };
    public static final ek<Long> j = new ek<Long>(eh.VARINT, Long.class) { // from class: com.tapjoy.internal.ek.12
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Long l2) {
            return em.a(l2.longValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Long l2) {
            emVar.c(l2.longValue());
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Long a(el elVar) {
            return Long.valueOf(elVar.d());
        }
    };
    public static final ek<Long> k = new ek<Long>(eh.VARINT, Long.class) { // from class: com.tapjoy.internal.ek.13
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(Long l2) {
            return em.a(em.b(l2.longValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Long l2) {
            emVar.c(em.b(l2.longValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Long a(el elVar) {
            long d2 = elVar.d();
            return Long.valueOf((-(d2 & 1)) ^ (d2 >>> 1));
        }
    };
    public static final ek<Float> n = new ek<Float>(eh.FIXED32, Float.class) { // from class: com.tapjoy.internal.ek.2
        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ int a(Float f2) {
            return 4;
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Float f2) {
            emVar.d(Float.floatToIntBits(f2.floatValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Float a(el elVar) {
            return Float.valueOf(Float.intBitsToFloat(elVar.e()));
        }
    };
    public static final ek<Double> o = new ek<Double>(eh.FIXED64, Double.class) { // from class: com.tapjoy.internal.ek.3
        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ int a(Double d2) {
            return 8;
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, Double d2) {
            emVar.d(Double.doubleToLongBits(d2.doubleValue()));
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ Double a(el elVar) {
            return Double.valueOf(Double.longBitsToDouble(elVar.f()));
        }
    };
    public static final ek<String> p = new ek<String>(eh.LENGTH_DELIMITED, String.class) { // from class: com.tapjoy.internal.ek.4
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(String str) {
            int i2;
            String str2 = str;
            int length = str2.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                char charAt = str2.charAt(i3);
                if (charAt >= 128) {
                    if (charAt < 2048) {
                        i4 += 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i4 += 3;
                    } else if (charAt <= 56319 && (i2 = i3 + 1) < length && str2.charAt(i2) >= 56320 && str2.charAt(i2) <= 57343) {
                        i4 += 4;
                        i3 = i2;
                    }
                    i3++;
                }
                i4++;
                i3++;
            }
            return i4;
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ void a(em emVar, String str) {
            emVar.a.b(str);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ String a(el elVar) {
            return elVar.a.c(elVar.g());
        }
    };
    public static final ek<iw> q = new ek<iw>(eh.LENGTH_DELIMITED, iw.class) { // from class: com.tapjoy.internal.ek.5
        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ int a(iw iwVar) {
            return iwVar.c();
        }

        @Override // com.tapjoy.internal.ek
        public final /* bridge */ /* synthetic */ void a(em emVar, iw iwVar) {
            emVar.a(iwVar);
        }

        @Override // com.tapjoy.internal.ek
        public final /* synthetic */ iw a(el elVar) {
            return elVar.a.b(elVar.g());
        }
    };

    public abstract int a(E e2);

    public abstract E a(el elVar);

    public abstract void a(em emVar, E e2);

    public ek(eh ehVar, Class<?> cls) {
        this.r = ehVar;
        this.a = cls;
    }

    public int a(int i2, E e2) {
        int a2 = a((ek<E>) e2);
        if (this.r == eh.LENGTH_DELIMITED) {
            a2 += em.a(a2);
        }
        return a2 + em.a(em.a(i2, eh.VARINT));
    }

    public void a(em emVar, int i2, E e2) {
        emVar.c(em.a(i2, this.r));
        if (this.r == eh.LENGTH_DELIMITED) {
            emVar.c(a((ek<E>) e2));
        }
        a(emVar, (em) e2);
    }

    public final void a(iu iuVar, E e2) {
        ej.a(e2, "value == null");
        ej.a(iuVar, "sink == null");
        a(new em(iuVar), (em) e2);
    }

    public final byte[] b(E e2) {
        ej.a(e2, "value == null");
        it itVar = new it();
        try {
            a((iu) itVar, (it) e2);
            return itVar.h();
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public final E a(byte[] bArr) {
        ej.a(bArr, "bytes == null");
        it itVar = new it();
        if (bArr != null) {
            return a((iv) itVar.a(bArr, 0, bArr.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    public final E a(iv ivVar) {
        ej.a(ivVar, "source == null");
        return a(new el(ivVar));
    }

    public static String c(E e2) {
        return e2.toString();
    }

    static {
        ek<Integer> ekVar = new ek<Integer>(eh.FIXED32, Integer.class) { // from class: com.tapjoy.internal.ek.10
            @Override // com.tapjoy.internal.ek
            public final /* bridge */ /* synthetic */ int a(Integer num) {
                return 4;
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ void a(em emVar, Integer num) {
                emVar.d(num.intValue());
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ Integer a(el elVar) {
                return Integer.valueOf(elVar.e());
            }
        };
        g = ekVar;
        h = ekVar;
        ek<Long> ekVar2 = new ek<Long>(eh.FIXED64, Long.class) { // from class: com.tapjoy.internal.ek.14
            @Override // com.tapjoy.internal.ek
            public final /* bridge */ /* synthetic */ int a(Long l2) {
                return 8;
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ void a(em emVar, Long l2) {
                emVar.d(l2.longValue());
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ Long a(el elVar) {
                return Long.valueOf(elVar.f());
            }
        };
        l = ekVar2;
        m = ekVar2;
    }

    public final ek<List<E>> a() {
        ek<List<E>> ekVar = this.b;
        if (ekVar != null) {
            return ekVar;
        }
        ek<List<E>> ekVar2 = new ek<List<E>>(this.r, List.class) { // from class: com.tapjoy.internal.ek.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ int a(int i2, Object obj) {
                List list = (List) obj;
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i3 += ek.this.a(i2, (int) list.get(i4));
                }
                return i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ void a(em emVar, int i2, Object obj) {
                List list = (List) obj;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ek.this.a(emVar, i2, list.get(i3));
                }
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ Object a(el elVar) {
                return Collections.singletonList(ek.this.a(elVar));
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ void a(em emVar, Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.tapjoy.internal.ek
            public final /* synthetic */ int a(Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
        };
        this.b = ekVar2;
        return ekVar2;
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static final class a extends IllegalArgumentException {
        public final int a;

        public a(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.a = i;
        }
    }
}
