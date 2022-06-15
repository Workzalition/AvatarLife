package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPEulaDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u000389:B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u001c\u00100\u001a\u000601R\u00020\u00002\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020.H\u0002J\u0012\u00107\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000103H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u0007@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u0005@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006;"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;", "", "currentActivity", "Landroid/app/Activity;", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/Platform101XPSettings;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "acceptButton", "Landroid/widget/Button;", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getConfigManager", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "setConfigManager", "(Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;)V", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "eulaDialog", "Landroid/app/Dialog;", "eulaDialogView", "Landroid/view/View;", "eulaUrl", "", "isEulaEnabled", "", "isLicenseAccepted", "readButton", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "setSettings", "(Lcom/platform101xp/sdk/internal/Platform101XPSettings;)V", "checkEulaEnabled", "", "dismissDialog", "getDialog", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$EulaDialogWrapper;", "authorizeListener", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;", "cancelAction", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "showEulaBrowserWarning", "showEulaDialog", "AuthorizeListener", "Companion", "EulaDialogWrapper", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPEulaDialog {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_EULA_URL = "https://mobile.101xp.com/pages/privacy-policy-terms-of-service";
    public static final String EULA_DIALOG_AUTHORIZE_ACTION = "eula_dialog_authorize_action_tag";
    public static final String LICENSE_ACCEPTED_KEY = "com.platform101xp.sdk.license_accepted_key";
    private Button acceptButton;
    private Platform101XPAnalytics analytics;
    private Platform101XPConfigManager configManager;
    private Activity currentActivity;
    private Platform101XPDialogCreator dialogCreator;
    private Dialog eulaDialog;
    private View eulaDialogView;
    private String eulaUrl;
    private boolean isEulaEnabled = true;
    private boolean isLicenseAccepted;
    private Button readButton;
    private Platform101XPSettings settings;

    /* compiled from: Platform101XPEulaDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;", "", "doAuthorizeAction", "", "isFirstAppLaunch", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface AuthorizeListener {
        void doAuthorizeAction(boolean z);
    }

    @Inject
    public Platform101XPEulaDialog(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPConfigManager platform101XPConfigManager, Platform101XPSettings platform101XPSettings, Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "analytics");
        this.currentActivity = activity;
        this.dialogCreator = platform101XPDialogCreator;
        this.configManager = platform101XPConfigManager;
        this.settings = platform101XPSettings;
        this.analytics = platform101XPAnalytics;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.eulaDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_eula, (ViewGroup) null) : null;
        checkEulaEnabled();
        this.eulaUrl = this.configManager.getString(Platform101XPConfigKeyHolder.eulaUrl, "https://mobile.101xp.com/pages/privacy-policy-terms-of-service");
        this.currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPEulaDialog.m96_init_$lambda0(Platform101XPEulaDialog.this);
            }
        });
        this.isLicenseAccepted = this.settings.getBoolean(LICENSE_ACCEPTED_KEY, false);
    }

    public final Platform101XPAnalytics getAnalytics() {
        return this.analytics;
    }

    public final Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public final Platform101XPDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    @Inject
    public final void setAnalytics(Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "<set-?>");
        this.analytics = platform101XPAnalytics;
    }

    @Inject
    public final void setConfigManager(Platform101XPConfigManager platform101XPConfigManager) {
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "<set-?>");
        this.configManager = platform101XPConfigManager;
    }

    @Inject
    public final void setCurrentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.currentActivity = activity;
    }

    @Inject
    public final void setDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "<set-?>");
        this.dialogCreator = platform101XPDialogCreator;
    }

    @Inject
    public final void setSettings(Platform101XPSettings platform101XPSettings) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "<set-?>");
        this.settings = platform101XPSettings;
    }

    /* compiled from: Platform101XPEulaDialog.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$Companion;", "", "()V", "DEFAULT_EULA_URL", "", "EULA_DIALOG_AUTHORIZE_ACTION", "LICENSE_ACCEPTED_KEY", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: _init_$lambda-0 */
    public static final void m96_init_$lambda0(Platform101XPEulaDialog platform101XPEulaDialog) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        View view = platform101XPEulaDialog.eulaDialogView;
        Button button = null;
        platform101XPEulaDialog.readButton = view == null ? null : (Button) view.findViewById(R.id.eula_read_btn);
        View view2 = platform101XPEulaDialog.eulaDialogView;
        if (view2 != null) {
            button = (Button) view2.findViewById(R.id.eula_accept_btn);
        }
        platform101XPEulaDialog.acceptButton = button;
        platform101XPEulaDialog.eulaDialog = platform101XPEulaDialog.dialogCreator.createDialog(platform101XPEulaDialog.eulaDialogView, false, Platform101XPDialogType.DIALOG_EULA);
    }

    private final void checkEulaEnabled() {
        this.isEulaEnabled = this.configManager.getBool(Platform101XPConfigKeyHolder.eulaShowEnabled, true);
    }

    public final EulaDialogWrapper getDialog(AuthorizeListener authorizeListener, Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        Context applicationContext = this.currentActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "currentActivity.applicationContext");
        EulaDialogWrapper eulaDialogWrapper = new EulaDialogWrapper(this, authorizeListener, applicationContext);
        this.dialogCreator.getDialogs()[Platform101XPDialogType.DIALOG_EULA.ordinal()] = eulaDialogWrapper;
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog = this.eulaDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eulaDialog");
            dialog = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog, onUserCancelAction);
        return eulaDialogWrapper;
    }

    public final void dismissDialog() {
        this.currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPEulaDialog.m97dismissDialog$lambda2(Platform101XPEulaDialog.this);
            }
        });
    }

    /* renamed from: dismissDialog$lambda-2 */
    public static final void m97dismissDialog$lambda2(Platform101XPEulaDialog platform101XPEulaDialog) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        Dialog dialog = platform101XPEulaDialog.eulaDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eulaDialog");
            dialog = null;
        }
        if (dialog.isShowing()) {
            Log.d("101XP SDK", "Dismiss dialog EULA Platform101XPEulaDialog");
            dialog.dismiss();
        }
    }

    public final void showEulaDialog(final AuthorizeListener authorizeListener) {
        this.currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPEulaDialog.m100showEulaDialog$lambda6(Platform101XPEulaDialog.this, authorizeListener);
            }
        });
    }

    /* renamed from: showEulaDialog$lambda-6 */
    public static final void m100showEulaDialog$lambda6(Platform101XPEulaDialog platform101XPEulaDialog, final AuthorizeListener authorizeListener) {
        Button button;
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        Button button2 = platform101XPEulaDialog.readButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPEulaDialog.m101showEulaDialog$lambda6$lambda4(Platform101XPEulaDialog.this, view);
                }
            });
        }
        if (authorizeListener == null && (button = platform101XPEulaDialog.acceptButton) != null) {
            button.setText(R.string.eula_close_text);
        }
        Button button3 = platform101XPEulaDialog.acceptButton;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPEulaDialog.m102showEulaDialog$lambda6$lambda5(Platform101XPEulaDialog.this, authorizeListener, view);
                }
            });
        }
        Dialog dialog = null;
        platform101XPEulaDialog.analytics.track("sdk_eula_show", null);
        Dialog dialog2 = platform101XPEulaDialog.eulaDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eulaDialog");
        } else {
            dialog = dialog2;
        }
        dialog.show();
    }

    /* renamed from: showEulaDialog$lambda-6$lambda-4 */
    public static final void m101showEulaDialog$lambda6$lambda4(Platform101XPEulaDialog platform101XPEulaDialog, View view) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(platform101XPEulaDialog.eulaUrl));
        Activity activity = platform101XPEulaDialog.currentActivity;
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            platform101XPEulaDialog.getAnalytics().track("sdk_eula_read", null);
            activity.startActivity(intent);
            return;
        }
        platform101XPEulaDialog.showEulaBrowserWarning();
    }

    /* renamed from: showEulaDialog$lambda-6$lambda-5 */
    public static final void m102showEulaDialog$lambda6$lambda5(Platform101XPEulaDialog platform101XPEulaDialog, AuthorizeListener authorizeListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        platform101XPEulaDialog.dismissDialog();
        platform101XPEulaDialog.isLicenseAccepted = true;
        platform101XPEulaDialog.settings.setBoolean(LICENSE_ACCEPTED_KEY, true);
        platform101XPEulaDialog.analytics.track("sdk_eula_accepted", null);
        if (authorizeListener == null) {
            return;
        }
        authorizeListener.doAuthorizeAction(true);
    }

    private final void showEulaBrowserWarning() {
        this.currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPEulaDialog.m98showEulaBrowserWarning$lambda8(Platform101XPEulaDialog.this);
            }
        });
    }

    /* renamed from: showEulaBrowserWarning$lambda-8 */
    public static final void m98showEulaBrowserWarning$lambda8(Platform101XPEulaDialog platform101XPEulaDialog) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
        new AlertDialog.Builder(platform101XPEulaDialog.currentActivity).setMessage(R.string.eula_browser_alert_text).setPositiveButton("Ok", Platform101XPEulaDialog$$ExternalSyntheticLambda0.INSTANCE).create().show();
    }

    /* renamed from: showEulaBrowserWarning$lambda-8$lambda-7 */
    public static final void m99showEulaBrowserWarning$lambda8$lambda7(DialogInterface dialogInterface, int i) {
        if (dialogInterface == null) {
            return;
        }
        dialogInterface.dismiss();
    }

    /* compiled from: Platform101XPEulaDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$EulaDialogWrapper;", "Landroid/app/Dialog;", "authorizeListener", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;", "context", "Landroid/content/Context;", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;Landroid/content/Context;)V", "getAuthorizeListener", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;", "setAuthorizeListener", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;)V", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL, "", "isShowing", "", TJAdUnitConstants.String.BEACON_SHOW_PATH, "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public final class EulaDialogWrapper extends Dialog {
        private AuthorizeListener authorizeListener;
        final /* synthetic */ Platform101XPEulaDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EulaDialogWrapper(Platform101XPEulaDialog platform101XPEulaDialog, AuthorizeListener authorizeListener, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = platform101XPEulaDialog;
            this.authorizeListener = authorizeListener;
        }

        public final AuthorizeListener getAuthorizeListener() {
            return this.authorizeListener;
        }

        public final void setAuthorizeListener(AuthorizeListener authorizeListener) {
            this.authorizeListener = authorizeListener;
        }

        @Override // android.app.Dialog
        public void show() {
            if (this.this$0.isEulaEnabled && (!this.this$0.isLicenseAccepted || this.authorizeListener == null)) {
                this.this$0.showEulaDialog(this.authorizeListener);
                return;
            }
            AuthorizeListener authorizeListener = this.authorizeListener;
            if (authorizeListener == null) {
                return;
            }
            authorizeListener.doAuthorizeAction(false);
        }

        @Override // android.app.Dialog
        public boolean isShowing() {
            Dialog dialog = this.this$0.eulaDialog;
            if (dialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eulaDialog");
                dialog = null;
            }
            return dialog.isShowing();
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            this.this$0.dismissDialog();
        }
    }
}
