package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class cp {
    public final cv a;
    public final List<cw> c;
    final String e;
    public final String f;
    public final String g;
    public final cq h;
    public final Map<String, cw> d = new HashMap();
    final WebView b = null;

    public cp(cv cvVar, String str, List<cw> list, String str2, String str3, cq cqVar) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = cvVar;
        this.e = str;
        this.h = cqVar;
        if (list != null) {
            arrayList.addAll(list);
            for (cw cwVar : list) {
                String uuid = UUID.randomUUID().toString();
                this.d.put(uuid, cwVar);
            }
        }
        this.g = str2;
        this.f = str3;
    }
}
