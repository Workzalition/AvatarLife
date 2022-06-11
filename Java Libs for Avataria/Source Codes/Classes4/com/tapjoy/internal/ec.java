package com.tapjoy.internal;

import com.tapjoy.internal.dt;
import com.tapjoy.internal.dz;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class ec extends dy {
    public ec(dz.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    @Override // com.tapjoy.internal.dz
    /* renamed from: a */
    public final void onPostExecute(String str) {
        dc a = dc.a();
        if (a != null) {
            for (cx cxVar : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(cxVar.f)) {
                    dt dtVar = cxVar.c;
                    if (this.c >= dtVar.d && dtVar.c != dt.a.c) {
                        dtVar.c = dt.a.c;
                        dg.a().b(dtVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ String doInBackground(Object[] objArr) {
        return this.b.toString();
    }
}
