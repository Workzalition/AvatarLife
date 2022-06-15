package com.platform101xp.sdk.internal.firebase.database;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;
import com.platform101xp.sdk.Platform101XP;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPFirebaseUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseUtils;", "", "()V", "saveToken", "", "listener", "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/firebase/installations/InstallationTokenResult;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseUtils {
    public final void saveToken(OnCompleteListener<InstallationTokenResult> onCompleteListener) {
        Intrinsics.checkNotNullParameter(onCompleteListener, "listener");
        FirebaseInstallations.getInstance().getToken(true).addOnCompleteListener(Platform101XP.getCurrentActivity(), onCompleteListener);
    }
}
