package com.platform101xp.sdk.internal.token;

import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPApi;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.Platform101XPToken;
import com.platform101xp.sdk.Platform101XPToken$Token;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.model.Platform101XPModelTokensMobile;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import com.platform101xp.sdk.internal.analytics.Platform101XPAnalyticsFirebase;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigKeyHolder;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigManager;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogFactory;
import com.platform101xp.sdk.internal.token.Platform101XPJwtParser;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Platform101XPTokenManager.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019J$\u0010\u001a\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J$\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J*\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00192\u001a\u0010(\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000fJ\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0019J\u001e\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u0011J\b\u00103\u001a\u0004\u0018\u00010\u0019J\"\u00104\u001a\u00020\u00192\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000fJ\u000e\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u000207J\"\u00108\u001a\u00020\u00112\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fj\u0002`\u000fJ\u000e\u00108\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0019J\u0012\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0002J\u0016\u0010;\u001a\u00020\u00112\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager;", "", "settings", "Lcom/platform101xp/sdk/internal/Platform101XPSettings;", "configManager", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;", "jwtParserBuilder", "Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser$Builder;", "(Lcom/platform101xp/sdk/internal/Platform101XPSettings;Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigManager;Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser$Builder;)V", "jwtParser", "Lcom/platform101xp/sdk/internal/token/Platform101XPJwtParser;", "tokenPlatform", "Lkotlin/Pair;", "Lcom/platform101xp/sdk/Platform101XPToken;", "Lcom/platform101xp/sdk/internal/token/Platform101XPTokenIds;", "Lcom/platform101xp/sdk/internal/token/TokenPlatform;", "checkUserGameId", "", "forced", "", "doAfterCheckAction", "Lkotlin/Function0;", "currentTokenHasProvider", "deserializeInCurrentToken", "stringToken", "", "deserializeToken", "deserializeTokenFromJson", "jsonObject", "Lorg/json/JSONObject;", "getAccessTokenValue", "getCurrentAccountId", "", "getCurrentToken", "getCurrentUserGameId", "getMobileId", "isDeviceTokenEnabled", "isGuestCurrentToken", "isNeedShowAuthorizeWarning", "snProvider", "currentTokenPlatformPair", "isTokenNeedRefresh", "refreshCurrentToken", "tokenString", "refreshTokenRequest", "clientId", "dialogFactory", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogFactory;", "refreshTokenListener", "Lcom/platform101xp/sdk/internal/token/RefreshTokenListener;", "saveCurrentToken", "serializeCurrentToken", "serializeToken", "tokenLogout", "requestListener", "Lcom/platform101xp/sdk/api/http/Platform101XPHttpRequest$HttpRequestListener;", "updateCurrentToken", "updateGameId", "mobileData", "updateTokenGameIdRequest", "doAfterUpdateAction", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPTokenManager {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_TOKEN_IDS_REQUEST_EXECUTED = "token_mobile_request";
    private final Platform101XPConfigManager configManager;
    private Platform101XPJwtParser jwtParser;
    private final Platform101XPJwtParser.Builder jwtParserBuilder;
    private final Platform101XPSettings settings;
    private Pair<Platform101XPToken, Platform101XPTokenIds> tokenPlatform;

    public Platform101XPTokenManager(Platform101XPSettings platform101XPSettings, Platform101XPConfigManager platform101XPConfigManager, Platform101XPJwtParser.Builder builder) {
        Intrinsics.checkNotNullParameter(platform101XPSettings, "settings");
        Intrinsics.checkNotNullParameter(platform101XPConfigManager, "configManager");
        Intrinsics.checkNotNullParameter(builder, "jwtParserBuilder");
        this.settings = platform101XPSettings;
        this.configManager = platform101XPConfigManager;
        this.jwtParserBuilder = builder;
        try {
            this.tokenPlatform = deserializeToken(platform101XPSettings.getString(KEY_ACCESS_TOKEN));
        } catch (IllegalStateException e) {
            Log.d("101XP SDK", "Token deserialize Exception: {" + ((Object) e.getMessage()) + '}');
        }
    }

    /* compiled from: Platform101XPTokenManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/token/Platform101XPTokenManager$Companion;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_TOKEN_IDS_REQUEST_EXECUTED", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String serializeToken(Pair<Platform101XPToken, Platform101XPTokenIds> pair) {
        Intrinsics.checkNotNullParameter(pair, "tokenPlatform");
        JSONObject jSONObject = new JSONObject();
        try {
            Platform101XPToken platform101XPToken = (Platform101XPToken) pair.getFirst();
            if (platform101XPToken != null) {
                jSONObject.put(KEY_ACCESS_TOKEN, platform101XPToken.getAccessToken().getId());
                jSONObject.put("expires", platform101XPToken.getAccessToken().getExpires());
                Platform101XPToken$Token refreshToken = platform101XPToken.getRefreshToken();
                Long l = null;
                jSONObject.put("refresh_token", refreshToken == null ? null : refreshToken.getId());
                Platform101XPToken$Token refreshToken2 = platform101XPToken.getRefreshToken();
                if (refreshToken2 != null) {
                    l = Long.valueOf(refreshToken2.getExpires());
                }
                jSONObject.put("refresh_expires", l);
                jSONObject.put("social_id", platform101XPToken.getSocialId());
                jSONObject.put("provider_exists", platform101XPToken.isHasBind());
                jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, platform101XPToken.getProvider());
            }
            Platform101XPTokenIds platform101XPTokenIds = (Platform101XPTokenIds) pair.getSecond();
            if (platform101XPTokenIds != null) {
                jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, platform101XPTokenIds.getAccountId());
                jSONObject.put("mob_id", platform101XPTokenIds.getMobileId());
                jSONObject.put("user_game_id", platform101XPTokenIds.getUserGameId());
            }
        } catch (JSONException e) {
            Log.d("101XP SDK", Intrinsics.stringPlus("Token serialize Exception: ", e.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final String serializeCurrentToken() {
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null) {
            return null;
        }
        return serializeToken(pair);
    }

    public final Pair<Platform101XPToken, Platform101XPTokenIds> deserializeToken(String str) {
        if (str != null) {
            if (!(str.length() == 0) && !Intrinsics.areEqual(str, "{}")) {
                try {
                    return deserializeTokenFromJson(new JSONObject(str));
                } catch (JSONException e) {
                    throw e;
                }
            }
        }
        throw new IllegalStateException("Token string is null or empty!");
    }

    public final void deserializeInCurrentToken(String str) {
        Intrinsics.checkNotNullParameter(str, "stringToken");
        try {
            this.tokenPlatform = deserializeToken(str);
        } catch (IllegalStateException e) {
            Log.d("101XP SDK", "Token deserialize Exception: {" + ((Object) e.getMessage()) + '}');
        }
    }

    private final Pair<Platform101XPToken, Platform101XPTokenIds> deserializeTokenFromJson(JSONObject jSONObject) {
        Log.d("101XP SDK", Intrinsics.stringPlus("Token json Object: ", jSONObject));
        String optString = jSONObject.optString(KEY_ACCESS_TOKEN);
        long optLong = jSONObject.optLong("expires");
        String optString2 = jSONObject.optString("refresh_token");
        long optLong2 = jSONObject.optLong("refresh_expires");
        long optLong3 = jSONObject.optLong(TapjoyAuctionFlags.AUCTION_ID);
        String optString3 = jSONObject.optString("social_id");
        boolean z = jSONObject.has("provider_exists") ? jSONObject.getBoolean("provider_exists") : false;
        String optString4 = jSONObject.optString(IronSourceConstants.EVENTS_PROVIDER);
        long optLong4 = jSONObject.optLong("guest_id");
        long optLong5 = jSONObject.optLong("user_game_id");
        long optLong6 = jSONObject.optLong("mob_id");
        long optLong7 = jSONObject.optLong(Platform101XPAnalyticsFirebase.PROPERTY_MOBILE_ID);
        Platform101XPJwtParser.Builder builder = this.jwtParserBuilder;
        Intrinsics.checkNotNullExpressionValue(optString, "accessTokenValue");
        Platform101XPJwtParser build = builder.setJwtString(optString).build();
        this.jwtParser = build;
        long j = optLong4 != 0 ? optLong4 : optLong3;
        Platform101XPJwtParser platform101XPJwtParser = null;
        if (optLong5 == 0) {
            if (optLong7 != 0) {
                optLong5 = optLong7;
            } else {
                if (build == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jwtParser");
                    build = null;
                }
                optLong5 = build.getMobileId();
            }
        }
        Long valueOf = Long.valueOf(optLong2);
        Intrinsics.checkNotNullExpressionValue(optString4, IronSourceConstants.EVENTS_PROVIDER);
        Intrinsics.checkNotNullExpressionValue(optString3, "socialId");
        Platform101XPJwtParser platform101XPJwtParser2 = this.jwtParser;
        if (platform101XPJwtParser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jwtParser");
        } else {
            platform101XPJwtParser = platform101XPJwtParser2;
        }
        return new Pair<>(new Platform101XPToken(optString, optLong, optString2, valueOf, optString4, optString3, z, platform101XPJwtParser.isGuest(), j), new Platform101XPTokenIds(optLong3, optLong6, optLong5));
    }

    public final void refreshTokenRequest(String str, Platform101XPDialogFactory platform101XPDialogFactory, final RefreshTokenListener refreshTokenListener) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(platform101XPDialogFactory, "dialogFactory");
        Intrinsics.checkNotNullParameter(refreshTokenListener, "refreshTokenListener");
        platform101XPDialogFactory.getProgressDialog().show();
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null) {
            return;
        }
        Platform101XPApi.auth().refresh(str, (Platform101XPToken) pair.getFirst(), isDeviceTokenEnabled()).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.token.Platform101XPTokenManager$$ExternalSyntheticLambda0
            @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
            public final void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                Platform101XPTokenManager.m158refreshTokenRequest$lambda4$lambda3(RefreshTokenListener.this, platform101XPModel, platform101XPError);
            }
        });
    }

    /* renamed from: refreshTokenRequest$lambda-4$lambda-3 */
    public static final void m158refreshTokenRequest$lambda4$lambda3(RefreshTokenListener refreshTokenListener, Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        Intrinsics.checkNotNullParameter(refreshTokenListener, "$refreshTokenListener");
        refreshTokenListener.onRefreshTokenResult(platform101XPModel, platform101XPError);
    }

    public static /* synthetic */ void checkUserGameId$default(Platform101XPTokenManager platform101XPTokenManager, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        platform101XPTokenManager.checkUserGameId(z, function0);
    }

    public final void checkUserGameId(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "doAfterCheckAction");
        if (z || (getCurrentAccountId() == getCurrentUserGameId() && !isGuestCurrentToken())) {
            updateTokenGameIdRequest(function0);
        } else {
            function0.invoke();
        }
    }

    private final void updateTokenGameIdRequest(final Function0<Unit> function0) {
        Platform101XPToken platform101XPToken;
        Platform101XPToken$Token accessToken;
        if (this.settings.getBoolean(KEY_TOKEN_IDS_REQUEST_EXECUTED, false)) {
            function0.invoke();
            return;
        }
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        String str = null;
        if (pair != null && (platform101XPToken = (Platform101XPToken) pair.getFirst()) != null && (accessToken = platform101XPToken.getAccessToken()) != null) {
            str = accessToken.getId();
        }
        if (str == null) {
            return;
        }
        Platform101XPApi.auth().tokensMobile(str).execute(new Platform101XPHttpRequest.HttpRequestListener() { // from class: com.platform101xp.sdk.internal.token.Platform101XPTokenManager$$ExternalSyntheticLambda1
            @Override // com.platform101xp.sdk.api.http.Platform101XPHttpRequest.HttpRequestListener
            public final void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
                Platform101XPTokenManager.m159updateTokenGameIdRequest$lambda8$lambda7(function0, this, platform101XPModel, platform101XPError);
            }
        });
    }

    /* renamed from: updateTokenGameIdRequest$lambda-8$lambda-7 */
    public static final void m159updateTokenGameIdRequest$lambda8$lambda7(Function0 function0, Platform101XPTokenManager platform101XPTokenManager, Platform101XPModel platform101XPModel, Platform101XPError platform101XPError) {
        Intrinsics.checkNotNullParameter(function0, "$doAfterUpdateAction");
        Intrinsics.checkNotNullParameter(platform101XPTokenManager, "this$0");
        if (platform101XPModel != null) {
            Objects.requireNonNull(platform101XPModel, "null cannot be cast to non-null type com.platform101xp.sdk.api.model.Platform101XPModelTokensMobile");
            platform101XPTokenManager.updateGameId(((Platform101XPModelTokensMobile) platform101XPModel).getMobile());
            platform101XPTokenManager.settings.setBoolean(KEY_TOKEN_IDS_REQUEST_EXECUTED, true);
        }
        if (platform101XPError != null) {
            Log.d("101XP SDK", Intrinsics.stringPlus("Refresh gameId Error: ", platform101XPError));
            Platform101XP.sendCrashReport(new Exception(Intrinsics.stringPlus("Refresh gameId Error: ", platform101XPError)));
        }
        function0.invoke();
    }

    public final boolean isTokenNeedRefresh() {
        Platform101XPToken platform101XPToken;
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null || (platform101XPToken = (Platform101XPToken) pair.getFirst()) == null) {
            return false;
        }
        return (platform101XPToken.isDeviceToken() && !isDeviceTokenEnabled()) || !platform101XPToken.isDeviceToken();
    }

    public final void saveCurrentToken() {
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null) {
            return;
        }
        this.settings.setString(KEY_ACCESS_TOKEN, serializeToken(pair));
    }

    public final boolean currentTokenHasProvider() {
        Platform101XPToken platform101XPToken;
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null || (platform101XPToken = (Platform101XPToken) pair.getFirst()) == null) {
            return false;
        }
        return platform101XPToken.hasProvider();
    }

    public final void updateCurrentToken(String str) {
        Intrinsics.checkNotNullParameter(str, "tokenString");
        this.tokenPlatform = deserializeToken(str);
    }

    public final void updateCurrentToken(Pair<Platform101XPToken, Platform101XPTokenIds> pair) {
        Intrinsics.checkNotNullParameter(pair, "tokenPlatform");
        this.tokenPlatform = pair;
    }

    public final void refreshCurrentToken(String str) {
        Intrinsics.checkNotNullParameter(str, "tokenString");
        Platform101XPToken platform101XPToken = (Platform101XPToken) deserializeToken(str).getFirst();
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        this.tokenPlatform = new Pair<>(platform101XPToken, pair == null ? null : (Platform101XPTokenIds) pair.getSecond());
    }

    public final boolean isGuestCurrentToken() {
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null) {
            return false;
        }
        Platform101XPToken platform101XPToken = (Platform101XPToken) pair.getFirst();
        return Intrinsics.areEqual(platform101XPToken == null ? null : Boolean.valueOf(platform101XPToken.isGuest()), true);
    }

    public final void tokenLogout(Platform101XPHttpRequest.HttpRequestListener httpRequestListener) {
        Intrinsics.checkNotNullParameter(httpRequestListener, "requestListener");
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        Platform101XPToken platform101XPToken = pair == null ? null : (Platform101XPToken) pair.getFirst();
        if (platform101XPToken != null && platform101XPToken.getAccessToken().getId() != null) {
            Platform101XPApi.auth().logout(platform101XPToken).execute(httpRequestListener);
        }
        this.tokenPlatform = null;
        this.settings.setString(KEY_ACCESS_TOKEN, null);
    }

    public final Platform101XPToken getCurrentToken() {
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null) {
            return null;
        }
        return (Platform101XPToken) pair.getFirst();
    }

    public final long getCurrentUserGameId() {
        Platform101XPTokenIds platform101XPTokenIds;
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null || (platform101XPTokenIds = (Platform101XPTokenIds) pair.getSecond()) == null) {
            return 0L;
        }
        return platform101XPTokenIds.getUserGameId();
    }

    public final long getCurrentAccountId() {
        Platform101XPTokenIds platform101XPTokenIds;
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null || (platform101XPTokenIds = (Platform101XPTokenIds) pair.getSecond()) == null) {
            return 0L;
        }
        return platform101XPTokenIds.getAccountId();
    }

    public final long getMobileId() {
        Platform101XPTokenIds platform101XPTokenIds;
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        if (pair == null || (platform101XPTokenIds = (Platform101XPTokenIds) pair.getSecond()) == null) {
            return 0L;
        }
        return platform101XPTokenIds.getMobileId();
    }

    public final String getAccessTokenValue() {
        Platform101XPToken$Token accessToken;
        Platform101XPToken currentToken = getCurrentToken();
        if (currentToken == null || (accessToken = currentToken.getAccessToken()) == null) {
            return null;
        }
        return accessToken.getId();
    }

    public final boolean isNeedShowAuthorizeWarning(String str, Pair<Platform101XPToken, Platform101XPTokenIds> pair) {
        Platform101XPTokenIds platform101XPTokenIds;
        Platform101XPToken platform101XPToken;
        Intrinsics.checkNotNullParameter(str, "snProvider");
        Intrinsics.checkNotNullParameter(pair, "currentTokenPlatformPair");
        Platform101XPToken platform101XPToken2 = (Platform101XPToken) pair.getFirst();
        Long l = null;
        if (Intrinsics.areEqual(platform101XPToken2 == null ? null : platform101XPToken2.getProvider(), str)) {
            Pair<Platform101XPToken, Platform101XPTokenIds> pair2 = this.tokenPlatform;
            String provider = (pair2 == null || (platform101XPToken = (Platform101XPToken) pair2.getFirst()) == null) ? null : platform101XPToken.getProvider();
            Platform101XPToken platform101XPToken3 = (Platform101XPToken) pair.getFirst();
            if (Intrinsics.areEqual(provider, platform101XPToken3 == null ? null : platform101XPToken3.getProvider())) {
                Pair<Platform101XPToken, Platform101XPTokenIds> pair3 = this.tokenPlatform;
                Long valueOf = (pair3 == null || (platform101XPTokenIds = (Platform101XPTokenIds) pair3.getSecond()) == null) ? null : Long.valueOf(platform101XPTokenIds.getUserGameId());
                Platform101XPTokenIds platform101XPTokenIds2 = (Platform101XPTokenIds) pair.getSecond();
                if (platform101XPTokenIds2 != null) {
                    l = Long.valueOf(platform101XPTokenIds2.getUserGameId());
                }
                if (Intrinsics.areEqual(valueOf, l)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isDeviceTokenEnabled() {
        return this.configManager.getBool(Platform101XPConfigKeyHolder.deviceTokenEnabled, false) || this.configManager.getBool(Platform101XPConfigKeyHolder.webUiEnabled, false);
    }

    private final void updateGameId(String str) {
        if (str == null) {
            return;
        }
        if (!(str.length() > 0)) {
            return;
        }
        long optLong = new JSONObject(str).optLong(TapjoyAuctionFlags.AUCTION_ID);
        if (optLong == 0) {
            return;
        }
        Log.d("101XP SDK", Intrinsics.stringPlus("Update userGameId, new id: ", Long.valueOf(optLong)));
        Pair<Platform101XPToken, Platform101XPTokenIds> pair = this.tokenPlatform;
        Platform101XPTokenIds platform101XPTokenIds = pair == null ? null : (Platform101XPTokenIds) pair.getSecond();
        if (platform101XPTokenIds == null) {
            return;
        }
        platform101XPTokenIds.setUserGameId(optLong);
    }
}
