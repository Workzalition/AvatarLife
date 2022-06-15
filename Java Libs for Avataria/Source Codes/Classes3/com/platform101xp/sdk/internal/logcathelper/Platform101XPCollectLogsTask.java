package com.platform101xp.sdk.internal.logcathelper;

import android.os.AsyncTask;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TJAdUnitConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPCollectLogsTask.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142*\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ7\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u00020\u00122\u001a\u0010\u0013\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lkotlin/Pair;", "", "", "listener", "Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask$OnSendLogsListener;", "appFilesHelper", "Lcom/platform101xp/sdk/internal/logcathelper/AppFilesHelper;", "(Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask$OnSendLogsListener;Lcom/platform101xp/sdk/internal/logcathelper/AppFilesHelper;)V", "getListener", "()Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask$OnSendLogsListener;", "doInBackground", TJAdUnitConstants.String.BEACON_PARAMS, "([Ljava/lang/Void;)Lkotlin/Pair;", "onPostExecute", "", IronSourceConstants.EVENTS_RESULT, "Companion", "OnSendLogsListener", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPCollectLogsTask extends AsyncTask<Void, Integer, Pair<? extends String[], ? extends String>> {
    public static final Companion Companion = new Companion(null);
    public static final String LOGS_ZIP_FILE_NAME = "logs.zip";
    private final AppFilesHelper appFilesHelper;
    private final OnSendLogsListener listener;

    /* compiled from: Platform101XPCollectLogsTask.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask$OnSendLogsListener;", "", "onShowSendLogs", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface OnSendLogsListener {
        void onShowSendLogs();
    }

    public Platform101XPCollectLogsTask(OnSendLogsListener onSendLogsListener, AppFilesHelper appFilesHelper) {
        Intrinsics.checkNotNullParameter(onSendLogsListener, "listener");
        Intrinsics.checkNotNullParameter(appFilesHelper, "appFilesHelper");
        this.listener = onSendLogsListener;
        this.appFilesHelper = appFilesHelper;
    }

    public final OnSendLogsListener getListener() {
        return this.listener;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Pair<? extends String[], ? extends String> pair) {
        onPostExecute2((Pair<String[], String>) pair);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<String[], String> doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, TJAdUnitConstants.String.BEACON_PARAMS);
        String constructAppInfoFile = this.appFilesHelper.constructAppInfoFile();
        this.appFilesHelper.collectFiles(constructAppInfoFile, AppFilesHelper.APP_INFO_FILE_NAME, LOGS_ZIP_FILE_NAME);
        return new Pair<>(new String[]{LOGS_ZIP_FILE_NAME}, constructAppInfoFile);
    }

    /* renamed from: onPostExecute  reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Pair<String[], String> pair) {
        super.onPostExecute((Platform101XPCollectLogsTask) pair);
        this.listener.onShowSendLogs();
    }

    /* compiled from: Platform101XPCollectLogsTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask$Companion;", "", "()V", "LOGS_ZIP_FILE_NAME", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
