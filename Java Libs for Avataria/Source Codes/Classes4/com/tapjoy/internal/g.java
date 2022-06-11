package com.tapjoy.internal;

import android.content.SharedPreferences;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class g extends l<Boolean> {
    private final boolean c = false;

    public g(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
    }

    public final void a(boolean z) {
        this.a.edit().putBoolean(this.b, z).apply();
    }

    public final Boolean a() {
        return Boolean.valueOf(this.a.getBoolean(this.b, this.c));
    }
}
