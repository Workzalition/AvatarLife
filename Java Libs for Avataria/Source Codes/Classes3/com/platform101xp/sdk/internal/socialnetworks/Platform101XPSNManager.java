package com.platform101xp.sdk.internal.socialnetworks;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPApi;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPSNType;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelSocialFriends;
import com.platform101xp.sdk.entities.Platform101XPSocialFriend;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.socialnetworks.Platform101XPSocialNetwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPSNManager {
    public static final String LAST_SN_AUTHORIZE = "Platform101XP_Last_Sn";
    public static final String META_SN_EXTRA_PERMISSION = "com.platform101xp.sdk.sn_extra_permission";
    private static final String RUSSIAN_USER_POSITION = "RU";
    private String clientId;
    @Inject
    Platform101XPConfigManager configManager;
    private Map<String, Platform101XPSNType> providerTypeMatcher = new HashMap();
    @Inject
    Platform101XPFacebook snFacebook;
    @Inject
    Platform101XPGoogle snGoogle;
    @Inject
    Platform101XPOK snOk;
    @Inject
    Platform101XPPortal snPortal;
    @Inject
    Platform101XPVK snVk;
    private Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener;
    private Platform101XPSocialNetwork[] socialNetworks;

    @Inject
    public Platform101XPSNManager(Platform101XPSocialNetwork.SocialNetworkListener socialNetworkListener, String str) {
        this.clientId = str;
        this.socialNetworkListener = socialNetworkListener;
    }

    private void initSn() {
        this.socialNetworks = new Platform101XPSocialNetwork[]{this.snPortal, this.snFacebook, this.snVk, this.snOk, this.snGoogle};
        initMatcher();
    }

    private void initMatcher() {
        int i = 0;
        while (true) {
            Platform101XPSocialNetwork[] platform101XPSocialNetworkArr = this.socialNetworks;
            if (i < platform101XPSocialNetworkArr.length) {
                this.providerTypeMatcher.put(platform101XPSocialNetworkArr[i].getProvider().toLowerCase(), Platform101XPSNType.fromOrdinal(i));
                i++;
            } else {
                return;
            }
        }
    }

    public void authorize(Platform101XPSNType platform101XPSNType) {
        Platform101XP.crashLog("101XP SDK", "Start authorize of sn type: " + platform101XPSNType);
        getSocialNetwork(platform101XPSNType).authorize();
    }

    public void logout() {
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : this.socialNetworks) {
            platform101XPSocialNetwork.logout();
        }
    }

    public boolean isEnabled() {
        boolean z = false;
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : this.socialNetworks) {
            z |= platform101XPSocialNetwork.isEnabled();
        }
        return z;
    }

    public boolean isEnabled(Platform101XPSNType platform101XPSNType) {
        return getSocialNetwork(platform101XPSNType).isEnabled();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Platform101XPSocialNetwork[] platform101XPSocialNetworkArr;
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : this.socialNetworks) {
            if (platform101XPSocialNetwork.isEnabled()) {
                platform101XPSocialNetwork.onActivityResult(i, i2, intent);
            }
        }
    }

    public void onCreate(Activity activity) {
        initSn();
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : this.socialNetworks) {
            platform101XPSocialNetwork.onCreate(activity);
        }
    }

    public void onResume(Activity activity) {
        Platform101XPSocialNetwork[] platform101XPSocialNetworkArr = this.socialNetworks;
        if (platform101XPSocialNetworkArr == null || platform101XPSocialNetworkArr.length <= 0) {
            return;
        }
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : platform101XPSocialNetworkArr) {
            platform101XPSocialNetwork.onResume(activity);
        }
    }

    public void onDestroy(Activity activity) {
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : this.socialNetworks) {
            platform101XPSocialNetwork.onDestroy(activity);
        }
    }

    private Platform101XPSocialNetwork getSocialNetwork(Platform101XPSNType platform101XPSNType) {
        return this.socialNetworks[platform101XPSNType.ordinal()];
    }

    public Platform101XPSocialFunction getSocialFunction(Platform101XPSNType platform101XPSNType) {
        if (getSocialNetwork(platform101XPSNType) instanceof Platform101XPSocialFunction) {
            return getSocialNetwork(platform101XPSNType);
        }
        return null;
    }

    public String getSocialProvider(Platform101XPSNType platform101XPSNType) {
        return this.socialNetworks[platform101XPSNType.ordinal()].getProvider();
    }

    public void getSocialFriends(Platform101XPSNType platform101XPSNType) {
        this.socialNetworks[platform101XPSNType.ordinal()].getSocialFriends(new SocialFriendsResultListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager.1
            public void onGetFriendsResult(List<Platform101XPSocialFriend> list, Platform101XPError platform101XPError) {
                if (platform101XPError != null) {
                    Platform101XPSNManager.this.socialNetworkListener.onFriendsResult((List) null, platform101XPError);
                } else {
                    Platform101XPSNManager.this.onHandleFriendsResult(list);
                }
            }
        });
    }

    public boolean isNeedGetSocialFriends(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return this.socialNetworks[getTypeByProvider(str).ordinal()].isNeedGetSocialFriends();
    }

    public void updateConfigData() {
        Platform101XPSocialNetwork[] platform101XPSocialNetworkArr = this.socialNetworks;
        if (platform101XPSocialNetworkArr == null || platform101XPSocialNetworkArr.length <= 0) {
            return;
        }
        for (Platform101XPSocialNetwork platform101XPSocialNetwork : platform101XPSocialNetworkArr) {
            platform101XPSocialNetwork.updateConfigData();
        }
    }

    protected void onHandleFriendsResult(final List<Platform101XPSocialFriend> list) {
        if (!list.isEmpty() && Platform101XP.getToken() != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).getSocialNetId());
            }
            Platform101XPApi.data().socialFriends(Platform101XP.getToken(), TextUtils.join(",", arrayList), this.clientId).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.socialnetworks.Platform101XPSNManager.2
                @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
                public void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                    if (platform101XPError != null) {
                        Platform101XPSNManager.this.socialNetworkListener.onFriendsResult((List) null, platform101XPError);
                    } else if (platform101XPModel != null) {
                        Map<String, Platform101XPModelSocialFriends.FriendInfo> map = ((Platform101XPModelSocialFriends) platform101XPModel).friendInfoMap;
                        for (Platform101XPSocialFriend platform101XPSocialFriend : list) {
                            platform101XPSocialFriend.setMobileId(map.get(platform101XPSocialFriend.getSocialNetId()).mobileId);
                            platform101XPSocialFriend.setLevel(map.get(platform101XPSocialFriend.getSocialNetId()).level);
                        }
                        Platform101XPSNManager.this.socialNetworkListener.onFriendsResult(list, (Platform101XPError) null);
                    }
                }
            });
            return;
        }
        this.socialNetworkListener.onFriendsResult(list, (Platform101XPError) null);
    }

    public Platform101XPSNType getTypeByProvider(String str) {
        return this.providerTypeMatcher.get(str.toLowerCase());
    }

    public void handleUserPosition(String str) {
        this.snFacebook.setBlocked(isUserPositionRu(str));
    }

    private boolean isUserPositionRu(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(RUSSIAN_USER_POSITION);
    }
}
