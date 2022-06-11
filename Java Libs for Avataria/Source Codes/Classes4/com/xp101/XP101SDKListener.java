package com.xp101;

import android.app.Activity;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPListener;
import com.platform101xp.sdk.Platform101XPMessage;
import com.platform101xp.sdk.Platform101XPProduct;
import com.platform101xp.sdk.Platform101XPPurchase;
import com.platform101xp.sdk.Platform101XPToken;
import com.platform101xp.sdk.entities.Platform101XPSocialFriend;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.vungle.warren.model.CacheBustDBAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cocos2dx.lib.Cocos2dxHelper;
import ru.ok.android.sdk.SharedKt;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class XP101SDKListener implements Platform101XPListener {
    private static HashMap<String, Platform101XPProduct> availableProducts = new HashMap<>();
    private static boolean billingIsReady = false;
    private static int lastInitializeStatus = 0;

    public static void doSendFabricEvent(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnAuth(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnGotInfo(String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnInitializeResult(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnPurchase(boolean z, String str);

    public void onGetAnalyticsConversionData(Map map) {
    }

    public void onGetSocialFriendsResult(List<Platform101XPSocialFriend> list, Platform101XPError platform101XPError) {
    }

    public void onInviteResult(Platform101XPError platform101XPError) {
    }

    public void onMessageReceived(Platform101XPMessage platform101XPMessage) {
    }

    public void onOfferwallAdCredits(Map<String, String> map, Platform101XPError platform101XPError) {
    }

    public void onOfferwallAdLoaded() {
    }

    public void onRewardedAdLoaded() {
    }

    public void onRewardedAdShowed(int i, String str, Platform101XPError platform101XPError) {
    }

    public void onRewardedInvite(String str) {
    }

    public boolean onRewardedInviteLinkRecipient(String str, String str2) {
        return false;
    }

    public void onRewardedInviteLinkSender(String str) {
    }

    public void onAuthorizeResult(Platform101XPToken platform101XPToken, Platform101XPError platform101XPError) {
        String str;
        if (platform101XPError == null) {
            str = "onAuthorizeResult: Success!";
        } else {
            str = "onAuthorizeResult: Error! " + platform101XPError.toString();
        }
        showMessage(str);
        if (platform101XPToken == null) {
            showMessage("Token is null");
        }
        if (platform101XPError == null && !getAccessToken().isEmpty()) {
            Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XP101SDKListener.nativeOnAuth(0);
                    } catch (Exception unused) {
                    }
                }
            });
            return;
        }
        int i = 2;
        int i2 = platform101XPError == null ? 2 : 0;
        if (i2 == 0) {
            int i3 = AnonymousClass18.$SwitchMap$com$platform101xp$sdk$Platform101XPError$ErrorType[platform101XPError.getErrorType().ordinal()];
            if (i3 == 1) {
                i = 1;
            } else if (i3 == 2) {
                i = 3;
            }
        } else {
            i = i2;
        }
        Cocos2dxHelper.runOnGLThread(new C1DoPurchaseRunner(i));
        showMessage("~onAuthorizeResult: !!!!! ERROR: " + i + " !!!!!");
    }

    /* renamed from: com.xp101.XP101SDKListener$18  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$platform101xp$sdk$Platform101XPError$ErrorType;

        static {
            int[] iArr = new int[Platform101XPError.ErrorType.values().length];
            $SwitchMap$com$platform101xp$sdk$Platform101XPError$ErrorType = iArr;
            try {
                iArr[Platform101XPError.ErrorType.ERROR_CANCELED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$platform101xp$sdk$Platform101XPError$ErrorType[Platform101XPError.ErrorType.ERROR_CONNECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1DoPurchaseRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1DoPurchaseRunner implements Runnable {
        private int _code;

        private C1DoPurchaseRunner(int i) {
            this._code = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            XP101SDKListener.nativeOnAuth(this._code);
        }
    }

    public static void doRequestProducts() {
        if (!billingIsReady) {
            return;
        }
        if (availableProducts.isEmpty()) {
            if (Platform101XP.getCurrentActivity() == null) {
                return;
            }
            Platform101XP.getCurrentActivity().runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Platform101XP.getProducts((List) null);
                    } catch (Exception e) {
                        Log.d("AVA", "Platform101XP.getProducts", e);
                    }
                }
            });
            return;
        }
        getInfo();
    }

    public void onBillingInitializeResult(Platform101XPError platform101XPError) {
        String str;
        if (platform101XPError == null) {
            str = "Billing is available!";
        } else {
            str = "Error onBillingInitializeResult: " + platform101XPError.toString();
        }
        showMessage(str);
        billingIsReady = platform101XPError == null;
    }

    public void onGetProductsResult(List<Platform101XPProduct> list, Platform101XPError platform101XPError) {
        if (platform101XPError != null) {
            showMessage("Error onGetProductsResult: " + platform101XPError.toString());
            return;
        }
        for (Platform101XPProduct platform101XPProduct : list) {
            availableProducts.put(platform101XPProduct.getProductId(), platform101XPProduct);
        }
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XP101SDKListener.showMessage("GetInfo: runner started");
                    for (Map.Entry entry : XP101SDKListener.availableProducts.entrySet()) {
                        Platform101XPProduct platform101XPProduct2 = (Platform101XPProduct) entry.getValue();
                        if (platform101XPProduct2 != null) {
                            XP101SDKListener.nativeOnGotInfo(platform101XPProduct2.getProductId(), platform101XPProduct2.getPriceValue(), platform101XPProduct2.getCurrencyCode());
                        } else {
                            XP101SDKListener.showMessage("GetInfo: product is null");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Platform101XP.restoreProducts();
    }

    public void onPurchaseProductResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError) {
        showMessage("onPurchaseProductResult...");
        if (platform101XPError != null) {
            showMessage("Error onPurchaseProductResult: " + platform101XPError.toString());
            if (platform101XPError.getErrorType() == Platform101XPError.ErrorType.ERROR_CANCELED) {
                showMessage("Error onPurchaseProductResult: CANCELED");
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            XP101SDKListener.nativeOnPurchase(false, "");
                        } catch (Exception unused) {
                        }
                    }
                });
                return;
            }
            showMessage("Error onPurchaseProductResult: ERROR");
            Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XP101SDKListener.nativeOnPurchase(false, "inappError");
                    } catch (Exception unused) {
                    }
                }
            });
            return;
        }
        Platform101XP.finishPurchase(platform101XPPurchase);
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XP101SDKListener.nativeOnPurchase(true, "inappSuccess");
                } catch (Exception unused) {
                }
            }
        });
    }

    public void onFinishPurchaseResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError) {
        if (platform101XPError != null) {
            showMessage("Error onFinishPurchaseResult: " + platform101XPError.toString());
            return;
        }
        showMessage("Consumed!");
    }

    public void onLogout() {
        showMessage("onLogout");
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XP101SDKListener.nativeOnAuth(1);
                } catch (Exception unused) {
                }
            }
        });
    }

    public void onInitializeResult(Platform101XPError platform101XPError) {
        if (platform101XPError != null) {
            try {
                doSendException("SDK Initialize failed, OnInitializeResult: " + platform101XPError.toString());
                showMessage("onInitializeResult: " + platform101XPError.toString());
            } catch (Exception unused) {
            }
            if (AnonymousClass18.$SwitchMap$com$platform101xp$sdk$Platform101XPError$ErrorType[platform101XPError.getErrorType().ordinal()] == 2) {
                lastInitializeStatus = 2;
            } else {
                lastInitializeStatus = 3;
            }
        } else {
            lastInitializeStatus = 1;
        }
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XP101SDKListener.nativeOnInitializeResult(XP101SDKListener.lastInitializeStatus);
                } catch (Exception e) {
                    Log.d("AVA", "nativeOnInitializeResult", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showMessage(String str) {
        Log.d("XP101SDKListener", str);
    }

    public static void doPurchase(String str, String str2, String str3) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
            Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XP101SDKListener.nativeOnPurchase(false, "somethingWentWrong");
                    } catch (Exception unused) {
                    }
                }
            });
            return;
        }
        showMessage("DoPurchase: " + str);
        if (billingIsReady && Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C2DoPurchaseRunner(str, str3, str2));
        } else {
            Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XP101SDKListener.nativeOnPurchase(false, "somethingWentWrong");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$2DoPurchaseRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C2DoPurchaseRunner implements Runnable {
        private String _productId;
        private String _serverId;
        private String _userId;

        private C2DoPurchaseRunner(String str, String str2, String str3) {
            this._productId = str;
            this._serverId = str2;
            this._userId = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Platform101XPProduct productById = Platform101XP.getProductById(this._productId);
                if (productById == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._userId);
                Platform101XP.purchaseProduct(productById, this._serverId, hashMap);
            } catch (Exception e) {
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.2DoPurchaseRunner.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            XP101SDKListener.nativeOnPurchase(false, "somethingWentWrong");
                        } catch (Exception unused) {
                        }
                    }
                });
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(SharedKt.PARAM_METHOD, "Platform101XP.doPurchase");
                    hashMap2.put("line", "440");
                    hashMap2.put("file", "XP101SDKListener");
                    Platform101XP.analyticsTrack("critical_exception", hashMap2);
                    Log.d("AVA", "Platform101XP.getProductById", e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void getInfo() {
        showMessage("GetInfo");
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XP101SDKListener.showMessage("GetInfo: runner started");
                    for (Map.Entry entry : XP101SDKListener.availableProducts.entrySet()) {
                        Platform101XPProduct platform101XPProduct = (Platform101XPProduct) entry.getValue();
                        if (platform101XPProduct != null) {
                            XP101SDKListener.nativeOnGotInfo(platform101XPProduct.getProductId(), platform101XPProduct.getPriceValue(), platform101XPProduct.getCurrencyCode());
                        } else {
                            Log.d("XP101SDKListener", "GetInfo: product is null");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void doAuthAuto() {
        showMessage("DoAuthAuto");
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Platform101XP.authorize();
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void doAuthManual() {
        showMessage("DoAuthManual");
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Platform101XP.managedAuthorize();
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public static void doRefund() {
        showMessage("DoRefund");
        if (billingIsReady && Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Platform101XP.restoreProducts();
                    } catch (Exception e) {
                        Log.d("AVA", " Platform101XP.restoreProducts", e);
                    }
                }
            });
        } else {
            Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: com.xp101.XP101SDKListener.15
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        XP101SDKListener.nativeOnPurchase(false, "somethingWentWrong");
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackLoginRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackLoginRunner implements Runnable {
        private String _locale;
        private String _serverId;
        private String _uid;

        private C1TrackLoginRunner(String str, String str2, String str3) {
            this._uid = str;
            this._serverId = str2;
            this._locale = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                hashMap.put("locale", this._locale);
                Platform101XP.analyticsTrack("af_login", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackLogin(String str, String str2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackLoginRunner(str, str2, str3));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackDisconnectRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackDisconnectRunner implements Runnable {
        private String _reason;
        private String _serverId;
        private String _uid;

        private C1TrackDisconnectRunner(String str, String str2, String str3) {
            this._uid = str2;
            this._reason = str;
            this._serverId = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put("reason", this._reason);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                Platform101XP.analyticsTrack("af_disconnect", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackDisconnect(String str, String str2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackDisconnectRunner(str3, str, str2));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackQuestRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackQuestRunner implements Runnable {
        private String _quest;
        private String _serverId;
        private String _uid;

        private C1TrackQuestRunner(String str, String str2, String str3) {
            this._uid = str2;
            this._quest = str;
            this._serverId = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put("quest_id", this._quest);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                Platform101XP.analyticsTrack("quest", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackQuest(String str, String str2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackQuestRunner(str, str2, str3));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackLevelRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackLevelRunner implements Runnable {
        private String _lvl;
        private String _serverId;
        private String _uid;

        private C1TrackLevelRunner(String str, String str2, String str3) {
            this._uid = str2;
            this._lvl = str;
            this._serverId = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put("af_level", this._lvl);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                Platform101XP.analyticsTrack("af_level_achieved", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackLevel(String str, String str2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackLevelRunner(str, str2, str3));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackTutorialRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackTutorialRunner implements Runnable {
        private String _gender;
        private String _serverId;
        private String _step;
        private String _uid;

        private C1TrackTutorialRunner(String str, String str2, String str3, String str4) {
            this._uid = str2;
            this._step = str;
            this._serverId = str3;
            this._gender = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put("step_id", this._step);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                hashMap.put("gender", this._gender);
                Platform101XP.analyticsTrack("tutorial_step", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackTutorial(String str, String str2, String str3, String str4) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackTutorialRunner(str, str2, str3, str4));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$2TrackTutorialRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C2TrackTutorialRunner implements Runnable {
        private String _gender;
        private String _params;
        private String _serverId;
        private String _step;
        private String _uid;

        private C2TrackTutorialRunner(String str, String str2, String str3, String str4, String str5) {
            this._uid = str2;
            this._step = str;
            this._serverId = str3;
            this._gender = str4;
            this._params = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put("step_id", this._step);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                hashMap.put("gender", this._gender);
                String[] split = this._params.split("\\|");
                for (int i = 0; i < split.length; i += 2) {
                    int i2 = i + 1;
                    if (i2 < split.length) {
                        hashMap.put(split[i], split[i2]);
                    }
                }
                Platform101XP.analyticsTrack("tutorial_step", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackTutorialParams(String str, String str2, String str3, String str4, String str5) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C2TrackTutorialRunner(str, str2, str3, str4, str5));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackTutorialCompleteRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackTutorialCompleteRunner implements Runnable {
        private String _gender;
        private String _serverId;
        private String _uid;

        private C1TrackTutorialCompleteRunner(String str, String str2, String str3) {
            this._uid = str;
            this._serverId = str2;
            this._gender = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this._uid);
                hashMap.put(PlayerMetaData.KEY_SERVER_ID, this._serverId);
                hashMap.put("gender", this._gender);
                Platform101XP.analyticsTrack("af_tutorial_completion", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackTutorialComplete(String str, String str2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackTutorialCompleteRunner(str, str2, str3));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackEventTimeRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackEventTimeRunner implements Runnable {
        private String _eventType;
        private String _playerId;
        private int _startTime;
        private int _time;
        private String _version;

        private C1TrackEventTimeRunner(String str, int i, String str2, int i2, String str3) {
            this._eventType = str;
            this._time = i;
            this._playerId = str2;
            this._startTime = i2;
            this._version = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_time", Integer.valueOf(this._time));
                hashMap.put("playerId", this._playerId);
                hashMap.put("download_start_time", Integer.valueOf(this._startTime));
                hashMap.put("app_version", this._version);
                Platform101XP.analyticsTrack(this._eventType, hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackEventTime(String str, int i, String str2, int i2, String str3) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackEventTimeRunner(str, i, str2, i2, str3));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackOfferRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackOfferRunner implements Runnable {
        private String m_eventType;
        private String m_gender;
        private int m_offerId;
        private String m_paymentType;
        private String m_playerId;
        private int m_playerLvl;
        private String m_price;

        private C1TrackOfferRunner(String str, String str2, int i, int i2, String str3, String str4, String str5) {
            this.m_eventType = str;
            this.m_playerId = str2;
            this.m_offerId = i;
            this.m_playerLvl = i2;
            this.m_gender = str3;
            this.m_paymentType = str4;
            this.m_price = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this.m_playerId);
                hashMap.put("offer_id", Integer.valueOf(this.m_offerId));
                hashMap.put("player_level", Integer.valueOf(this.m_playerLvl));
                hashMap.put("gender", this.m_gender);
                hashMap.put("payment_type", this.m_paymentType);
                hashMap.put("price", this.m_price);
                Platform101XP.analyticsTrack(this.m_eventType, hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackOffer(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackOfferRunner(str, str2, i, i2, str3, str4, str5));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackErrorRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackErrorRunner implements Runnable {
        private String m_buildNumber;
        private String m_eventName;
        private String m_platform;
        private String m_playerId;

        private C1TrackErrorRunner(String str, String str2, String str3, String str4) {
            this.m_eventName = str;
            this.m_platform = str2;
            this.m_buildNumber = str3;
            this.m_playerId = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("player_id", this.m_playerId);
                hashMap.put(SharedKt.PARAM_PLATFORM, this.m_platform);
                hashMap.put("build_number", this.m_buildNumber);
                Platform101XP.analyticsTrack(this.m_eventName, hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackError(String str, String str2, String str3, String str4) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackErrorRunner(str, str2, str3, str4));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackWaterPistolResultRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackWaterPistolResultRunner implements Runnable {
        private String m_defence;
        private String m_id;
        private String m_pistol;
        private int m_points;
        private String m_result;
        private int m_time;

        private C1TrackWaterPistolResultRunner(int i, String str, String str2, String str3, String str4, int i2) {
            this.m_id = str;
            this.m_pistol = str2;
            this.m_defence = str3;
            this.m_result = str4;
            this.m_time = i;
            this.m_points = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("time", Integer.valueOf(this.m_time));
                hashMap.put(CacheBustDBAdapter.CacheBustColumns.COLUMN_EVENT_ID, this.m_id);
                hashMap.put("pistol", this.m_pistol);
                hashMap.put("defence", this.m_defence);
                hashMap.put("result", this.m_result);
                hashMap.put("points", Integer.valueOf(this.m_points));
                Platform101XP.analyticsTrack("waterpistolEvent", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackWaterPistolResult(int i, String str, String str2, String str3, String str4, int i2) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackWaterPistolResultRunner(i, str, str2, str3, str4, i2));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackWaterPistolMoveRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackWaterPistolMoveRunner implements Runnable {
        private int m_move;
        private int m_time;
        private boolean m_timer;
        private String m_userId;

        private C1TrackWaterPistolMoveRunner(String str, int i, int i2, boolean z) {
            this.m_userId = str;
            this.m_time = i;
            this.m_move = i2;
            this.m_timer = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("userId", this.m_userId);
                hashMap.put("time", Integer.valueOf(this.m_time));
                hashMap.put("move", Integer.valueOf(this.m_move));
                hashMap.put("timer", Boolean.valueOf(this.m_timer));
                Platform101XP.analyticsTrack("waterpistolMoveEvent", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackWaterPistolMove(String str, int i, int i2, boolean z) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackWaterPistolMoveRunner(str, i, i2, z));
        }
    }

    /* renamed from: com.xp101.XP101SDKListener$1TrackPromoDialogRunner  reason: invalid class name */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
    class C1TrackPromoDialogRunner implements Runnable {
        private String m_promoId;
        private String m_userId;

        private C1TrackPromoDialogRunner(String str, String str2) {
            this.m_userId = str;
            this.m_promoId = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("userId", this.m_userId);
                hashMap.put("promoId", this.m_promoId);
                Platform101XP.analyticsTrack("promoDialogEvent", hashMap);
            } catch (Exception unused) {
            }
        }
    }

    public static void doTrackPromoDialog(String str, String str2) {
        if (Platform101XP.getCurrentActivity() != null) {
            Platform101XP.getCurrentActivity().runOnUiThread(new C1TrackPromoDialogRunner(str, str2));
        }
    }

    public static void doSendException(String str) {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        firebaseCrashlytics.log("Exception: " + str);
        firebaseCrashlytics.recordException(new Exception(str));
    }

    public static String getAccessToken() {
        Platform101XPToken token = Platform101XP.getToken();
        return token != null ? token.getAccessToken().getId() : "";
    }

    public static int getInitializeStatus() {
        if (Platform101XP.isInitialized()) {
            return 1;
        }
        return lastInitializeStatus;
    }

    public static void showApplicationReview() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Platform101XP.applicationReview();
                } catch (Exception e) {
                    Log.d("AVA", "Platform101XP.applicationReview", e);
                }
            }
        });
    }

    public static void ShowWebStore() {
        Activity currentActivity = Platform101XP.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.xp101.XP101SDKListener.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Platform101XP.showWebStore((Map) null);
                } catch (Exception e) {
                    Log.d("AVA", "Platform101XP.showWebStore", e);
                }
            }
        });
    }
}
