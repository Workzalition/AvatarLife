package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
final class hd$1 implements q {
    hd$1() {
    }

    @Override // com.tapjoy.internal.q
    public final String a(Context context) {
        return hl.a(context).b.getString("gcm.senderIds", "");
    }

    @Override // com.tapjoy.internal.q
    public final void a(Context context, String str) {
        m.a(hl.a(context).b, "gcm.senderIds", str);
    }

    @Override // com.tapjoy.internal.q
    public final String b(Context context) {
        return hl.a(context).b.getString("gcm.regId", "");
    }

    @Override // com.tapjoy.internal.q
    public final void b(Context context, String str) {
        m.a(hl.a(context).b, "gcm.regId", str);
    }

    @Override // com.tapjoy.internal.q
    public final boolean c(Context context) {
        return hl.a(context).b.getBoolean("gcm.stale", true);
    }

    @Override // com.tapjoy.internal.q
    public final void a(Context context, boolean z) {
        m.a(hl.a(context).b, "gcm.stale", z);
    }

    @Override // com.tapjoy.internal.q
    public final int d(Context context) {
        return hl.a(context).b.getInt("gcm.appVersion", Integer.MIN_VALUE);
    }

    @Override // com.tapjoy.internal.q
    public final void a(Context context, int i) {
        m.a(hl.a(context).b, "gcm.appVersion", i);
    }

    @Override // com.tapjoy.internal.q
    public final boolean e(Context context) {
        return hl.a(context).b.getBoolean("gcm.onServer", false);
    }

    @Override // com.tapjoy.internal.q
    public final void b(Context context, boolean z) {
        hl.a(context).a(z);
    }

    @Override // com.tapjoy.internal.q
    public final long f(Context context) {
        return hl.a(context).b.getLong("gcm.onServerExpirationTime", 0L);
    }

    @Override // com.tapjoy.internal.q
    public final void a(Context context, long j) {
        SharedPreferences.Editor edit = hl.a(context).b.edit();
        edit.putLong("gcm.onServerExpirationTime", j);
        edit.apply();
    }

    @Override // com.tapjoy.internal.q
    public final int g(Context context) {
        return hl.a(context).b.getInt("gcm.backoff", 0);
    }

    @Override // com.tapjoy.internal.q
    public final void b(Context context, int i) {
        m.a(hl.a(context).b, "gcm.backoff", i);
    }
}
