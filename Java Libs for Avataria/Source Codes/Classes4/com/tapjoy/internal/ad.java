package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.view.MotionEvent;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class ad extends ae {
    private int a = 0;
    private final Matrix b = new Matrix();
    private final float[] c = new float[2];

    public ad(Context context) {
        super(context);
    }

    public int getRotationCount() {
        return this.a;
    }

    public void setRotationCount(int i) {
        this.a = i & 3;
    }

    @Override // com.tapjoy.internal.ae, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.a % 2 == 0) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if ((r3 instanceof android.widget.HorizontalScrollView) != false) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void dispatchDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.a
            if (r0 != 0) goto L8
            super.dispatchDraw(r9)
            return
        L8:
            r9.save()
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            r2 = 0
            r9.clipRect(r2, r2, r0, r1)
            android.view.ViewParent r2 = r8.getParent()     // Catch: java.lang.Exception -> L4f
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch: java.lang.Exception -> L4f
            android.view.ViewParent r3 = r2.getParent()     // Catch: java.lang.Exception -> L2c
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3     // Catch: java.lang.Exception -> L2c
            boolean r4 = r3 instanceof android.widget.ScrollView     // Catch: java.lang.Exception -> L2c
            if (r4 != 0) goto L2b
            boolean r4 = r3 instanceof android.widget.HorizontalScrollView     // Catch: java.lang.Exception -> L2c
            if (r4 == 0) goto L2c
        L2b:
            r2 = r3
        L2c:
            int r3 = r8.getLeft()     // Catch: java.lang.Exception -> L4f
            int r4 = r2.getScrollX()     // Catch: java.lang.Exception -> L4f
            int r3 = r3 - r4
            int r4 = r8.getTop()     // Catch: java.lang.Exception -> L4f
            int r5 = r2.getScrollY()     // Catch: java.lang.Exception -> L4f
            int r4 = r4 - r5
            int r5 = 0 - r3
            int r6 = 0 - r4
            int r7 = r2.getWidth()     // Catch: java.lang.Exception -> L4f
            int r7 = r7 - r3
            int r2 = r2.getHeight()     // Catch: java.lang.Exception -> L4f
            int r2 = r2 - r4
            r9.clipRect(r5, r6, r7, r2)     // Catch: java.lang.Exception -> L4f
        L4f:
            int r2 = r8.a
            int r2 = r2 * 90
            float r2 = (float) r2
            r9.rotate(r2)
            int r2 = r8.a
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == r6) goto L77
            if (r2 == r4) goto L6f
            if (r2 != r3) goto L69
            int r2 = -r1
            float r2 = (float) r2
            r9.translate(r2, r5)
            goto L7c
        L69:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L6f:
            int r2 = -r0
            float r2 = (float) r2
            int r7 = -r1
            float r7 = (float) r7
            r9.translate(r2, r7)
            goto L7c
        L77:
            int r2 = -r0
            float r2 = (float) r2
            r9.translate(r5, r2)
        L7c:
            android.graphics.Matrix r2 = r8.b
            int r7 = r8.a
            int r7 = r7 * (-90)
            float r7 = (float) r7
            r2.setRotate(r7)
            int r2 = r8.a
            if (r2 == r6) goto La6
            if (r2 == r4) goto L9c
            if (r2 != r3) goto L96
            android.graphics.Matrix r0 = r8.b
            int r1 = r1 - r6
            float r1 = (float) r1
            r0.postTranslate(r1, r5)
            goto Lad
        L96:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L9c:
            android.graphics.Matrix r2 = r8.b
            int r0 = r0 - r6
            float r0 = (float) r0
            int r1 = r1 - r6
            float r1 = (float) r1
            r2.postTranslate(r0, r1)
            goto Lad
        La6:
            android.graphics.Matrix r1 = r8.b
            int r0 = r0 - r6
            float r0 = (float) r0
            r1.postTranslate(r5, r0)
        Lad:
            super.dispatchDraw(r9)
            r9.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ad.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float[] fArr = this.c;
        fArr[0] = motionEvent.getX();
        fArr[1] = motionEvent.getY();
        this.b.mapPoints(fArr);
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }
}
