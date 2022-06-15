package com.platform101xp.sdk.internal.dialogs.nativedialogs;

import android.app.Dialog;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.dialogs.Platform101XPAuthorizeActionsListener;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.dialogs.Platform101XPProfileActionsListener;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.support.Platform101XPSupport;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPNativeDialogFactory.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J$\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016JP\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006-"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPNativeDialogFactory;", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "()V", "authorizeDialogs", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPAuthorizeDialogs;", "getAuthorizeDialogs", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPAuthorizeDialogs;", "setAuthorizeDialogs", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPAuthorizeDialogs;)V", "profileDialogs", "Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProfileDialogs;", "getProfileDialogs", "()Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProfileDialogs;", "setProfileDialogs", "(Lcom/platform101xp/sdk/internal/dialogs/nativedialogs/Platform101XPProfileDialogs;)V", "Landroid/app/Dialog;", "authorizeActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "isLoggegAsGuest", "", "asGuestEnabled", "latestAccounts", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "getGuestAuthorizeWarning", "bindAction", "Lkotlin/Function0;", "", "cancelAction", "isGuest", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "support", "Lcom/platform101xp/sdk/internal/support/Platform101XPSupport;", "profileActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "userGameId", "", "accessToken", "", "page", "getWidgetVersion", "setSnManager", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPNativeDialogFactory extends Platform101XPDialogFactory {
    @Inject
    public Platform101XPAuthorizeDialogs authorizeDialogs;
    @Inject
    public Platform101XPProfileDialogs profileDialogs;

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public String getWidgetVersion() {
        return "0";
    }

    public final Platform101XPAuthorizeDialogs getAuthorizeDialogs() {
        Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs = this.authorizeDialogs;
        if (platform101XPAuthorizeDialogs != null) {
            return platform101XPAuthorizeDialogs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("authorizeDialogs");
        return null;
    }

    public final void setAuthorizeDialogs(Platform101XPAuthorizeDialogs platform101XPAuthorizeDialogs) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeDialogs, "<set-?>");
        this.authorizeDialogs = platform101XPAuthorizeDialogs;
    }

    public final Platform101XPProfileDialogs getProfileDialogs() {
        Platform101XPProfileDialogs platform101XPProfileDialogs = this.profileDialogs;
        if (platform101XPProfileDialogs != null) {
            return platform101XPProfileDialogs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileDialogs");
        return null;
    }

    public final void setProfileDialogs(Platform101XPProfileDialogs platform101XPProfileDialogs) {
        Intrinsics.checkNotNullParameter(platform101XPProfileDialogs, "<set-?>");
        this.profileDialogs = platform101XPProfileDialogs;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getAuthorizeDialogs(Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, boolean z, boolean z2, List<Platform101XPLatestAccount> list) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "authorizeActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        return getAuthorizeDialogs().createAuthorizeDialog(platform101XPAuthorizeActionsListener, z, z2);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getProfileDialogs(boolean z, Platform101XPAccount platform101XPAccount, Platform101XPSupport platform101XPSupport, Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j, String str, List<Platform101XPLatestAccount> list, String str2) {
        Intrinsics.checkNotNullParameter(platform101XPAccount, "account");
        Intrinsics.checkNotNullParameter(platform101XPSupport, "support");
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "profileActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        Intrinsics.checkNotNullParameter(str2, "page");
        return getProfileDialogs().createManagedProfileDialog(z, platform101XPAccount, platform101XPSupport, platform101XPProfileActionsListener, j);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getGuestAuthorizeWarning(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "cancelAction");
        return getWarningDialogs().createGuestAuthorizeWarningDialog(function0, function02);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public void setSnManager(Platform101XPSNManager platform101XPSNManager) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        getAuthorizeDialogs().setSnManager(platform101XPSNManager);
    }
}
