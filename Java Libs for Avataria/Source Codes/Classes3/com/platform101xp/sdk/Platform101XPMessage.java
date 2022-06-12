package com.platform101xp.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public class Platform101XPMessage implements Parcelable {
    public static final Parcelable.Creator<Platform101XPMessage> CREATOR = new Parcelable.Creator<Platform101XPMessage>() { // from class: com.platform101xp.sdk.Platform101XPMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Platform101XPMessage createFromParcel(Parcel parcel) {
            return new Platform101XPMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Platform101XPMessage[] newArray(int i) {
            return new Platform101XPMessage[i];
        }
    };
    public static final String REMOTE_MESSAGE_EXTRA = "com.platform101xp.sdk.remote_message_extra_key";
    private String messageBody;
    private String messageId;
    private long messageSentTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Platform101XPMessage(RemoteMessage remoteMessage) {
        this.messageId = remoteMessage.getMessageId();
        this.messageSentTime = remoteMessage.getSentTime();
        this.messageBody = remoteMessage.getNotification().getBody();
    }

    public Platform101XPMessage(String str, long j, String str2) {
        this.messageId = str;
        this.messageSentTime = j;
        this.messageBody = str2;
    }

    protected Platform101XPMessage(Parcel parcel) {
        this.messageId = parcel.readString();
        this.messageSentTime = parcel.readLong();
        this.messageBody = parcel.readString();
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public long getMessageSentTime() {
        return this.messageSentTime;
    }

    public String toString() {
        return "Id: " + this.messageId + " SentTime: " + this.messageSentTime + " Body: " + this.messageBody;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.messageId);
        parcel.writeLong(this.messageSentTime);
        parcel.writeString(this.messageBody);
    }
}
