package com.xp101;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.platform101xp.sdk.Platform101XP;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes4.dex */
public class NotificationPublisher extends BroadcastReceiver {
    public static final String CHANNEL_ID = "com.avataria.chanel_id";
    public static final String NOTIFICATION_ID = "notification-id";
    public static final String NOTIFICATION_MESSAGE = "notification_message";
    public static final String NOTIFICATION_TITLE = "notification_title";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            String stringExtra = intent.getStringExtra(NOTIFICATION_MESSAGE);
            String stringExtra2 = intent.getStringExtra(NOTIFICATION_TITLE);
            if ((stringExtra != null && !stringExtra.isEmpty()) || (stringExtra2 != null && !stringExtra2.isEmpty())) {
                from.notify(intent.getIntExtra(NOTIFICATION_ID, 0), getNotification(stringExtra, stringExtra2, context));
            }
        } catch (Exception e) {
            Log.d("AVA", "NotificationPublisher onReceive", e);
        }
    }

    public static void createLocalNotification(String str, String str2, int i, int i2) {
        try {
            Activity currentActivity = Platform101XP.getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            scheduleNotification(str, str2, i, i2, currentActivity);
        } catch (Exception e) {
            Log.d("AVA", "NotificationPublisher createLocalNotification", e);
        }
    }

    public static void cancelLocalNotification(int i) {
        try {
            Activity currentActivity = Platform101XP.getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            ((AlarmManager) currentActivity.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(currentActivity, i, new Intent(currentActivity, NotificationPublisher.class), 134217728));
        } catch (Exception e) {
            Log.d("AVA", "NotificationPublisher cancelLocalNotification", e);
        }
    }

    private static void scheduleNotification(String str, String str2, int i, int i2, Context context) {
        Intent intent = new Intent(context, NotificationPublisher.class);
        intent.putExtra(NOTIFICATION_ID, i2);
        intent.putExtra(NOTIFICATION_MESSAGE, str);
        intent.putExtra(NOTIFICATION_TITLE, str2);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent, 134217728);
        ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + (i * 1000), broadcast);
    }

    private Notification getNotification(String str, String str2, Context context) {
        PendingIntent pendingIntent;
        Intent intent = new Intent(context, AvatariaActivity.class);
        intent.setFlags(603979776);
        if (Build.VERSION.SDK_INT >= 23) {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 67108864);
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        }
        return new NotificationCompat.Builder(context, CHANNEL_ID).setContentIntent(pendingIntent).setSmallIcon((int) R.mipmap.ic_launcher).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).setContentTitle(str2).setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setPriority(0).setVisibility(1).setAutoCancel(true).build();
    }

    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Avataria Chanel", 3);
            notificationChannel.setDescription("Avataria Chanel");
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }
}
