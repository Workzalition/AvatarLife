package com.tapjoy.internal;

import com.tapjoy.internal.dz;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class dy extends dz {
    protected final HashSet<String> a;
    protected final JSONObject b;
    protected final long c;

    public dy(dz.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar);
        this.a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
