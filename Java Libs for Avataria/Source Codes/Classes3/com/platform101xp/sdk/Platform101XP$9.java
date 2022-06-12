package com.platform101xp.sdk;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$9 implements OnCompleteListener<InstallationTokenResult> {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$9(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<InstallationTokenResult> task) {
        String token = task.getResult().getToken();
        Log.e("token: ", token);
        Platform101XP.access$300(Platform101XP.access$000()).writeUserFirebaseToken(token);
    }
}
