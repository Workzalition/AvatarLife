package com.platform101xp.sdk.internal.dialogs;

import android.app.Dialog;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPEulaDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPInviteDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPLogsDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPProgressDialog;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.support.Platform101XPSupport;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPDialogFactory.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H&J\u0018\u0010\u0005\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.J$\u0010/\u001a\u00020\"2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020201H&J\u0016\u0010\u000b\u001a\u00020\"2\u0006\u00103\u001a\u0002042\u0006\u0010-\u001a\u00020.J\u000e\u0010\u0011\u001a\u00020\"2\u0006\u00105\u001a\u000206JP\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010C\u001a\u00020BH&J\u0006\u0010D\u001a\u00020\"J\u0018\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IJ\b\u0010J\u001a\u00020BH&J\u0010\u0010K\u001a\u0002022\u0006\u00103\u001a\u000204H&R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006L"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "", "()V", "eulaDialog", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;", "getEulaDialog", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;", "setEulaDialog", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog;)V", "inviteDialog", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPInviteDialog;", "getInviteDialog", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPInviteDialog;", "setInviteDialog", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPInviteDialog;)V", "logsDialog", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPLogsDialog;", "getLogsDialog", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPLogsDialog;", "setLogsDialog", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPLogsDialog;)V", "progressDialogs", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog;", "getProgressDialogs", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog;", "setProgressDialogs", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProgressDialog;)V", "warningDialogs", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs;", "getWarningDialogs", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs;", "setWarningDialogs", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs;)V", "getAuthorizeDialogs", "Landroid/app/Dialog;", "authorizeActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "isLoggedAsGuest", "", "asGuestEnabled", "latestAccounts", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "authorizeListener", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPEulaDialog$AuthorizeListener;", "cancelAction", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "getGuestAuthorizeWarning", "bindAction", "Lkotlin/Function0;", "", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "logsActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPLogsActionsListener;", "getProfileDialogs", "isGuest", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "support", "Lcom/platform101xp/sdk/internal/support/Platform101XPSupport;", "profileActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "userGameId", "", "accessToken", "", "page", "getProgressDialog", "getWarningDialog", TapjoyAuctionFlags.AUCTION_TYPE, "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPWarningDialogs$WarningType;", "warningActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPWarningActionsListener;", "getWidgetVersion", "setSnManager", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public abstract class Platform101XPDialogFactory {
    @Inject
    public Platform101XPEulaDialog eulaDialog;
    @Inject
    public Platform101XPInviteDialog inviteDialog;
    @Inject
    public Platform101XPLogsDialog logsDialog;
    @Inject
    public Platform101XPProgressDialog progressDialogs;
    @Inject
    public Platform101XPWarningDialogs warningDialogs;

    /* compiled from: Platform101XPDialogFactory.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Platform101XPWarningDialogs.WarningType.values().length];
            iArr[Platform101XPWarningDialogs.WarningType.GUEST_AUTHORISE_WARNING.ordinal()] = 1;
            iArr[Platform101XPWarningDialogs.WarningType.GUEST_LOGOUT_WARNING.ordinal()] = 2;
            iArr[Platform101XPWarningDialogs.WarningType.AUTHORIZE_ACTION_WARNING.ordinal()] = 3;
            iArr[Platform101XPWarningDialogs.WarningType.ACCOUNT_HAS_BIND_WARNING.ordinal()] = 4;
            iArr[Platform101XPWarningDialogs.WarningType.HAS_BIND_PROGRESS_WARNING.ordinal()] = 5;
            iArr[Platform101XPWarningDialogs.WarningType.FACEBOOK_WARNING.ordinal()] = 6;
            iArr[Platform101XPWarningDialogs.WarningType.TO_MANY_OPERATIONS_WARNING.ordinal()] = 7;
            iArr[Platform101XPWarningDialogs.WarningType.USER_NOT_LOGGED_IN_WARNING.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract Dialog getAuthorizeDialogs(Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, boolean z, boolean z2, List<Platform101XPLatestAccount> list);

    public abstract Dialog getGuestAuthorizeWarning(Function0<Unit> function0, Function0<Unit> function02);

    public abstract Dialog getProfileDialogs(boolean z, Platform101XPAccount platform101XPAccount, Platform101XPSupport platform101XPSupport, Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j, String str, List<Platform101XPLatestAccount> list, String str2);

    public abstract String getWidgetVersion();

    public abstract void setSnManager(Platform101XPSNManager platform101XPSNManager);

    public final Platform101XPWarningDialogs getWarningDialogs() {
        Platform101XPWarningDialogs platform101XPWarningDialogs = this.warningDialogs;
        if (platform101XPWarningDialogs != null) {
            return platform101XPWarningDialogs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("warningDialogs");
        return null;
    }

    public final void setWarningDialogs(Platform101XPWarningDialogs platform101XPWarningDialogs) {
        Intrinsics.checkNotNullParameter(platform101XPWarningDialogs, "<set-?>");
        this.warningDialogs = platform101XPWarningDialogs;
    }

    public final Platform101XPProgressDialog getProgressDialogs() {
        Platform101XPProgressDialog platform101XPProgressDialog = this.progressDialogs;
        if (platform101XPProgressDialog != null) {
            return platform101XPProgressDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressDialogs");
        return null;
    }

    public final void setProgressDialogs(Platform101XPProgressDialog platform101XPProgressDialog) {
        Intrinsics.checkNotNullParameter(platform101XPProgressDialog, "<set-?>");
        this.progressDialogs = platform101XPProgressDialog;
    }

    public final Platform101XPInviteDialog getInviteDialog() {
        Platform101XPInviteDialog platform101XPInviteDialog = this.inviteDialog;
        if (platform101XPInviteDialog != null) {
            return platform101XPInviteDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inviteDialog");
        return null;
    }

    public final void setInviteDialog(Platform101XPInviteDialog platform101XPInviteDialog) {
        Intrinsics.checkNotNullParameter(platform101XPInviteDialog, "<set-?>");
        this.inviteDialog = platform101XPInviteDialog;
    }

    public final Platform101XPEulaDialog getEulaDialog() {
        Platform101XPEulaDialog platform101XPEulaDialog = this.eulaDialog;
        if (platform101XPEulaDialog != null) {
            return platform101XPEulaDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eulaDialog");
        return null;
    }

    public final void setEulaDialog(Platform101XPEulaDialog platform101XPEulaDialog) {
        Intrinsics.checkNotNullParameter(platform101XPEulaDialog, "<set-?>");
        this.eulaDialog = platform101XPEulaDialog;
    }

    public final Platform101XPLogsDialog getLogsDialog() {
        Platform101XPLogsDialog platform101XPLogsDialog = this.logsDialog;
        if (platform101XPLogsDialog != null) {
            return platform101XPLogsDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logsDialog");
        return null;
    }

    public final void setLogsDialog(Platform101XPLogsDialog platform101XPLogsDialog) {
        Intrinsics.checkNotNullParameter(platform101XPLogsDialog, "<set-?>");
        this.logsDialog = platform101XPLogsDialog;
    }

    public final Dialog getEulaDialog(Platform101XPEulaDialog.AuthorizeListener authorizeListener, Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        return getEulaDialog().getDialog(authorizeListener, onUserCancelAction);
    }

    public final Dialog getWarningDialog(Platform101XPWarningDialogs.WarningType warningType, Platform101XPWarningActionsListener platform101XPWarningActionsListener) {
        Intrinsics.checkNotNullParameter(warningType, TapjoyAuctionFlags.AUCTION_TYPE);
        switch (WhenMappings.$EnumSwitchMapping$0[warningType.ordinal()]) {
            case 1:
                return getGuestAuthorizeWarning((Function0) new Platform101XPDialogFactory$getWarningDialog$1(platform101XPWarningActionsListener), (Function0) new Platform101XPDialogFactory$getWarningDialog$2(platform101XPWarningActionsListener));
            case 2:
                return getWarningDialogs().createGuestLogoutWarningDialog((Function0) new Platform101XPDialogFactory$getWarningDialog$3(platform101XPWarningActionsListener), (Function0) new Platform101XPDialogFactory$getWarningDialog$4(platform101XPWarningActionsListener), (Function0) new Platform101XPDialogFactory$getWarningDialog$5(platform101XPWarningActionsListener));
            case 3:
                return getWarningDialogs().createAuthorizeActionWarningDialog((Function0) new Platform101XPDialogFactory$getWarningDialog$6(platform101XPWarningActionsListener), (Function0) new Platform101XPDialogFactory$getWarningDialog$7(platform101XPWarningActionsListener));
            case 4:
                return getWarningDialogs().createAccountHasBindWarningDialog((Function0) new Platform101XPDialogFactory$getWarningDialog$8(platform101XPWarningActionsListener));
            case 5:
                return getWarningDialogs().createBindProgressWarning((Function0) new Platform101XPDialogFactory$getWarningDialog$9(platform101XPWarningActionsListener));
            case 6:
                return getWarningDialogs().createWarningFacebookDialog();
            case 7:
                return getWarningDialogs().createToManyOperationsDialog();
            case 8:
                return getWarningDialogs().userNotLoggedInDialog();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Dialog getProgressDialog() {
        return getProgressDialogs().m126getProgressDialog();
    }

    public final Dialog getInviteDialog(Platform101XPSNManager platform101XPSNManager, Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        return getInviteDialog().createInviteDialog(platform101XPSNManager, onUserCancelAction);
    }

    public final Dialog getLogsDialog(Platform101XPLogsActionsListener platform101XPLogsActionsListener) {
        Intrinsics.checkNotNullParameter(platform101XPLogsActionsListener, "logsActionsListener");
        return getLogsDialog().createLogsDialog(platform101XPLogsActionsListener);
    }
}
