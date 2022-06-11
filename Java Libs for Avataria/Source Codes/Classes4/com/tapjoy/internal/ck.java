package com.tapjoy.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ck extends ContentObserver {
    public final Context a;
    public float b;
    private final AudioManager c;
    private final ch d;
    private final cj e;

    public ck(Handler handler, Context context, ch chVar, cj cjVar) {
        super(handler);
        this.a = context;
        this.c = (AudioManager) context.getSystemService("audio");
        this.d = chVar;
        this.e = cjVar;
    }

    public final float a() {
        return ch.a(this.c.getStreamVolume(3), this.c.getStreamMaxVolume(3));
    }

    public final void b() {
        this.e.a(this.b);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        float a = a();
        if (a != this.b) {
            this.b = a;
            b();
        }
    }
}
