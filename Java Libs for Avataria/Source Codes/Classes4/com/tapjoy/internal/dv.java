package com.tapjoy.internal;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.vungle.warren.AdLoader;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class dv extends dt {
    WebView e;
    private Long f = null;
    private final Map<String, cw> g;
    private final String h;

    public dv(Map<String, cw> map, String str) {
        this.g = map;
        this.h = str;
    }

    @Override // com.tapjoy.internal.dt
    public final void a() {
        super.a();
        WebView webView = new WebView(df.a().a);
        this.e = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.e);
        dg.a();
        dg.a(this.e, this.h);
        for (String str : this.g.keySet()) {
            String externalForm = this.g.get(str).b.toExternalForm();
            dg.a();
            WebView webView2 = this.e;
            if (externalForm != null && !TextUtils.isEmpty(str)) {
                dg.a(webView2, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", str));
            }
        }
        this.f = Long.valueOf(System.nanoTime());
    }

    @Override // com.tapjoy.internal.dt
    public final void a(cx cxVar, cp cpVar) {
        JSONObject jSONObject = new JSONObject();
        Map unmodifiableMap = Collections.unmodifiableMap(cpVar.d);
        for (String str : unmodifiableMap.keySet()) {
            dn.a(jSONObject, str, (cw) unmodifiableMap.get(str));
        }
        a(cxVar, cpVar, jSONObject);
    }

    @Override // com.tapjoy.internal.dt
    public final void b() {
        super.b();
        new Handler().postDelayed(new Runnable() { // from class: com.tapjoy.internal.dv.1
            private final WebView b;

            @Override // java.lang.Runnable
            public final void run() {
                this.b.destroy();
            }

            {
                dv.this = this;
                this.b = this.e;
            }
        }, Math.max(4000 - (this.f == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f.longValue(), TimeUnit.NANOSECONDS)), (long) AdLoader.RETRY_DELAY));
        this.e = null;
    }
}
