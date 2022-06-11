package com.tapjoy.internal;

import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import com.vk.api.sdk.exceptions.VKApiCodes;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.ReportDBAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ru.ok.android.sdk.OkListenerKt;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class hr {
    public static String a(fb fbVar) {
        bc b = new bc().c().a("sdk").b(fbVar.t).a("os_name").b(fbVar.k).a("os_ver").b(fbVar.l).a(VKApiCodes.PARAM_DEVICE_ID).b(fbVar.h).a("device_maker").b(fbVar.i).a("device_model").b(fbVar.j).a("pkg_id").b(fbVar.r).a("pkg_sign").b(fbVar.s).a("locale").b(fbVar.p).a("timezone").b(fbVar.q);
        if (fbVar.m != null) {
            b.a("display_d").a((Number) fbVar.m);
        }
        if (fbVar.n != null) {
            b.a("display_w").a((Number) fbVar.n);
        }
        if (fbVar.o != null) {
            b.a("display_h").a((Number) fbVar.o);
        }
        if (fbVar.g != null) {
            b.a("mac").b(fbVar.g);
        }
        if (fbVar.u != null) {
            b.a("country_sim").b(fbVar.u);
        }
        if (fbVar.v != null) {
            b.a("country_net").b(fbVar.v);
        }
        if (fbVar.w != null) {
            b.a("imei").b(fbVar.w);
        }
        if (fbVar.x != null) {
            b.a(VungleApiClient.ANDROID_ID).b(fbVar.x);
        }
        return b.d().toString();
    }

    public static String a(ev evVar) {
        bc c = new bc().c();
        if (evVar.e != null) {
            c.a("pkg_ver").b(evVar.e);
        }
        if (evVar.f != null) {
            c.a("pkg_rev").a((Number) evVar.f);
        }
        if (evVar.g != null) {
            c.a("data_ver").b(evVar.g);
        }
        if (evVar.h != null) {
            c.a("installer").b(evVar.h);
        }
        if (evVar.i != null) {
            c.a(TransactionErrorDetailsUtilities.STORE).b(evVar.i);
        }
        return c.d().toString();
    }

    public static String a(fi fiVar) {
        return a(fiVar, null);
    }

    private static String a(fi fiVar, ew ewVar) {
        String b;
        bc c = new bc().c();
        if (fiVar.s != null) {
            c.a("installed").a((Number) fiVar.s);
        }
        if (fiVar.t != null) {
            c.a("referrer").b(fiVar.t);
        }
        if (fiVar.G != null) {
            c.a("idfa").b(fiVar.G);
            if (fiVar.H != null && fiVar.H.booleanValue()) {
                c.a("idfa_optout").a(1L);
            }
        } else if (ewVar != null && ewVar.r != null && he.a.equals(ewVar.r) && (b = hp.b()) != null) {
            c.a("idfa").b(b);
            if (hp.c()) {
                c.a("idfa_optout").a(1L);
            }
        }
        if (fiVar.u != null) {
            c.a("fq7").a(Math.max(fiVar.u.intValue(), 1));
        }
        if (fiVar.v != null) {
            c.a("fq30").a(Math.max(fiVar.v.intValue(), 1));
        }
        if (fiVar.w.size() > 0) {
            ArrayList arrayList = new ArrayList(fiVar.w.size());
            for (ff ffVar : fiVar.w) {
                if (ffVar.h != null) {
                    arrayList.add(ffVar.f);
                }
            }
            if (!arrayList.isEmpty()) {
                c.a("push").a();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b((String) it.next());
                }
                c.b();
            }
        }
        c.a("session").c();
        if (fiVar.x != null) {
            c.a("total_count").a((Number) fiVar.x);
        }
        if (fiVar.y != null) {
            c.a("total_length").a((Number) fiVar.y);
        }
        if (fiVar.z != null) {
            c.a("last_at").a((Number) fiVar.z);
        }
        if (fiVar.A != null) {
            c.a("last_length").a((Number) fiVar.A);
        }
        c.d();
        c.a("purchase").c();
        if (fiVar.B != null) {
            c.a("currency").b(fiVar.B);
        }
        if (fiVar.C != null) {
            c.a("total_count").a((Number) fiVar.C);
        }
        if (fiVar.D != null) {
            c.a("total_price").a((Number) fiVar.D);
        }
        if (fiVar.E != null) {
            c.a("last_at").a((Number) fiVar.E);
        }
        if (fiVar.F != null) {
            c.a("last_price").a((Number) fiVar.F);
        }
        c.d();
        if (fiVar.I != null) {
            c.a(ReportDBAdapter.ReportColumns.COLUMN_USER_ID).b(fiVar.I);
        }
        if (fiVar.J != null) {
            c.a("user_level").a((Number) fiVar.J);
        }
        if (fiVar.K != null) {
            c.a("friend_count").a((Number) fiVar.K);
        }
        if (fiVar.L != null) {
            c.a("uv1").b(fiVar.L);
        }
        if (fiVar.M != null) {
            c.a("uv2").b(fiVar.M);
        }
        if (fiVar.N != null) {
            c.a("uv3").b(fiVar.N);
        }
        if (fiVar.O != null) {
            c.a("uv4").b(fiVar.O);
        }
        if (fiVar.P != null) {
            c.a("uv5").b(fiVar.P);
        }
        if (fiVar.Q.size() > 0) {
            c.a("tags").a((Collection) fiVar.Q);
        }
        if (Boolean.TRUE.equals(fiVar.R)) {
            c.a("push_optout").a(1L);
        }
        return c.d().toString();
    }

    private static String a(ew ewVar, boolean z, boolean z2, boolean z3) {
        bc b = new bc().c().a(SharedKt.PARAM_TYPE).b(a(ewVar.n)).a(MediationMetaData.KEY_NAME).b(ewVar.o);
        b.a("time");
        if (ewVar.q != null) {
            b.a((Number) ewVar.p);
            b.a("systime").a((Number) ewVar.q);
        } else if (u.c() && ewVar.r != null && ewVar.s != null && he.a.equals(ewVar.r)) {
            b.a(u.a(ewVar.s.longValue()));
            b.a("systime").a((Number) ewVar.p);
        } else {
            b.a((Number) ewVar.p);
        }
        if (ewVar.t != null) {
            b.a("duration").a((Number) ewVar.t);
        }
        if (!z && ewVar.u != null) {
            b.a("info").a((bg) new bh(a(ewVar.u)));
        }
        if (!z2 && ewVar.v != null) {
            b.a("app").a((bg) new bh(a(ewVar.v)));
        }
        if (!z3 && ewVar.w != null) {
            b.a("user").a((bg) new bh(a(ewVar.w, ewVar)));
        }
        if (ewVar.y != null) {
            b.a("event_seq").a((Number) ewVar.y);
        }
        if (ewVar.z != null) {
            bc a = b.a("event_prev");
            ey eyVar = ewVar.z;
            bc b2 = new bc().c().a(SharedKt.PARAM_TYPE).b(a(eyVar.e)).a(MediationMetaData.KEY_NAME).b(eyVar.f);
            if (eyVar.g != null) {
                b2.a("category").b(eyVar.g);
            }
            a.a((bg) new bh(b2.d().toString()));
        }
        if (ewVar.A != null) {
            bc a2 = b.a("purchase");
            fe feVar = ewVar.A;
            bc b3 = new bc().c().a("product_id").b(feVar.h);
            if (feVar.i != null) {
                b3.a("product_quantity").a((Number) feVar.i);
            }
            if (feVar.j != null) {
                b3.a("product_price").a((Number) feVar.j);
            }
            if (feVar.k != null) {
                b3.a("product_price_currency").b(feVar.k);
            }
            if (feVar.s != null) {
                b3.a("currency_price").b(feVar.s);
            }
            if (feVar.l != null) {
                b3.a("product_type").b(feVar.l);
            }
            if (feVar.m != null) {
                b3.a("product_title").b(feVar.m);
            }
            if (feVar.n != null) {
                b3.a("product_description").b(feVar.n);
            }
            if (feVar.o != null) {
                b3.a("transaction_id").b(feVar.o);
            }
            if (feVar.p != null) {
                b3.a("transaction_state").a((Number) feVar.p);
            }
            if (feVar.q != null) {
                b3.a("transaction_date").a((Number) feVar.q);
            }
            if (feVar.r != null) {
                b3.a("campaign_id").b(feVar.r);
            }
            if (feVar.t != null) {
                b3.a(TransactionDetailsUtilities.RECEIPT).b(feVar.t);
            }
            if (feVar.u != null) {
                b3.a(InAppPurchaseMetaData.KEY_SIGNATURE).b(feVar.u);
            }
            a2.a((bg) new bh(b3.d().toString()));
        }
        if (ewVar.B != null) {
            b.a(OkListenerKt.KEY_EXCEPTION).b(ewVar.B);
        }
        try {
            if (ewVar.D != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (ewVar.C != null) {
                    bi.b(ewVar.C).a(linkedHashMap);
                }
                fd fdVar = ewVar.D;
                if (fdVar.d != null) {
                    linkedHashMap.put("fq7_change", fdVar.d);
                }
                if (fdVar.e != null) {
                    linkedHashMap.put("fq30_change", fdVar.e);
                }
                if (fdVar.f != null) {
                    linkedHashMap.put("push_id", fdVar.f);
                }
                b.a("meta").a((Map) linkedHashMap);
            } else if (ewVar.C != null) {
                b.a("meta").a((bg) new bh(ewVar.C));
            }
        } catch (IOException unused) {
        }
        if (ewVar.I != null) {
            b.a("dimensions").a((bg) new bh(ewVar.I));
        }
        if (ewVar.J != null) {
            b.a("count").a((Number) ewVar.J);
        }
        if (ewVar.K != null) {
            b.a("first_time").a((Number) ewVar.K);
        }
        if (ewVar.L != null) {
            b.a("last_time").a((Number) ewVar.L);
        }
        if (ewVar.E != null) {
            b.a("category").b(ewVar.E);
        }
        if (ewVar.F != null) {
            b.a("p1").b(ewVar.F);
        }
        if (ewVar.G != null) {
            b.a("p2").b(ewVar.G);
        }
        if (ewVar.H.size() > 0) {
            b.a("values").c();
            for (fa faVar : ewVar.H) {
                b.a(faVar.e).a((Number) faVar.f);
            }
            b.d();
        }
        return b.d().toString();
    }

    public static String a(ex exVar) {
        boolean z;
        boolean z2;
        bc a = new bc().a();
        fb fbVar = null;
        ev evVar = null;
        fi fiVar = null;
        for (ew ewVar : exVar.d) {
            boolean z3 = true;
            if (fbVar == null || !fbVar.equals(ewVar.u)) {
                fbVar = ewVar.u;
                z = false;
            } else {
                z = true;
            }
            if (evVar == null || !evVar.equals(ewVar.v)) {
                evVar = ewVar.v;
                z2 = false;
            } else {
                z2 = true;
            }
            if (fiVar == null || !fiVar.equals(ewVar.w)) {
                fiVar = ewVar.w;
                z3 = false;
            }
            a.a((bg) new bh(a(ewVar, z, z2, z3)));
        }
        return a.b().toString();
    }

    /* renamed from: com.tapjoy.internal.hr$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ez.values().length];
            a = iArr;
            try {
                iArr[ez.APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ez.CAMPAIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ez.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ez.USAGES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static String a(ez ezVar) {
        int i = AnonymousClass1.a[ezVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "campaign";
            }
            if (i == 3) {
                return "custom";
            }
            if (i != 4) {
                throw new RuntimeException();
            }
            return "usages";
        }
        return "app";
    }
}
