package com.platform101xp.sdk.internal.logcathelper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Platform101XPFileHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ#\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/AppFilesHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "collectFiles", "", "fileData", "", "fileName", "zipFileName", "constructAppInfoFile", "zipFiles", "sourceLocation", "", "Ljava/io/File;", "targetLocation", "([Ljava/io/File;Ljava/io/File;)V", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class AppFilesHelper {
    public static final String ANDROID_MANUAL_CLIENT_LOG = "app.log";
    public static final String APP_INFO_FILE_NAME = "appInfo.txt";
    public static final String A_NEW_LINE = "\n";
    public static final Companion Companion = new Companion(null);
    public static final String SPACE = "_";
    private final Context context;

    /* compiled from: Platform101XPFileHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/AppFilesHelper$Companion;", "", "()V", "ANDROID_MANUAL_CLIENT_LOG", "", "APP_INFO_FILE_NAME", "A_NEW_LINE", "SPACE", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppFilesHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String constructAppInfoFile() {
        PackageInfo packageInfo;
        String str = null;
        try {
            packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            str = packageInfo.versionName;
        }
        String str2 = Build.MODEL + A_NEW_LINE + Build.VERSION.RELEASE + SPACE + Build.VERSION.SDK_INT + A_NEW_LINE + Build.DEVICE + A_NEW_LINE + str;
        Intrinsics.checkNotNullExpressionValue(str2, "email.toString()");
        return str2;
    }

    public final void collectFiles(String str, String str2, String str3) {
        FileWriter fileWriter;
        Intrinsics.checkNotNullParameter(str3, "zipFileName");
        File cacheDir = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        File file = new File(cacheDir, str2);
        FileWriter fileWriter2 = new FileWriter(file);
        File file2 = new File(cacheDir, str3);
        File[] listFiles = cacheDir.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "cacheDir.listFiles()");
        try {
            FileWriter fileWriter3 = fileWriter2;
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter3.write(str);
            fileWriter3.flush();
            zipFiles(listFiles, file2);
            Unit unit = Unit.INSTANCE;
            th = null;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    private final void zipFiles(File[] fileArr, File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            int length = fileArr.length;
            int i = 0;
            while (true) {
                th = null;
                if (i < length) {
                    File file2 = fileArr[i];
                    i++;
                    if (!file2.isDirectory()) {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "file.name");
                        if (!StringsKt.contains$default(name, "zip", false, 2, th)) {
                            zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            FileInputStream fileInputStream2 = fileInputStream;
                            byte[] bArr = new byte[IronSourceError.ERROR_RV_LOAD_FAILED_NO_CANDIDATES];
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream, th);
                            zipOutputStream.closeEntry();
                        }
                    }
                } else {
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
