package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Platform101XPWebDialogsConstructor.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 _2\u00020\u0001:\u0001_B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020\tH\u0002J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010>\u001a\u000207H\u0002J,\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020&2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HJ\"\u0010J\u001a\u00020 2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002090L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002090LJ\u001c\u0010N\u001a\u00020I2\u0006\u0010O\u001a\u00020\t2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HJF\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\t2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010Y\u001a\u00020\tJ\b\u0010Z\u001a\u00020\tH\u0002J\u000e\u0010[\u001a\u0002092\u0006\u00103\u001a\u000204J,\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010\t2\b\u0010X\u001a\u0004\u0018\u00010\t2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010HH\u0002J\u0006\u0010^\u001a\u00020\tR\u001c\u0010\f\u001a\u00020\r@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u0007@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u0005@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u000f@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor;", "", "currentActivity", "Landroid/app/Activity;", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "clientId", "", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "parameters", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Ljava/lang/String;Lcom/platform101xp/sdk/internal/Platform101XPSettings;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;)V", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getClientId", "()Ljava/lang/String;", "getConfigManager", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "setConfigManager", "(Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;)V", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "currentWebDialog", "Landroid/app/Dialog;", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "isHorizontal", "", "isVertical", "getParameters", "()Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;", "setParameters", "(Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;)V", "screeRotation", "screenOrientation", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "setSettings", "(Lcom/platform101xp/sdk/internal/Platform101XPSettings;)V", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "socButtonsMap", "", "Lcom/platform101xp/sdk/Platform101XPSNType;", "addToDialogsByType", "", "currentDialog", TapjoyAuctionFlags.AUCTION_TYPE, "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogType;", "callSnAuthorize", "snType", "getAuthorizeSocialView", "Landroid/view/View;", "activity", "getAuthorizeWebDialog", "authorizeActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "isLoggedAsGuest", "asGuestEnabled", "latestAccounts", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "getGuestAuthorizeWarning", "bindAction", "Lkotlin/Function0;", "cancelAction", "getLatestAccountByData", "accountData", "getProfileWebDialog", "isGuest", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "profileActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "userGameId", "", "accessToken", "page", "getSocialNetworkButtons", "setSnManager", "setUserParams", "portalParams", "widgetVersion", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogsConstructor {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_WEB_UI_VERSION = "1.0.0";
    public static final String DEV_DIALOGS_URL = "https://mobile-game-id-dev.101xp.com";
    public static final String DIALOGS_URL = "https://mobile-game-id.101xp.com";
    public static final String JS_INTERFACE_NAME = "GameClient";
    public static final String LAST_SN_LOGGED = "com.platform101xp.last_sn_logged_type";
    private Platform101XPAnalytics analytics;
    private final String clientId;
    private Platform101XPConfigManager configManager;
    private Activity currentActivity;
    private Dialog currentWebDialog;
    private Platform101XPDialogCreator dialogCreator;
    private final boolean isHorizontal;
    private final boolean isVertical;
    private Platform101XPWebDialogParameters parameters;
    private final boolean screeRotation;
    private final Platform101XPScreenOrientation screenOrientation;
    private Platform101XPSettings settings;
    private Platform101XPSNManager snManager;
    private final Map<String, Platform101XPSNType> socButtonsMap = new LinkedHashMap();

    @Inject
    public Platform101XPWebDialogsConstructor(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPConfigManager platform101XPConfigManager, String str, Platform101XPSettings platform101XPSettings, Platform101XPAnalytics platform101XPAnalytics, Platform101XPWebDialogParameters platform101XPWebDialogParameters) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "analytics");
        Intrinsics.checkNotNullParameter(platform101XPWebDialogParameters, "parameters");
        this.currentActivity = activity;
        this.dialogCreator = platform101XPDialogCreator;
        this.configManager = platform101XPConfigManager;
        this.clientId = str;
        this.settings = platform101XPSettings;
        this.analytics = platform101XPAnalytics;
        this.parameters = platform101XPWebDialogParameters;
        boolean bool = this.configManager.getBool(Platform101XPConfigKeyHolder.screenRotationDisabled, false);
        this.screeRotation = bool;
        boolean bool2 = this.configManager.getBool(Platform101XPConfigKeyHolder.screenlockHorizontal, false);
        this.isHorizontal = bool2;
        boolean bool3 = this.configManager.getBool(Platform101XPConfigKeyHolder.screenlockVertical, false);
        this.isVertical = bool3;
        this.screenOrientation = new Platform101XPScreenOrientation(bool, bool2, bool3);
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    @Inject
    public final void setCurrentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.currentActivity = activity;
    }

    public final Platform101XPDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    @Inject
    public final void setDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "<set-?>");
        this.dialogCreator = platform101XPDialogCreator;
    }

    public final Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    @Inject
    public final void setConfigManager(Platform101XPConfigManager platform101XPConfigManager) {
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "<set-?>");
        this.configManager = platform101XPConfigManager;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    @Inject
    public final void setSettings(Platform101XPSettings platform101XPSettings) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "<set-?>");
        this.settings = platform101XPSettings;
    }

    public final Platform101XPAnalytics getAnalytics() {
        return this.analytics;
    }

    @Inject
    public final void setAnalytics(Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "<set-?>");
        this.analytics = platform101XPAnalytics;
    }

    public final Platform101XPWebDialogParameters getParameters() {
        return this.parameters;
    }

    @Inject
    public final void setParameters(Platform101XPWebDialogParameters platform101XPWebDialogParameters) {
        Intrinsics.checkNotNullParameter(platform101XPWebDialogParameters, "<set-?>");
        this.parameters = platform101XPWebDialogParameters;
    }

    /* compiled from: Platform101XPWebDialogsConstructor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor$Companion;", "", "()V", "DEFAULT_WEB_UI_VERSION", "", "DEV_DIALOGS_URL", "DIALOGS_URL", "JS_INTERFACE_NAME", "LAST_SN_LOGGED", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String getSocialNetworkButtons() {
        String str = "'socials': [";
        if (!this.socButtonsMap.isEmpty()) {
            Map.Entry entry = (Map.Entry) CollectionsKt.last(this.socButtonsMap.entrySet());
            for (Map.Entry<String, Platform101XPSNType> entry2 : this.socButtonsMap.entrySet()) {
                str = str + "{type:'" + entry2.getKey() + "'}";
                if (!Intrinsics.areEqual(entry2, entry)) {
                    str = Intrinsics.stringPlus(str, ",");
                }
            }
        }
        return Intrinsics.stringPlus(str, "]");
    }

    private final String setUserParams(String str, String str2, List<Platform101XPLatestAccount> list) {
        String stringPlus = Intrinsics.stringPlus('{' + this.parameters.baseParams() + ',', this.parameters.getMobileParams(str2));
        if (str != null) {
            if (str.length() > 0) {
                stringPlus = stringPlus + str + ',';
            }
        }
        String str3 = (stringPlus + getSocialNetworkButtons() + ',') + this.parameters.getLatestAccountsParams(list) + '}';
        Log.d("101XP SDK", Intrinsics.stringPlus("Set User Params: ", str3));
        return "javascript:window.setUser(" + str3 + ')';
    }

    public final View getAuthorizeSocialView(Activity activity, Platform101XPSNType platform101XPSNType) {
        View view = new View(activity);
        view.setTag(platform101XPSNType);
        return view;
    }

    private final void addToDialogsByType(Dialog dialog, Platform101XPDialogType platform101XPDialogType) {
        this.dialogCreator.getDialogs()[platform101XPDialogType.ordinal()] = dialog;
    }

    public final Dialog getAuthorizeWebDialog(final Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, boolean z, boolean z2, final List<Platform101XPLatestAccount> list) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "authorizeActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        String userParams = setUserParams(this.parameters.getPortalParams(null, 0L), null, null);
        Object obj = new Object() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor$getAuthorizeWebDialog$jsInterface$1
            @JavascriptInterface
            public final void getGuestAuth() {
                Log.d("101XP SDK", "Action guest login");
                Platform101XPWebDialogsConstructor.this.getSettings().setInt(Platform101XPWebDialogsConstructor.LAST_SN_LOGGED, -1);
                platform101XPAuthorizeActionsListener.onGuestClick();
            }

            @JavascriptInterface
            public final void getSocialAuth(String str) {
                Dialog dialog;
                Map map;
                View authorizeSocialView;
                Intrinsics.checkNotNullParameter(str, "snType");
                Log.d("101XP SDK", Intrinsics.stringPlus("Action social type ", str));
                Activity currentActivity = Platform101XPWebDialogsConstructor.this.getCurrentActivity();
                Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor = Platform101XPWebDialogsConstructor.this;
                Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener2 = platform101XPAuthorizeActionsListener;
                dialog = platform101XPWebDialogsConstructor.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                map = platform101XPWebDialogsConstructor.socButtonsMap;
                Platform101XPSNType platform101XPSNType = (Platform101XPSNType) map.get(str);
                if (platform101XPSNType != null) {
                    platform101XPWebDialogsConstructor.getSettings().setInt(Platform101XPWebDialogsConstructor.LAST_SN_LOGGED, platform101XPSNType.getValue());
                    authorizeSocialView = platform101XPWebDialogsConstructor.getAuthorizeSocialView(currentActivity, platform101XPSNType);
                    platform101XPAuthorizeActionsListener2.onAuthorizeClick(authorizeSocialView);
                    return;
                }
                platform101XPAuthorizeActionsListener2.onGuestClick();
            }

            @JavascriptInterface
            public final void getDisagreeConnect() {
                Dialog dialog;
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPAuthorizeActionsListener.onCancelClick();
            }

            @JavascriptInterface
            public final void updateUser(String str) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str, "jsonToken");
                Log.d("101XP SDK", Intrinsics.stringPlus("Update user Authorize, params: ", str));
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPAuthorizeActionsListener.onUserUpdate(str);
            }

            @JavascriptInterface
            public final void openLink(String str) {
                Intrinsics.checkNotNullParameter(str, "linkUrl");
                Log.d("101XP SDK", Intrinsics.stringPlus("Open link ", str));
                Platform101XPWebDialogsConstructor.this.getCurrentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }

            @JavascriptInterface
            public final void getLatestAccountsAuth(String str) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str, "accountData");
                String deviceToken = Platform101XPWebDialogsConstructor.this.getLatestAccountByData(str, list).getDeviceToken();
                Log.d("101XP SDK", Intrinsics.stringPlus("Get Latest Account token: ", deviceToken));
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPAuthorizeActionsListener.onUserUpdate(deviceToken);
            }
        };
        String authorizeUrl = this.parameters.getAuthorizeUrl(z2, z);
        Log.d("101XP SDK", Intrinsics.stringPlus("Auth url: ", authorizeUrl));
        Platform101XPWebDialogWrapper platform101XPWebDialogWrapper = new Platform101XPWebDialogWrapper(this.currentActivity, authorizeUrl, this.screenOrientation, userParams, obj, this.analytics, new Platform101XPWebDialogsConstructor$getAuthorizeWebDialog$1(platform101XPAuthorizeActionsListener));
        this.currentWebDialog = platform101XPWebDialogWrapper;
        addToDialogsByType(platform101XPWebDialogWrapper, Platform101XPDialogType.DIALOG_AUTHORIZE);
        Dialog dialog = this.currentWebDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
            return null;
        }
        return dialog;
    }

    public final Dialog getProfileWebDialog(final boolean z, final Platform101XPAccount platform101XPAccount, final Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j, String str, final List<Platform101XPLatestAccount> list, String str2) {
        Intrinsics.checkNotNullParameter(platform101XPAccount, "account");
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "profileActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        Intrinsics.checkNotNullParameter(str2, "page");
        String userParams = setUserParams(this.parameters.getPortalParams(platform101XPAccount, j), str, list);
        Object obj = new Object() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogsConstructor$getProfileWebDialog$jsInterface$1
            @JavascriptInterface
            public final void getLogout() {
                Dialog dialog;
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPProfileActionsListener.onLogoutClick(platform101XPAccount.getId());
            }

            @JavascriptInterface
            public final void bindProvider(String str3) {
                Map map;
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str3, "snType");
                map = Platform101XPWebDialogsConstructor.this.socButtonsMap;
                Log.d("101XP SDK", Intrinsics.stringPlus("Bind provider: ", map.get(str3)));
                Platform101XPWebDialogsConstructor.this.callSnAuthorize(str3);
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
            }

            @JavascriptInterface
            public final void getSocialAuth(String str3) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str3, "snType");
                Log.d("101XP SDK", Intrinsics.stringPlus("get social auth type ", str3));
                if (!z) {
                    platform101XPProfileActionsListener.onLogoutClick(platform101XPAccount.getId());
                }
                Platform101XPWebDialogsConstructor.this.callSnAuthorize(str3);
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
            }

            @JavascriptInterface
            public final void openLink(String str3) {
                Intrinsics.checkNotNullParameter(str3, "eulaUrl");
                Log.d("101XP SDK", Intrinsics.stringPlus("Open link ", str3));
                Platform101XPWebDialogsConstructor.this.getCurrentActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str3)));
            }

            @JavascriptInterface
            public final void updateUser(String str3) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str3, "jsonToken");
                Log.d("101XP SDK", Intrinsics.stringPlus("Update user Profile, params: ", str3));
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPProfileActionsListener.onUserUpdate(str3);
            }

            @JavascriptInterface
            public final void updateEmail(String str3) {
                Intrinsics.checkNotNullParameter(str3, "email");
                Log.d("101XP SDK", Intrinsics.stringPlus("Update user email: ", str3));
                platform101XPAccount.setEmail(str3);
            }

            @JavascriptInterface
            public final void getLatestAccountsAuth(String str3) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str3, "accountData");
                String deviceToken = Platform101XPWebDialogsConstructor.this.getLatestAccountByData(str3, list).getDeviceToken();
                Log.d("101XP SDK", Intrinsics.stringPlus("Get Latest Account token: ", deviceToken));
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPProfileActionsListener.onUserUpdate(deviceToken);
            }

            @JavascriptInterface
            public final void getDeleteLatestAccount(String str3) {
                Dialog dialog;
                Intrinsics.checkNotNullParameter(str3, "accountData");
                long userId = Platform101XPWebDialogsConstructor.this.getLatestAccountByData(str3, list).getUserId();
                Log.d("101XP SDK", Intrinsics.stringPlus("Get Delete Account with userId : ", Long.valueOf(userId)));
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPProfileActionsListener.onDeleteLatestAccount(userId);
            }

            @JavascriptInterface
            public final void restoreProducts() {
                Log.d("101XP SDK", "restore products");
                platform101XPProfileActionsListener.onRestoreProduct();
            }

            @JavascriptInterface
            public final void sendLogs() {
                Dialog dialog;
                Log.d("101XP SDK", "send logs");
                dialog = Platform101XPWebDialogsConstructor.this.currentWebDialog;
                if (dialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
                    dialog = null;
                }
                dialog.dismiss();
                platform101XPProfileActionsListener.onSendLogs();
            }
        };
        Platform101XPWebDialogWrapper platform101XPWebDialogWrapper = new Platform101XPWebDialogWrapper(this.currentActivity, this.parameters.getBaseUrl() + '/' + str2, this.screenOrientation, userParams, obj, this.analytics, new Platform101XPWebDialogsConstructor$getProfileWebDialog$1(platform101XPProfileActionsListener));
        this.currentWebDialog = platform101XPWebDialogWrapper;
        addToDialogsByType(platform101XPWebDialogWrapper, Platform101XPDialogType.DIALOG_MANAGED_AUTHORIZE);
        Dialog dialog = this.currentWebDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
            return null;
        }
        return dialog;
    }

    public final void callSnAuthorize(String str) {
        Platform101XPSNManager platform101XPSNManager;
        Platform101XPSNType platform101XPSNType = this.socButtonsMap.get(str);
        if (platform101XPSNType == null || (platform101XPSNManager = this.snManager) == null) {
            return;
        }
        platform101XPSNManager.authorize(platform101XPSNType);
    }

    public final Dialog getGuestAuthorizeWarning(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "cancelAction");
        String userParams = setUserParams(null, null, null);
        Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1 platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1 = new Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1(this, function0, function02);
        Platform101XPWebDialogWrapper platform101XPWebDialogWrapper = new Platform101XPWebDialogWrapper(this.currentActivity, Intrinsics.stringPlus(this.parameters.getBaseUrl(), "/notifications/connect"), this.screenOrientation, userParams, platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$jsInterface$1, this.analytics, new Platform101XPWebDialogsConstructor$getGuestAuthorizeWarning$1(function02));
        this.currentWebDialog = platform101XPWebDialogWrapper;
        addToDialogsByType(platform101XPWebDialogWrapper, Platform101XPDialogType.DIALOG_WARNING);
        Dialog dialog = this.currentWebDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentWebDialog");
            return null;
        }
        return dialog;
    }

    public final void setSnManager(Platform101XPSNManager platform101XPSNManager) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        this.snManager = platform101XPSNManager;
        if (platform101XPSNManager != null) {
            if (platform101XPSNManager.isEnabled(Platform101XPSNType.FACEBOOK)) {
                this.socButtonsMap.put("fb", Platform101XPSNType.FACEBOOK);
            }
            if (platform101XPSNManager.isEnabled(Platform101XPSNType.VK)) {
                this.socButtonsMap.put("vk", Platform101XPSNType.VK);
            }
            if (platform101XPSNManager.isEnabled(Platform101XPSNType.OK)) {
                this.socButtonsMap.put("ok", Platform101XPSNType.OK);
            }
            if (platform101XPSNManager.isEnabled(Platform101XPSNType.GOOGLE)) {
                this.socButtonsMap.put("googlePlay", Platform101XPSNType.GOOGLE);
            }
        }
        Log.d("101XP SDK", "Web Constructor SNmap: " + this.socButtonsMap + ' ');
    }

    public final Platform101XPLatestAccount getLatestAccountByData(String str, List<Platform101XPLatestAccount> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "accountData");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        int optInt = new JSONObject(str).optInt(TapjoyAuctionFlags.AUCTION_ID);
        ListIterator<Platform101XPLatestAccount> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Platform101XPLatestAccount previous = listIterator.previous();
            if (previous.getId() == optInt) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return previous;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public final String widgetVersion() {
        return this.configManager.getString(Platform101XPConfigKeyHolder.webUiVersion, DEFAULT_WEB_UI_VERSION);
    }
}
