package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.app.Dialog;
import android.util.Log;
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

/* compiled from: Platform101XPWebDialogFactory.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J$\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016JP\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogFactory;", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "()V", "webDialogsConstructor", "Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor;", "getWebDialogsConstructor", "()Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor;", "setWebDialogsConstructor", "(Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogsConstructor;)V", "getAuthorizeDialogs", "Landroid/app/Dialog;", "authorizeActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPAuthorizeActionsListener;", "isLoggedAsGuest", "", "asGuestEnabled", "latestAccounts", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "getGuestAuthorizeWarning", "bindAction", "Lkotlin/Function0;", "", "cancelAction", "getProfileDialogs", "isGuest", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "support", "Lcom/platform101xp/sdk/internal/support/Platform101XPSupport;", "profileActionsListener", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPProfileActionsListener;", "userGameId", "", "accessToken", "", "page", "getWidgetVersion", "setSnManager", "snManager", "Lcom/platform101xp/sdk/internal/socialnetworks/Platform101XPSNManager;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogFactory extends Platform101XPDialogFactory {
    @Inject
    public Platform101XPWebDialogsConstructor webDialogsConstructor;

    public final Platform101XPWebDialogsConstructor getWebDialogsConstructor() {
        Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor = this.webDialogsConstructor;
        if (platform101XPWebDialogsConstructor != null) {
            return platform101XPWebDialogsConstructor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webDialogsConstructor");
        return null;
    }

    public final void setWebDialogsConstructor(Platform101XPWebDialogsConstructor platform101XPWebDialogsConstructor) {
        Intrinsics.checkNotNullParameter(platform101XPWebDialogsConstructor, "<set-?>");
        this.webDialogsConstructor = platform101XPWebDialogsConstructor;
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getAuthorizeDialogs(Platform101XPAuthorizeActionsListener platform101XPAuthorizeActionsListener, boolean z, boolean z2, List<Platform101XPLatestAccount> list) {
        Intrinsics.checkNotNullParameter(platform101XPAuthorizeActionsListener, "authorizeActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        return getWebDialogsConstructor().getAuthorizeWebDialog(platform101XPAuthorizeActionsListener, z, z2, list);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getProfileDialogs(boolean z, Platform101XPAccount platform101XPAccount, Platform101XPSupport platform101XPSupport, Platform101XPProfileActionsListener platform101XPProfileActionsListener, long j, String str, List<Platform101XPLatestAccount> list, String str2) {
        Intrinsics.checkNotNullParameter(platform101XPAccount, "account");
        Intrinsics.checkNotNullParameter(platform101XPSupport, "support");
        Intrinsics.checkNotNullParameter(platform101XPProfileActionsListener, "profileActionsListener");
        Intrinsics.checkNotNullParameter(list, "latestAccounts");
        Intrinsics.checkNotNullParameter(str2, "page");
        return getWebDialogsConstructor().getProfileWebDialog(z, platform101XPAccount, platform101XPProfileActionsListener, j, str, list, str2);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public void setSnManager(Platform101XPSNManager platform101XPSNManager) {
        Intrinsics.checkNotNullParameter(platform101XPSNManager, "snManager");
        getWebDialogsConstructor().setSnManager(platform101XPSNManager);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public Dialog getGuestAuthorizeWarning(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "bindAction");
        Intrinsics.checkNotNullParameter(function02, "cancelAction");
        Log.d("101XP SDK", "Guest Authorize Warning!!!");
        return getWebDialogsConstructor().getGuestAuthorizeWarning(function0, function02);
    }

    @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory
    public String getWidgetVersion() {
        return getWebDialogsConstructor().widgetVersion();
    }
}
