package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class gl extends Observable {
    public final List<a> b = new ArrayList();

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class a {
        public final String a;
        public volatile Map<String, Object> b;

        a(String str) {
            gl.this = r1;
            this.a = str;
        }

        public final Object a(String str) {
            Map<String, Object> map = this.b;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    protected final a a(String str) {
        a aVar = new a(str);
        this.b.add(aVar);
        return aVar;
    }

    @Override // java.util.Observable
    protected void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    public final boolean a(String str, boolean z) {
        for (a aVar : this.b) {
            Object a2 = aVar.a(str);
            if (a2 != null) {
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                if (!(a2 instanceof String)) {
                    continue;
                } else if ("true".equals(a2)) {
                    return true;
                } else {
                    if ("false".equals(a2)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    public final long b(String str) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            Object a2 = it.next().a(str);
            if (a2 != null) {
                if (a2 instanceof Number) {
                    return ((Number) a2).longValue();
                }
                if (a2 instanceof String) {
                    try {
                        return Long.parseLong((String) a2);
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    private static long a(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            return Long.parseLong((String) obj);
        }
        throw new IllegalArgumentException();
    }

    public final gk c(String str) {
        double parseDouble;
        for (a aVar : this.b) {
            Object a2 = aVar.a(str);
            if (a2 instanceof List) {
                List list = (List) a2;
                try {
                    long a3 = a(list.get(0));
                    long a4 = a(list.get(1));
                    long a5 = a(list.get(2));
                    Object obj = list.get(3);
                    if (obj instanceof Number) {
                        parseDouble = ((Number) obj).doubleValue();
                    } else if (obj instanceof String) {
                        parseDouble = Double.parseDouble((String) obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    return new gk(a3, a4, a5, parseDouble);
                } catch (RuntimeException unused) {
                }
            }
        }
        return gk.a;
    }
}
