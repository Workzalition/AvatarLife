package com.tapjoy.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ac {
    public static void a(Window window, View view, ViewGroup.LayoutParams layoutParams) {
        Window.Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(view, layoutParams);
        window.setCallback(callback);
    }

    public static int a(Window window) {
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
