package com.platform101xp.sdk.internal.logcathelper;

import android.content.Context;
import android.util.Log;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Platform101XPLogcatHelper.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPLogcatHelper;", "", "context", "Landroid/content/Context;", "collectLogsTask", "Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask;", "(Landroid/content/Context;Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask;)V", "getCollectLogsTask", "()Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPCollectLogsTask;", "getContext", "()Landroid/content/Context;", "logcatRunnable", "Ljava/lang/Runnable;", "mLogCheckThread", "Ljava/lang/Thread;", "packageFilter", "Ljava/util/concurrent/atomic/AtomicReference;", "", "procArray", "", "[Ljava/lang/String;", "saveSystemLog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getLogFileStream", "Ljava/io/FileOutputStream;", TJAdUnitConstants.String.VIDEO_START, "", "filter", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPLogcatHelper {
    public static final int BUF_SIZE = 10240;
    public static final Companion Companion = new Companion(null);
    private final Platform101XPCollectLogsTask collectLogsTask;
    private final Context context;
    private Thread mLogCheckThread;
    private final String[] procArray = {"logcat", "-v", LogOutputFormat.THREADTIME.getOutputFormat()};
    private final AtomicBoolean saveSystemLog = new AtomicBoolean(false);
    private final AtomicReference<String> packageFilter = new AtomicReference<>();
    private final Runnable logcatRunnable = new Runnable() { // from class: com.platform101xp.sdk.internal.logcathelper.Platform101XPLogcatHelper$logcatRunnable$1
        private final byte[] buf = new byte[Platform101XPLogcatHelper.BUF_SIZE];
        private Process logcatProc;
        private FileOutputStream mLogFileStream;
        private InputStream mLogInputStream;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            String[] strArr;
            Runtime runtime = Runtime.getRuntime();
            strArr = Platform101XPLogcatHelper.this.procArray;
            Process exec = runtime.exec(strArr);
            Intrinsics.checkNotNullExpressionValue(exec, "getRuntime().exec(procArray)");
            this.logcatProc = exec;
            InputStream inputStream = exec.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "logcatProc.inputStream");
            this.mLogInputStream = inputStream;
            this.mLogFileStream = Platform101XPLogcatHelper.this.getLogFileStream();
        }

        @Override // java.lang.Runnable
        public void run() {
            InputStream inputStream = this.mLogInputStream;
            Platform101XPLogcatHelper platform101XPLogcatHelper = Platform101XPLogcatHelper.this;
            try {
                InputStream inputStream2 = inputStream;
                FileOutputStream fileOutputStream = this.mLogFileStream;
                FileOutputStream fileOutputStream2 = fileOutputStream;
                Log.d("101XP SDK", "start save logs");
                while (true) {
                    byte[] bArr = this.buf;
                    Charset defaultCharset = Charset.defaultCharset();
                    Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
                    String str = new String(bArr, defaultCharset);
                    int read = inputStream2.read(this.buf);
                    th = null;
                    if (read <= 0 || StringsKt.contains$default(str, "start save logs", false, 2, th)) {
                        break;
                    }
                    fileOutputStream2.write(this.buf, 0, read);
                }
                platform101XPLogcatHelper.getCollectLogsTask().execute(new Void[0]);
                fileOutputStream2.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, th);
                this.logcatProc.destroy();
                Unit unit2 = Unit.INSTANCE;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
    };

    public Platform101XPLogcatHelper(Context context, Platform101XPCollectLogsTask platform101XPCollectLogsTask) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(platform101XPCollectLogsTask, "collectLogsTask");
        this.context = context;
        this.collectLogsTask = platform101XPCollectLogsTask;
    }

    public final Platform101XPCollectLogsTask getCollectLogsTask() {
        return this.collectLogsTask;
    }

    public final Context getContext() {
        return this.context;
    }

    /* compiled from: Platform101XPLogcatHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPLogcatHelper$Companion;", "", "()V", "BUF_SIZE", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void start(String str) {
        this.packageFilter.set(str);
        this.saveSystemLog.set(true);
        if (this.mLogCheckThread == null) {
            Thread thread = new Thread(this.logcatRunnable);
            this.mLogCheckThread = thread;
            thread.start();
        }
    }

    public final FileOutputStream getLogFileStream() {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(this.context.getCacheDir(), AppFilesHelper.ANDROID_MANUAL_CLIENT_LOG);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLogFileStream");
            return null;
        }
        return fileOutputStream;
    }
}
