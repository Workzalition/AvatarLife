package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.net.Uri;
import android.util.Log;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.Platform101XPLinkInvite;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseDynamicLinksManager.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u001e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinksManager;", "", "()V", "analytics", "Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "getAnalytics", "()Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;", "setAnalytics", "(Lcom/platform101xp/sdk/internal/analytics/Platform101XPAnalytics;)V", "dynamicLinks", "Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinks;", "getDynamicLinks", "()Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinks;", "setDynamicLinks", "(Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinks;)V", "linkAuthorize", "Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinkAuthorize;", "getLinkAuthorize", "()Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinkAuthorize;", "setLinkAuthorize", "(Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinkAuthorize;)V", "linkInvite", "Lcom/platform101xp/sdk/internal/Platform101XPLinkInvite;", "getLinkInvite", "()Lcom/platform101xp/sdk/internal/Platform101XPLinkInvite;", "setLinkInvite", "(Lcom/platform101xp/sdk/internal/Platform101XPLinkInvite;)V", "checkDynamicLink", "", "initializeParameters", "sendInvite", "userName", "", "event", "userGameId", "", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinksManager {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_PARAMETER_NAME = "event";
    public static final String FLASH_TOKEN_PARAMETER_NAME = "flash_token";
    public static final String INVITE_PARAMETER_NAME = "invitedby";
    @Inject
    public Platform101XPAnalytics analytics;
    @Inject
    public Platform101XPFirebaseDynamicLinks dynamicLinks;
    @Inject
    public Platform101XPLinkAuthorize linkAuthorize;
    @Inject
    public Platform101XPLinkInvite linkInvite;

    /* compiled from: Platform101XPFirebaseDynamicLinksManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinksManager$Companion;", "", "()V", "EVENT_PARAMETER_NAME", "", "FLASH_TOKEN_PARAMETER_NAME", "INVITE_PARAMETER_NAME", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Platform101XPFirebaseDynamicLinks getDynamicLinks() {
        Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks = this.dynamicLinks;
        if (platform101XPFirebaseDynamicLinks != null) {
            return platform101XPFirebaseDynamicLinks;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dynamicLinks");
        return null;
    }

    public final void setDynamicLinks(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDynamicLinks, "<set-?>");
        this.dynamicLinks = platform101XPFirebaseDynamicLinks;
    }

    public final Platform101XPLinkInvite getLinkInvite() {
        Platform101XPLinkInvite platform101XPLinkInvite = this.linkInvite;
        if (platform101XPLinkInvite != null) {
            return platform101XPLinkInvite;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkInvite");
        return null;
    }

    public final void setLinkInvite(Platform101XPLinkInvite platform101XPLinkInvite) {
        Intrinsics.checkNotNullParameter(platform101XPLinkInvite, "<set-?>");
        this.linkInvite = platform101XPLinkInvite;
    }

    public final Platform101XPLinkAuthorize getLinkAuthorize() {
        Platform101XPLinkAuthorize platform101XPLinkAuthorize = this.linkAuthorize;
        if (platform101XPLinkAuthorize != null) {
            return platform101XPLinkAuthorize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("linkAuthorize");
        return null;
    }

    public final void setLinkAuthorize(Platform101XPLinkAuthorize platform101XPLinkAuthorize) {
        Intrinsics.checkNotNullParameter(platform101XPLinkAuthorize, "<set-?>");
        this.linkAuthorize = platform101XPLinkAuthorize;
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

    public final void initializeParameters() {
        getLinkInvite().initParameters();
    }

    public final void checkDynamicLink() {
        try {
            Log.d("101XP SDK", "DeepLink check");
            getDynamicLinks().receiveDynamicLinks(new Platform101XPDynamicLinksListener() { // from class: com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinksManager$checkDynamicLink$1
                @Override // com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPDynamicLinksListener
                public void onLinkReceiveResult(Uri uri, Platform101XPError platform101XPError) {
                    if (platform101XPError != null) {
                        Log.d("101XP SDK", platform101XPError.toString());
                    } else if (uri == null) {
                    } else {
                        Platform101XPFirebaseDynamicLinksManager platform101XPFirebaseDynamicLinksManager = Platform101XPFirebaseDynamicLinksManager.this;
                        String queryParameter = uri.getQueryParameter(Platform101XPFirebaseDynamicLinksManager.INVITE_PARAMETER_NAME);
                        String queryParameter2 = uri.getQueryParameter("event");
                        String queryParameter3 = uri.getQueryParameter(Platform101XPFirebaseDynamicLinksManager.FLASH_TOKEN_PARAMETER_NAME);
                        if (queryParameter != null && queryParameter2 != null) {
                            platform101XPFirebaseDynamicLinksManager.getLinkInvite().saveDynamicLinkParameters(queryParameter, queryParameter2);
                        }
                        if (queryParameter3 == null) {
                            return;
                        }
                        platform101XPFirebaseDynamicLinksManager.getAnalytics().track("sdk_qr_transit", null);
                        platform101XPFirebaseDynamicLinksManager.getLinkAuthorize().changeFlashToken(queryParameter3);
                    }
                }
            });
        } catch (NoClassDefFoundError e) {
            String message = e.getMessage();
            if (message == null) {
                message = e.toString();
            }
            Log.d("101XP SDK", message);
        }
    }

    public final void sendInvite(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "event");
        getLinkInvite().sendInvite(str, str2, Long.valueOf(j));
    }
}
