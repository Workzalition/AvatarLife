package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bo implements Closeable {
    final Writer a;
    private final List<bl> b;
    private String c;
    private String d = ":";
    private boolean e;

    public bo(Writer writer) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(bl.EMPTY_DOCUMENT);
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    public final bo a() {
        return a(bl.EMPTY_ARRAY, "[");
    }

    public final bo b() {
        return a(bl.EMPTY_ARRAY, bl.NONEMPTY_ARRAY, "]");
    }

    public final bo c() {
        return a(bl.EMPTY_OBJECT, "{");
    }

    public final bo d() {
        return a(bl.EMPTY_OBJECT, bl.NONEMPTY_OBJECT, "}");
    }

    private bo a(bl blVar, String str) {
        b(true);
        this.b.add(blVar);
        this.a.write(str);
        return this;
    }

    private bo a(bl blVar, bl blVar2, String str) {
        bl e = e();
        if (e != blVar2 && e != blVar) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        List<bl> list = this.b;
        list.remove(list.size() - 1);
        if (e == blVar2) {
            g();
        }
        this.a.write(str);
        return this;
    }

    private bl e() {
        List<bl> list = this.b;
        return list.get(list.size() - 1);
    }

    private void a(bl blVar) {
        List<bl> list = this.b;
        list.set(list.size() - 1, blVar);
    }

    public final bo a(String str) {
        Objects.requireNonNull(str, "name == null");
        h();
        c(str);
        return this;
    }

    public final bo b(String str) {
        if (str == null) {
            return f();
        }
        b(false);
        c(str);
        return this;
    }

    private bo f() {
        b(false);
        this.a.write("null");
        return this;
    }

    private bo a(boolean z) {
        b(false);
        this.a.write(z ? "true" : "false");
        return this;
    }

    private bo a(double d) {
        if (!this.e && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(d)));
        }
        b(false);
        this.a.append((CharSequence) Double.toString(d));
        return this;
    }

    public final bo a(long j) {
        b(false);
        this.a.write(Long.toString(j));
        return this;
    }

    public final bo a(Number number) {
        if (number == null) {
            return f();
        }
        String obj = number.toString();
        if (!this.e && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
        }
        b(false);
        this.a.append((CharSequence) obj);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        if (e() == bl.NONEMPTY_DOCUMENT) {
            return;
        }
        throw new IOException("Incomplete document");
    }

    private void c(String str) {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                this.a.write("\\f");
            } else if (charAt == '\r') {
                this.a.write("\\r");
            } else {
                if (charAt == '\"' || charAt == '\\') {
                    this.a.write(92);
                } else if (charAt != 8232 && charAt != 8233) {
                    switch (charAt) {
                        case '\b':
                            this.a.write("\\b");
                            break;
                        case '\t':
                            this.a.write("\\t");
                            break;
                        case '\n':
                            this.a.write("\\n");
                            break;
                        default:
                            if (charAt <= 31) {
                                this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                } else {
                    this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
                this.a.write(charAt);
            }
        }
        this.a.write("\"");
    }

    private void g() {
        if (this.c == null) {
            return;
        }
        this.a.write("\n");
        for (int i = 1; i < this.b.size(); i++) {
            this.a.write(this.c);
        }
    }

    private void h() {
        bl e = e();
        if (e == bl.NONEMPTY_OBJECT) {
            this.a.write(44);
        } else if (e != bl.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        g();
        a(bl.DANGLING_NAME);
    }

    /* renamed from: com.tapjoy.internal.bo$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
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
                a[bl.DANGLING_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[bl.NONEMPTY_DOCUMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void b(boolean z) {
        int i = AnonymousClass1.a[e().ordinal()];
        if (i == 1) {
            if (!this.e && !z) {
                throw new IllegalStateException("JSON must start with an array or an object.");
            }
            a(bl.NONEMPTY_DOCUMENT);
        } else if (i == 2) {
            a(bl.NONEMPTY_ARRAY);
            g();
        } else if (i == 3) {
            this.a.append(',');
            g();
        } else if (i == 4) {
            this.a.append((CharSequence) this.d);
            a(bl.NONEMPTY_OBJECT);
        } else if (i == 5) {
            throw new IllegalStateException("JSON must have only one top-level value.");
        } else {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
    }

    public final bo a(Object obj) {
        if (obj == null) {
            return f();
        }
        if (obj instanceof bm) {
            if (this.b.size() == this.b.size()) {
                return this;
            }
            throw new IllegalStateException(obj.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
        } else if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof Number) {
                if (obj instanceof Long) {
                    return a(((Number) obj).longValue());
                }
                if (obj instanceof Double) {
                    return a(((Number) obj).doubleValue());
                }
                return a((Number) obj);
            } else if (obj instanceof String) {
                return b((String) obj);
            } else {
                if (obj instanceof bg) {
                    return a((bg) obj);
                }
                if (obj instanceof Collection) {
                    return a((Collection) obj);
                }
                if (obj instanceof Map) {
                    return b((Map) obj);
                }
                if (obj instanceof Date) {
                    return a((Date) obj);
                }
                if (obj instanceof Object[]) {
                    return a((Object[]) obj);
                }
                throw new IllegalArgumentException("Unknown type: " + obj.getClass().getName());
            }
        }
    }

    private bo a(Object[] objArr) {
        if (objArr == null) {
            return f();
        }
        a();
        for (Object obj : objArr) {
            a(obj);
        }
        b();
        return this;
    }

    public final bo a(bg bgVar) {
        b(false);
        bgVar.a(this.a);
        return this;
    }

    public final bo a(Collection collection) {
        if (collection == null) {
            return f();
        }
        a();
        for (Object obj : collection) {
            a(obj);
        }
        b();
        return this;
    }

    private bo b(Map map) {
        return a((Map<Object, Object>) map);
    }

    public final bo a(Map<Object, Object> map) {
        if (map == null) {
            return f();
        }
        c();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            a(String.valueOf(entry.getKey()));
            a(entry.getValue());
        }
        d();
        return this;
    }

    private bo a(Date date) {
        if (date == null) {
            return f();
        }
        return b(v.a(date));
    }
}
