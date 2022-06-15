package com.platform101xp.sdk.internal.billing;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPApi;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPProduct;
import com.platform101xp.sdk.Platform101XPPurchase;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelTransaction;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsAppsFlyer;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Platform101XPGoogleBillingManager.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 V2\u00020\u0001:\u0003VWXB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 2\u0006\u0010!\u001a\u00020\u000b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018H\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&H\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001eJ\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0&H\u0002J\u0010\u0010+\u001a\u0004\u0018\u00010\u000b2\u0006\u0010,\u001a\u00020\u0015J\u0016\u0010-\u001a\u00020\u001a2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0018\u0010/\u001a\u00020\u001a2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000101H\u0002J \u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000f2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u0014H\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\u0006\u0010:\u001a\u00020\u0011J\u001e\u0010;\u001a\u0004\u0018\u00010\u00152\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010 J\u0016\u0010=\u001a\u00020\u001a2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0?H\u0002J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020BH\u0002J\u0006\u0010C\u001a\u00020\u001aJ\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010E\u001a\u00020\u001aJ\"\u0010F\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000b2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 J\u001c\u0010G\u001a\u00020\u00152\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 H\u0002J\u0010\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u0015H\u0002J\u0006\u0010J\u001a\u00020\u001aJ\u0010\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020MH\u0002J$\u0010N\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00152\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 H\u0002J\u001a\u0010O\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020B2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0006\u0010R\u001a\u00020\u001aJ\u001c\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 2\u0006\u0010T\u001a\u00020\u0015H\u0002J\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager;", "", "androidBillingClient", "Lcom/platform101xp/sdk/internal/billing/Platform101XPAndroidBillingClient;", "billingListener", "Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$Listener;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "(Lcom/platform101xp/sdk/internal/billing/Platform101XPAndroidBillingClient;Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$Listener;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;)V", "availableProducts", "", "Lcom/platform101xp/sdk/Platform101XPProduct;", "connectionInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "developerErrorCounter", "", TJAdUnitConstants.String.ENABLED, "", "initialized", "propertiesName", "", "", "purchaseInProgress", "purchasesProperties", "", "acknowledgePurchase", "", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "resPurchase", "Lcom/platform101xp/sdk/Platform101XPPurchase;", "addOrReplacePurchaseProperties", "", "product", "purchaseProperties", "checkEnabled", "connectToPlayBillingService", "createSkuList", "", "developerErrorHandler", "debugMessage", "finishPurchase", "getAvailableProducts", "getProduct", "productId", "getProducts", "getProperties", "handleBillingResultOk", "purchases", "", "handleOnGetProductsResult", "responseCode", "skuDetailsList", "Lcom/android/billingclient/api/SkuDetails;", "initAndroidBillingClient", "initializeBillingClient", "isConnectionInProgress", "isEnabled", "isInitialized", "isOverridingPurchaseParameters", "properties", "launchCoroutine", "action", "Lkotlin/Function0;", "needReturn", TapjoyAuctionFlags.AUCTION_TYPE, "Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$ListenerFunType;", "onDestroy", "onPurchaseSubmitResult", "onResume", "purchaseProduct", "purchasePropertiesToString", "removeProperties", "propertiesKey", "restoreProducts", "restoreProductsResultOk", "purchasesResult", "Lcom/android/billingclient/api/Purchase$PurchasesResult;", "saveProperties", "sendErrorResult", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "startBillingConnection", "stringToPurchaseProperties", "propertiesString", "submitPurchase", "Companion", "Listener", "ListenerFunType", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPGoogleBillingManager {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int MAX_RECONNECT_COUNT = 3;
    @Deprecated
    public static final String META_BILLING_PUBLIC_KEY = "com.platform101xp.sdk.billing.public_key";
    @Deprecated
    public static final String META_ENABLED = "com.platform101xp.sdk.billing.enabled";
    @Deprecated
    public static final String META_SKU = "com.platform101xp.sdk.billing.sku";
    @Deprecated
    public static final String PAYLOAD_IS_TEST = "is_test";
    @Deprecated
    public static final String PURCHASE_STATE = "purchase_state_";
    @Deprecated
    public static final String STATE_CANCELED = "com.platform101xp.canceled";
    @Deprecated
    public static final String STATE_PURCHASED = "com.platform101xp.purchased";
    private final Platform101XPAndroidBillingClient androidBillingClient;
    private final Listener billingListener;
    private final Platform101XPConfigManager configManager;
    private int developerErrorCounter;
    private boolean enabled;
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final AtomicBoolean purchaseInProgress = new AtomicBoolean(false);
    private final AtomicBoolean connectionInProgress = new AtomicBoolean(false);
    private Map<String, String> purchasesProperties = new LinkedHashMap();
    private final Set<Platform101XPProduct> availableProducts = new LinkedHashSet();
    private List<String> propertiesName = CollectionsKt.listOf(new String[]{"packageName", "productId", "token", Platform101XPAnalyticsFirebase.PROPERTY_APPFLYER_ID});

    /* compiled from: Platform101XPGoogleBillingManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$Listener;", "", "onFinishPurchaseResult", "", FirebaseAnalytics.Event.PURCHASE, "Lcom/platform101xp/sdk/Platform101XPPurchase;", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "onGetProductsResult", "products", "", "Lcom/platform101xp/sdk/Platform101XPProduct;", "onInitializeResult", "onPurchaseProductResult", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface Listener {
        void onFinishPurchaseResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError);

        void onGetProductsResult(List<Platform101XPProduct> list, Platform101XPError platform101XPError);

        void onInitializeResult(Platform101XPError platform101XPError);

        void onPurchaseProductResult(Platform101XPPurchase platform101XPPurchase, Platform101XPError platform101XPError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Platform101XPGoogleBillingManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$ListenerFunType;", "", "(Ljava/lang/String;I)V", "INITIALIZE_RESULT", "GET_PRODUCTS_RESULT", "PURCHASE_RESULT", "FINISH_RESULT", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public enum ListenerFunType {
        INITIALIZE_RESULT,
        GET_PRODUCTS_RESULT,
        PURCHASE_RESULT,
        FINISH_RESULT
    }

    /* compiled from: Platform101XPGoogleBillingManager.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ListenerFunType.values().length];
            iArr[ListenerFunType.INITIALIZE_RESULT.ordinal()] = 1;
            iArr[ListenerFunType.PURCHASE_RESULT.ordinal()] = 2;
            iArr[ListenerFunType.GET_PRODUCTS_RESULT.ordinal()] = 3;
            iArr[ListenerFunType.FINISH_RESULT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Platform101XPGoogleBillingManager(Platform101XPAndroidBillingClient platform101XPAndroidBillingClient, Listener listener, Platform101XPConfigManager platform101XPConfigManager) {
        Intrinsics.checkNotNullParameter(platform101XPAndroidBillingClient, "androidBillingClient");
        Intrinsics.checkNotNullParameter(listener, "billingListener");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        this.androidBillingClient = platform101XPAndroidBillingClient;
        this.billingListener = listener;
        this.configManager = platform101XPConfigManager;
        checkEnabled();
        initializeBillingClient();
    }

    /* compiled from: Platform101XPGoogleBillingManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/platform101xp/sdk/internal/billing/Platform101XPGoogleBillingManager$Companion;", "", "()V", "MAX_RECONNECT_COUNT", "", "META_BILLING_PUBLIC_KEY", "", "META_ENABLED", "META_SKU", "PAYLOAD_IS_TEST", "PURCHASE_STATE", "STATE_CANCELED", "STATE_PURCHASED", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void initAndroidBillingClient() {
        this.androidBillingClient.initListener(new BillingListener() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager$initAndroidBillingClient$listener$1
            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void setupFinished(int i, String str) {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                AtomicBoolean atomicBoolean3;
                Intrinsics.checkNotNullParameter(str, TJAdUnitConstants.String.MESSAGE);
                Log.d("101XP SDK", "onBillingSetupFinished");
                atomicBoolean = Platform101XPGoogleBillingManager.this.connectionInProgress;
                atomicBoolean.set(false);
                if (i == 0) {
                    atomicBoolean2 = Platform101XPGoogleBillingManager.this.initialized;
                    atomicBoolean2.set(true);
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.INITIALIZE_RESULT, null);
                } else if (i != 5) {
                    atomicBoolean3 = Platform101XPGoogleBillingManager.this.initialized;
                    atomicBoolean3.set(false);
                    Platform101XPGoogleBillingManager platform101XPGoogleBillingManager = Platform101XPGoogleBillingManager.this;
                    Platform101XPGoogleBillingManager.ListenerFunType listenerFunType = Platform101XPGoogleBillingManager.ListenerFunType.INITIALIZE_RESULT;
                    platform101XPGoogleBillingManager.sendErrorResult(listenerFunType, new Platform101XPError(new Exception("Google Billing Connection is fail! ResponseCode: " + i + ", debugMessage: " + str)));
                } else {
                    Platform101XPGoogleBillingManager.this.developerErrorHandler(str);
                }
            }

            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void purchaseUpdated(int i, List<Purchase> list) {
                AtomicBoolean atomicBoolean;
                atomicBoolean = Platform101XPGoogleBillingManager.this.purchaseInProgress;
                atomicBoolean.set(false);
                if (i == -1) {
                    Log.d("101XP SDK", "onPurchasesUpdated: Start reconnect to billing service");
                    Platform101XPGoogleBillingManager.this.connectToPlayBillingService();
                } else if (i == 0) {
                    Platform101XPGoogleBillingManager.this.handleBillingResultOk(list);
                } else if (i == 1) {
                    if (list != null && (!list.isEmpty())) {
                        for (Purchase purchase : list) {
                            Iterator it = purchase.getSkus().iterator();
                            while (it.hasNext()) {
                                Platform101XPSettings.saveString(Intrinsics.stringPlus(Platform101XPGoogleBillingManager.PURCHASE_STATE, (String) it.next()), Platform101XPGoogleBillingManager.STATE_CANCELED);
                            }
                        }
                    }
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(Platform101XPError.ErrorType.ERROR_CANCELED));
                } else if (i != 7) {
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception(Intrinsics.stringPlus("Purchase product Error! Response code: ", Integer.valueOf(i)))));
                } else {
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception("Purchase product Error! Item already owned.")));
                }
            }

            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void billingDisconnected() {
                Log.d("101XP SDK", "onBillingServiceDisconnected");
                Platform101XPGoogleBillingManager.this.connectToPlayBillingService();
            }

            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void purchaseFinished(int i, Platform101XPPurchase platform101XPPurchase) {
                Platform101XPGoogleBillingManager.Listener listener;
                Intrinsics.checkNotNullParameter(platform101XPPurchase, FirebaseAnalytics.Event.PURCHASE);
                if (i == -1) {
                    Log.d("101XP SDK", "finishPurchase: Start reconnect to billing service");
                    Platform101XPGoogleBillingManager.this.connectToPlayBillingService();
                } else if (i == 0) {
                    listener = Platform101XPGoogleBillingManager.this.billingListener;
                    listener.onFinishPurchaseResult(platform101XPPurchase, null);
                } else if (i != 1) {
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.FINISH_RESULT, new Platform101XPError(new Exception(Intrinsics.stringPlus("Finish purchase Error! Response code: ", Integer.valueOf(i)))));
                } else {
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.FINISH_RESULT, new Platform101XPError(Platform101XPError.ErrorType.ERROR_CANCELED));
                }
            }

            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void purchaseAcknowledged(int i, Platform101XPPurchase platform101XPPurchase) {
                Intrinsics.checkNotNullParameter(platform101XPPurchase, FirebaseAnalytics.Event.PURCHASE);
                if (i != 0) {
                    Platform101XPGoogleBillingManager.this.sendErrorResult(Platform101XPGoogleBillingManager.ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception("Purchase acknowledge error")));
                    return;
                }
                Log.d("101XP SDK", "Purchase Acknowledged");
                Platform101XPGoogleBillingManager.this.onPurchaseSubmitResult(platform101XPPurchase);
            }

            @Override // com.platform101xp.sdk.internal.billing.BillingListener
            public void productsGot(int i, List<? extends SkuDetails> list) {
                Platform101XPGoogleBillingManager.this.handleOnGetProductsResult(i, list);
            }
        });
    }

    private final void initializeBillingClient() {
        initAndroidBillingClient();
        if (!this.enabled) {
            return;
        }
        this.androidBillingClient.initBillingClient();
    }

    private final void checkEnabled() {
        this.enabled = this.configManager.getBool(Platform101XPConfigKeyHolder.billingEnabled, true);
    }

    public final void startBillingConnection() {
        if (!this.enabled) {
            return;
        }
        connectToPlayBillingService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectToPlayBillingService() {
        if (isInitialized() && this.androidBillingClient.isReady()) {
            Log.d("101XP SDK", "Billing is already initialized!");
            return;
        }
        Log.d("101XP SDK", "Connect to billing service");
        if (isConnectionInProgress()) {
            Log.d("101XP SDK", "Billing Connection in progress, please wait");
        } else if (this.androidBillingClient.isReady()) {
            Log.d("101XP SDK", "Billing Client is ready");
            BillingResult build = BillingResult.newBuilder().setResponseCode(0).setDebugMessage("Billing Client is ready").build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …\n                .build()");
            this.androidBillingClient.onBillingSetupFinished(build);
        } else {
            this.connectionInProgress.set(true);
            Log.d("101XP SDK", "Billing Client start connection");
            launchCoroutine((Function0) new Platform101XPGoogleBillingManager$connectToPlayBillingService$1(this));
        }
    }

    public final boolean isInitialized() {
        return this.initialized.get();
    }

    private final boolean isConnectionInProgress() {
        return this.connectionInProgress.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void developerErrorHandler(String str) {
        int i = this.developerErrorCounter;
        if (i < 3) {
            this.developerErrorCounter = i + 1;
            Log.d("101XP SDK", "DeveloperError. Billing start reconnect");
            connectToPlayBillingService();
            return;
        }
        this.initialized.set(false);
        sendErrorResult(ListenerFunType.INITIALIZE_RESULT, new Platform101XPError(new Exception(Intrinsics.stringPlus("Google Billing Connection is fail with DEVELOPER_ERROR, debugMessage: ", str))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendErrorResult(ListenerFunType listenerFunType, Platform101XPError platform101XPError) {
        int i = WhenMappings.$EnumSwitchMapping$0[listenerFunType.ordinal()];
        if (i == 1) {
            this.billingListener.onInitializeResult(platform101XPError);
        } else if (i == 2) {
            this.billingListener.onPurchaseProductResult(null, platform101XPError);
        } else if (i == 3) {
            this.billingListener.onGetProductsResult(null, platform101XPError);
        } else if (i == 4) {
            this.billingListener.onFinishPurchaseResult(null, platform101XPError);
        }
        if (platform101XPError != null) {
            Platform101XP.sendCrashReport(new Exception(platform101XPError.toString()));
        }
    }

    private final boolean isEnabled() {
        return this.enabled;
    }

    private final boolean needReturn(ListenerFunType listenerFunType) {
        if (!isEnabled()) {
            sendErrorResult(listenerFunType, new Platform101XPError(new Exception("Billing not enabled!")));
            Log.d("101XP SDK", "Google Billing not enabled");
            return true;
        } else if (isInitialized()) {
            return false;
        } else {
            Log.d("101XP SDK", Intrinsics.stringPlus("Google Billing not initialized ", Boolean.valueOf(this.initialized.get())));
            sendErrorResult(listenerFunType, new Platform101XPError(new Exception("Billing Client in't initialised or is null! Try reinitialize Billing Manager.")));
            return true;
        }
    }

    public final void getProducts(List<String> list) {
        if (needReturn(ListenerFunType.GET_PRODUCTS_RESULT)) {
            return;
        }
        launchCoroutine((Function0) new Platform101XPGoogleBillingManager$getProducts$1(list, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> createSkuList() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.billingSku, "");
        if (string.length() > 0) {
            List<String> mutableList = CollectionsKt.toMutableList(StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutableList, 10));
            for (String str : mutableList) {
                arrayList.add(StringsKt.trim(str).toString());
            }
            linkedHashSet.addAll(arrayList);
            for (String str2 : linkedHashSet) {
                Log.d("101XP SDK", Intrinsics.stringPlus("getProducts: sku = ", str2));
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOnGetProductsResult(int i, List<? extends SkuDetails> list) {
        if (i != 0) {
            this.billingListener.onGetProductsResult(null, new Platform101XPError(new Exception(Intrinsics.stringPlus("Google Query Sku Details is fail! ResponseCode: ", Integer.valueOf(i)))));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SkuDetails skuDetails : list) {
                arrayList.add(new Platform101XPProduct(skuDetails));
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            this.availableProducts.addAll(arrayList2);
        }
        this.billingListener.onGetProductsResult(arrayList, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreProductsResultOk(Purchase.PurchasesResult purchasesResult) {
        List<Purchase> purchasesList = purchasesResult.getPurchasesList();
        if (purchasesList == null) {
            return;
        }
        for (Purchase purchase : purchasesList) {
            int loadInt = Platform101XPSettings.loadInt(purchase.getPurchaseToken(), -1);
            Iterator it = purchase.getSkus().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                boolean z = !Intrinsics.areEqual(Platform101XPSettings.loadString(Intrinsics.stringPlus(PURCHASE_STATE, str)), STATE_CANCELED) && !Intrinsics.areEqual(Platform101XPSettings.loadString(Intrinsics.stringPlus(PURCHASE_STATE, str)), STATE_PURCHASED);
                Log.d("101XP SDK", "restore: " + ((Object) str) + " orderId=" + purchase.getOrderId() + " transactionId=" + loadInt);
                Log.d("101XP SDK", Intrinsics.stringPlus("Original JSON: ", purchase.getOriginalJson()));
                if (loadInt == -1 && z && Platform101XPSettings.isKeyExist(str)) {
                    if (purchase.getPurchaseState() == 2) {
                        sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception("Purchase pending")));
                    } else {
                        Log.d("101XP SDK", Intrinsics.stringPlus("Try to restore: ", str));
                        Intrinsics.checkNotNullExpressionValue(purchase, "it");
                        submitPurchase(purchase);
                    }
                } else {
                    onPurchaseSubmitResult(new Platform101XPPurchase(Integer.valueOf(loadInt), purchase));
                }
            }
        }
    }

    public final void restoreProducts() {
        if (needReturn(ListenerFunType.PURCHASE_RESULT)) {
            return;
        }
        BuildersKt.async$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new Platform101XPGoogleBillingManager$restoreProducts$1(this, null), 2, (Object) null);
    }

    public final void purchaseProduct(Platform101XPProduct platform101XPProduct, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(platform101XPProduct, "product");
        Intrinsics.checkNotNullParameter(map, "properties");
        if (needReturn(ListenerFunType.PURCHASE_RESULT)) {
            return;
        }
        if (this.purchaseInProgress.get()) {
            sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(Platform101XPError.ErrorType.ERROR_OPERATION_IN_PROGRESS));
            return;
        }
        this.purchaseInProgress.set(true);
        SkuDetails internalProduct = platform101XPProduct.getInternalProduct();
        Intrinsics.checkNotNullExpressionValue(internalProduct, "product.internalProduct");
        BillingFlowParams flowParams = this.androidBillingClient.getFlowParams(internalProduct);
        if (true ^ this.purchasesProperties.isEmpty()) {
            this.purchasesProperties.clear();
        }
        this.purchasesProperties.putAll(map);
        String sku = internalProduct.getSku();
        Intrinsics.checkNotNullExpressionValue(sku, "skuDetails.sku");
        saveProperties(sku, addOrReplacePurchaseProperties(platform101XPProduct, this.purchasesProperties));
        Platform101XPAndroidBillingClient platform101XPAndroidBillingClient = this.androidBillingClient;
        Activity currentActivity = Platform101XP.getCurrentActivity();
        Intrinsics.checkNotNullExpressionValue(currentActivity, "getCurrentActivity()");
        platform101XPAndroidBillingClient.launchBillingFlow(currentActivity, flowParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBillingResultOk(List<Purchase> list) {
        if (list == null || list.isEmpty()) {
            sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception("There aren't purchases!")));
            return;
        }
        for (Purchase purchase : list) {
            if (purchase.getPurchaseState() == 1) {
                submitPurchase(purchase);
            } else {
                Exception exc = new Exception(Intrinsics.stringPlus("Purchase status differs from PURCHASED, current status: ", Integer.valueOf(purchase.getPurchaseState())));
                Platform101XP.crashLog("101XP SDK", exc.getMessage());
                sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(exc));
            }
        }
    }

    public final void finishPurchase(Platform101XPPurchase platform101XPPurchase) {
        Intrinsics.checkNotNullParameter(platform101XPPurchase, FirebaseAnalytics.Event.PURCHASE);
        if (needReturn(ListenerFunType.FINISH_RESULT)) {
            return;
        }
        this.androidBillingClient.finishPurchase(platform101XPPurchase);
    }

    private final Set<Platform101XPProduct> getAvailableProducts() {
        return this.availableProducts;
    }

    public final Platform101XPProduct getProduct(String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Set<Platform101XPProduct> availableProducts = getAvailableProducts();
        Log.d("101XP SDK", "getProducts:  " + availableProducts.size() + ", " + availableProducts.hashCode());
        Object obj = null;
        if (!(!availableProducts.isEmpty())) {
            Platform101XP.sendCrashReport(new Exception("Available Products is empty!"));
            return null;
        }
        boolean z = false;
        for (Object obj2 : availableProducts) {
            if (Intrinsics.areEqual(((Platform101XPProduct) obj2).getProductId(), str)) {
                if (z) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                obj = obj2;
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        Platform101XPProduct platform101XPProduct = (Platform101XPProduct) obj;
        Log.d("101XP SDK", "getProduct: " + str + " = " + platform101XPProduct);
        return platform101XPProduct;
    }

    public final void onResume() {
        Log.d("101XP SDK", Intrinsics.stringPlus("Billing onResume() is enabled: ", Boolean.valueOf(this.enabled)));
        startBillingConnection();
    }

    private final void acknowledgePurchase(Purchase purchase, Platform101XPPurchase platform101XPPurchase) {
        if (!purchase.isAcknowledged()) {
            this.androidBillingClient.acknowledgePurchase(purchase, platform101XPPurchase);
            return;
        }
        Log.d("101XP SDK", "product is already acknowledge");
        onPurchaseSubmitResult(platform101XPPurchase);
    }

    private final void submitPurchase(final Purchase purchase) {
        Iterator it = purchase.getSkus().iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            Log.d("101XP SDK", "purchase: packageName=" + purchase.getPackageName() + ", token=" + purchase.getPurchaseToken() + ", productId=" + ((Object) str) + ", time=" + purchase.getPurchaseTime());
            try {
                Intrinsics.checkNotNullExpressionValue(str, "productId");
            } catch (IllegalStateException e) {
                Platform101XP.crashLog("101XP SDK", Intrinsics.stringPlus("Purchase Json: ", purchase.getOriginalJson()));
                sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception(Intrinsics.stringPlus("Submit purchase exception: ", e.getMessage()))));
            }
            if (str.length() == 0) {
                throw new IllegalStateException(Intrinsics.stringPlus("Purchase.sku is empty order Id: ", purchase.getOrderId()));
                break;
            }
            String loadString = Platform101XPSettings.loadString(str);
            Intrinsics.checkNotNullExpressionValue(loadString, "loadString(productId)");
            Platform101XPHttpRequest submitPurchase = Platform101XPApi.billing().submitPurchase("transactions", str, purchase.getPackageName(), purchase.getPurchaseToken(), "inapp", stringToPurchaseProperties(loadString));
            Intrinsics.checkNotNullExpressionValue(submitPurchase, "billing()\n              …kuType.INAPP, properties)");
            submitPurchase.execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager$$ExternalSyntheticLambda0
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public final void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    Platform101XPGoogleBillingManager.m85submitPurchase$lambda7(Platform101XPGoogleBillingManager.this, str, purchase, str, platform101XPModel, platform101XPError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitPurchase$lambda-7  reason: not valid java name */
    public static final void m85submitPurchase$lambda7(Platform101XPGoogleBillingManager platform101XPGoogleBillingManager, String str, Purchase purchase, String str2, Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        Intrinsics.checkNotNullParameter(platform101XPGoogleBillingManager, "this$0");
        Intrinsics.checkNotNullParameter(purchase, "$purchase");
        if (platform101XPError != null) {
            platform101XPGoogleBillingManager.sendErrorResult(ListenerFunType.PURCHASE_RESULT, new Platform101XPError(new Exception(Intrinsics.stringPlus("Submit purchase error: ", platform101XPError))));
            return;
        }
        Platform101XPSettings.saveString(Intrinsics.stringPlus(PURCHASE_STATE, str), STATE_PURCHASED);
        Objects.requireNonNull(platform101XPModel, "null cannot be cast to non-null type com.platform101xp.sdk.api.model.Platform101XPModelTransaction");
        int i = ((Platform101XPModelTransaction) platform101XPModel).transactionId;
        Platform101XPSettings.saveInt(purchase.getPurchaseToken(), i);
        Platform101XPPurchase platform101XPPurchase = new Platform101XPPurchase(Integer.valueOf(i), purchase);
        Intrinsics.checkNotNullExpressionValue(str2, "productId");
        platform101XPGoogleBillingManager.removeProperties(str2);
        platform101XPGoogleBillingManager.acknowledgePurchase(purchase, platform101XPPurchase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchaseSubmitResult(final Platform101XPPurchase platform101XPPurchase) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.platform101xp.sdk.internal.billing.Platform101XPGoogleBillingManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPGoogleBillingManager.m84onPurchaseSubmitResult$lambda8(Platform101XPGoogleBillingManager.this, platform101XPPurchase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPurchaseSubmitResult$lambda-8  reason: not valid java name */
    public static final void m84onPurchaseSubmitResult$lambda8(Platform101XPGoogleBillingManager platform101XPGoogleBillingManager, Platform101XPPurchase platform101XPPurchase) {
        Intrinsics.checkNotNullParameter(platform101XPGoogleBillingManager, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPPurchase, "$resPurchase");
        platform101XPGoogleBillingManager.billingListener.onPurchaseProductResult(platform101XPPurchase, null);
    }

    private final Map<String, String> stringToPurchaseProperties(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (StringsKt.startsWith$default(str, "&", false, 2, (Object) null)) {
            str = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        for (String str2 : StringsKt.split$default(str, new String[]{"&"}, false, 0, 6, (Object) null)) {
            if (!StringsKt.contains$default(str2, PAYLOAD_IS_TEST, false, 2, (Object) null)) {
                List split$default = StringsKt.split$default(str2, new String[]{"="}, false, 0, 6, (Object) null);
                linkedHashMap.put(split$default.get(0), split$default.get(1));
            }
        }
        return linkedHashMap;
    }

    private final void saveProperties(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("is_test=");
        sb.append(this.configManager.isTestBilling() ? TapjoyAuctionFlags.AUCTION_TYPE_FIRST_PRICE : "0");
        sb.append(purchasePropertiesToString(map));
        Platform101XPSettings.saveString(str, sb.toString());
    }

    private final void removeProperties(String str) {
        Platform101XPSettings.removeValue(str);
    }

    private final Map<String, String> addOrReplacePurchaseProperties(Platform101XPProduct platform101XPProduct, Map<String, String> map) {
        if (map.containsKey(Platform101XPAnalyticsAppsFlyer.CURRENCY_KEY)) {
            map.remove(Platform101XPAnalyticsAppsFlyer.CURRENCY_KEY);
        }
        if (map.containsKey(Platform101XPAnalyticsAppsFlyer.REVENUE_KEY)) {
            map.remove(Platform101XPAnalyticsAppsFlyer.REVENUE_KEY);
        }
        String currencyCode = platform101XPProduct.getCurrencyCode();
        Intrinsics.checkNotNullExpressionValue(currencyCode, "product.currencyCode");
        map.put(Platform101XPAnalyticsAppsFlyer.CURRENCY_KEY, currencyCode);
        String priceValue = platform101XPProduct.getPriceValue();
        Intrinsics.checkNotNullExpressionValue(priceValue, "product.priceValue");
        map.put(Platform101XPAnalyticsAppsFlyer.REVENUE_KEY, priceValue);
        return map;
    }

    public final List<String> getProperties() {
        return this.propertiesName;
    }

    public final String isOverridingPurchaseParameters(Map<String, String> map) {
        if (map == null || !(!map.isEmpty())) {
            return null;
        }
        for (String str : this.propertiesName) {
            if (map.containsKey(str)) {
                return str;
            }
        }
        return null;
    }

    public final void onDestroy() {
        this.androidBillingClient.endConnection();
    }

    private final void launchCoroutine(Function0<Unit> function0) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new Platform101XPGoogleBillingManager$launchCoroutine$1(function0, null), 3, (Object) null);
    }

    private final String purchasePropertiesToString(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + '&' + entry.getKey() + '=' + entry.getValue();
        }
        return str;
    }
}
