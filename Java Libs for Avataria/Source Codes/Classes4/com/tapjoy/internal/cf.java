package com.tapjoy.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class cf {
    private static db a = new db();

    public static String a() {
        return "1.3.16-tapjoy";
    }

    public static void a(Context context) {
        db dbVar = a;
        Context applicationContext = context.getApplicationContext();
        dp.a(applicationContext, "Application Context cannot be null");
        if (!dbVar.a) {
            dbVar.a = true;
            dh a2 = dh.a();
            a2.b = new ck(new Handler(), applicationContext, new ch(), a2);
            dd a3 = dd.a();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(a3);
            }
            dn.a(applicationContext);
            df.a().a = applicationContext != null ? applicationContext.getApplicationContext() : null;
        }
    }

    public static boolean b() {
        return a.a;
    }
}
