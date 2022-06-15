package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogCreator;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPAuthorizeDialogs.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001eH\u0002J\u001e\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001eJ\u000e\u0010(\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPAuthorizeDialogs;", "", "dialogCreator", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "(Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;)V", "authText", "Landroid/widget/TextView;", "authTitle", "authorizeDialog", "Landroid/app/Dialog;", "authorizeDialogView", "Landroid/view/View;", "buttonAsGuest", "Landroid/widget/Button;", "buttonCancel", "getDialogCreator", "()Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogCreator;", "setDialogCreator", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "socialButtonsMap", "", "Lcom/platform101xp/sdk/Platform101XPSNType;", "addBorderToLastSn", "", "snType", "lastSnAuthorize", "", "snButton", "isAuthoriseDialog", "", "checkEnabledSN", "platform101XPSNManager", "checkSocialNetworkButtons", "isAuthorizeDialog", "createAuthorizeDialog", "authorizeActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "isLoggegAsGuest", "asGuestEnabled", "setSnManager", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPAuthorizeDialogs {
    private TextView authText;
    private TextView authTitle;
    private Dialog authorizeDialog;
    private final View authorizeDialogView;
    private Button buttonAsGuest;
    private Button buttonCancel;
    private Platform101XPDialogCreator dialogCreator;
    private Platform101XPSNManager snManager;
    private final Map<Platform101XPSNType, View> socialButtonsMap;

    @Inject
    public Platform101XPAuthorizeDialogs(Platform101XPDialogCreator platform101XPDialogCreator) {
        Intrinsics.checkNotNullParameter(platform101XPDialogCreator, "dialogCreator");
        this.dialogCreator = platform101XPDialogCreator;
        LayoutInflater layoutInflater = platform101XPDialogCreator.getLayoutInflater();
        this.authorizeDialogView = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_authorization, (ViewGroup) null) : null;
        this.socialButtonsMap = new LinkedHashMap();
        Activity currentActivity = this.dialogCreator.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPAuthorizeDialogs.m90_init_$lambda4(Platform101XPAuthorizeDialogs.this);
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

    /* renamed from: _init_$lambda-4 */
    public static final void m90_init_$lambda4(Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeDialogs, "this$0");
        View view = platform101XPAuthorizeDialogs.authorizeDialogView;
        TextView textView = null;
        platform101XPAuthorizeDialogs.buttonAsGuest = view == null ? null : (Button) view.findViewById(R.id.button_as_guest);
        View view2 = platform101XPAuthorizeDialogs.authorizeDialogView;
        platform101XPAuthorizeDialogs.buttonCancel = view2 == null ? null : (Button) view2.findViewById(R.id.button_cancel);
        View view3 = platform101XPAuthorizeDialogs.authorizeDialogView;
        platform101XPAuthorizeDialogs.authTitle = view3 == null ? null : (TextView) view3.findViewById(R.id.auth_label1);
        View view4 = platform101XPAuthorizeDialogs.authorizeDialogView;
        if (view4 != null) {
            textView = (TextView) view4.findViewById(R.id.auth_text);
        }
        platform101XPAuthorizeDialogs.authText = textView;
        if (platform101XPAuthorizeDialogs.authorizeDialogView != null) {
            platform101XPAuthorizeDialogs.socialButtonsMap.put(Platform101XPSNType.PORTAL, platform101XPAuthorizeDialogs.authorizeDialogView.findViewById(R.id.auth_button_101xp));
            platform101XPAuthorizeDialogs.socialButtonsMap.put(Platform101XPSNType.FACEBOOK, platform101XPAuthorizeDialogs.authorizeDialogView.findViewById(R.id.auth_button_fb));
            platform101XPAuthorizeDialogs.socialButtonsMap.put(Platform101XPSNType.VK, platform101XPAuthorizeDialogs.authorizeDialogView.findViewById(R.id.auth_button_vk));
            platform101XPAuthorizeDialogs.socialButtonsMap.put(Platform101XPSNType.OK, platform101XPAuthorizeDialogs.authorizeDialogView.findViewById(R.id.auth_button_od));
            platform101XPAuthorizeDialogs.socialButtonsMap.put(Platform101XPSNType.GOOGLE, platform101XPAuthorizeDialogs.authorizeDialogView.findViewById(R.id.auth_button_gg));
        }
        platform101XPAuthorizeDialogs.authorizeDialog = platform101XPAuthorizeDialogs.dialogCreator.createDialog(platform101XPAuthorizeDialogs.authorizeDialogView, true, Platform101XPDialogType.DIALOG_AUTHORIZE);
    }

    private final void addBorderToLastSn(Platform101XPSNType platform101XPSNType, String str, View view, boolean z) {
        if (str == null || !z) {
            return;
        }
        Platform101XPSNManager platform101XPSNManager = this.snManager;
        String str2 = null;
        if (Intrinsics.areEqual(platform101XPSNManager == null ? null : platform101XPSNManager.getSocialProvider(platform101XPSNType), str)) {
            Platform101XPSNManager platform101XPSNManager2 = this.snManager;
            if (platform101XPSNManager2 != null) {
                str2 = platform101XPSNManager2.getSocialProvider(Platform101XPSNType.PORTAL);
            }
            if (Intrinsics.areEqual(str, str2)) {
                if (view == null) {
                    return;
                }
                view.setBackgroundResource(R.drawable.selector_border_portal_button);
                return;
            } else if (view == null) {
                return;
            } else {
                view.setBackgroundResource(R.drawable.button_border);
                return;
            }
        }
        if (view != null && view.getId() == R.id.auth_button_101xp) {
            view.setBackgroundResource(R.drawable.selector_portal_button);
        } else if (view == null) {
        } else {
            view.setBackgroundResource(0);
        }
    }

    private final boolean checkEnabledSN(Platform101XPSNManager platform101XPSNManager) {
        return !platform101XPSNManager.isEnabled(Platform101XPSNType.VK) && !platform101XPSNManager.isEnabled(Platform101XPSNType.OK) && !platform101XPSNManager.isEnabled(Platform101XPSNType.GOOGLE);
    }

    private final void checkSocialNetworkButtons(boolean z) {
        View value;
        String loadString = Platform101XPSettings.loadString(Platform101XPSNManager.LAST_SN_AUTHORIZE);
        for (Map.Entry<Platform101XPSNType, View> entry : this.socialButtonsMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Sn ");
            sb.append(entry.getKey());
            sb.append(" is enabled: ");
            Platform101XPSNManager platform101XPSNManager = this.snManager;
            sb.append(platform101XPSNManager == null ? null : Boolean.valueOf(platform101XPSNManager.isEnabled(entry.getKey())));
            Log.d("101XP SDK", sb.toString());
            Platform101XPSNManager platform101XPSNManager2 = this.snManager;
            boolean z2 = true;
            if (platform101XPSNManager2 == null || !platform101XPSNManager2.isEnabled(entry.getKey())) {
                z2 = false;
            }
            if (z2) {
                View value2 = entry.getValue();
                if (value2 != null) {
                    value2.setTag(entry.getKey());
                }
                addBorderToLastSn(entry.getKey(), loadString, entry.getValue(), z);
                View value3 = entry.getValue();
                if (value3 != null) {
                    value3.setVisibility(0);
                }
            } else if (entry.getKey() != Platform101XPSNType.PORTAL && (value = entry.getValue()) != null) {
                value.setVisibility(8);
            }
        }
        Platform101XPSNManager platform101XPSNManager3 = this.snManager;
        if (platform101XPSNManager3 != null && platform101XPSNManager3.isEnabled(Platform101XPSNType.FACEBOOK) && checkEnabledSN(platform101XPSNManager3)) {
            View view = this.authorizeDialogView;
            if (view != null) {
                View findViewById = view.findViewById(R.id.auth_buttons_layout);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
                findViewById.setVisibility(8);
            }
            View view2 = this.authorizeDialogView;
            if (view2 == null) {
                return;
            }
            View findViewById2 = view2.findViewById(R.id.auth_button_fb_big);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "authorizeDialogView.find…(R.id.auth_button_fb_big)");
            Button button = (Button) findViewById2;
            button.setVisibility(0);
            button.setTag(Platform101XPSNType.FACEBOOK);
            this.socialButtonsMap.put(Platform101XPSNType.FACEBOOK, button);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1] */
    public final Dialog createAuthorizeDialog(final Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "authorizeActionsListener");
        Dialog dialog = this.authorizeDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeDialog");
            dialog = null;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-2, -2);
        }
        final ?? r0 = new Platform101XPDialogs.OnUserCancelAction() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs.OnUserCancelAction
            public void onCancelClick() {
                Platform101XPAuthorizeActionsListener.this.onCancelClick();
            }
        };
        Platform101XPDialogCreator platform101XPDialogCreator = this.dialogCreator;
        Dialog dialog2 = this.authorizeDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeDialog");
            dialog2 = null;
        }
        platform101XPDialogCreator.setOnBackKeyListener(dialog2, (Platform101XPDialogs.OnUserCancelAction) r0);
        boolean z3 = true;
        final boolean z4 = Platform101XP.isLoggedIn() && !Platform101XP.isGuest();
        if (z4 || !z2) {
            Button button = this.buttonAsGuest;
            if (button != null) {
                button.setVisibility(8);
            }
        } else {
            Button button2 = this.buttonAsGuest;
            if (button2 != null) {
                button2.setTransformationMethod(null);
            }
            Button button3 = this.buttonAsGuest;
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Platform101XPAuthorizeDialogs.m93createAuthorizeDialog$lambda8(Platform101XPAuthorizeActionsListener.this, view);
                    }
                });
            }
        }
        if (z) {
            Button button4 = this.buttonAsGuest;
            if (button4 != null) {
                button4.setVisibility(8);
            }
            TextView textView = this.authTitle;
            if (textView != null) {
                textView.setText(R.string.save_game_progress);
            }
            TextView textView2 = this.authText;
            if (textView2 != null) {
                textView2.setText(R.string.guest_session_save_text);
            }
            View view = this.socialButtonsMap.get(Platform101XPSNType.PORTAL);
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.Button");
            ((Button) view).setText(R.string.bind_101xp);
        } else if (!Platform101XP.isLoggedIn()) {
            Button button5 = this.buttonAsGuest;
            if (button5 != null) {
                button5.setVisibility(0);
            }
            TextView textView3 = this.authTitle;
            if (textView3 != null) {
                textView3.setText(R.string.login);
            }
            TextView textView4 = this.authText;
            if (textView4 != null) {
                textView4.setText(R.string.login_text);
            }
            View view2 = this.socialButtonsMap.get(Platform101XPSNType.PORTAL);
            Objects.requireNonNull(view2, "null cannot be cast to non-null type android.widget.Button");
            ((Button) view2).setText(R.string.sign_in_101xp);
        }
        checkSocialNetworkButtons(!z4);
        Platform101XPSNManager platform101XPSNManager = this.snManager;
        if (platform101XPSNManager == null || !platform101XPSNManager.isEnabled()) {
            z3 = false;
        }
        if (z3) {
            TextView textView5 = this.authTitle;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            TextView textView6 = this.authText;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
        }
        for (Map.Entry<Platform101XPSNType, View> entry : this.socialButtonsMap.entrySet()) {
            View value = entry.getValue();
            if (value != null) {
                value.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        Platform101XPAuthorizeDialogs.m91createAuthorizeDialog$lambda10$lambda9(Platform101XPAuthorizeDialogs.this, platform101XPAuthorizeActionsListener, view3);
                    }
                });
            }
        }
        Button button6 = this.buttonCancel;
        if (button6 != null) {
            button6.setTransformationMethod(null);
        }
        Button button7 = this.buttonCancel;
        if (button7 != null) {
            button7.setOnClickListener(new View.OnClickListener() { // from class: com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPAuthorizeDialogs$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Platform101XPAuthorizeDialogs.m92createAuthorizeDialog$lambda11(z4, platform101XPAuthorizeActionsListener, this, r0, view3);
                }
            });
        }
        Dialog dialog3 = this.authorizeDialog;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeDialog");
            return null;
        }
        return dialog3;
    }

    /* renamed from: createAuthorizeDialog$lambda-8 */
    public static final void m93createAuthorizeDialog$lambda8(Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "$authorizeActionsListener");
        platform101XPAuthorizeActionsListener.onGuestClick();
    }

    /* renamed from: createAuthorizeDialog$lambda-10$lambda-9 */
    public static final void m91createAuthorizeDialog$lambda10$lambda9(Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs, Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, View view) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeDialogs, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "$authorizeActionsListener");
        Dialog dialog = platform101XPAuthorizeDialogs.authorizeDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeDialog");
            dialog = null;
        }
        dialog.dismiss();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        platform101XPAuthorizeActionsListener.onAuthorizeClick(view);
    }

    /* renamed from: createAuthorizeDialog$lambda-11 */
    public static final void m92createAuthorizeDialog$lambda11(boolean z, Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs, Platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1 platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1, View view) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "$authorizeActionsListener");
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeDialogs, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1, "$cancelAction");
        if (z) {
            platform101XPAuthorizeActionsListener.onGuestClick();
        } else {
            platform101XPAuthorizeDialogs.dialogCreator.switchOff(Platform101XPDialogType.DIALOG_AUTHORIZE, platform101XPAuthorizeDialogs$createAuthorizeDialog$cancelAction$1).onClick(view);
        }
    }

    public final void setSnManager(Platform101XPSNManager platform101XPSNManager) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        this.snManager = platform101XPSNManager;
    }
}
