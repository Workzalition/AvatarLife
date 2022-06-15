package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPWebDialogWrapper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u0001+BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u0002\u0010\u0010J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001e¨\u0006,"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogWrapper;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", TJAdUnitConstants.String.URL, "", "screenOrientation", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", "jsFunction", "jsInterface", "", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "cancelAction", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Ljava/lang/String;Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;Ljava/lang/String;Ljava/lang/Object;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroid/app/Activity;", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getCancelAction", "()Lkotlin/jvm/functions/Function0;", "setCancelAction", "(Lkotlin/jvm/functions/Function0;)V", "getJsFunction", "()Ljava/lang/String;", "setJsFunction", "(Ljava/lang/String;)V", "getJsInterface", "()Ljava/lang/Object;", "setJsInterface", "(Ljava/lang/Object;)V", "getScreenOrientation", "()Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", "setScreenOrientation", "(Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;)V", "getUrl", "setUrl", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL, TJAdUnitConstants.String.BEACON_SHOW_PATH, "DialogFragmentWrapper", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogWrapper extends Dialog {
    private final Activity activity;
    private Platform101XPAnalytics analytics;
    private Function0<Unit> cancelAction;
    private String jsFunction;
    private Object jsInterface;
    private Platform101XPScreenOrientation screenOrientation;
    private String url;

    public final Activity getActivity() {
        return this.activity;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final Platform101XPScreenOrientation getScreenOrientation() {
        return this.screenOrientation;
    }

    public final void setScreenOrientation(Platform101XPScreenOrientation platform101XPScreenOrientation) {
        Intrinsics.checkNotNullParameter(platform101XPScreenOrientation, "<set-?>");
        this.screenOrientation = platform101XPScreenOrientation;
    }

    public final String getJsFunction() {
        return this.jsFunction;
    }

    public final void setJsFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsFunction = str;
    }

    public final Object getJsInterface() {
        return this.jsInterface;
    }

    public final void setJsInterface(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.jsInterface = obj;
    }

    public final Platform101XPAnalytics getAnalytics() {
        return this.analytics;
    }

    public final void setAnalytics(Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "<set-?>");
        this.analytics = platform101XPAnalytics;
    }

    public final Function0<Unit> getCancelAction() {
        return this.cancelAction;
    }

    public final void setCancelAction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.cancelAction = function0;
    }

    /* compiled from: Platform101XPWebDialogWrapper.kt */
    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH\u0002J\"\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0002J8\u00104\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogWrapper$DialogFragmentWrapper;", "Landroidx/fragment/app/DialogFragment;", "()V", "cancelAction", "Lkotlin/Function0;", "", "fileCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "isFirstCall", "", "jsFunction", "", "jsInterface", "", "screenOrientation", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", TJAdUnitConstants.String.URL, "webCloseButtonLandscape", "Landroid/widget/ImageButton;", "webCloseButtonPortrait", "webView", "Landroid/webkit/WebView;", "closeButtonListener", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL, "evaluateJs", "function", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "sendWebViewOrientation", "setDialogArgs", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class DialogFragmentWrapper extends DialogFragment {
        public static final Companion Companion = new Companion(null);
        public static final int IMAGE_SEND_REQUEST_CODE = 51182;
        private static boolean isShowing;
        private Function0<Unit> cancelAction;
        private ValueCallback<Uri[]> fileCallback;
        private boolean isFirstCall = true;
        private String jsFunction;
        private Object jsInterface;
        private Platform101XPScreenOrientation screenOrientation;
        private String url;
        private ImageButton webCloseButtonLandscape;
        private ImageButton webCloseButtonPortrait;
        private WebView webView;

        /* compiled from: Platform101XPWebDialogWrapper.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogWrapper$DialogFragmentWrapper$Companion;", "", "()V", "IMAGE_SEND_REQUEST_CODE", "", "isShowing", "", "()Z", "setShowing", "(Z)V", "getDialogInstance", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogWrapper$DialogFragmentWrapper;", TJAdUnitConstants.String.URL, "", "jsFunction", "screenOrientation", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPScreenOrientation;", "jsInterface", "cancelAction", "Lkotlin/Function0;", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final boolean isShowing() {
                return DialogFragmentWrapper.isShowing;
            }

            public final void setShowing(boolean z) {
                DialogFragmentWrapper.isShowing = z;
            }

            public final DialogFragmentWrapper getDialogInstance(String str, String str2, Platform101XPScreenOrientation platform101XPScreenOrientation, Object obj, Function0<Unit> function0) {
                Intrinsics.checkNotNullParameter(str, TJAdUnitConstants.String.URL);
                Intrinsics.checkNotNullParameter(str2, "jsFunction");
                Intrinsics.checkNotNullParameter(platform101XPScreenOrientation, "screenOrientation");
                Intrinsics.checkNotNullParameter(obj, "jsInterface");
                Intrinsics.checkNotNullParameter(function0, "cancelAction");
                DialogFragmentWrapper dialogFragmentWrapper = new DialogFragmentWrapper();
                dialogFragmentWrapper.setDialogArgs(str, str2, platform101XPScreenOrientation, obj, function0);
                return dialogFragmentWrapper;
            }
        }

        public final void setDialogArgs(String str, String str2, Platform101XPScreenOrientation platform101XPScreenOrientation, Object obj, Function0<Unit> function0) {
            this.url = str;
            this.jsFunction = str2;
            this.screenOrientation = platform101XPScreenOrientation;
            this.jsInterface = obj;
            this.cancelAction = function0;
        }

        public void onStart() {
            Platform101XPWebDialogWrapper.super.onStart();
            evaluateJs("javascript:window.screenUnlocked()");
        }

        public void onConfigurationChanged(Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "newConfig");
            Platform101XPWebDialogWrapper.super.onConfigurationChanged(configuration);
            ImageButton imageButton = null;
            if (configuration.orientation == 2) {
                ImageButton imageButton2 = this.webCloseButtonPortrait;
                if (imageButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonPortrait");
                    imageButton2 = null;
                }
                imageButton2.setVisibility(8);
                ImageButton imageButton3 = this.webCloseButtonLandscape;
                if (imageButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonLandscape");
                } else {
                    imageButton = imageButton3;
                }
                imageButton.setVisibility(0);
                return;
            }
            ImageButton imageButton4 = this.webCloseButtonLandscape;
            if (imageButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonLandscape");
                imageButton4 = null;
            }
            imageButton4.setVisibility(8);
            ImageButton imageButton5 = this.webCloseButtonPortrait;
            if (imageButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonPortrait");
            } else {
                imageButton = imageButton5;
            }
            imageButton.setVisibility(0);
        }

        public final void evaluateJs(String str) {
            WebView webView = this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.evaluateJavascript(str, Platform101XPWebDialogWrapper$DialogFragmentWrapper$$ExternalSyntheticLambda2.INSTANCE);
        }

        /* renamed from: evaluateJs$lambda-0 */
        public static final void m146evaluateJs$lambda0(String str) {
            Log.d("101XP SDK", "EvaluateJavascript result: " + ((Object) str) + ' ');
        }

        public Dialog onCreateDialog(Bundle bundle) {
            setStyle(2, 16973830);
            Dialog onCreateDialog = Platform101XPWebDialogWrapper.super.onCreateDialog(bundle);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            Window window = onCreateDialog.getWindow();
            if (window != null) {
                window.setFlags(IronSourceError.ERROR_RV_LOAD_FAILED_NO_CANDIDATES, IronSourceError.ERROR_RV_LOAD_FAILED_NO_CANDIDATES);
                if (Build.VERSION.SDK_INT >= 21) {
                    window.addFlags(Integer.MIN_VALUE);
                    window.setNavigationBarColor(ContextCompat.getColor(onCreateDialog.getContext(), R.color.white_background_color));
                    if (Build.VERSION.SDK_INT >= 26) {
                        window.getDecorView().setSystemUiVisibility(16);
                    } else {
                        window.addFlags(134217728);
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        window.setNavigationBarDividerColor(ContextCompat.getColor(onCreateDialog.getContext(), R.color.p101xp_navigation_bar_divider));
                    }
                }
            }
            return onCreateDialog;
        }

        private final void closeButtonListener() {
            dismiss();
            Function0<Unit> function0 = this.cancelAction;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cancelAction");
                function0 = null;
            }
            function0.invoke();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            FragmentActivity activity;
            Resources resources;
            Configuration configuration;
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            String str = null;
            View inflate = layoutInflater.inflate(R.layout.dialogs_web_managment, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.web_dialogs);
            Intrinsics.checkNotNullExpressionValue(findViewById, "webDialogView.findViewBy…ebView>(R.id.web_dialogs)");
            this.webView = (WebView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.web_close_button_portrait);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "webDialogView.findViewBy…eb_close_button_portrait)");
            this.webCloseButtonPortrait = (ImageButton) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.web_close_button_landscape);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "webDialogView.findViewBy…b_close_button_landscape)");
            this.webCloseButtonLandscape = (ImageButton) findViewById3;
            FragmentActivity activity2 = getActivity();
            if ((activity2 == null || (resources = activity2.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 1) ? false : true) {
                ImageButton imageButton = this.webCloseButtonPortrait;
                if (imageButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonPortrait");
                    imageButton = null;
                }
                imageButton.setVisibility(0);
            } else {
                ImageButton imageButton2 = this.webCloseButtonLandscape;
                if (imageButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonLandscape");
                    imageButton2 = null;
                }
                imageButton2.setVisibility(0);
            }
            Platform101XPScreenOrientation platform101XPScreenOrientation = this.screenOrientation;
            if (platform101XPScreenOrientation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenOrientation");
                platform101XPScreenOrientation = null;
            }
            if (platform101XPScreenOrientation.isHorizontal()) {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.setRequestedOrientation(0);
                }
            } else {
                Platform101XPScreenOrientation platform101XPScreenOrientation2 = this.screenOrientation;
                if (platform101XPScreenOrientation2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenOrientation");
                    platform101XPScreenOrientation2 = null;
                }
                if (platform101XPScreenOrientation2.isVertical() && (activity = getActivity()) != null) {
                    activity.setRequestedOrientation(1);
                }
            }
            ImageButton imageButton3 = this.webCloseButtonPortrait;
            if (imageButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonPortrait");
                imageButton3 = null;
            }
            imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWebDialogWrapper.DialogFragmentWrapper.m147onCreateView$lambda2(Platform101XPWebDialogWrapper.DialogFragmentWrapper.this, view);
                }
            });
            ImageButton imageButton4 = this.webCloseButtonLandscape;
            if (imageButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webCloseButtonLandscape");
                imageButton4 = null;
            }
            imageButton4.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWebDialogWrapper.DialogFragmentWrapper.m148onCreateView$lambda3(Platform101XPWebDialogWrapper.DialogFragmentWrapper.this, view);
                }
            });
            WebView webView = this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.getSettings().setDomStorageEnabled(true);
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView2 = null;
            }
            webView2.getSettings().setJavaScriptEnabled(true);
            WebView webView3 = this.webView;
            if (webView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView3 = null;
            }
            webView3.getSettings().setAppCacheEnabled(false);
            WebView webView4 = this.webView;
            if (webView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView4 = null;
            }
            webView4.setWebViewClient(new WebViewClient() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$onCreateView$3
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView5, String str2) {
                    boolean z;
                    String str3;
                    Platform101XPWebDialogWrapper.DialogFragmentWrapper.Companion.setShowing(false);
                    Log.d("101XP SDK", "onPageFinished url: " + ((Object) str2) + ' ');
                    z = Platform101XPWebDialogWrapper.DialogFragmentWrapper.this.isFirstCall;
                    if (z) {
                        Platform101XPWebDialogWrapper.DialogFragmentWrapper dialogFragmentWrapper = Platform101XPWebDialogWrapper.DialogFragmentWrapper.this;
                        str3 = dialogFragmentWrapper.jsFunction;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("jsFunction");
                            str3 = null;
                        }
                        dialogFragmentWrapper.evaluateJs(str3);
                    }
                    Platform101XPWebDialogWrapper.DialogFragmentWrapper.this.isFirstCall = false;
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView5, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Log.d("101XP SDK", Intrinsics.stringPlus("webView error ", webResourceError));
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView5, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Log.d("101XP SDK", Intrinsics.stringPlus("webView error ", sslError));
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView5, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    Log.d("101XP SDK", Intrinsics.stringPlus("webView error ", webResourceResponse));
                    super.onReceivedHttpError(webView5, webResourceRequest, webResourceResponse);
                }
            });
            WebView webView5 = this.webView;
            if (webView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView5 = null;
            }
            webView5.setWebChromeClient(new WebChromeClient() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$onCreateView$4
                @Override // android.webkit.WebChromeClient
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onShowFileChooser(android.webkit.WebView r2, android.webkit.ValueCallback<android.net.Uri[]> r3, android.webkit.WebChromeClient.FileChooserParams r4) {
                    /*
                        r1 = this;
                        com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper r2 = com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.this
                        com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.access$setFileCallback$p(r2, r3)
                        android.content.Intent r2 = new android.content.Intent
                        java.lang.String r3 = "android.intent.action.GET_CONTENT"
                        r2.<init>(r3)
                        java.lang.String r3 = "android.intent.category.OPENABLE"
                        r2.addCategory(r3)
                        java.lang.String r3 = "image/*"
                        r2.setType(r3)
                        com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper r3 = com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.this
                        androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
                        r4 = 1
                        if (r3 == 0) goto L21
                        r3 = 1
                        goto L22
                    L21:
                        r3 = 0
                    L22:
                        if (r3 != r4) goto L34
                        com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper r3 = com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.this
                        androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
                        if (r3 != 0) goto L2d
                        goto L43
                    L2d:
                        r0 = 51182(0xc7ee, float:7.1721E-41)
                        r3.startActivityForResult(r2, r0)
                        goto L43
                    L34:
                        if (r3 != 0) goto L43
                        com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper r2 = com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.this
                        android.webkit.ValueCallback r2 = com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper.DialogFragmentWrapper.access$getFileCallback$p(r2)
                        if (r2 != 0) goto L3f
                        goto L43
                    L3f:
                        r3 = 0
                        r2.onReceiveValue(r3)
                    L43:
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$onCreateView$4.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
                }
            });
            WebView webView6 = this.webView;
            if (webView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView6 = null;
            }
            webView6.setOnKeyListener(new View.OnKeyListener() { // from class: com.platform101xp.sdk.internal.dialogs.webdialogs.Platform101XPWebDialogWrapper$DialogFragmentWrapper$onCreateView$5
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    Intrinsics.checkNotNullParameter(view, "v");
                    Intrinsics.checkNotNullParameter(keyEvent, "event");
                    WebView webView7 = (WebView) view;
                    if (i != 4 || !webView7.canGoBack()) {
                        return false;
                    }
                    webView7.goBack();
                    return true;
                }
            });
            WebView webView7 = this.webView;
            if (webView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView7 = null;
            }
            Object obj = this.jsInterface;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
                obj = Unit.INSTANCE;
            }
            webView7.addJavascriptInterface(obj, Platform101XPWebDialogsConstructor.JS_INTERFACE_NAME);
            sendWebViewOrientation();
            WebView webView8 = this.webView;
            if (webView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView8 = null;
            }
            String str2 = this.url;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TJAdUnitConstants.String.URL);
            } else {
                str = str2;
            }
            webView8.loadUrl(str);
            return inflate;
        }

        /* renamed from: onCreateView$lambda-2 */
        public static final void m147onCreateView$lambda2(DialogFragmentWrapper dialogFragmentWrapper, View view) {
            Intrinsics.checkNotNullParameter(dialogFragmentWrapper, "this$0");
            dialogFragmentWrapper.closeButtonListener();
        }

        /* renamed from: onCreateView$lambda-3 */
        public static final void m148onCreateView$lambda3(DialogFragmentWrapper dialogFragmentWrapper, View view) {
            Intrinsics.checkNotNullParameter(dialogFragmentWrapper, "this$0");
            dialogFragmentWrapper.closeButtonListener();
        }

        public void onCancel(DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
            Platform101XPWebDialogWrapper.super.onCancel(dialogInterface);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            Function0<Unit> function0 = this.cancelAction;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cancelAction");
                function0 = null;
            }
            function0.invoke();
        }

        public void dismiss() {
            Platform101XPWebDialogWrapper.super.dismiss();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            ValueCallback<Uri[]> valueCallback;
            Uri data;
            if (i != 51182 || (valueCallback = this.fileCallback) == null) {
                return;
            }
            if (intent != null && (data = intent.getData()) != null) {
                valueCallback.onReceiveValue(new Uri[]{data});
            }
            this.fileCallback = null;
        }

        private final void sendWebViewOrientation() {
            Platform101XPScreenOrientation platform101XPScreenOrientation = this.screenOrientation;
            if (platform101XPScreenOrientation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenOrientation");
                platform101XPScreenOrientation = null;
            }
            String str = platform101XPScreenOrientation.isVertical() ? TJAdUnitConstants.String.PORTRAIT : TJAdUnitConstants.String.LANDSCAPE;
            evaluateJs("javascript:window.setOrientation(" + str + ')');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPWebDialogWrapper(Activity activity, String str, Platform101XPScreenOrientation platform101XPScreenOrientation, String str2, Object obj, Platform101XPAnalytics platform101XPAnalytics, Function0<Unit> function0) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, TJAdUnitConstants.String.URL);
        Intrinsics.checkNotNullParameter(platform101XPScreenOrientation, "screenOrientation");
        Intrinsics.checkNotNullParameter(str2, "jsFunction");
        Intrinsics.checkNotNullParameter(obj, "jsInterface");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "analytics");
        Intrinsics.checkNotNullParameter(function0, "cancelAction");
        this.activity = activity;
        this.url = str;
        this.screenOrientation = platform101XPScreenOrientation;
        this.jsFunction = str2;
        this.jsInterface = obj;
        this.analytics = platform101XPAnalytics;
        this.cancelAction = function0;
    }

    @Override // android.app.Dialog
    public void show() {
        Platform101XPWebFragmentActivity.Companion.setCurrentDialog((DialogFragment) DialogFragmentWrapper.Companion.getDialogInstance(this.url, this.jsFunction, this.screenOrientation, this.jsInterface, (Function0) new Platform101XPWebDialogWrapper$show$1(this)));
        Intent intent = new Intent(this.activity, Platform101XPWebFragmentActivity.class);
        if (this.screenOrientation.isHorizontal() || this.screenOrientation.isVertical()) {
            this.screenOrientation.setRotation(false);
        }
        intent.putExtra(Platform101XPWebFragmentActivity.EXTRA_SCREEN_ROTATION_DISABLED, this.screenOrientation.isRotation());
        this.analytics.track("sdk_mobvid_open", null);
        if (!DialogFragmentWrapper.Companion.isShowing()) {
            DialogFragmentWrapper.Companion.setShowing(true);
            this.activity.startActivity(intent);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.analytics.track("sdk_mobvid_close", null);
        DialogFragment currentDialog = Platform101XPWebFragmentActivity.Companion.getCurrentDialog();
        if (currentDialog == null) {
            return;
        }
        currentDialog.dismiss();
    }
}
