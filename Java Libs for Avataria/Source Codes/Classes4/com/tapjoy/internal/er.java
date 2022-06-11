package com.tapjoy.internal;

import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public final class er {
    public static String b = "";
    public TJAdUnitJSBridge a;
    private cm c;
    private cn d;
    private cv e;
    private cy f;

    public er(TJAdUnitJSBridge tJAdUnitJSBridge) {
        String version = Tapjoy.getVersion();
        dp.a("Tapjoy", "Name is null or empty");
        dp.a(version, "Version is null or empty");
        this.e = new cv("Tapjoy", version);
        this.a = tJAdUnitJSBridge;
    }

    /* renamed from: com.tapjoy.internal.er$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ String b;

        public AnonymousClass1(JSONObject jSONObject, String str) {
            er.this = r1;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!cf.b()) {
                    cf.a(er.this.a.b.getContext());
                }
                if (cf.b()) {
                    TapjoyLog.d("TJOMViewabilityAgent", "initialized");
                    List b = er.b(this.a.optJSONArray("vendors"));
                    cv cvVar = er.this.e;
                    String str = er.b;
                    dp.a(cvVar, "Partner is null");
                    dp.a((Object) str, "OM SDK JS script content is null");
                    dp.a(b, "VerificationScriptResources is null");
                    cp cpVar = new cp(cvVar, str, b, "", "", cq.NATIVE);
                    cr crVar = cr.VIDEO;
                    ct ctVar = ct.BEGIN_TO_RENDER;
                    cu cuVar = cu.NATIVE;
                    dp.a(crVar, "CreativeType is null");
                    dp.a(ctVar, "ImpressionType is null");
                    dp.a(cuVar, "Impression owner is null");
                    if (cuVar != cu.NONE) {
                        if (crVar == cr.DEFINED_BY_JAVASCRIPT && cuVar == cu.NATIVE) {
                            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
                        }
                        if (ctVar == ct.DEFINED_BY_JAVASCRIPT && cuVar == cu.NATIVE) {
                            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
                        }
                        co coVar = new co(crVar, ctVar, cuVar, cuVar);
                        er erVar = er.this;
                        if (cf.b()) {
                            dp.a(coVar, "AdSessionConfiguration is null");
                            dp.a(cpVar, "AdSessionContext is null");
                            erVar.d = new cx(coVar, cpVar);
                            er.this.d.a(er.this.a.a.getWebView());
                            er erVar2 = er.this;
                            cn cnVar = erVar2.d;
                            cx cxVar = (cx) cnVar;
                            dp.a(cnVar, "AdSession is null");
                            if (!(cu.NATIVE == cxVar.a.b)) {
                                throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
                            }
                            if (!cxVar.d) {
                                dp.a(cxVar);
                                if (cxVar.c.b == null) {
                                    cy cyVar = new cy(cxVar);
                                    cxVar.c.b = cyVar;
                                    erVar2.f = cyVar;
                                    er erVar3 = er.this;
                                    cn cnVar2 = erVar3.d;
                                    cx cxVar2 = (cx) cnVar2;
                                    dp.a(cnVar2, "AdSession is null");
                                    if (cxVar2.c.a == null) {
                                        dp.a(cxVar2);
                                        cm cmVar = new cm(cxVar2);
                                        cxVar2.c.a = cmVar;
                                        erVar3.c = cmVar;
                                        er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.TRUE});
                                        return;
                                    }
                                    throw new IllegalStateException("AdEvents already exists for AdSession");
                                }
                                throw new IllegalStateException("MediaEvents already exists for AdSession");
                            }
                            throw new IllegalStateException("AdSession is started");
                        }
                        throw new IllegalStateException("Method called before OM SDK activation");
                    }
                    throw new IllegalArgumentException("Impression owner is none");
                }
                TapjoyLog.d("TJOMViewabilityAgent", "Failed to initialize");
                er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.FALSE});
            } catch (Exception e) {
                TapjoyLog.d("TJOMViewabilityAgent", "Failed to init with exception: " + e.getMessage());
                er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.FALSE});
            }
        }
    }

    /* renamed from: com.tapjoy.internal.er$2 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
            er.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                er.this.d.a();
            } catch (Exception e) {
                TapjoyLog.d("TJOMViewabilityAgent", "Failed to start with exception: " + e.getMessage());
            }
        }
    }

    /* renamed from: com.tapjoy.internal.er$3 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        public AnonymousClass3(String str, String str2) {
            er.this = r1;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a.equals("rendered")) {
                    cm cmVar = er.this.c;
                    cz czVar = cz.STANDALONE;
                    dp.a(czVar, "Position is null");
                    da daVar = new da(czVar);
                    dp.a(daVar, "VastProperties is null");
                    dp.b(cmVar.a);
                    dp.c(cmVar.a);
                    cx cxVar = cmVar.a;
                    JSONObject a = daVar.a();
                    if (cxVar.h) {
                        throw new IllegalStateException("Loaded event can only be sent once");
                    }
                    dg.a().a(cxVar.c.c(), "publishLoadedEvent", a);
                    cxVar.h = true;
                    cm cmVar2 = er.this.c;
                    dp.a(cmVar2.a);
                    dp.c(cmVar2.a);
                    if (!cmVar2.a.d()) {
                        try {
                            cmVar2.a.a();
                        } catch (Exception unused) {
                        }
                    }
                    if (cmVar2.a.d()) {
                        cx cxVar2 = cmVar2.a;
                        if (cxVar2.g) {
                            throw new IllegalStateException("Impression event can only be sent once");
                        }
                        dg.a().a(cxVar2.c.c(), "publishImpressionEvent", new Object[0]);
                        cxVar2.g = true;
                    }
                } else if (this.a.equals("bufferStart")) {
                    cy cyVar = er.this.f;
                    dp.b(cyVar.a);
                    cyVar.a.c.a("bufferStart");
                } else if (this.a.equals("bufferEnd")) {
                    cy cyVar2 = er.this.f;
                    dp.b(cyVar2.a);
                    cyVar2.a.c.a("bufferFinish");
                } else {
                    float f = 1.0f;
                    if (this.a.equals("start")) {
                        if (er.this.a.a.isMuted()) {
                            f = 0.0f;
                        }
                        cy cyVar3 = er.this.f;
                        float duration = er.this.a.a.getVideoView().getDuration();
                        if (duration > 0.0f) {
                            cy.a(f);
                            dp.b(cyVar3.a);
                            JSONObject jSONObject = new JSONObject();
                            dn.a(jSONObject, "duration", Float.valueOf(duration));
                            dn.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
                            dn.a(jSONObject, "deviceVolume", Float.valueOf(dh.a().a));
                            cyVar3.a.c.a("start", jSONObject);
                        } else {
                            throw new IllegalArgumentException("Invalid Media duration");
                        }
                    } else if (this.a.equals("firstQuartile")) {
                        cy cyVar4 = er.this.f;
                        dp.b(cyVar4.a);
                        cyVar4.a.c.a("firstQuartile");
                    } else if (this.a.equals("midpoint")) {
                        cy cyVar5 = er.this.f;
                        dp.b(cyVar5.a);
                        cyVar5.a.c.a("midpoint");
                    } else if (this.a.equals("thirdQuartile")) {
                        cy cyVar6 = er.this.f;
                        dp.b(cyVar6.a);
                        cyVar6.a.c.a("thirdQuartile");
                    } else if (this.a.equals("paused")) {
                        cy cyVar7 = er.this.f;
                        dp.b(cyVar7.a);
                        cyVar7.a.c.a("pause");
                    } else if (this.a.equals("playing")) {
                        cy cyVar8 = er.this.f;
                        dp.b(cyVar8.a);
                        cyVar8.a.c.a("resume");
                    } else if (this.a.equals("skipped")) {
                        cy cyVar9 = er.this.f;
                        dp.b(cyVar9.a);
                        cyVar9.a.c.a("skipped");
                    } else if (this.a.equals("volumeChanged")) {
                        if (er.this.a.a.isMuted()) {
                            f = 0.0f;
                        }
                        cy cyVar10 = er.this.f;
                        cy.a(f);
                        dp.b(cyVar10.a);
                        JSONObject jSONObject2 = new JSONObject();
                        dn.a(jSONObject2, "mediaPlayerVolume", Float.valueOf(f));
                        dn.a(jSONObject2, "deviceVolume", Float.valueOf(dh.a().a));
                        cyVar10.a.c.a("volumeChange", jSONObject2);
                    } else if (this.a.equals("complete")) {
                        cy cyVar11 = er.this.f;
                        dp.b(cyVar11.a);
                        cyVar11.a.c.a("complete");
                        er.this.d.b();
                        er.this.d = null;
                    } else {
                        TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + this.a + "' not found");
                        er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.FALSE});
                        return;
                    }
                }
                TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent: event name '" + this.a + "'");
                er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.TRUE});
            } catch (Exception e) {
                TapjoyLog.d("TJOMViewabilityAgent", "triggerEvent exception:" + e.getMessage());
                er.this.a.invokeJSCallback(this.b, new Object[]{Boolean.FALSE});
            }
        }
    }

    public final boolean a(JSONObject jSONObject) {
        if (this.a.b == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- WebView is null");
            return false;
        } else if (this.a.a == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- TJAdUnit is null");
            return false;
        } else if (this.a.a.getVideoView() == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- VideoView is null");
            return false;
        } else if (jSONObject == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- json parameter is null");
            return false;
        } else if (!jSONObject.has("omJavaScriptURL")) {
            TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- unable to parse om javascript url from json");
            return false;
        } else {
            try {
                jSONObject.getJSONArray("vendors");
                return true;
            } catch (JSONException unused) {
                TapjoyLog.d("TJOMViewabilityAgent", "Can not init -- unable to parse vendors from json");
                return false;
            }
        }
    }

    public static List<cw> b(JSONArray jSONArray) {
        cw cwVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("vendorJSResource", null);
                if (optString == null) {
                    TapjoyLog.d("TJOMViewabilityAgent", "Vendor JS URL not found. Skipping.");
                } else {
                    try {
                        URL url = new URL(optString);
                        String optString2 = jSONObject.optString("vendorName", null);
                        String optString3 = jSONObject.optString("vendorParameters", null);
                        if (optString3 == null || optString2 == null) {
                            dp.a(url, "ResourceURL is null");
                            cwVar = new cw(null, url, null);
                        } else {
                            dp.a(optString2, "VendorKey is null or empty");
                            dp.a(url, "ResourceURL is null");
                            dp.a(optString3, "VerificationParameters is null or empty");
                            cwVar = new cw(optString2, url, optString3);
                        }
                        arrayList.add(cwVar);
                    } catch (Exception unused) {
                        TapjoyLog.d("TJOMViewabilityAgent", "Malformed vendor JS URL. Skipping ".concat(String.valueOf(optString)));
                    }
                }
            } catch (JSONException unused2) {
                TapjoyLog.d("TJOMViewabilityAgent", "Malformed vendor object. Skipping.");
            }
        }
        return arrayList;
    }

    public static void b(JSONObject jSONObject) {
        if (!ag.a(b)) {
            return;
        }
        String optString = jSONObject.optString("omJavaScriptURL", null);
        if (optString == null) {
            TapjoyLog.d("TJOMViewabilityAgent", "Open Mediation JavaScript name not found in json.");
            return;
        }
        try {
            TapjoyCachedAssetData cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
            String str = "";
            if (cachedDataForURL == null) {
                TapjoyCache.getInstance().cacheAssetFromURL(optString, str, 30L).get();
                cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
            }
            if (cachedDataForURL != null) {
                str = TapjoyUtil.getFileContents(new File(cachedDataForURL.getLocalFilePath()));
            }
            b = str;
        } catch (Exception unused) {
            TapjoyLog.d("TJOMViewabilityAgent", "Failed downloading Open Mediation JavaScript");
        }
    }
}
