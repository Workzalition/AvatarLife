package com.platform101xp.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.Games;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAchievements {
    private static final String LOG_TAG = "101XP Achievements";
    private static Context mContext;
    private static GoogleSignInAccount mGoogleAccount;
    private static AccomplishmentsOutbox mOutbox = new AccomplishmentsOutbox();
    private static Activity sActivity;
    private Platform101XPConfigManager configManager;
    private boolean enabled;
    private Platform101XPUserTiming userTiming;
    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private final long mHour = 3600000;
    private final long mDay = 86400000;

    private boolean isEnabled() {
        return this.enabled;
    }

    private void checkEnabled() {
        boolean z = false;
        boolean bool = this.configManager.getBool(Platform101XPConfigKeyHolder.achievementsOn, false);
        String string = this.configManager.getString(Platform101XPConfigKeyHolder.googlePlayServicesAppId, "");
        if (bool && !string.isEmpty()) {
            z = true;
        }
        this.enabled = z;
    }

    private boolean isSignedIn() {
        GoogleSignInAccount googleSignInAccount = mGoogleAccount;
        return googleSignInAccount != null && !googleSignInAccount.isExpired();
    }

    public void SetGoogleApiClient(GoogleSignInAccount googleSignInAccount) {
        mGoogleAccount = googleSignInAccount;
    }

    public Platform101XPAchievements(Activity activity, Platform101XPConfigManager platform101XPConfigManager) {
        this.configManager = platform101XPConfigManager;
        checkEnabled();
        if (isEnabled()) {
            sActivity = activity;
            Context applicationContext = activity.getApplicationContext();
            mContext = applicationContext;
            mOutbox.loadLocal(applicationContext);
            this.userTiming = new Platform101XPUserTiming(true);
            RunListener();
        }
    }

    public void showAchievementActivity() {
        if (sActivity == null || !isSignedIn()) {
            return;
        }
        Games.getAchievementsClient(sActivity, mGoogleAccount).getAchievementsIntent().addOnCompleteListener(new OnCompleteListener<Intent>() { // from class: com.platform101xp.sdk.internal.Platform101XPAchievements.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Intent> task) {
                Platform101XPAchievements.sActivity.startActivityForResult(task.getResult(), 1);
            }
        });
    }

    public void updateConfigData() {
        checkEnabled();
    }

    public void checkTimeAchievements(long j) {
        if (isEnabled()) {
            Log.d(LOG_TAG, String.valueOf(j));
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(5);
            int i2 = calendar.get(2);
            int i3 = calendar.get(11);
            if (!mOutbox.mGuestAchievement && j / 3600000 >= 1) {
                mOutbox.mGuestAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.guest"), getString(R.string.achievement_guest));
            }
            if (!mOutbox.mNewbieAchievement && j / 3600000 >= 3) {
                mOutbox.mNewbieAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.newbie"), getString(R.string.achievement_newbie));
            }
            if (!mOutbox.mMiddleAchievement && j / 3600000 >= 24) {
                mOutbox.mMiddleAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.middle"), getString(R.string.achievement_middle));
            }
            if (!mOutbox.mProAchievement && j / 3600000 >= 100) {
                mOutbox.mProAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.pro"), getString(R.string.achievement_pro));
            }
            if (!mOutbox.mAsWorkAchievement && this.userTiming.CalculateSessionSum(System.currentTimeMillis() - 432000000) > 144000000) {
                mOutbox.mAsWorkAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.as_work"), getString(R.string.achievement_as_work));
            }
            this.userTiming.ClearSession(System.currentTimeMillis() - 518400000);
            if (!mOutbox.mNewYearAchievement && i == 31 && i2 == 11) {
                mOutbox.mNewYearAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.new_year"), getString(R.string.achievement_new_year));
            }
            if (!mOutbox.mNightAchievement && i3 >= 1 && i3 < 4) {
                mOutbox.mNightAchievement = true;
                unlockAchievement(getManifestString("com.platform101xp.sdk.achievements.night"), getString(R.string.achievement_night));
            }
            pushAccomplishments();
        }
    }

    private String getString(int i) {
        return mContext.getResources().getString(i);
    }

    private String getManifestString(String str) {
        Platform101XPConfigManager platform101XPConfigManager = this.configManager;
        return platform101XPConfigManager == null ? "" : platform101XPConfigManager.getString(str, "");
    }

    public void Start() {
        Platform101XPUserTiming platform101XPUserTiming;
        if (!isEnabled() || (platform101XPUserTiming = this.userTiming) == null) {
            return;
        }
        platform101XPUserTiming.Start();
    }

    public long GetTime() {
        if (isEnabled()) {
            return this.userTiming.GetTime();
        }
        return -1L;
    }

    public void Stop() {
        if (isEnabled()) {
            this.userTiming.Stop();
        }
    }

    public void RunListener() {
        this.service.scheduleAtFixedRate(new Runnable() { // from class: com.platform101xp.sdk.internal.Platform101XPAchievements.2
            @Override // java.lang.Runnable
            public void run() {
                if (Platform101XPAchievements.this.userTiming != null) {
                    Platform101XPAchievements platform101XPAchievements = Platform101XPAchievements.this;
                    platform101XPAchievements.checkTimeAchievements(platform101XPAchievements.userTiming.GetTime());
                }
            }
        }, 60L, 300L, TimeUnit.SECONDS);
    }

    void unlockAchievement(String str, String str2) {
        if (isSignedIn()) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(str);
        } else {
            achievementToast(str2);
        }
    }

    void achievementToast(final String str) {
        if (!isSignedIn()) {
            sActivity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.Platform101XPAchievements.3
                @Override // java.lang.Runnable
                public void run() {
                    Context context = Platform101XPAchievements.mContext;
                    Toast.makeText(context, Platform101XPAchievements.mContext.getResources().getString(R.string.achievement) + ": " + str, 1).show();
                }
            });
            Log.d(LOG_TAG, str);
        }
    }

    void pushAccomplishments() {
        if (!isSignedIn()) {
            mOutbox.saveLocal(mContext);
            return;
        }
        if (mOutbox.mGuestAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.guest"));
        }
        if (mOutbox.mNewbieAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.newbie"));
        }
        if (mOutbox.mMiddleAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.middle"));
        }
        if (mOutbox.mProAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.pro"));
        }
        if (mOutbox.mAsWorkAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.as_work"));
        }
        if (mOutbox.mNewYearAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.new_year"));
        }
        if (mOutbox.mNightAchievement) {
            Games.getAchievementsClient(sActivity, mGoogleAccount).unlock(getManifestString("com.platform101xp.sdk.achievements.night"));
        }
        mOutbox.saveLocal(mContext);
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static class AccomplishmentsOutbox {
        private static final String KEY_ASWORK_ACHIEVEMENT = "com.platform101xp.sdk.achievements.as_work";
        private static final String KEY_GUEST_ACHIEVEMENT = "com.platform101xp.sdk.achievements.guest";
        private static final String KEY_MIDLE_ACHIEVEMENT = "com.platform101xp.sdk.achievements.middle";
        private static final String KEY_NEWBIE_ACHIEVEMENT = "com.platform101xp.sdk.achievements.newbie";
        private static final String KEY_NEWYEAR_ACHIEVEMENT = "com.platform101xp.sdk.achievements.new_year";
        private static final String KEY_NIGHT_ACHIEVEMENT = "com.platform101xp.sdk.achievements.night";
        private static final String KEY_PRO_ACHIEVEMENT = "com.platform101xp.sdk.achievements.pro";
        boolean mAsWorkAchievement;
        boolean mGuestAchievement;
        boolean mMiddleAchievement;
        boolean mNewYearAchievement;
        boolean mNewbieAchievement;
        boolean mNightAchievement;
        boolean mProAchievement;

        AccomplishmentsOutbox() {
        }

        public void saveLocal(Context context) {
            Platform101XPSettings.saveBoolean(KEY_GUEST_ACHIEVEMENT, this.mGuestAchievement);
            Platform101XPSettings.saveBoolean(KEY_NEWBIE_ACHIEVEMENT, this.mNewbieAchievement);
            Platform101XPSettings.saveBoolean(KEY_MIDLE_ACHIEVEMENT, this.mMiddleAchievement);
            Platform101XPSettings.saveBoolean(KEY_PRO_ACHIEVEMENT, this.mProAchievement);
            Platform101XPSettings.saveBoolean(KEY_ASWORK_ACHIEVEMENT, this.mAsWorkAchievement);
            Platform101XPSettings.saveBoolean(KEY_NEWYEAR_ACHIEVEMENT, this.mNewYearAchievement);
            Platform101XPSettings.saveBoolean(KEY_NIGHT_ACHIEVEMENT, this.mNightAchievement);
        }

        public void loadLocal(Context context) {
            this.mGuestAchievement = Platform101XPSettings.loadBoolean(KEY_GUEST_ACHIEVEMENT, false);
            this.mNewbieAchievement = Platform101XPSettings.loadBoolean(KEY_NEWBIE_ACHIEVEMENT, false);
            this.mMiddleAchievement = Platform101XPSettings.loadBoolean(KEY_MIDLE_ACHIEVEMENT, false);
            this.mProAchievement = Platform101XPSettings.loadBoolean(KEY_PRO_ACHIEVEMENT, false);
            this.mAsWorkAchievement = Platform101XPSettings.loadBoolean(KEY_ASWORK_ACHIEVEMENT, false);
            this.mNewYearAchievement = Platform101XPSettings.loadBoolean(KEY_NEWYEAR_ACHIEVEMENT, false);
            this.mNightAchievement = Platform101XPSettings.loadBoolean(KEY_NIGHT_ACHIEVEMENT, false);
        }
    }
}
