package com.platform101xp.sdk.internal.dialogs.webdialogs;

import kotlin.Metadata;

/* compiled from: Platform101XPScreenOrientation.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", "", "isRotation", "", "isHorizontal", "isVertical", "(ZZZ)V", "()Z", "setHorizontal", "(Z)V", "setRotation", "setVertical", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPScreenOrientation {
    private boolean isHorizontal;
    private boolean isRotation;
    private boolean isVertical;

    public static /* synthetic */ Platform101XPScreenOrientation copy$default(Platform101XPScreenOrientation platform101XPScreenOrientation, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = platform101XPScreenOrientation.isRotation;
        }
        if ((i & 2) != 0) {
            z2 = platform101XPScreenOrientation.isHorizontal;
        }
        if ((i & 4) != 0) {
            z3 = platform101XPScreenOrientation.isVertical;
        }
        return platform101XPScreenOrientation.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.isRotation;
    }

    public final boolean component2() {
        return this.isHorizontal;
    }

    public final boolean component3() {
        return this.isVertical;
    }

    public final Platform101XPScreenOrientation copy(boolean z, boolean z2, boolean z3) {
        return new Platform101XPScreenOrientation(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Platform101XPScreenOrientation)) {
            return false;
        }
        Platform101XPScreenOrientation platform101XPScreenOrientation = (Platform101XPScreenOrientation) obj;
        return this.isRotation == platform101XPScreenOrientation.isRotation && this.isHorizontal == platform101XPScreenOrientation.isHorizontal && this.isVertical == platform101XPScreenOrientation.isVertical;
    }

    public int hashCode() {
        boolean z = this.isRotation;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i2 * 31;
        boolean z2 = this.isHorizontal;
        if (z2) {
            z2 = true;
        }
        int i5 = z2 ? 1 : 0;
        int i6 = z2 ? 1 : 0;
        int i7 = (i4 + i5) * 31;
        boolean z3 = this.isVertical;
        if (!z3) {
            i = z3 ? 1 : 0;
        }
        return i7 + i;
    }

    public String toString() {
        return "Platform101XPScreenOrientation(isRotation=" + this.isRotation + ", isHorizontal=" + this.isHorizontal + ", isVertical=" + this.isVertical + ')';
    }

    public Platform101XPScreenOrientation(boolean z, boolean z2, boolean z3) {
        this.isRotation = z;
        this.isHorizontal = z2;
        this.isVertical = z3;
    }

    public final boolean isHorizontal() {
        return this.isHorizontal;
    }

    public final boolean isRotation() {
        return this.isRotation;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setHorizontal(boolean z) {
        this.isHorizontal = z;
    }

    public final void setRotation(boolean z) {
        this.isRotation = z;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }
}
