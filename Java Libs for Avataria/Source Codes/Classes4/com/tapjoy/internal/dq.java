package com.tapjoy.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dq {
    public static float a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static String c(View view) {
        if (Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) {
            int visibility = view.getVisibility();
            if (visibility != 0) {
                return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
            } else if (view.getAlpha() != 0.0f) {
                return null;
            } else {
                return "viewAlphaZero";
            }
        }
        return "notAttached";
    }

    public static boolean b(View view) {
        if ((Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) && view.isShown()) {
            while (view != null) {
                if (view.getAlpha() == 0.0f) {
                    return false;
                }
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            return true;
        }
        return false;
    }
}
