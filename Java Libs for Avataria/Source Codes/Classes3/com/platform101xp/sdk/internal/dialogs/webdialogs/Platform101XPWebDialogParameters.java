package com.platform101xp.sdk.internal.dialogs.webdialogs;

import android.os.Build;
import android.util.Log;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.internal.Platform101XPAccount;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.Platform101XPUtils;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigData;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.entities.Platform101XPLatestAccount;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPWebDialogParameters.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\u00020\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0010\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0018\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/platform101xp/sdk/internal/dialogs/webdialogs/Platform101XPWebDialogParameters;", "", "clientId", "", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "(Ljava/lang/String;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;)V", "getClientId", "()Ljava/lang/String;", "getConfigManager", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "setConfigManager", "(Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;)V", "baseParams", "getAuthorizeUrl", "asGuestEnabled", "", "isLoggedAsGuest", "getBaseUrl", "getLatestAccountsParams", "latestAccountsList", "", "Lcom/platform101xp/sdk/internal/entities/Platform101XPLatestAccount;", "getMobileParams", "accessToken", "getParams", "current", "lastAccount", "getPortalParams", "account", "Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "userGameId", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPWebDialogParameters {
    private final String clientId;
    private Platform101XPConfigManager configManager;

    public Platform101XPWebDialogParameters(String str, Platform101XPConfigManager platform101XPConfigManager) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        this.clientId = str;
        this.configManager = platform101XPConfigManager;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Platform101XPConfigManager getConfigManager() {
        return this.configManager;
    }

    public final void setConfigManager(Platform101XPConfigManager platform101XPConfigManager) {
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "<set-?>");
        this.configManager = platform101XPConfigManager;
    }

    public final String getBaseUrl() {
        String stringPlus = Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? Platform101XPWebDialogsConstructor.DEV_DIALOGS_URL : Intrinsics.stringPlus("https://mobile-game-id.101xp.com/", this.configManager.getString(Platform101XPConfigKeyHolder.webUiVersion, Platform101XPWebDialogsConstructor.DEFAULT_WEB_UI_VERSION));
        Log.d("101XP SDK", Intrinsics.stringPlus("Base url: ", stringPlus));
        return stringPlus;
    }

    public final String baseParams() {
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.zendeskGameId, "");
        return "'sdk_data': {'sdk_version': '1.48.14','os_name': 'Android','os_version': '" + Build.VERSION.SDK_INT + "','device_model': '" + ((Object) Build.MODEL) + "','zendesk_game_id': '" + string + "'}";
    }

    public final String getMobileParams(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("'mobile': {");
        String str2 = "";
        if (str != null) {
            String str3 = "access_token: '" + str + "', ";
            if (str3 != null) {
                str2 = str3;
            }
        }
        sb.append(str2);
        sb.append("'device_id': '");
        sb.append((Object) Platform101XP.getDeviceId());
        sb.append("','client_id': '");
        sb.append(this.clientId);
        sb.append("','locale': '");
        sb.append((Object) Platform101XPUtils.getLocale());
        sb.append("'}, ");
        return sb.toString();
    }

    public final String getPortalParams(Platform101XPAccount platform101XPAccount, long j) {
        boolean z = platform101XPAccount != null;
        if (!z) {
            if (z) {
                throw new NoWhenBranchMatchedException();
            }
            return "portal: {guest: false}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("portal: {id: ");
        sb.append(platform101XPAccount.getId());
        sb.append(", game_id: '");
        sb.append(j);
        sb.append("', display_name: '");
        sb.append((Object) platform101XPAccount.getUserName());
        sb.append("', email: '");
        String email = platform101XPAccount.getEmail();
        String str = "";
        if (email == null) {
            email = str;
        }
        sb.append(email);
        sb.append("',photo: '");
        String userPhotoUrl = platform101XPAccount.getUserPhotoUrl();
        if (userPhotoUrl != null) {
            str = userPhotoUrl;
        }
        sb.append(str);
        sb.append("', guest: ");
        sb.append(platform101XPAccount.isGuest());
        sb.append('}');
        return sb.toString();
    }

    private final String getParams(Platform101XPLatestAccount platform101XPLatestAccount, Platform101XPLatestAccount platform101XPLatestAccount2) {
        String str = "{'id': '" + platform101XPLatestAccount.getId() + "', 'user_id': '" + platform101XPLatestAccount.getUserId() + "', 'game_id': '" + platform101XPLatestAccount.getGameId() + "', 'display_name': '" + platform101XPLatestAccount.getDisplayName() + "', 'timestamp': '" + platform101XPLatestAccount.getTimestamp() + "', 'type': '" + platform101XPLatestAccount.getType() + "'}";
        return !Intrinsics.areEqual(platform101XPLatestAccount, platform101XPLatestAccount2) ? Intrinsics.stringPlus(str, ",") : str;
    }

    public final String getLatestAccountsParams(List<Platform101XPLatestAccount> list) {
        String str = "'latest_accounts':[";
        if (list != null && (!list.isEmpty())) {
            Platform101XPLatestAccount platform101XPLatestAccount = (Platform101XPLatestAccount) CollectionsKt.last(list);
            for (Platform101XPLatestAccount platform101XPLatestAccount2 : list) {
                str = Intrinsics.stringPlus(str, getParams(platform101XPLatestAccount2, platform101XPLatestAccount));
            }
        }
        return Intrinsics.stringPlus(str, "]");
    }

    public final String getAuthorizeUrl(boolean z, boolean z2) {
        String str;
        String str2;
        if (z2 || !z) {
            str2 = getBaseUrl();
            str = "/connect";
        } else {
            str2 = getBaseUrl();
            str = "/auth";
        }
        return Intrinsics.stringPlus(str2, str);
    }
}
