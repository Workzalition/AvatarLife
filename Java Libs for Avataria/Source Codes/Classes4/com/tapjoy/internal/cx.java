package com.tapjoy.internal;

import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class cx extends cn {
    private static final Pattern i = Pattern.compile("^[a-zA-Z0-9 ]+$");
    public final co a;
    public dt c;
    public boolean g;
    public boolean h;
    private final cp j;
    private dr k;
    public final List<de> b = new ArrayList();
    public boolean d = false;
    public boolean e = false;
    public final String f = UUID.randomUUID().toString();

    private void b(View view) {
        this.k = new dr(view);
    }

    public final View c() {
        return (View) this.k.get();
    }

    public final boolean d() {
        return this.d && !this.e;
    }

    public cx(co coVar, cp cpVar) {
        this.a = coVar;
        this.j = cpVar;
        b(null);
        if (cpVar.h == cq.HTML || cpVar.h == cq.JAVASCRIPT) {
            this.c = new du(cpVar.b);
        } else {
            this.c = new dv(Collections.unmodifiableMap(cpVar.d), cpVar.e);
        }
        this.c.a();
        dc.a().a.add(this);
        dt dtVar = this.c;
        dg a = dg.a();
        WebView c = dtVar.c();
        JSONObject jSONObject = new JSONObject();
        dn.a(jSONObject, "impressionOwner", coVar.a);
        dn.a(jSONObject, "mediaEventsOwner", coVar.b);
        dn.a(jSONObject, "creativeType", coVar.d);
        dn.a(jSONObject, "impressionType", coVar.e);
        dn.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(coVar.c));
        a.a(c, "init", jSONObject);
    }

    @Override // com.tapjoy.internal.cn
    public final void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        dc a = dc.a();
        boolean b = a.b();
        a.b.add(this);
        if (!b) {
            dh a2 = dh.a();
            dd.a().c = a2;
            dd a3 = dd.a();
            a3.a = true;
            a3.b = false;
            a3.b();
            dw.a();
            dw.b();
            ck ckVar = a2.b;
            ckVar.b = ckVar.a();
            ckVar.b();
            ckVar.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, ckVar);
        }
        this.c.a(dh.a().a);
        this.c.a(this, this.j);
    }

    @Override // com.tapjoy.internal.cn
    public final void a(View view) {
        if (this.e) {
            return;
        }
        dp.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        b(view);
        this.c.d();
        Collection<cx> unmodifiableCollection = Collections.unmodifiableCollection(dc.a().a);
        if (unmodifiableCollection == null || unmodifiableCollection.isEmpty()) {
            return;
        }
        for (cx cxVar : unmodifiableCollection) {
            if (cxVar != this && cxVar.c() == view) {
                cxVar.k.clear();
            }
        }
    }

    @Override // com.tapjoy.internal.cn
    public final void b() {
        if (this.e) {
            return;
        }
        this.k.clear();
        if (!this.e) {
            this.b.clear();
        }
        this.e = true;
        dg.a().a(this.c.c(), "finishSession", new Object[0]);
        dc a = dc.a();
        boolean b = a.b();
        a.a.remove(this);
        a.b.remove(this);
        if (b && !a.b()) {
            dh a2 = dh.a();
            final dw a3 = dw.a();
            dw.c();
            a3.b.clear();
            dw.a.post(new Runnable() { // from class: com.tapjoy.internal.dw.1
                @Override // java.lang.Runnable
                public final void run() {
                    dw.this.h.b();
                }
            });
            dd a4 = dd.a();
            a4.a = false;
            a4.b = false;
            a4.c = null;
            ck ckVar = a2.b;
            ckVar.a.getContentResolver().unregisterContentObserver(ckVar);
        }
        this.c.b();
        this.c = null;
    }
}
