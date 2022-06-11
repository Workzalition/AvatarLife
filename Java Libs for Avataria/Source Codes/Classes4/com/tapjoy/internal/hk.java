package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class hk {
    final n a;
    public final n b;
    private final SharedPreferences c;

    public hk(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        this.c = sharedPreferences;
        this.a = new n(sharedPreferences, "noMoreToday.date");
        this.b = new n(sharedPreferences, "noMoreToday.actionIds");
        b();
    }

    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public final void b() {
        String a = this.a.a();
        if (a != null && !a().equals(a)) {
            this.a.a(null);
            this.b.a(null);
        }
    }
}
