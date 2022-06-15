package com.platform101xp.sdk.internal.services;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPAndroidMessagingService extends FirebaseMessagingService {
    Platform101XPMessagingService messagingService = new Platform101XPMessagingService();

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("101XP SDK", "Got remote message from: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d("101XP SDK", "Message data payload: " + remoteMessage.getData());
        }
        if (remoteMessage.getNotification() != null) {
            Log.d("101XP SDK", "Message Notification Body: " + remoteMessage.getNotification().getBody());
            this.messagingService.getMessage(remoteMessage.getNotification().getBody(), remoteMessage.getSentTime(), remoteMessage.getMessageId());
        }
    }
}
