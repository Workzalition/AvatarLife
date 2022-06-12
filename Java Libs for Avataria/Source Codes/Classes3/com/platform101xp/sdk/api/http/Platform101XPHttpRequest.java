package com.platform101xp.sdk.api.http;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.annotations.Expose;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.Platform101XPError;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.model.Platform101XPModel;
import com.platform101xp.sdk.api.parser.Platform101XPParser;
import com.platform101xp.sdk.internal.Platform101XPSettings;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPHttpRequest {
    private static final String NETWORK_CONNECTION = "network";
    private static final Executor executor = Executors.newCachedThreadPool();
    @Expose
    private Platform101XPUrlConnection connection;
    @Expose
    private final Platform101XPParameters parameters;
    @Expose
    protected final Platform101XPParser parser;

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public enum HttpMethod {
        POST,
        GET,
        DELETE
    }

    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface HttpRequestListener {
        void onResult(Platform101XPModel platform101XPModel, Platform101XPError platform101XPError);
    }

    public Platform101XPHttpRequest(String str, Platform101XPParameters platform101XPParameters, HttpMethod httpMethod, Class<? extends Platform101XPModel> cls) {
        this(new Platform101XPUrlConnection(str, platform101XPParameters, httpMethod), cls);
    }

    public Platform101XPHttpRequest(Platform101XPUrlConnection platform101XPUrlConnection, Class<? extends Platform101XPModel> cls) {
        this.connection = platform101XPUrlConnection;
        this.parser = new Platform101XPParser(cls);
        this.parameters = platform101XPUrlConnection.getParameters();
    }

    public void execute(final HttpRequestListener httpRequestListener) {
        executor.execute(new Runnable() { // from class: com.platform101xp.sdk.api.http.Platform101XPHttpRequest.1
            @Override // java.lang.Runnable
            public void run() {
                Platform101XPError platform101XPError;
                Throwable th;
                Platform101XPModel platform101XPModel;
                Platform101XPError platform101XPError2 = null;
                try {
                    if (!Platform101XPHttpRequest.this.checkNetworkConnection()) {
                        Platform101XPHttpRequest.this.onResult(httpRequestListener, null, new Platform101XPError(Platform101XPError.ErrorType.ERROR_CONNECTION));
                        return;
                    }
                    try {
                        JSONObject jsonObject = Platform101XPHttpRequest.this.connection.getJsonObject();
                        if (jsonObject == null) {
                            if (Platform101XPHttpRequest.this.connection.isErrorCode(Platform101XPHttpRequest.this.connection.getConnectionResponseCode())) {
                                platform101XPError2 = new Platform101XPError(new Exception("Response JSONObject is null."));
                                platform101XPModel = null;
                            } else {
                                platform101XPModel = null;
                            }
                        } else {
                            if (!Platform101XPHttpRequest.this.connection.isErrorCode(Platform101XPHttpRequest.this.connection.getConnectionResponseCode()) && !Platform101XPHttpRequest.this.parser.isError(jsonObject)) {
                                platform101XPModel = Platform101XPHttpRequest.this.parser.createModel(jsonObject);
                            }
                            Platform101XPError platform101XPError3 = new Platform101XPError(jsonObject);
                            platform101XPModel = null;
                            platform101XPError2 = platform101XPError3;
                        }
                        if (platform101XPError2 != null) {
                            Platform101XP.crashLog("101XP SDK", "http fail: " + platform101XPError2.toString());
                        }
                        Platform101XPHttpRequest.this.onResult(httpRequestListener, platform101XPModel, platform101XPError2);
                    } catch (Exception e) {
                        platform101XPError = new Platform101XPError(e);
                        try {
                            e.printStackTrace();
                            Platform101XP.crashLog("101XP SDK", "http fail: " + platform101XPError.toString());
                            Platform101XPHttpRequest.this.onResult(httpRequestListener, null, platform101XPError);
                        } catch (Throwable th2) {
                            th = th2;
                            if (platform101XPError != null) {
                                Platform101XP.crashLog("101XP SDK", "http fail: " + platform101XPError.toString());
                            }
                            Platform101XPHttpRequest.this.onResult(httpRequestListener, null, platform101XPError);
                            Platform101XPHttpRequest.this.connection.disconnect();
                            throw th;
                        }
                    }
                    Platform101XPHttpRequest.this.connection.disconnect();
                } catch (Throwable th3) {
                    th = th3;
                    platform101XPError = null;
                }
            }
        });
    }

    public void onResult(final HttpRequestListener httpRequestListener, final Platform101XPModel platform101XPModel, final Platform101XPError platform101XPError) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.platform101xp.sdk.api.http.Platform101XPHttpRequest.2
            @Override // java.lang.Runnable
            public void run() {
                httpRequestListener.onResult(platform101XPModel, platform101XPError);
            }
        });
    }

    public Platform101XPParameters getParameters() {
        return this.parameters;
    }

    public boolean checkNetworkConnection() {
        if (Platform101XP.getCurrentActivity() == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Platform101XP.getCurrentActivity().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            Platform101XPSettings.saveBoolean(NETWORK_CONNECTION, true);
            return true;
        }
        Platform101XPSettings.saveBoolean(NETWORK_CONNECTION, false);
        return false;
    }
}
