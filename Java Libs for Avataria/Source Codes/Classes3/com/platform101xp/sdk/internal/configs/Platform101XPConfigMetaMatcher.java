package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Platform101XPConfigMetaMatcher.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigMetaMatcher;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "metaList", "", "", "getMetaKeyByConfigKey", "configKey", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigMetaMatcher {
    private final Set<String> metaList;

    public Platform101XPConfigMetaMatcher(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "appContext.packageManage…ageManager.GET_META_DATA)");
        Set<String> keySet = applicationInfo.metaData.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "appInfo.metaData.keySet()");
        this.metaList = keySet;
    }

    public final String getMetaKeyByConfigKey(String str) {
        Intrinsics.checkNotNullParameter(str, "configKey");
        Regex regex = new Regex("[.,_]");
        for (String str2 : this.metaList) {
            if (StringsKt.contains(regex.replace(str2, ""), regex.replace(str, ""), true)) {
                return str2;
            }
        }
        return "";
    }
}
