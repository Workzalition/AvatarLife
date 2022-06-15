package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPWarningDialogs.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001%B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\"\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\"\u0010\u001d\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J0\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010 \u001a\u00020\u001bJ\u0006\u0010!\u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0016\u0010#\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0006\u0010$\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs;", "", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "cancelButton", "Landroid/widget/Button;", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "exitButton", "firstDivisor", "Landroid/view/View;", "warningDialog", "Landroid/app/Dialog;", "warningDialogView", "warningText", "Landroid/widget/TextView;", "warningTitle", "yesButton", "createAccountHasBindWarningDialog", "cancelAction", "Lkotlin/Function0;", "", "createAuthorizeActionWarningDialog", "bindAction", "createBindProgressWarning", "Landroid/app/AlertDialog;", "agreeAction", "createGuestAuthorizeWarningDialog", "createGuestLogoutWarningDialog", "exitAction", "createToManyOperationsDialog", "createWarningFacebookDialog", "setBindAction", "setCancelAction", "userNotLoggedInDialog", "WarningType", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWarningDialogs {
    private Button cancelButton;
    private Platform101XPDialogCreator dialogCreator;
    private Button exitButton;
    private View firstDivisor;
    private Dialog warningDialog;
    private View warningDialogView;
    private TextView warningText;
    private TextView warningTitle;
    private Button yesButton;

    /* compiled from: Platform101XPWarningDialogs.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs$WarningType;", "", "(Ljava/lang/String;I)V", "GUEST_AUTHORISE_WARNING", "GUEST_LOGOUT_WARNING", "AUTHORIZE_ACTION_WARNING", "ACCOUNT_HAS_BIND_WARNING", "HAS_BIND_PROGRESS_WARNING", "FACEBOOK_WARNING", "TO_MANY_OPERATIONS_WARNING", "USER_NOT_LOGGED_IN_WARNING", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public enum WarningType {
        GUEST_AUTHORISE_WARNING,
        GUEST_LOGOUT_WARNING,
        AUTHORIZE_ACTION_WARNING,
        ACCOUNT_HAS_BIND_WARNING,
        HAS_BIND_PROGRESS_WARNING,
        FACEBOOK_WARNING,
        TO_MANY_OPERATIONS_WARNING,
        USER_NOT_LOGGED_IN_WARNING
    }

    @Inject
    public Platform101XPWarningDialogs(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        this.dialogCreator = platform101XPDialogCreator;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.warningDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_bind_progress, (ViewGroup) null) : null;
        this.dialogCreator.getCurrentActivity().runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPWarningDialogs.m133_init_$lambda6(Platform101XPWarningDialogs.this);
            }
        });
    }

    public final Platform101XPDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    @Inject
    public final void setDialogCreator(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "<set-?>");
        this.dialogCreator = platform101XPDialogCreator;
    }

    /* renamed from: _init_$lambda-6 */
    public static final void m133_init_$lambda6(Platform101XPWarningDialogs platform101XPWarningDialogs) {
        TextView textView;
        TextView textView2;
        View view;
        Button button;
        Button button2;
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        View view2 = platform101XPWarningDialogs.warningDialogView;
        Button button3 = null;
        if (view2 == null) {
            textView = null;
        } else {
            View findViewById = view2.findViewById(R.id.attention_label);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            textView = (TextView) findViewById;
        }
        platform101XPWarningDialogs.warningTitle = textView;
        View view3 = platform101XPWarningDialogs.warningDialogView;
        if (view3 == null) {
            textView2 = null;
        } else {
            View findViewById2 = view3.findViewById(R.id.attention_text);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            textView2 = (TextView) findViewById2;
        }
        platform101XPWarningDialogs.warningText = textView2;
        View view4 = platform101XPWarningDialogs.warningDialogView;
        if (view4 == null) {
            view = null;
        } else {
            view = view4.findViewById(R.id.first_divisor);
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.View");
        }
        platform101XPWarningDialogs.firstDivisor = view;
        View view5 = platform101XPWarningDialogs.warningDialogView;
        if (view5 == null) {
            button = null;
        } else {
            View findViewById3 = view5.findViewById(R.id.bind_button_101xp);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
            button = (Button) findViewById3;
        }
        platform101XPWarningDialogs.yesButton = button;
        View view6 = platform101XPWarningDialogs.warningDialogView;
        if (view6 == null) {
            button2 = null;
        } else {
            View findViewById4 = view6.findViewById(R.id.button_exit);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.Button");
            button2 = (Button) findViewById4;
        }
        platform101XPWarningDialogs.exitButton = button2;
        View view7 = platform101XPWarningDialogs.warningDialogView;
        if (view7 != null) {
            View findViewById5 = view7.findViewById(R.id.button_cancel);
            Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.Button");
            button3 = (Button) findViewById5;
        }
        platform101XPWarningDialogs.cancelButton = button3;
        platform101XPWarningDialogs.warningDialog = platform101XPWarningDialogs.dialogCreator.createDialog(platform101XPWarningDialogs.warningDialogView, true, Platform101XPDialogType.DIALOG_WARNING);
    }

    private final void setCancelAction(final Function0<Unit> function0) {
        Platform101XPDialogs.OnUserCancelAction onUserCancelAction = new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$setCancelAction$1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                function0.invoke();
            }
        };
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog, onUserCancelAction);
    }

    private final void setBindAction(final Function0<Unit> function0) {
        Button button = this.yesButton;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWarningDialogs.m142setBindAction$lambda7(function0, this, view);
                }
            });
        }
        Button button2 = this.yesButton;
        if (button2 == null) {
            return;
        }
        button2.setTransformationMethod(null);
    }

    /* renamed from: setBindAction$lambda-7 */
    public static final void m142setBindAction$lambda7(Function0 function0, Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(function0, "$bindAction");
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        function0.invoke();
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    public final Dialog createGuestAuthorizeWarningDialog(Function0<Unit> function0, final Function0<Unit> function02) {
        Button button;
        Button button2;
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "cancelAction");
        setCancelAction((Function0) new Platform101XPWarningDialogs$createGuestAuthorizeWarningDialog$1(function02));
        Button button3 = this.exitButton;
        if (button3 != null) {
            button3.setVisibility(8);
        }
        Button button4 = this.cancelButton;
        boolean z = true;
        if ((button4 != null && button4.getVisibility() == 8) && (button2 = this.cancelButton) != null) {
            button2.setVisibility(0);
        }
        Button button5 = this.yesButton;
        if (button5 == null || button5.getVisibility() != 8) {
            z = false;
        }
        if (z && (button = this.yesButton) != null) {
            button.setVisibility(0);
        }
        TextView textView = this.warningText;
        if (textView != null) {
            textView.setText(R.string.save_game_progress_text);
        }
        setBindAction(function0);
        Button button6 = this.cancelButton;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWarningDialogs.m137createGuestAuthorizeWarningDialog$lambda8(function02, this, view);
                }
            });
        }
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            return null;
        }
        return dialog;
    }

    /* renamed from: createGuestAuthorizeWarningDialog$lambda-8 */
    public static final void m137createGuestAuthorizeWarningDialog$lambda8(Function0 function0, Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        function0.invoke();
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    public final Dialog createGuestLogoutWarningDialog(Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        Button button;
        Button button2;
        Button button3;
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "exitAction");
        Intrinsics.checkNotNullParameter(function03, "cancelAction");
        setCancelAction((Function0) new Platform101XPWarningDialogs$createGuestLogoutWarningDialog$1(function03));
        Button button4 = this.yesButton;
        boolean z = true;
        if ((button4 != null && button4.getVisibility() == 8) && (button3 = this.yesButton) != null) {
            button3.setVisibility(0);
        }
        Button button5 = this.exitButton;
        if ((button5 != null && button5.getVisibility() == 8) && (button2 = this.exitButton) != null) {
            button2.setVisibility(0);
        }
        Button button6 = this.cancelButton;
        if (button6 == null || button6.getVisibility() != 8) {
            z = false;
        }
        if (z && (button = this.cancelButton) != null) {
            button.setVisibility(0);
        }
        TextView textView = this.warningText;
        if (textView != null) {
            textView.setText(R.string.save_game_progress_text);
        }
        setBindAction(function0);
        Button button7 = this.cancelButton;
        if (button7 != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWarningDialogs.m139createGuestLogoutWarningDialog$lambda9(function03, this, view);
                }
            });
        }
        Button button8 = this.exitButton;
        if (button8 != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWarningDialogs.m138createGuestLogoutWarningDialog$lambda10(Platform101XPWarningDialogs.this, function02, view);
                }
            });
        }
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            return null;
        }
        return dialog;
    }

    /* renamed from: createGuestLogoutWarningDialog$lambda-9 */
    public static final void m139createGuestLogoutWarningDialog$lambda9(Function0 function0, Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        function0.invoke();
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    /* renamed from: createGuestLogoutWarningDialog$lambda-10 */
    public static final void m138createGuestLogoutWarningDialog$lambda10(Platform101XPWarningDialogs platform101XPWarningDialogs, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$exitAction");
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
        function0.invoke();
    }

    public final Dialog createAuthorizeActionWarningDialog(Function0<Unit> function0, final Function0<Unit> function02) {
        Button button;
        Button button2;
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "cancelAction");
        setCancelAction((Function0) new Platform101XPWarningDialogs$createAuthorizeActionWarningDialog$1(function02));
        Button button3 = this.exitButton;
        if (button3 != null) {
            button3.setVisibility(8);
        }
        Button button4 = this.yesButton;
        boolean z = true;
        if ((button4 != null && button4.getVisibility() == 8) && (button2 = this.yesButton) != null) {
            button2.setVisibility(0);
        }
        Button button5 = this.cancelButton;
        if (button5 == null || button5.getVisibility() != 8) {
            z = false;
        }
        if (z && (button = this.cancelButton) != null) {
            button.setVisibility(0);
        }
        TextView textView = this.warningText;
        if (textView != null) {
            textView.setText(R.string.bind_text_warning);
        }
        setBindAction(function0);
        Button button6 = this.cancelButton;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Platform101XPWarningDialogs.m135createAuthorizeActionWarningDialog$lambda11(function02, this, view);
                }
            });
        }
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            return null;
        }
        return dialog;
    }

    /* renamed from: createAuthorizeActionWarningDialog$lambda-11 */
    public static final void m135createAuthorizeActionWarningDialog$lambda11(Function0 function0, Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        function0.invoke();
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    public final Dialog createAccountHasBindWarningDialog(final Function0<Unit> function0) {
        Button button;
        Intrinsics.checkNotNullParameter(function0, "cancelAction");
        setCancelAction((Function0) new Platform101XPWarningDialogs$createAccountHasBindWarningDialog$1(function0));
        View view = this.firstDivisor;
        if (view != null) {
            view.setVisibility(8);
        }
        Button button2 = this.exitButton;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        Button button3 = this.yesButton;
        if (button3 != null) {
            button3.setVisibility(8);
        }
        Button button4 = this.cancelButton;
        if ((button4 != null && button4.getVisibility() == 8) && (button = this.cancelButton) != null) {
            button.setVisibility(0);
        }
        TextView textView = this.warningTitle;
        if (textView != null) {
            textView.setText(R.string.attention);
        }
        TextView textView2 = this.warningText;
        if (textView2 != null) {
            textView2.setText(R.string.warning_bind_text);
        }
        Button button5 = this.cancelButton;
        if (button5 != null) {
            button5.setText(R.string.close);
        }
        Button button6 = this.cancelButton;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Platform101XPWarningDialogs.m134createAccountHasBindWarningDialog$lambda12(function0, this, view2);
                }
            });
        }
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            return null;
        }
        return dialog;
    }

    /* renamed from: createAccountHasBindWarningDialog$lambda-12 */
    public static final void m134createAccountHasBindWarningDialog$lambda12(Function0 function0, Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(function0, "$cancelAction");
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        function0.invoke();
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    public final Dialog createWarningFacebookDialog() {
        Button button;
        View view = this.firstDivisor;
        if (view != null) {
            view.setVisibility(8);
        }
        Button button2 = this.yesButton;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        Button button3 = this.exitButton;
        if (button3 != null) {
            button3.setVisibility(8);
        }
        Button button4 = this.cancelButton;
        if ((button4 != null && button4.getVisibility() == 8) && (button = this.cancelButton) != null) {
            button.setVisibility(0);
        }
        TextView textView = this.warningText;
        if (textView != null) {
            textView.setText(R.string.facebook_bind_warning);
        }
        Button button5 = this.cancelButton;
        if (button5 != null) {
            button5.setText(R.string.close);
        }
        Button button6 = this.cancelButton;
        if (button6 != null) {
            button6.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Platform101XPWarningDialogs.m141createWarningFacebookDialog$lambda13(Platform101XPWarningDialogs.this, view2);
                }
            });
        }
        Dialog dialog = this.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            return null;
        }
        return dialog;
    }

    /* renamed from: createWarningFacebookDialog$lambda-13 */
    public static final void m141createWarningFacebookDialog$lambda13(Platform101XPWarningDialogs platform101XPWarningDialogs, View view) {
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "this$0");
        Dialog dialog = platform101XPWarningDialogs.warningDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            dialog = null;
        }
        dialog.dismiss();
    }

    public final AlertDialog createToManyOperationsDialog() {
        AlertDialog create = new AlertDialog.Builder(this.dialogCreator.getCurrentActivity()).setPositiveButton("Ok", Platform101XPWarningDialogs$$ExternalSyntheticLambda2.INSTANCE).create();
        create.setMessage(this.dialogCreator.getCurrentActivity().getString(R.string.meny_operations_warning_test));
        Dialog[] dialogs = this.dialogCreator.getDialogs();
        int ordinal = Platform101XPDialogType.DIALOG_WARNING.ordinal();
        Intrinsics.checkNotNullExpressionValue(create, "alertWarningDialog");
        dialogs[ordinal] = create;
        return create;
    }

    public final AlertDialog createBindProgressWarning(final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "agreeAction");
        SpannableString spannableString = new SpannableString(this.dialogCreator.getCurrentActivity().getString(R.string.attention));
        spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, spannableString.length(), 0);
        AlertDialog create = new AlertDialog.Builder(this.dialogCreator.getCurrentActivity()).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Platform101XPWarningDialogs.m136createBindProgressWarning$lambda16(function0, dialogInterface, i);
            }
        }).create();
        create.setTitle(spannableString);
        create.setMessage(this.dialogCreator.getCurrentActivity().getString(R.string.bind_warning_text));
        Dialog[] dialogs = this.dialogCreator.getDialogs();
        int ordinal = Platform101XPDialogType.DIALOG_WARNING.ordinal();
        Intrinsics.checkNotNullExpressionValue(create, "progressBindWarningDialog");
        dialogs[ordinal] = create;
        return create;
    }

    /* renamed from: createBindProgressWarning$lambda-16 */
    public static final void m136createBindProgressWarning$lambda16(Function0 function0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(function0, "$agreeAction");
        function0.invoke();
        dialogInterface.dismiss();
    }

    public final Dialog userNotLoggedInDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.dialogCreator.getCurrentActivity());
        builder.setMessage(R.string.not_logged_in_message);
        builder.setPositiveButton("Ok", Platform101XPWarningDialogs$$ExternalSyntheticLambda3.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "dialogBuilder.create()");
        return create;
    }
}
