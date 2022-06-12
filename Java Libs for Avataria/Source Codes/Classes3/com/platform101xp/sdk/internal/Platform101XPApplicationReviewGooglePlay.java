package com.platform101xp.sdk.internal;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.platform101xp.sdk.Platform101XP;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPApplicationReviewGooglePlay {
    Platform101XPApplicationReviewListener reviewListener;
    ReviewInfo reviewInfo = null;
    ReviewManager reviewManager = ReviewManagerFactory.create(Platform101XP.getApplicationContext());

    public Platform101XPApplicationReviewGooglePlay(Platform101XPApplicationReviewListener platform101XPApplicationReviewListener) {
        this.reviewListener = platform101XPApplicationReviewListener;
    }

    public void show() {
        this.reviewManager.requestReviewFlow().addOnCompleteListener(new OnCompleteListener<ReviewInfo>() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReviewGooglePlay.1
            @Override // com.google.android.play.core.tasks.OnCompleteListener
            public void onComplete(Task<ReviewInfo> task) {
                if (task.isSuccessful()) {
                    Platform101XPApplicationReviewGooglePlay.this.reviewInfo = task.getResult();
                    Platform101XPApplicationReviewGooglePlay.this.reviewManager.launchReviewFlow(Platform101XP.getCurrentActivity(), Platform101XPApplicationReviewGooglePlay.this.reviewInfo).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.platform101xp.sdk.internal.Platform101XPApplicationReviewGooglePlay.1.1
                        @Override // com.google.android.play.core.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task2) {
                            Platform101XPApplicationReviewGooglePlay.this.reviewListener.reviewSuccess();
                        }
                    });
                    return;
                }
                Platform101XPApplicationReviewGooglePlay.this.reviewListener.reviewFailed(task.getException());
            }
        });
    }
}
