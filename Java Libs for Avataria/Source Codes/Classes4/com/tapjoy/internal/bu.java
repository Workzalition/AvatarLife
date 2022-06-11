package com.tapjoy.internal;

import com.vungle.warren.model.ReportDBAdapter;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public abstract class bu<Result> extends bv<Result> {
    protected abstract Result a(bi biVar);

    public final Map<String, Object> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Accept", "application/json");
        return linkedHashMap;
    }

    public final Result a(URI uri, InputStream inputStream) {
        bi a = bi.a(inputStream);
        a.a("BASE_URI", uri);
        int i = 0;
        try {
            a.h();
            Result result = null;
            String str = null;
            while (a.j()) {
                String l = a.l();
                if (ReportDBAdapter.ReportColumns.COLUMN_REPORT_STATUS.equals(l)) {
                    i = a.r();
                } else if (SharedKt.PARAM_MESSAGE.equals(l)) {
                    str = a.m();
                } else if ("data".equals(l)) {
                    result = a(a);
                } else {
                    a.s();
                }
            }
            a.i();
            if (i == 200) {
                return result;
            }
            throw new bw(i, str);
        } finally {
            a.close();
        }
    }
}
