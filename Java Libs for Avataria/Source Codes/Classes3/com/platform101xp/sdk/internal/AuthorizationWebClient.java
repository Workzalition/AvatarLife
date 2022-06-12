package com.platform101xp.sdk.internal;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.platform101xp.sdk.AuthorizationActivity;
import com.platform101xp.sdk.R;
import com.platform101xp.sdk.api.Platform101XPParameters;
import com.platform101xp.sdk.internal.configs.Platform101XPConfigData;
import com.platform101xp.sdk.internal.token.Platform101XPTokenManager;
import com.tapjoy.TapjoyAuctionFlags;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class AuthorizationWebClient extends WebViewClient {
    public static final String AUTHORIZATION_URL;
    public static final String REDIRECT_URL;
    private AuthorizationActivity activity;
    private ProgressDialog progress;

    static {
        AUTHORIZATION_URL = Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? "https://mobile-auth-dev.101xp.com/" : "https://mobile-auth.101xp.com/";
        REDIRECT_URL = Platform101XPSettings.loadBoolean(Platform101XPConfigData.DEV_MODE_KEY, false) ? "https://mobile-auth-dev.101xp.com/blank" : "https://mobile-auth.101xp.com/blank";
    }

    public AuthorizationWebClient(AuthorizationActivity authorizationActivity) {
        this.activity = authorizationActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.contains("mobile.101xp.com")) {
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        return processUrl(str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        processUrl(str);
        ProgressDialog progressDialog = new ProgressDialog(this.activity);
        this.progress = progressDialog;
        progressDialog.setMessage(this.activity.getString(R.string.loading));
        AuthorizationActivity authorizationActivity = this.activity;
        if (authorizationActivity == null || authorizationActivity.isFinishing() || this.activity.isFinishing()) {
            return;
        }
        this.progress.show();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        dismissProgress();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        handleError(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        handleError(webResourceError.getDescription().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        handleError("SSL error: " + sslError.getPrimaryError());
    }

    private void handleError(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setMessage(str);
        builder.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.platform101xp.sdk.internal.AuthorizationWebClient.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AuthorizationWebClient.this.activity.loadPage();
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.platform101xp.sdk.internal.AuthorizationWebClient.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AuthorizationWebClient.this.activity.finish();
            }
        });
        try {
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dismissProgress();
    }

    private void dismissProgress() {
        ProgressDialog progressDialog;
        if (this.activity.isFinishing() || this.activity.isFinishing() || (progressDialog = this.progress) == null || !progressDialog.isShowing()) {
            return;
        }
        this.progress.dismiss();
    }

    private boolean processUrl(String str) {
        if (!str.startsWith(REDIRECT_URL)) {
            return true;
        }
        try {
            String extraToken = getExtraToken(new Platform101XPParameters(str.substring(str.indexOf("?") + 1)));
            Intent intent = new Intent();
            intent.putExtra(AuthorizationActivity.EXTRA_TOKEN, extraToken);
            this.activity.setResult(-1, intent);
            this.activity.finish();
            return true;
        } catch (Exception e) {
            Log.d("101XP SDK", "Deserialize Token Exception: " + e.getMessage());
            return false;
        }
    }

    private String getExtraToken(Platform101XPParameters platform101XPParameters) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String[] strArr = {Platform101XPTokenManager.KEY_ACCESS_TOKEN, "expires", "refresh_token", "refresh_expires", TapjoyAuctionFlags.AUCTION_ID, "user_game_id", "social_id", "mob_id", "provider_exists", IronSourceConstants.EVENTS_PROVIDER};
        for (int i = 0; i < 10; i++) {
            String str = strArr[i];
            if (platform101XPParameters.containsParameter(str)) {
                jSONObject.put(str, platform101XPParameters.getParameter(str));
            }
        }
        return jSONObject.toString();
    }
}
