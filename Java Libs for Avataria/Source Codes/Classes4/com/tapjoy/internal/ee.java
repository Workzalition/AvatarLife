package com.tapjoy.internal;

import com.tapjoy.internal.dz;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ee implements dz.b {
    final ea a;
    private JSONObject b;

    public ee(ea eaVar) {
        this.a = eaVar;
    }

    @Override // com.tapjoy.internal.dz.b
    public final JSONObject a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.dz.b
    public final void a(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public final void b() {
        this.a.a(new eb(this));
    }
}
