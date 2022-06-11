package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class be {
    public static final bd<Point> a = new bd<Point>() { // from class: com.tapjoy.internal.be.1
        @Override // com.tapjoy.internal.bd
        public final /* synthetic */ Point a(bi biVar) {
            Point point = new Point();
            biVar.h();
            while (biVar.j()) {
                String l = biVar.l();
                if ("x".equals(l)) {
                    point.x = biVar.r();
                } else if ("y".equals(l)) {
                    point.y = biVar.r();
                } else {
                    biVar.s();
                }
            }
            biVar.i();
            return point;
        }
    };
    public static final bd<Rect> b = new bd<Rect>() { // from class: com.tapjoy.internal.be.2
        @Override // com.tapjoy.internal.bd
        public final /* synthetic */ Rect a(bi biVar) {
            Rect rect = new Rect();
            int i = AnonymousClass3.a[biVar.k().ordinal()];
            if (i == 1) {
                biVar.f();
                rect.left = biVar.r();
                rect.top = biVar.r();
                rect.right = biVar.r();
                rect.bottom = biVar.r();
                while (biVar.j()) {
                    biVar.s();
                }
                biVar.g();
            } else if (i == 2) {
                biVar.h();
                while (biVar.j()) {
                    String l = biVar.l();
                    if ("left".equals(l)) {
                        rect.left = biVar.r();
                    } else if ("top".equals(l)) {
                        rect.top = biVar.r();
                    } else if ("right".equals(l)) {
                        rect.right = biVar.r();
                    } else if ("bottom".equals(l)) {
                        rect.bottom = biVar.r();
                    } else {
                        biVar.s();
                    }
                }
                biVar.i();
            } else {
                throw new IllegalStateException("Unexpected token: " + biVar.k());
            }
            return rect;
        }
    };

    /* renamed from: com.tapjoy.internal.be$3 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bn.values().length];
            a = iArr;
            try {
                iArr[bn.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bn.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
