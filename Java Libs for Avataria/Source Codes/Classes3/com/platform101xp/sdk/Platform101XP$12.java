package com.platform101xp.sdk;

import android.util.Log;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelToken;
import com.platform101xp.sdk.entities.Platform101XPSocialFriend;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogType;
import com.platform101xp.sdk.internal.dialogs.nativedialogs.Platform101XPWarningDialogs;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPFacebook;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPGoogle;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPPortal;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import com.platform101xp.sdk.internal.token.Platform101XPTokenIds;
import java.util.List;
import kotlin.Pair;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
class Platform101XP$12 implements Platform101XPSocialNetwork.SocialNetworkListener {
    final /* synthetic */ Platform101XP this$0;

    Platform101XP$12(Platform101XP platform101XP) {
        this.this$0 = platform101XP;
    }

    public void onResult(final Platform101XPSocialNetwork platform101XPSocialNetwork, String str, Platform101XPError platform101XPError) {
        if (platform101XPSocialNetwork.getProvider() != Platform101XPGoogle.SN_PROVIDER) {
            Platform101XP.access$800(this.this$0).getFactory().getProgressDialog().show();
        }
        String str2 = null;
        if (str != null) {
            Platform101XP.access$800(this.this$0).dismissDialogs();
            if (platform101XPSocialNetwork.getProvider() == Platform101XPPortal.SN_PROVIDER) {
                Platform101XP.access$1002(this.this$0, false);
                Platform101XPSettings.saveString(Platform101XPSNManager.LAST_SN_AUTHORIZE, platform101XPSocialNetwork.getProvider());
                if (Platform101XP.access$300(this.this$0) != null) {
                    Platform101XP.access$300(this.this$0).saveUserToken(str, new Platform101XPFirebaseDbManager.DataResultListener() { // from class: com.platform101xp.sdk.Platform101XP$12.1
                        @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataResultListener
                        public void onActionResult(Platform101XPError platform101XPError2) {
                            if (platform101XPError2 != null) {
                                Log.d("101XP SDK", platform101XPError2.toString());
                            }
                        }
                    });
                }
                try {
                    Pair<Platform101XPToken, Platform101XPTokenIds> deserializeToken = Platform101XP.access$1100(this.this$0).deserializeToken(str);
                    if (deserializeToken != null) {
                        Platform101XP.access$1100(this.this$0).updateCurrentToken(deserializeToken);
                        str2 = Platform101XP.getToken();
                    }
                } catch (Exception e) {
                    Platform101XP.access$1200(e.getMessage());
                }
                Platform101XP.access$1300(str2, platform101XPError);
            } else {
                if (Platform101XP.access$800(this.this$0).isWebDialogs()) {
                    Platform101XP.access$800(this.this$0).getFactory().getProgressDialog().show();
                }
                if (Platform101XP.isLoggedIn()) {
                    str2 = Platform101XP.getToken().getAccessToken().getId();
                }
                Platform101XPApi.auth().socialAuth(platform101XPSocialNetwork.getProvider(), Platform101XP.access$1400(this.this$0), Platform101XP.getDeviceId(), str, str2, Platform101XP.access$1100(this.this$0).isDeviceTokenEnabled()).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.Platform101XP$12.2
                    @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                    public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError2) {
                        if (platform101XPError2 != null) {
                            Log.d("101XP SDK", "Bind Error: " + platform101XPError2);
                            if (platform101XPError2.getErrorType().equals(Platform101XPError.ErrorType.ERROR_API)) {
                                Platform101XP.access$800(Platform101XP$12.this.this$0).dismissCurrentDialog(Platform101XPDialogType.DIALOG_PROGRESS);
                                if (platform101XPError2.getApiError().code == 1100 && !Platform101XP.access$800(Platform101XP.access$000()).isWebDialogs()) {
                                    Platform101XP.access$1500(Platform101XPWarningDialogs.WarningType.ACCOUNT_HAS_BIND_WARNING, (Platform101XPSNType) null);
                                    return;
                                } else if (platform101XPError2.getApiError().code == 2002112) {
                                    Platform101XP.access$1500(Platform101XPWarningDialogs.WarningType.HAS_BIND_PROGRESS_WARNING, (Platform101XPSNType) null);
                                    return;
                                } else {
                                    Platform101XP.access$1300((Platform101XPToken) null, platform101XPError2);
                                    return;
                                }
                            } else if (platform101XPSocialNetwork.getProvider() == Platform101XPGoogle.SN_PROVIDER && Platform101XP.access$1600()) {
                                Log.d("101XP SDK", "Google Error: " + platform101XPError2.toString());
                                Platform101XP.access$1700();
                                return;
                            } else {
                                Platform101XP.access$1300((Platform101XPToken) null, platform101XPError2);
                                return;
                            }
                        }
                        try {
                            Pair<Platform101XPToken, Platform101XPTokenIds> deserializeToken2 = Platform101XP.access$1100(Platform101XP$12.this.this$0).deserializeToken(platform101XPModel != null ? ((Platform101XPModelToken) platform101XPModel).access : null);
                            Platform101XP.access$1002(Platform101XP$12.this.this$0, false);
                            if (Platform101XP.access$1100(Platform101XP$12.this.this$0).isNeedShowAuthorizeWarning(Platform101XPFacebook.SN_PROVIDER, deserializeToken2)) {
                                platform101XPSocialNetwork.showAuthorizeWarning();
                                return;
                            }
                            Platform101XP.access$1100(Platform101XP$12.this.this$0).updateCurrentToken(deserializeToken2);
                            if (Platform101XP.access$300(Platform101XP$12.this.this$0) != null && deserializeToken2 != null) {
                                Platform101XP.access$300(Platform101XP$12.this.this$0).saveUserToken(Platform101XP.access$1100(Platform101XP$12.this.this$0).serializeCurrentToken(), new Platform101XPFirebaseDbManager.DataResultListener() { // from class: com.platform101xp.sdk.Platform101XP.12.2.1
                                    @Override // com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager.DataResultListener
                                    public void onActionResult(Platform101XPError platform101XPError3) {
                                        if (platform101XPError3 != null) {
                                            Log.d("101XP SDK", platform101XPError3.toString());
                                        }
                                    }
                                });
                            }
                            Platform101XPSettings.saveString(Platform101XPSNManager.LAST_SN_AUTHORIZE, platform101XPSocialNetwork.getProvider());
                            Platform101XP.access$1300((Platform101XPToken) deserializeToken2.getFirst(), (Platform101XPError) null);
                        } catch (Exception e2) {
                            Platform101XP.access$1300((Platform101XPToken) null, new Platform101XPError(e2));
                        }
                    }
                });
            }
        } else if (platform101XPSocialNetwork.getProvider() == Platform101XPGoogle.SN_PROVIDER && Platform101XP.access$1600()) {
            Platform101XP.access$1700();
        } else {
            Platform101XP.access$1300((Platform101XPToken) null, platform101XPError);
        }
        Platform101XP.access$1802(false);
    }

    public void onInviteResult(Platform101XPSocialNetwork platform101XPSocialNetwork, Platform101XPError platform101XPError) {
        Platform101XP.access$1900(platform101XPError);
    }

    public void onFriendsResult(List<Platform101XPSocialFriend> list, Platform101XPError platform101XPError) {
        Platform101XP.access$800(this.this$0).getFactory().getProgressDialog().dismiss();
        Platform101XP.access$700(this.this$0).onGetSocialFriendsResult(list, platform101XPError);
    }
}
