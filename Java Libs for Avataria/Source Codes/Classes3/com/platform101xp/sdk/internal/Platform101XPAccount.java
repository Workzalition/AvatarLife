package com.platform101xp.sdk.internal;

import com.google.gson.Gson;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.R;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPAccount.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR\u001c\u0010!\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\f¨\u0006("}, d2 = {"Lcom/platform101xp/sdk/internal/Platform101XPAccount;", "", "isGuest", "", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "(ZLcom/platform101xp/sdk/internal/Platform101XPSettings;)V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", TapjoyAuctionFlags.AUCTION_ID, "", "getId", "()J", "setId", "(J)V", "()Z", "setGuest", "(Z)V", "properties", "", "getProperties", "()Ljava/util/Map;", "setProperties", "(Ljava/util/Map;)V", "getSettings", "()Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "userName", "getUserName", "setUserName", "userPhotoUrl", "getUserPhotoUrl", "setUserPhotoUrl", "logout", "", "saveAccountData", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPAccount {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String KEY_ACCOUNT_EMAIL = "account_email";
    @Deprecated
    public static final String KEY_ACCOUNT_ID = "account_id";
    @Deprecated
    public static final String KEY_ACCOUNT_PHOTO_URL = "account_photo_url";
    @Deprecated
    public static final String KEY_ACCOUNT_PROPERTIES = "account_properties";
    @Deprecated
    public static final String KEY_ACCOUNT_USERNAME = "account_username";
    private String email;
    private long id;
    private boolean isGuest;
    private Map<String, Object> properties = new LinkedHashMap();
    private final Platform101XPSettings settings;
    private String userName;
    private String userPhotoUrl;

    /* compiled from: Platform101XPAccount.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/platform101xp/sdk/internal/Platform101XPAccount$Companion;", "", "()V", "KEY_ACCOUNT_EMAIL", "", "KEY_ACCOUNT_ID", "KEY_ACCOUNT_PHOTO_URL", "KEY_ACCOUNT_PROPERTIES", "KEY_ACCOUNT_USERNAME", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Platform101XPAccount(boolean z, Platform101XPSettings platform101XPSettings) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        this.isGuest = z;
        this.settings = platform101XPSettings;
        this.id = -1L;
        if (this.isGuest) {
            this.userName = Platform101XP.getCurrentActivity().getString(R.string.welcome_guest);
            this.userPhotoUrl = "";
        } else {
            this.userName = platform101XPSettings.getString(KEY_ACCOUNT_USERNAME);
            this.userPhotoUrl = platform101XPSettings.getString(KEY_ACCOUNT_PHOTO_URL);
        }
        this.email = platform101XPSettings.getString(KEY_ACCOUNT_EMAIL);
        Long l = platform101XPSettings.getLong(KEY_ACCOUNT_ID, -1L);
        Intrinsics.checkNotNullExpressionValue(l, "settings.getLong(KEY_ACCOUNT_ID, -1)");
        this.id = l.longValue();
        String string = platform101XPSettings.getString(KEY_ACCOUNT_PROPERTIES);
        if (string == null) {
            return;
        }
        if (!(string.length() > 0)) {
            return;
        }
        Object fromJson = new Gson().fromJson(string, (Class<Object>) getProperties().getClass());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(stringPr…, properties::class.java)");
        setProperties((Map) fromJson);
    }

    public final Platform101XPSettings getSettings() {
        return this.settings;
    }

    public final boolean isGuest() {
        return this.isGuest;
    }

    public final void setGuest(boolean z) {
        this.isGuest = z;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getUserPhotoUrl() {
        return this.userPhotoUrl;
    }

    public final void setUserPhotoUrl(String str) {
        this.userPhotoUrl = str;
    }

    public final Map<String, Object> getProperties() {
        return this.properties;
    }

    public final void setProperties(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.properties = map;
    }

    public final void saveAccountData(boolean z) {
        if (!z) {
            this.settings.setString(KEY_ACCOUNT_USERNAME, this.userName);
            this.settings.setString(KEY_ACCOUNT_PHOTO_URL, this.userPhotoUrl);
        }
        this.settings.setString(KEY_ACCOUNT_EMAIL, this.email);
        this.settings.setLong(KEY_ACCOUNT_ID, this.id);
        Map<String, Object> map = this.properties;
        if (map != null && (!map.isEmpty())) {
            getSettings().setString(KEY_ACCOUNT_PROPERTIES, new Gson().toJson(map));
        }
    }

    public final void logout() {
        this.userName = null;
        this.email = null;
        this.id = -1L;
        this.userPhotoUrl = null;
        this.properties.clear();
    }
}
