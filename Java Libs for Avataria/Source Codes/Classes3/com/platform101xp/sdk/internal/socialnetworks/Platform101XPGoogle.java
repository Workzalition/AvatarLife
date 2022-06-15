package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import java.util.List;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPGoogle implements Platform101XPSocialNetwork {
    public static final String GOOGLE_FIRST_LAUNCH_KEY = "com.platform101xp.sdk.google_first_launch";
    private static final int GOOGLE_SIGN_IN_CANCELLED = 12501;
    private static final int RC_SIGN_IN = 9001;
    public static final String SN_PROVIDER = "google";
    private Platform101XPConfigManager configManager;
    @Inject
    Platform101XPDialogFactory dialogsFactory;
    private GoogleSignInAccount googleAccount;
    private String googleAppId;
    private GoogleSignInClient googleSignInClient;
    private boolean isAchievementsOn;
    private Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener;
    private boolean enabled = true;
    private final Platform101XPGoogle self = this;

    public String getProvider() {
        return SN_PROVIDER;
    }

    public boolean isNeedGetSocialFriends() {
        return false;
    }

    public void onDestroy(Activity activity) {
    }

    @Inject
    public Platform101XPGoogle(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, Platform101XPConfigManager platform101XPConfigManager) {
        this.socialNetworkListener = socialNetworkListener;
        this.configManager = platform101XPConfigManager;
        checkEnabled();
        if (!isEnabled()) {
            return;
        }
        this.googleSignInClient = GoogleSignIn.getClient(Platform101XP.getCurrentActivity(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).requestScopes(new Scope("https://www.googleapis.com/auth/games"), new Scope[0]).requestServerAuthCode(this.googleAppId).requestProfile().requestEmail().requestIdToken(this.googleAppId).build());
    }

    public void authorize() {
        if (!isEnabled()) {
            return;
        }
        this.dialogsFactory.getProgressDialog().show();
        try {
            if (isFirstLunch()) {
                this.googleSignInClient.silentSignIn().addOnCompleteListener(new OnCompleteListener<GoogleSignInAccount>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle.1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(Task<GoogleSignInAccount> task) {
                        Platform101XPSettings.saveBoolean(Platform101XPGoogle.GOOGLE_FIRST_LAUNCH_KEY, true);
                        try {
                            Platform101XPGoogle.this.googleAccount = task.getResult();
                            if (Platform101XPGoogle.this.googleAccount == null || Platform101XPGoogle.this.googleAccount.getIdToken() == null || Platform101XPGoogle.this.googleAccount.getIdToken().isEmpty()) {
                                Platform101XPGoogle.this.result(null, new Platform101XPError(new Exception("Google Token is incorrect!")));
                            } else {
                                Log.d("101XP SDK", "Existed Google Token:" + Platform101XPGoogle.this.googleAccount.getIdToken());
                                Platform101XPGoogle platform101XPGoogle = Platform101XPGoogle.this;
                                platform101XPGoogle.result(platform101XPGoogle.googleAccount.getIdToken(), null);
                            }
                        } catch (Exception unused) {
                            Platform101XP.getCurrentActivity().startActivityForResult(Platform101XPGoogle.this.googleSignInClient.getSignInIntent(), Platform101XPGoogle.RC_SIGN_IN);
                        }
                    }
                });
            } else {
                Platform101XP.getCurrentActivity().startActivityForResult(this.googleSignInClient.getSignInIntent(), RC_SIGN_IN);
            }
        } catch (Throwable th) {
            result(null, new Platform101XPError(new Exception(th.getMessage())));
            Platform101XP.sendCrashReport(th);
        }
    }

    public void logout() {
        if (!isEnabled()) {
            return;
        }
        this.dialogsFactory.getProgressDialog().dismiss();
        try {
            GoogleSignInClient googleSignInClient = this.googleSignInClient;
            if (googleSignInClient == null) {
                return;
            }
            googleSignInClient.revokeAccess().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle.2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    Log.d("101XP SDK", "Google Client revokeAccess");
                }
            });
            this.googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle.3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    Log.d("101XP SDK", "Google Client signOut");
                }
            });
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == RC_SIGN_IN) {
            try {
                handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(intent));
            } catch (Throwable th) {
                result(null, new Platform101XPError(new Exception(th.getMessage())));
                th.printStackTrace();
            }
        }
    }

    private void handleSignInResult(GoogleSignInResult googleSignInResult) {
        if (googleSignInResult != null && googleSignInResult.isSuccess()) {
            GoogleSignInAccount signInAccount = googleSignInResult.getSignInAccount();
            this.googleAccount = signInAccount;
            String idToken = signInAccount.getIdToken();
            Log.d("101XP SDK", "New Google Token: " + idToken);
            result(idToken, null);
            return;
        }
        Log.d("101XP SDK", "Google Token result status: " + googleSignInResult.getStatus() + " error: " + googleSignInResult.getStatus().getStatusMessage());
        if (googleSignInResult.getStatus().isCanceled() || googleSignInResult.getStatus().getStatusCode() == GOOGLE_SIGN_IN_CANCELLED) {
            result(null, new Platform101XPError(Platform101XPError.ErrorType.ERROR_CANCELED));
        } else {
            result(null, new Platform101XPError(new Exception(googleSignInResult.getStatus().toString())));
        }
    }

    public void onCreate(Activity activity) {
        setClientToAchievements();
    }

    public void onResume(Activity activity) {
        setClientToAchievements();
    }

    public void updateConfigData() {
        if (this.configManager != null) {
            checkEnabled();
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    private void checkEnabled() {
        this.enabled = this.configManager.getBool(Platform101XPConfigKeyHolder.gpEnabled, true);
        Log.d("101XP SDK", "Google+ config enabled:" + this.enabled);
        if (this.enabled) {
            initParameters();
        }
    }

    private void initParameters() {
        this.isAchievementsOn = this.configManager.getBool(Platform101XPConfigKeyHolder.achievementsOn, false);
        this.googleAppId = this.configManager.getString(Platform101XPConfigKeyHolder.googleWebClientId, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void result(String str, Platform101XPError platform101XPError) {
        this.dialogsFactory.getProgressDialog().dismiss();
        this.socialNetworkListener.onResult(this.self, str, platform101XPError);
    }

    private void setClientToAchievements() {
        if (this.googleAccount == null || !this.isAchievementsOn) {
            return;
        }
        Platform101XP.getAchievementsInstance().SetGoogleApiClient(this.googleAccount);
    }

    public void getSocialFriends(Platform101XPSNManager.SocialFriendsResultListener socialFriendsResultListener) {
        socialFriendsResultListener.onGetFriendsResult((List) null, new Platform101XPError(new Exception("Getting social friends is't available in this social network!")));
    }

    public void showAuthorizeWarning() {
        Log.d("101XP SDK", "For Google not implemented");
    }

    private boolean isFirstLunch() {
        return !Platform101XPSettings.loadBoolean(GOOGLE_FIRST_LAUNCH_KEY, false);
    }
}
