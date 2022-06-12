package com.platform101xp.sdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPMetaManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMetaBoolean", "", "key", "", "defaultValue", "getMetaData", "getMetaDouble", "", "getMetaInt", "", "getMetaLong", "", "getMetaString", "isMetaDataExist", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPMetaManager {
    private final Context appContext;

    public Platform101XPMetaManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        this.appContext = context;
    }

    private final Object getMetaData(String str) {
        ApplicationInfo applicationInfo = this.appContext.getPackageManager().getApplicationInfo(this.appContext.getPackageName(), 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "appContext.packageManage…ageManager.GET_META_DATA)");
        Bundle bundle = applicationInfo.metaData;
        return applicationInfo.metaData.get(str);
    }

    public final boolean getMetaBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!isMetaDataExist(str)) {
            return z;
        }
        Object metaData = getMetaData(str);
        return metaData instanceof Boolean ? ((Boolean) metaData).booleanValue() : z;
    }

    public final int getMetaInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!isMetaDataExist(str)) {
            return i;
        }
        Object metaData = getMetaData(str);
        return metaData instanceof Integer ? ((Number) metaData).intValue() : i;
    }

    public final String getMetaString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        if (!isMetaDataExist(str)) {
            return str2;
        }
        Object metaData = getMetaData(str);
        return metaData instanceof String ? (String) metaData : str2;
    }

    public final double getMetaDouble(String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!isMetaDataExist(str)) {
            return d;
        }
        Object metaData = getMetaData(str);
        return metaData instanceof Double ? ((Number) metaData).doubleValue() : d;
    }

    public final long getMetaLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!isMetaDataExist(str)) {
            return j;
        }
        Object metaData = getMetaData(str);
        return metaData instanceof Long ? ((Number) metaData).longValue() : j;
    }

    public final boolean isMetaDataExist(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return getMetaData(str) != null;
    }
}
