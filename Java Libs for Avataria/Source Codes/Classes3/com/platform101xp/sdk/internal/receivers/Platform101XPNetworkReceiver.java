package com.platform101xp.sdk.internal.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPRequestsKeeper;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPNetworkReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                Log.d("101XP SDK", "Network is available");
                executeKeptRequests();
            } else if (activeNetworkInfo == null || activeNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.DISCONNECTED) {
            } else {
                Log.d("101XP SDK", "Network is disconnected");
            }
        }
    }

    private void executeKeptRequests() {
        Platform101XPRequestsKeeper.getInstance().executeKeptRequests();
    }
}
