package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class bc implements bg {
    private final StringWriter a;
    private final bo b;

    public bc() {
        StringWriter stringWriter = new StringWriter();
        this.a = stringWriter;
        this.b = new bo(stringWriter);
    }

    public final String toString() {
        try {
            this.b.a.flush();
            return this.a.toString();
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    @Override // com.tapjoy.internal.bg
    public final void a(Writer writer) {
        try {
            this.b.a.flush();
            writer.write(this.a.toString());
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a() {
        try {
            this.b.a();
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc b() {
        try {
            this.b.b();
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc c() {
        try {
            this.b.c();
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc d() {
        try {
            this.b.d();
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(String str) {
        try {
            this.b.a(str);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(bg bgVar) {
        try {
            this.b.a(bgVar);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc b(String str) {
        try {
            this.b.b(str);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(long j) {
        try {
            this.b.a(j);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(Number number) {
        try {
            this.b.a(number);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    private bc b(Object obj) {
        try {
            this.b.a(obj);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(Collection collection) {
        try {
            this.b.a(collection);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public final bc a(Map map) {
        try {
            this.b.a((Map<Object, Object>) map);
            return this;
        } catch (IOException e) {
            throw jt.a(e);
        }
    }

    public static String a(Object obj) {
        return new bc().b(obj).toString();
    }
}
