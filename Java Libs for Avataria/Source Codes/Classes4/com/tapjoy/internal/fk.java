package com.tapjoy.internal;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class fk {
    private static fk a = new fk();

    public static URLConnection a(URL url) {
        return url.openConnection();
    }
}
