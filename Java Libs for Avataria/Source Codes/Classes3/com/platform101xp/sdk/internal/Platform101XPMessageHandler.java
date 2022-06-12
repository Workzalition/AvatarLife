package com.platform101xp.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import com.platform101xp.sdk.Platform101XPListener;
import com.platform101xp.sdk.Platform101XPMessage;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPMessageHandler {
    private static Platform101XPMessageHandler instance;
    private Platform101XPListener platform101XPListener;

    private Platform101XPMessageHandler() {
    }

    public static Platform101XPMessageHandler getInstance() {
        if (instance == null) {
            instance = new Platform101XPMessageHandler();
        }
        return instance;
    }

    public void setPlatform101XPListener(Platform101XPListener platform101XPListener) {
        this.platform101XPListener = platform101XPListener;
    }

    public void messageReceived(final Platform101XPMessage platform101XPMessage) {
        if (this.platform101XPListener == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.platform101xp.sdk.internal.Platform101XPMessageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                Platform101XPMessageHandler.this.platform101XPListener.onMessageReceived(platform101XPMessage);
            }
        });
    }
}
