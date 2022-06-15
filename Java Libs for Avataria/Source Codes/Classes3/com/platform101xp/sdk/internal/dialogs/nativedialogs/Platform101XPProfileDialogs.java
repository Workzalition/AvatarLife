package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener;
import com.platform101xp.sdk.internal.support.Platform101XPSupport;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPProfileDialogs.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0002082\u0006\u00103\u001a\u000204H\u0002J\b\u00109\u001a\u000208H\u0002R\u001c\u0010\b\u001a\u00020\t@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u0005@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u00020\u0007@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProfileDialogs;", "", "currentActivity", "Landroid/app/Activity;", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "eulaDialog", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "buttonEula", "Landroid/widget/Button;", "buttonLogout", "buttonReport", "buttonSn", "closeButton", "Landroid/widget/ImageButton;", "collectLogsButton", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "getEulaDialog", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;", "setEulaDialog", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;)V", "profileDialog", "Landroid/app/Dialog;", "profileDialogView", "Landroid/view/View;", "userGameIdValue", "Landroid/widget/TextView;", "userIdLabel", "userIdValue", "userName", "createManagedProfileDialog", "isGuest", "", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "support", "Lcom/platform101xp/sdk/internal/support/Platform101XPSupport;", "profileActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "userGameId", "", "initButtonProfileDialog", "", "showEulaBrowserWarning", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPProfileDialogs {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_EULA_URL = "https://mobile.101xp.com/pages/privacy-policy-terms-of-service";
    private Platform101XPAnalytics analytics;
    private Button buttonEula;
    private Button buttonLogout;
    private Button buttonReport;
    private Button buttonSn;
    private ImageButton closeButton;
    private Button collectLogsButton;
    private Activity currentActivity;
    private Platform101XPDialogCreator dialogCreator;
    private Platform101XPEulaDialog eulaDialog;
    private Dialog profileDialog;
    private final View profileDialogView;
    private TextView userGameIdValue;
    private TextView userIdLabel;
    private TextView userIdValue;
    private TextView userName;

    @Inject
    public Platform101XPProfileDialogs(Activity activity, Platform101XPDialogCreator platform101XPDialogCreator, Platform101XPEulaDialog platform101XPEulaDialog, Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "eulaDialog");
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "analytics");
        this.currentActivity = activity;
        this.dialogCreator = platform101XPDialogCreator;
        this.eulaDialog = platform101XPEulaDialog;
        this.analytics = platform101XPAnalytics;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.profileDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_managment_authorization, (ViewGroup) null) : null;
        Activity activity2 = this.currentActivity;
        if (activity2 == null) {
            return;
        }
        activity2.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPProfileDialogs.m115_init_$lambda10(Platform101XPProfileDialogs.this);
            }
        });
    }

    public final Platform101XPAnalytics getAnalytics() {
        return this.analytics;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public final Platform101XPDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    public final Platform101XPEulaDialog getEulaDialog() {
        return this.eulaDialog;
    }

    @Inject
    public final void setAnalytics(Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "<set-?>");
        this.analytics = platform101XPAnalytics;
    }

    @Inject
    public final void setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
    }

    @Inject
    public final void setDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "<set-?>");
        this.dialogCreator = platform101XPDialogCreator;
    }

    @Inject
    public final void setEulaDialog(Platform101XPEulaDialog platform101XPEulaDialog) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "<set-?>");
        this.eulaDialog = platform101XPEulaDialog;
    }

    /* compiled from: Platform101XPProfileDialogs.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProfileDialogs$Companion;", "", "()V", "DEFAULT_EULA_URL", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: _init_$lambda-10 */
    public static final void m115_init_$lambda10(Platform101XPProfileDialogs platform101XPProfileDialogs) {
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "this$0");
        View view = platform101XPProfileDialogs.profileDialogView;
        Button button = null;
        platform101XPProfileDialogs.closeButton = view == null ? null : (ImageButton) view.findViewById(R.id.button_close);
        View view2 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.buttonLogout = view2 == null ? null : (Button) view2.findViewById(R.id.button_logout);
        View view3 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.buttonReport = view3 == null ? null : (Button) view3.findViewById(R.id.button_report);
        View view4 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.buttonSn = view4 == null ? null : (Button) view4.findViewById(R.id.bind_sn_button);
        View view5 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.buttonEula = view5 == null ? null : (Button) view5.findViewById(R.id.eula_text_button);
        View view6 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.userName = view6 == null ? null : (TextView) view6.findViewById(R.id.username_textview);
        View view7 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.userGameIdValue = view7 == null ? null : (TextView) view7.findViewById(R.id.user_game_id_value);
        View view8 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.userIdLabel = view8 == null ? null : (TextView) view8.findViewById(R.id.p101xp_id_label);
        View view9 = platform101XPProfileDialogs.profileDialogView;
        platform101XPProfileDialogs.userIdValue = view9 == null ? null : (TextView) view9.findViewById(R.id.p101xp_id_value);
        View view10 = platform101XPProfileDialogs.profileDialogView;
        if (view10 != null) {
            button = (Button) view10.findViewById(R.id.button_collect_logs);
        }
        platform101XPProfileDialogs.collectLogsButton = button;
        platform101XPProfileDialogs.profileDialog = platform101XPProfileDialogs.dialogCreator.createDialog(platform101XPProfileDialogs.profileDialogView, true, Platform101XPDialogType.DIALOG_MANAGED_AUTHORIZE);
    }

    private final void initButtonProfileDialog(final Platform101XPProfileActionsListener platform101XPProfileActionsListener) {
        Dialog dialog = this.profileDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileDialog");
            dialog = null;
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                Platform101XPProfileDialogs.m117initButtonProfileDialog$lambda11(Platform101XPProfileActionsListener.this, dialogInterface);
            }
        });
        Button button = this.buttonLogout;
        if (button != null) {
            button.setTransformationMethod(null);
        }
        Button button2 = this.buttonLogout;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPProfileDialogs.m118initButtonProfileDialog$lambda12(Platform101XPProfileActionsListener.this, this, view);
                }
            });
        }
        ImageButton imageButton = this.closeButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPProfileDialogs.m119initButtonProfileDialog$lambda13(Platform101XPProfileDialogs.this, platform101XPProfileActionsListener, view);
                }
            });
        }
        Button button3 = this.buttonSn;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPProfileDialogs.m120initButtonProfileDialog$lambda14(Platform101XPProfileActionsListener.this, view);
                }
            });
        }
        Button button4 = this.buttonEula;
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPProfileDialogs.m121initButtonProfileDialog$lambda16(Platform101XPProfileDialogs.this, view);
                }
            });
        }
        Button button5 = this.collectLogsButton;
        if (button5 == null) {
            return;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Platform101XPProfileDialogs.m122initButtonProfileDialog$lambda17(Platform101XPProfileActionsListener.this, view);
            }
        });
    }

    /* renamed from: initButtonProfileDialog$lambda-11 */
    public static final void m117initButtonProfileDialog$lambda11(Platform101XPProfileActionsListener platform101XPProfileActionsListener, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "$profileActionsListener");
        platform101XPProfileActionsListener.onDismissDialog();
    }

    /* renamed from: initButtonProfileDialog$lambda-12 */
    public static final void m118initButtonProfileDialog$lambda12(Platform101XPProfileActionsListener platform101XPProfileActionsListener, Platform101XPProfileDialogs platform101XPProfileDialogs, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "$profileActionsListener");
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "this$0");
        Dialog dialog = null;
        Platform101XPProfileActionsListener.DefaultImpls.onLogoutClick$default(platform101XPProfileActionsListener, 0L, 1, null);
        Dialog dialog2 = platform101XPProfileDialogs.profileDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileDialog");
        } else {
            dialog = dialog2;
        }
        dialog.cancel();
    }

    /* renamed from: initButtonProfileDialog$lambda-13 */
    public static final void m119initButtonProfileDialog$lambda13(Platform101XPProfileDialogs platform101XPProfileDialogs, Platform101XPProfileActionsListener platform101XPProfileActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "$profileActionsListener");
        Dialog dialog = platform101XPProfileDialogs.profileDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileDialog");
            dialog = null;
        }
        dialog.cancel();
        platform101XPProfileActionsListener.onCloseClick();
    }

    /* renamed from: initButtonProfileDialog$lambda-14 */
    public static final void m120initButtonProfileDialog$lambda14(Platform101XPProfileActionsListener platform101XPProfileActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "$profileActionsListener");
        platform101XPProfileActionsListener.onAuthorizeClick();
    }

    /* renamed from: initButtonProfileDialog$lambda-16 */
    public static final void m121initButtonProfileDialog$lambda16(Platform101XPProfileDialogs platform101XPProfileDialogs, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://mobile.101xp.com/pages/privacy-policy-terms-of-service"));
        Activity activity = platform101XPProfileDialogs.currentActivity;
        if (activity == null) {
            return;
        }
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            platform101XPProfileDialogs.getAnalytics().track("sdk_eula_read", null);
            activity.startActivity(intent);
            return;
        }
        platform101XPProfileDialogs.showEulaBrowserWarning();
    }

    /* renamed from: initButtonProfileDialog$lambda-17 */
    public static final void m122initButtonProfileDialog$lambda17(Platform101XPProfileActionsListener platform101XPProfileActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "$profileActionsListener");
        platform101XPProfileActionsListener.onSendLogs();
    }

    public final Dialog createManagedProfileDialog(boolean z, Platform101XPAccount platform101XPAccount, final Platform101XPSupport platform101XPSupport, final Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j) {
        TextView textView;
        Intrinsics.checkNotNullParameter(platform101XPAccount, "account");
        Intrinsics.checkNotNullParameter(platform101XPSupport, "support");
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "profileActionsListener");
        Platform101XPDialogs.OnUserCancelAction onUserCancelAction = new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$createManagedProfileDialog$cancelAction$1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                Platform101XPProfileActionsListener.this.onCloseClick();
            }
        };
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog = this.profileDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileDialog");
            dialog = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog, onUserCancelAction);
        initButtonProfileDialog(platform101XPProfileActionsListener);
        if (platform101XPSupport.isEnabled()) {
            Button button = this.buttonReport;
            if (button != null) {
                button.setVisibility(0);
            }
            Button button2 = this.buttonReport;
            if (button2 != null) {
                button2.setTransformationMethod(null);
            }
            Button button3 = this.buttonReport;
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProfileDialogs$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Platform101XPProfileDialogs.m116createManagedProfileDialog$lambda18(Platform101XPProfileDialogs.this, platform101XPSupport, view);
                    }
                });
            }
        } else {
            Button button4 = this.buttonReport;
            if (button4 != null) {
                button4.setVisibility(8);
            }
            View view = this.profileDialogView;
            if (view != null) {
                View findViewById = view.findViewById(R.id.android_report_layout);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
                findViewById.setVisibility(8);
            }
        }
        TextView textView2 = this.userName;
        if (textView2 != null) {
            String userName = platform101XPAccount.getUserName();
            if (userName == null) {
                userName = "";
            }
            textView2.setText(userName);
        }
        if (j > 0 && (textView = this.userGameIdValue) != null) {
            textView.setText(String.valueOf(j));
        }
        if (z) {
            Button button5 = this.buttonSn;
            if (button5 != null) {
                button5.setVisibility(0);
            }
            View view2 = this.profileDialogView;
            if (view2 != null) {
                View findViewById2 = view2.findViewById(R.id.bind_sn_text);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
                findViewById2.setVisibility(0);
            }
            View view3 = this.profileDialogView;
            if (view3 != null) {
                View findViewById3 = view3.findViewById(R.id.manage_divisor);
                Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
                findViewById3.setVisibility(0);
            }
            TextView textView3 = this.userIdLabel;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.userIdValue;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        } else {
            Button button6 = this.buttonSn;
            if (button6 != null) {
                button6.setVisibility(8);
            }
            View view4 = this.profileDialogView;
            if (view4 != null) {
                View findViewById4 = view4.findViewById(R.id.bind_sn_text);
                Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
                findViewById4.setVisibility(8);
            }
            View view5 = this.profileDialogView;
            if (view5 != null) {
                View findViewById5 = view5.findViewById(R.id.manage_divisor);
                Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
                findViewById5.setVisibility(8);
            }
            if (platform101XPAccount.getId() != -1 && platform101XPAccount.getId() != j) {
                TextView textView5 = this.userIdLabel;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                }
                TextView textView6 = this.userIdValue;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.userIdValue;
                if (textView7 != null) {
                    textView7.setText(String.valueOf(platform101XPAccount.getId()));
                }
            }
        }
        Dialog dialog2 = this.profileDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileDialog");
            return null;
        }
        return dialog2;
    }

    /* renamed from: createManagedProfileDialog$lambda-18 */
    public static final void m116createManagedProfileDialog$lambda18(Platform101XPProfileDialogs platform101XPProfileDialogs, Platform101XPSupport platform101XPSupport, View view) {
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPSupport, "$support");
        platform101XPProfileDialogs.analytics.track("sdk_support_open", null);
        platform101XPSupport.showSupportForm();
    }

    private final void showEulaBrowserWarning() {
        new AlertDialog.Builder(this.currentActivity).setMessage(R.string.eula_browser_alert_text).setPositiveButton("Ok", Platform101XPProfileDialogs$$ExternalSyntheticLambda0.INSTANCE).create().show();
    }

    /* renamed from: showEulaBrowserWarning$lambda-24 */
    public static final void m123showEulaBrowserWarning$lambda24(DialogInterface dialogInterface, int i) {
        if (dialogInterface == null) {
            return;
        }
        dialogInterface.dismiss();
    }
}
