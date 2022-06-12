package com.platform101xp.sdk.api.http;

import android.util.Log;
import com.google.gson.annotations.Expose;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.HttpDelete;
import com.platform101xp.sdk.Platform101XP;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.api.http.Platform101XPHttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPUrlConnection {
    private static final int CONNECTION_TIMEOUT = 3000;
    public static final String CONTENT_TYPE_FROM_JSON = "application/json";
    public static final String CONTENT_TYPE_FROM_URL = "application/x-www-form-urlencoded";
    @Expose
    private String address;
    @Expose
    private Platform101XPHttpRequest.HttpMethod method;
    @Expose
    private Platform101XPParameters parameters;
    private HttpURLConnection urlConnection = null;
    @Expose
    private String contentTypeValue = CONTENT_TYPE_FROM_URL;

    public boolean isErrorCode(int i) {
        return i >= 300;
    }

    public Platform101XPUrlConnection(String str, Platform101XPParameters platform101XPParameters, Platform101XPHttpRequest.HttpMethod httpMethod) {
        this.address = str;
        this.parameters = platform101XPParameters;
        this.method = httpMethod;
    }

    /* renamed from: com.platform101xp.sdk.api.http.Platform101XPUrlConnection$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$platform101xp$sdk$api$http$Platform101XPHttpRequest$HttpMethod;

        static {
            int[] iArr = new int[Platform101XPHttpRequest.HttpMethod.values().length];
            $SwitchMap$com$platform101xp$sdk$api$http$Platform101XPHttpRequest$HttpMethod = iArr;
            try {
                iArr[Platform101XPHttpRequest.HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$platform101xp$sdk$api$http$Platform101XPHttpRequest$HttpMethod[Platform101XPHttpRequest.HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$platform101xp$sdk$api$http$Platform101XPHttpRequest$HttpMethod[Platform101XPHttpRequest.HttpMethod.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void getUrlConnection() throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$platform101xp$sdk$api$http$Platform101XPHttpRequest$HttpMethod[this.method.ordinal()];
        if (i == 1) {
            if (this.parameters != null) {
                this.address += "?" + this.parameters.toString();
            }
            this.urlConnection = createGetRequest();
            Log.d("101XP SDK", "http: get: " + this.urlConnection.getURL());
        } else if (i == 2) {
            this.urlConnection = createPostRequest();
            Log.d("101XP SDK", "http: post: " + this.urlConnection.getURL() + " parameters: " + this.parameters.toString());
        } else if (i == 3) {
            if (this.parameters != null) {
                this.address += "?" + this.parameters.toString();
            }
            this.urlConnection = createDeleteRequest();
            Log.d("101XP SDK", "http: delete: " + this.urlConnection.getURL());
        }
        this.urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
        this.urlConnection.setReadTimeout(CONNECTION_TIMEOUT);
    }

    private InputStream getConnectionInputStream() throws IOException {
        getUrlConnection();
        int responseCode = this.urlConnection.getResponseCode();
        Log.d("101XP SDK", "Response Code : " + responseCode);
        if (responseCode >= 400) {
            Platform101XP.crashLog("101XP SDK", "Request error: " + this.urlConnection.getURL() + "response code: " + responseCode);
        }
        return (responseCode == 200 || responseCode == 201) ? this.urlConnection.getInputStream() : this.urlConnection.getErrorStream();
    }

    public int getConnectionResponseCode() throws IOException {
        return this.urlConnection.getResponseCode();
    }

    public JSONObject getJsonObject() throws IOException, NullPointerException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream connectionInputStream = getConnectionInputStream();
        byte[] bArr = new byte[IronSourceError.ERROR_RV_LOAD_FAILED_NO_CANDIDATES];
        if (getConnectionResponseCode() != 204) {
            while (true) {
                int read = connectionInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            Log.d("101XP SDK", "http: recieved " + byteArrayOutputStream.size());
            if (getConnectionResponseCode() != 201) {
                try {
                    return bytesToJSONObject(byteArrayOutputStream.toByteArray());
                } catch (JSONException e) {
                    Platform101XP.crashLog("101XP SDK", e.getMessage());
                    Log.d("101XP SDK", "Can't create JsonObject: " + e.getMessage());
                }
            }
        }
        return null;
    }

    private JSONObject bytesToJSONObject(byte[] bArr) throws UnsupportedEncodingException, JSONException {
        String str = new String(bArr, AsyncHttpResponseHandler.DEFAULT_CHARSET);
        if (!str.startsWith("{") && !str.endsWith("}")) {
            str = "{data:" + str + "}";
        }
        return new JSONObject(str);
    }

    private HttpURLConnection createPostRequest() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.address).openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", this.contentTypeValue);
        addRequestProperties(httpURLConnection);
        if (this.parameters != null) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            outputStreamWriter.write(this.parameters.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }
        return httpURLConnection;
    }

    private HttpURLConnection createGetRequest() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.address).openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        addRequestProperties(httpURLConnection);
        return httpURLConnection;
    }

    private HttpURLConnection createDeleteRequest() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.address).openConnection();
        httpURLConnection.setRequestMethod(HttpDelete.METHOD_NAME);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", CONTENT_TYPE_FROM_URL);
        addRequestProperties(httpURLConnection);
        return httpURLConnection;
    }

    private void addRequestProperties(HttpURLConnection httpURLConnection) {
        httpURLConnection.addRequestProperty("SDK-Version", "a1.48.14");
        if (this.address.startsWith("https")) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                sSLContext.init(null, null, new SecureRandom());
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (Exception e) {
                Log.d("101XP SDK", "UrlConnection SSL Error:" + e);
                Platform101XP.sendCrashReport(e);
            }
        }
    }

    public void disconnect() {
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.d("101XP SDK", e.getMessage());
            }
        }
    }

    public void setContentTypeValue(String str) {
        this.contentTypeValue = str;
    }

    public Platform101XPParameters getParameters() {
        return this.parameters;
    }
}
