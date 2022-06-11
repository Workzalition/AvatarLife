package com.tapjoy.internal;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class dz extends AsyncTask<Object, Void, String> {
    a d;
    protected final b e;

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public interface a {
        void a();
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public interface b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public dz(b bVar) {
        this.e = bVar;
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
