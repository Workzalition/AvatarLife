package com.tapjoy.internal;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJInstallReferrer;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class et extends es {
    private boolean c = false;
    private String d = "";
    private TJCurrency e = null;
    private TapjoyCache f = null;

    @Override // com.tapjoy.internal.es
    public final String b() {
        return "12.8.1";
    }

    @Override // com.tapjoy.internal.es
    public final void a(boolean z) {
        TapjoyLog.setDebugEnabled(z);
    }

    @Override // com.tapjoy.internal.es
    public final boolean a(Context context, String str) {
        return a(context, str, (Hashtable<String, ?>) null, (TJConnectListener) null);
    }

    @Override // com.tapjoy.internal.es
    public synchronized boolean a(final Context context, String str, Hashtable<String, ?> hashtable, final TJConnectListener tJConnectListener) {
        String valueOf;
        if (hashtable != null) {
            Object obj = hashtable.get("TJC_OPTION_ENABLE_LOGGING");
            if (obj != null) {
                TapjoyLog.setDebugEnabled("true".equals(obj.toString()));
            }
        }
        TapjoyConnectCore.setSDKType("event");
        boolean z = false;
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (js.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            FiveRocksIntegration.a();
            try {
                TapjoyAppSettings.init(context);
                TapjoyConnectCore.requestTapjoyConnect(context, str, hashtable, new TJConnectListener() { // from class: com.tapjoy.internal.et.1
                    public final void onConnectSuccess() {
                        et.this.e = new TJCurrency(context);
                        et.this.f = new TapjoyCache(context);
                        try {
                            TJEventOptimizer.init(context);
                            et.this.a = true;
                            TJConnectListener tJConnectListener2 = tJConnectListener;
                            if (tJConnectListener2 == null) {
                                return;
                            }
                            tJConnectListener2.onConnectSuccess();
                        } catch (InterruptedException unused) {
                            onConnectFailure();
                        } catch (RuntimeException e) {
                            TapjoyLog.w("TapjoyAPI", e.getMessage());
                            onConnectFailure();
                        }
                    }

                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectFailure();
                        }
                    }
                });
                this.c = true;
                if (Build.VERSION.SDK_INT < 14) {
                    TapjoyLog.i("TapjoyAPI", "Automatic session tracking is not available on this device.");
                } else {
                    if (hashtable != null && (valueOf = String.valueOf(hashtable.get("TJC_OPTION_DISABLE_AUTOMATIC_SESSION_TRACKING"))) != null && valueOf.equalsIgnoreCase("true")) {
                        z = true;
                    }
                    if (!z) {
                        fm.a(context);
                    } else {
                        TapjoyLog.i("TapjoyAPI", "Automatic session tracking is disabled.");
                    }
                }
                return true;
            } catch (TapjoyIntegrationException e) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.es
    public final synchronized boolean a(final Context context, String str, final TJConnectListener tJConnectListener) {
        TapjoyConnectCore.setSDKType("event");
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else if (js.c(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The limited SDK key is NULL. A valid limited SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                tJConnectListener.onConnectFailure();
            }
            return false;
        } else {
            try {
                TapjoyConnectCore.requestLimitedTapjoyConnect(context, str, new TJConnectListener() { // from class: com.tapjoy.internal.et.2
                    public final void onConnectSuccess() {
                        et.this.f = new TapjoyCache(context);
                        et.this.b = true;
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectSuccess();
                        }
                    }

                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectFailure();
                        }
                    }
                });
                return true;
            } catch (TapjoyIntegrationException e) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            } catch (TapjoyException e2) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e2.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
        }
    }

    @Override // com.tapjoy.internal.es
    public final TJPlacement a(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.a(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.es
    public final TJPlacement b(String str, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.b(str, "", "", tJPlacementListener);
    }

    @Override // com.tapjoy.internal.es
    public final void a(Activity activity) {
        if (activity != null) {
            b.a(activity);
        } else {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
        }
    }

    @Override // com.tapjoy.internal.es
    public final void a(float f) {
        if (l("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f);
        }
    }

    @Override // com.tapjoy.internal.es
    public final float c() {
        if (l("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    @Override // com.tapjoy.internal.es
    public final void e(String str) {
        if (k("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(str);
        }
    }

    @Override // com.tapjoy.internal.es
    public final void a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.e == null || !k("getCurrencyBalance")) {
            return;
        }
        this.e.getCurrencyBalance(tJGetCurrencyBalanceListener);
    }

    @Override // com.tapjoy.internal.es
    public final void a(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.e == null || !k("spendCurrency")) {
            return;
        }
        this.e.spendCurrency(i, tJSpendCurrencyListener);
    }

    @Override // com.tapjoy.internal.es
    public final void a(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.e == null || !k("awardCurrency")) {
            return;
        }
        this.e.awardCurrency(i, tJAwardCurrencyListener);
    }

    @Override // com.tapjoy.internal.es
    public final void a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.e == null || !k("setEarnedCurrencyListener")) {
            return;
        }
        this.e.setEarnedCurrencyListener(tJEarnedCurrencyListener);
    }

    @Override // com.tapjoy.internal.es
    public final void a(TJVideoListener tJVideoListener) {
        if (l("setVideoListener")) {
            TJAdUnit.a = tJVideoListener;
        }
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4) {
        gp.a(str, str2, str3, str4);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2) {
        gp.a(str, null, null, str2);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str) {
        gp.a(null, str, null, null, 0L);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, long j) {
        gp.a(null, str, null, null, j);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, long j) {
        gp.a(str, str2, null, null, j);
    }

    @Override // com.tapjoy.internal.es
    public final void b(String str, String str2, String str3, String str4) {
        gp.a(str, str2, str3, str4, 0L);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4, long j) {
        gp.a(str, str2, str3, str4, j);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        gp.a(str, str2, str3, str4, str5, j, null, 0L, null, 0L);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        gp.a(str, str2, str3, str4, str5, j, str6, j2, null, 0L);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        gp.a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    @Override // com.tapjoy.internal.es
    public final void d() {
        if (l("startSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fm.a();
            }
            TapjoyConnectCore.getInstance().appResume();
            hb.a().f();
        }
    }

    @Override // com.tapjoy.internal.es
    public final void e() {
        if (l("endSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                fm.a();
            }
            hb.a().m = false;
            TapjoyConnectCore.getInstance().appPause();
            hb.a().g();
        }
    }

    @Override // com.tapjoy.internal.es
    public final void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fm.a();
        }
        hb.a().m = true;
        hb.a().a(activity);
    }

    @Override // com.tapjoy.internal.es
    public final void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            fm.a();
        }
        hb.a().b(activity);
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, TJSetUserIDListener tJSetUserIDListener) {
        if (!l("setUserID")) {
            if (tJSetUserIDListener == null) {
                return;
            }
            tJSetUserIDListener.onSetUserIDFailure(this.d);
            return;
        }
        TapjoyConnectCore.setUserID(str, tJSetUserIDListener);
        hb a = hb.a();
        if (!a.d("setUserId")) {
            return;
        }
        a.f.b(gw.a(str));
    }

    @Override // com.tapjoy.internal.es
    public final void j(String str) {
        TapjoyConnectCore.setCustomParameter(str);
    }

    @Override // com.tapjoy.internal.es
    public final String l() {
        return TapjoyConnectCore.getCustomParameter();
    }

    @Override // com.tapjoy.internal.es
    public final Set<String> f() {
        return hb.a().d();
    }

    @Override // com.tapjoy.internal.es
    public final void a(Set<String> set) {
        hb.a().a(set);
    }

    @Override // com.tapjoy.internal.es
    public final void g() {
        hb.a().a((Set) null);
    }

    @Override // com.tapjoy.internal.es
    public final void c(String str) {
        if (js.c(str)) {
            return;
        }
        hb a = hb.a();
        Set d = a.d();
        if (!d.add(str)) {
            return;
        }
        a.a(d);
    }

    @Override // com.tapjoy.internal.es
    public final void d(String str) {
        if (js.c(str)) {
            return;
        }
        hb a = hb.a();
        Set d = a.d();
        if (!d.remove(str)) {
            return;
        }
        a.a(d);
    }

    @Override // com.tapjoy.internal.es
    public final boolean h() {
        hb a = hb.a();
        if (!a.d("isPushNotificationDisabled")) {
            return false;
        }
        boolean f = a.f.f();
        gy.a("isPushNotificationDisabled = {}", Boolean.valueOf(f));
        return f;
    }

    @Override // com.tapjoy.internal.es
    public final void b(boolean z) {
        String str;
        Object[] objArr;
        String str2;
        hb a = hb.a();
        if (a.d("setPushNotificationDisabled")) {
            boolean a2 = a.f.a(z);
            char c = 0;
            String str3 = "setPushNotificationDisabled({}) called, but it is already {}";
            if (a2) {
                objArr = new Object[1];
                str = Boolean.valueOf(z);
                str3 = "setPushNotificationDisabled({}) called";
            } else {
                Object[] objArr2 = new Object[2];
                objArr2[0] = Boolean.valueOf(z);
                str = z ? "disabled" : "enabled";
                objArr = objArr2;
                c = 1;
            }
            objArr[c] = str;
            gy.a(str3, objArr);
            if (!a2 || !a.j || js.c(a.d)) {
                return;
            }
            if (a.n != null) {
                str2 = null;
            } else {
                hd a3 = hd.a(a.e);
                str2 = js.b(a3.b.b(a3.a));
            }
            a.a(str2);
        }
    }

    @Override // com.tapjoy.internal.es
    public final boolean i() {
        return this.a;
    }

    @Override // com.tapjoy.internal.es
    public final boolean j() {
        return this.b;
    }

    @Override // com.tapjoy.internal.es
    public final String g(String str) {
        if (k("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(str);
        }
        return null;
    }

    @Override // com.tapjoy.internal.es
    public final String k() {
        return TapjoyConnectCore.getUserToken();
    }

    @Override // com.tapjoy.internal.es
    public final void i(String str) {
        hb.a().a(str);
    }

    @Override // com.tapjoy.internal.es
    public final void a(Context context, Map<String, String> map) {
        hb a = hb.a();
        if (a.e == null) {
            a.b(context);
        }
        hd.a(a.e);
        Context context2 = a.e;
        String str = map.get("fiverocks");
        if (str != null) {
            if (he.a(context2).f()) {
                hb.a(context2).b(str);
                return;
            }
            String str2 = map.get("title");
            String str3 = map.get(SharedKt.PARAM_MESSAGE);
            if (str3 == null) {
                return;
            }
            String str4 = map.get("rich");
            String str5 = map.get("sound");
            String str6 = map.get("payload");
            String str7 = map.get("always");
            boolean z = "true".equals(str7) || Boolean.TRUE.equals(str7);
            String str8 = map.get("repeatable");
            boolean z2 = "true".equals(str8) || Boolean.TRUE.equals(str8);
            String str9 = map.get("placement");
            int b = hd.b(map.get("nid"));
            String str10 = map.get("channel_id");
            if (!z && hb.a(context2).e()) {
                return;
            }
            Notification a2 = hd.a(context2, str, js.a(str2), str3, hd.a(str4), hd.a(str5), str6, str9, b, str10);
            if (!hb.a(context2).a(context2, str, z2)) {
                return;
            }
            hd.a(context2, b, a2);
        }
    }

    @Override // com.tapjoy.internal.es
    public final void a(Context context) {
        hb a = hb.a();
        if (a.e == null) {
            a.b(context);
        }
        if (!a.c()) {
            throw new TapjoyIntegrationException("InstallReferrerClient APIs aren't available in your project. To use activateInstallReferrerClient() API,`com.android.installreferrer:installreferrer` dependency is required to your project level build.gradle file");
        }
        new TJInstallReferrer().init(context);
    }

    @Override // com.tapjoy.internal.es
    public final void b(Context context, String str) {
        hb a = hb.a();
        if (a.e == null) {
            a.b(context);
        }
        hb.a(a.e, str);
    }

    private boolean k(String str) {
        if (!this.a) {
            TapjoyLog.w("TapjoyAPI", "Can not call " + str + " because Tapjoy SDK has not successfully connected.");
            return false;
        }
        return true;
    }

    private boolean l(String str) {
        if (!this.c) {
            this.d = "Can not call " + str + " because Tapjoy SDK is not initialized.";
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, this.d));
            return false;
        }
        return true;
    }

    @Override // com.tapjoy.internal.es
    public final void c(boolean z) {
        gg.a().a(z);
    }

    @Override // com.tapjoy.internal.es
    public final void h(String str) {
        gg.a().a(str);
    }

    @Override // com.tapjoy.internal.es
    public final void d(boolean z) {
        gg.a().b(z);
    }

    @Override // com.tapjoy.internal.es
    public final TJPrivacyPolicy m() {
        return TJPrivacyPolicy.getInstance();
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, double d, String str3) {
        String a;
        String a2;
        hb a3 = hb.a();
        if (!a3.c("trackPurchase") || (a = gw.a(str, "trackPurchase", "productId")) == null || (a2 = gw.a(str2, "trackPurchase", "currencyCode")) == null) {
            return;
        }
        if (a2.length() != 3) {
            gy.a("trackPurchase", "currencyCode", "invalid currency code");
            return;
        }
        a3.g.a(a, a2.toUpperCase(Locale.US), d, (String) null, (String) null, gw.b(str3));
        gy.a("trackPurchase called");
    }

    @Override // com.tapjoy.internal.es
    public final void a(String str, String str2, String str3, String str4, Map<String, Long> map) {
        hb a = hb.a();
        if (!a.c("trackEvent") || js.c(str2)) {
            return;
        }
        LinkedHashMap b = jw.b();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    if (key instanceof String) {
                        String a2 = gw.a(key, "trackEvent", "key in values map");
                        if (a2 == null) {
                            return;
                        }
                        Long value = entry.getValue();
                        if (value instanceof Number) {
                            b.put(a2, Long.valueOf(value.longValue()));
                        } else {
                            gy.a("trackEvent", "value in values map", "must be a long");
                            return;
                        }
                    }
                } else if (!gy.a) {
                    return;
                } else {
                    w.a("Tapjoy", "{}: {} must not be null", new Object[]{"trackEvent", "key in values map"});
                    return;
                }
            }
        }
        a.g.a(str, str2, str3, str4, b);
        gy.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
    }

    @Override // com.tapjoy.internal.es
    public final void a(int i) {
        hb a = hb.a();
        if (a.d("setUserLevel")) {
            gy.a("setUserLevel({}) called", Integer.valueOf(i));
            a.f.a(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    @Override // com.tapjoy.internal.es
    public final void b(int i) {
        hb a = hb.a();
        if (a.d("setUserFriendCount")) {
            gy.a("setUserFriendCount({}) called", Integer.valueOf(i));
            a.f.b(i >= 0 ? Integer.valueOf(i) : null);
        }
    }

    @Override // com.tapjoy.internal.es
    public final void b(String str) {
        hb a = hb.a();
        if (a.d("setAppDataVersion")) {
            a.f.a(gw.a(str));
        }
    }

    @Override // com.tapjoy.internal.es
    public final void a(int i, String str) {
        hb a = hb.a();
        if (a.d("setUserCohortVariable")) {
            boolean z = i > 0 && i <= 5;
            if (gy.a && !z) {
                gy.b("setCohortVariable: variableIndex is out of range");
            }
            if (!z) {
                return;
            }
            gy.a("setUserCohortVariable({}, {}) called", Integer.valueOf(i), str);
            a.f.a(i, gw.a(str));
        }
    }

    @Override // com.tapjoy.internal.es
    public final void f(String str) {
        hb a = hb.a();
        gy.a("setGcmSender({}) called", str);
        a.d = js.a(str);
        a.b();
    }

    @Override // com.tapjoy.internal.es
    public final void a(GLSurfaceView gLSurfaceView) {
        hb.a();
        hb.a(gLSurfaceView);
    }
}
