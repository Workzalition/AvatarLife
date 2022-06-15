package com.platform101xp.sdk.internal.firebase.dynamiclinks;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseDynamicLinks.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPFirebaseDynamicLinks;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "buildShortLink", "", "platform101XPLinks", "Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPLinks;", "successListener", "Lcom/google/android/gms/tasks/OnSuccessListener;", "Lcom/google/firebase/dynamiclinks/ShortDynamicLink;", "onFailureHandler", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "receiveDynamicLinks", "resultListener", "Lcom/platform101xp/sdk/internal/firebase/dynamiclinks/Platform101XPDynamicLinksListener;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDynamicLinks {
    private Activity activity;

    @Inject
    public Platform101XPFirebaseDynamicLinks(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Inject
    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    public final void buildShortLink(Platform101XPLinks platform101XPLinks, OnSuccessListener<ShortDynamicLink> onSuccessListener) {
        Intrinsics.checkNotNullParameter(platform101XPLinks, "platform101XPLinks");
        Intrinsics.checkNotNullParameter(onSuccessListener, "successListener");
        DynamicLink.Builder androidParameters = FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse(platform101XPLinks.getLink())).setDomainUriPrefix(platform101XPLinks.getDynamicLinkDomain()).setAndroidParameters(new DynamicLink.AndroidParameters.Builder(platform101XPLinks.getAndroidLink()).build());
        DynamicLink.IosParameters build = platform101XPLinks.getIOsId() == null ? null : new DynamicLink.IosParameters.Builder(platform101XPLinks.getIOsLink()).setAppStoreId(platform101XPLinks.getIOsId()).build();
        if (build == null) {
            build = new DynamicLink.IosParameters.Builder(platform101XPLinks.getIOsLink()).build();
        }
        androidParameters.setIosParameters(build).buildShortDynamicLink().addOnSuccessListener(onSuccessListener).addOnFailureListener(new OnFailureListener() { // from class: com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Platform101XPFirebaseDynamicLinks.m151buildShortLink$lambda1(Platform101XPFirebaseDynamicLinks.this, exc);
            }
        });
    }

    /* renamed from: buildShortLink$lambda-1 */
    public static final void m151buildShortLink$lambda1(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks, Exception exc) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDynamicLinks, "this$0");
        Intrinsics.checkNotNullParameter(exc, "e");
        platform101XPFirebaseDynamicLinks.onFailureHandler(exc);
    }

    public final void receiveDynamicLinks(final Platform101XPDynamicLinksListener platform101XPDynamicLinksListener) {
        Intrinsics.checkNotNullParameter(platform101XPDynamicLinksListener, "resultListener");
        FirebaseDynamicLinks.getInstance().getDynamicLink(this.activity.getIntent()).addOnSuccessListener(new OnSuccessListener() { // from class: com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Platform101XPFirebaseDynamicLinks.m152receiveDynamicLinks$lambda2(Platform101XPDynamicLinksListener.this, (PendingDynamicLinkData) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.platform101xp.sdk.internal.firebase.dynamiclinks.Platform101XPFirebaseDynamicLinks$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Platform101XPFirebaseDynamicLinks.m153receiveDynamicLinks$lambda3(Platform101XPFirebaseDynamicLinks.this, platform101XPDynamicLinksListener, exc);
            }
        });
    }

    /* renamed from: receiveDynamicLinks$lambda-2 */
    public static final void m152receiveDynamicLinks$lambda2(Platform101XPDynamicLinksListener platform101XPDynamicLinksListener, PendingDynamicLinkData pendingDynamicLinkData) {
        Intrinsics.checkNotNullParameter(platform101XPDynamicLinksListener, "$resultListener");
        if (pendingDynamicLinkData != null) {
            Uri link = pendingDynamicLinkData.getLink();
            Log.d("101XP SDK", Intrinsics.stringPlus("DeepLink :", link));
            platform101XPDynamicLinksListener.onLinkReceiveResult(link, null);
        }
    }

    /* renamed from: receiveDynamicLinks$lambda-3 */
    public static final void m153receiveDynamicLinks$lambda3(Platform101XPFirebaseDynamicLinks platform101XPFirebaseDynamicLinks, Platform101XPDynamicLinksListener platform101XPDynamicLinksListener, Exception exc) {
        Intrinsics.checkNotNullParameter(platform101XPFirebaseDynamicLinks, "this$0");
        Intrinsics.checkNotNullParameter(platform101XPDynamicLinksListener, "$resultListener");
        Intrinsics.checkNotNullParameter(exc, "e");
        platform101XPFirebaseDynamicLinks.onFailureHandler(exc);
        platform101XPDynamicLinksListener.onLinkReceiveResult(null, new Platform101XPError(exc));
    }

    private final void onFailureHandler(Exception exc) {
        Log.d("101XP SDK", Intrinsics.stringPlus("DynamicLinks Failure: ", exc));
        Platform101XP.sendCrashReport(exc);
    }
}
