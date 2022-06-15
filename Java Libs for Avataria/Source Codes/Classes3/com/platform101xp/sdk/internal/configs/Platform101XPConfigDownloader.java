package com.platform101xp.sdk.internal.configs;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import com.platform101xp.sdk.api.http.Platform101XPUrlConnection;
import com.platform101xp.sdk.internal.Platform101XPMetaManager;
import com.tapjoy.TJAdUnitConstants;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: Platform101XPConfigDownloader.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u0005@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader;", "", "appContext", "Landroid/content/Context;", "metaManager", "Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;", "(Landroid/content/Context;Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;)V", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "configName", "", "getMetaManager", "()Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;", "setMetaManager", "(Lcom/platform101xp/sdk/internal/Platform101XPMetaManager;)V", "downloadConfigFromNet", "", "listener", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;", "Companion", "DownloadResultListener", "GetConfigTask", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPConfigDownloader {
    private static final int CONFIG_ERROR_CODE = 5112;
    private static final String CONFIG_ERRROR_NULL_MESSAGE = "JsonConfig is null";
    private static final String CONFIG_URL = "http://xp-scg-mobilsdk.akamaized.net/config/%s_android_params.json";
    public static final Companion Companion = new Companion(null);
    private static final String META_APP_CONFIG_NAME_KEY = "com.platform101xp.sdk.app_config_name";
    private Context appContext;
    private final String configName;
    private Platform101XPMetaManager metaManager;

    /* compiled from: Platform101XPConfigDownloader.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;", "", "onConfigDownloadResult", "", "jsonConfig", "Lorg/json/JSONObject;", "error", "Lcom/platform101xp/sdk/Platform101XPError;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface DownloadResultListener {
        void onConfigDownloadResult(JSONObject jSONObject, Platform101XPError platform101XPError);
    }

    /* compiled from: Platform101XPConfigDownloader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$Companion;", "", "()V", "CONFIG_ERROR_CODE", "", "CONFIG_ERRROR_NULL_MESSAGE", "", "CONFIG_URL", "META_APP_CONFIG_NAME_KEY", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public Platform101XPConfigDownloader(Context context, Platform101XPMetaManager platform101XPMetaManager) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(platform101XPMetaManager, "metaManager");
        this.appContext = context;
        this.metaManager = platform101XPMetaManager;
        this.configName = platform101XPMetaManager.getMetaString(META_APP_CONFIG_NAME_KEY, "");
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final Platform101XPMetaManager getMetaManager() {
        return this.metaManager;
    }

    @Inject
    public final void setAppContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    @Inject
    public final void setMetaManager(Platform101XPMetaManager platform101XPMetaManager) {
        Intrinsics.checkNotNullParameter(platform101XPMetaManager, "<set-?>");
        this.metaManager = platform101XPMetaManager;
    }

    public final void downloadConfigFromNet(DownloadResultListener downloadResultListener) {
        Intrinsics.checkNotNullParameter(downloadResultListener, "listener");
        if (this.configName.length() > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(CONFIG_URL, Arrays.copyOf(new Object[]{this.configName}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            new GetConfigTask(downloadResultListener, new Platform101XPUrlConnection(format, null, Platform101XPHttpRequest.HttpMethod.GET)).execute(new Unit[0]);
            return;
        }
        downloadResultListener.onConfigDownloadResult(null, new Platform101XPError(new Exception("Config name is empty, please check strings.xml of AndroidManifest metadata!")));
    }

    /* compiled from: Platform101XPConfigDownloader.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0002\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\r\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$GetConfigTask;", "Landroid/os/AsyncTask;", "", "Lorg/json/JSONObject;", "listener", "Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;", "configConnection", "Lcom/platform101xp/sdk/api/http/Platform101XPUrlConnection;", "(Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;Lcom/platform101xp/sdk/api/http/Platform101XPUrlConnection;)V", "getConfigConnection", "()Lcom/platform101xp/sdk/api/http/Platform101XPUrlConnection;", "getListener", "()Lcom/platform101xp/sdk/internal/configs/Platform101XPConfigDownloader$DownloadResultListener;", "doInBackground", TJAdUnitConstants.String.BEACON_PARAMS, "", "([Lkotlin/Unit;)Lorg/json/JSONObject;", "onPostExecute", IronSourceConstants.EVENTS_RESULT, "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    private static final class GetConfigTask extends AsyncTask<Unit, Unit, JSONObject> {
        private final Platform101XPUrlConnection configConnection;
        private final DownloadResultListener listener;

        public GetConfigTask(DownloadResultListener downloadResultListener, Platform101XPUrlConnection platform101XPUrlConnection) {
            Intrinsics.checkNotNullParameter(downloadResultListener, "listener");
            Intrinsics.checkNotNullParameter(platform101XPUrlConnection, "configConnection");
            this.listener = downloadResultListener;
            this.configConnection = platform101XPUrlConnection;
        }

        public final Platform101XPUrlConnection getConfigConnection() {
            return this.configConnection;
        }

        public final DownloadResultListener getListener() {
            return this.listener;
        }

        public JSONObject doInBackground(Unit... unitArr) {
            JSONObject jSONObject;
            SocketTimeoutException e;
            Exception e2;
            Intrinsics.checkNotNullParameter(unitArr, TJAdUnitConstants.String.BEACON_PARAMS);
            try {
                jSONObject = this.configConnection.getJsonObject();
            } catch (SocketTimeoutException e3) {
                e = e3;
                jSONObject = null;
            } catch (Exception e4) {
                e2 = e4;
                jSONObject = null;
            }
            try {
                Log.d("101XP SDK", Intrinsics.stringPlus("Config json ", jSONObject));
            } catch (SocketTimeoutException e5) {
                e = e5;
                Log.d("101XP SDK", "Config json timeout.");
                this.listener.onConfigDownloadResult(null, new Platform101XPError(e));
                return jSONObject;
            } catch (Exception e6) {
                e2 = e6;
                this.listener.onConfigDownloadResult(null, new Platform101XPError(e2));
                return jSONObject;
            }
            return jSONObject;
        }

        public void onPostExecute(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.listener.onConfigDownloadResult(jSONObject, null);
            } else {
                this.listener.onConfigDownloadResult(null, new Platform101XPError((int) Platform101XPConfigDownloader.CONFIG_ERROR_CODE, Platform101XPConfigDownloader.CONFIG_ERRROR_NULL_MESSAGE, Platform101XPError.ErrorType.ERROR_API));
            }
        }
    }
}
