package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.util.Log;
import com.platform101xp.sdk.Platform101XPApi;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPLinkAuthorize.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinkAuthorize;", "", "()V", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "setDeviceId", "tokenManager", "Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;", "getTokenManager", "()Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;", "setTokenManager", "(Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;)V", "changeFlashToken", "", "flashToken", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLinkAuthorize {
    @Inject
    public Platform101XPAnalytics analytics;
    @Inject
    @Named("clientId")
    public String clientId;
    @Inject
    @Named("deviceId")
    public String deviceId;
    @Inject
    public Platform101XPTokenManager tokenManager;

    public final Platform101XPTokenManager getTokenManager() {
        Platform101XPTokenManager platform101XPTokenManager = this.tokenManager;
        if (platform101XPTokenManager != null) {
            return platform101XPTokenManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tokenManager");
        return null;
    }

    public final void setTokenManager(Platform101XPTokenManager platform101XPTokenManager) {
        Intrinsics.checkNotNullParameter(platform101XPTokenManager, "<set-?>");
        this.tokenManager = platform101XPTokenManager;
    }

    public final String getClientId() {
        String str = this.clientId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clientId");
        return null;
    }

    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientId = str;
    }

    public final String getDeviceId() {
        String str = this.deviceId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceId");
        return null;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public final Platform101XPAnalytics getAnalytics() {
        Platform101XPAnalytics platform101XPAnalytics = this.analytics;
        if (platform101XPAnalytics != null) {
            return platform101XPAnalytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final void setAnalytics(Platform101XPAnalytics platform101XPAnalytics) {
        Intrinsics.checkNotNullParameter(platform101XPAnalytics, "<set-?>");
        this.analytics = platform101XPAnalytics;
    }

    public final void changeFlashToken(String str) {
        Intrinsics.checkNotNullParameter(str, "flashToken");
        if (getTokenManager().getCurrentToken() != null) {
            Log.d("101XP SDK", "User already has token.");
        } else {
            Platform101XPApi.data().changeFlashToken(str, getClientId(), getDeviceId(), getTokenManager().isDeviceTokenEnabled()).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPLinkAuthorize$$ExternalSyntheticLambda0
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public final void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    Platform101XPLinkAuthorize.m155changeFlashToken$lambda2(Platform101XPLinkAuthorize.this, platform101XPModel, platform101XPError);
                }
            });
        }
    }

    /* renamed from: changeFlashToken$lambda-2 */
    public static final void m155changeFlashToken$lambda2(Platform101XPLinkAuthorize platform101XPLinkAuthorize, Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        Intrinsics.checkNotNullParameter(platform101XPLinkAuthorize, "this$0");
        if (platform101XPError != null) {
            Log.d("101XP SDK", Intrinsics.stringPlus("FlashToken change error : ", platform101XPError));
        }
        if (platform101XPModel == null) {
            return;
        }
        platform101XPLinkAuthorize.getAnalytics().track("sdk_qr_login", null);
        Platform101XPTokenManager tokenManager = platform101XPLinkAuthorize.getTokenManager();
        Objects.requireNonNull(platform101XPModel, "null cannot be cast to non-null type com.platform101xp.sdk.api.model.Platform101XPModelToken");
        String str = ((Platform101XPModelToken) platform101XPModel).access;
        Intrinsics.checkNotNullExpressionValue(str, "model as Platform101XPModelToken).access");
        tokenManager.deserializeInCurrentToken(str);
    }
}
