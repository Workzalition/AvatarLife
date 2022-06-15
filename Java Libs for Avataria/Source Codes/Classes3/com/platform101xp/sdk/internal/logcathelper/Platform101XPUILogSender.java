package com.platform101xp.sdk.internal.logcathelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.platform101xp.sdk.internal.dialogs.Platform101XPDialogs;
import com.platform101xp.sdk.internal.dialogs.Platform101XPLogsActionsListener;
import com.platform101xp.sdk.internal.logcathelper.Platform101XPCollectLogsTask;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPUILogSender.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/Platform101XPUILogSender;", "", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "(Landroid/content/Context;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "showLogs", "", "dialogsManager", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs;", "cancelAction", "Lcom/platform101xp/sdk/internal/dialogs/Platform101XPDialogs$OnUserCancelAction;", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPUILogSender {
    private final Activity activity;
    private final Context context;

    public Platform101XPUILogSender(Context context, Activity activity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.context = context;
        this.activity = activity;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void showLogs(final Platform101XPDialogs platform101XPDialogs, final Platform101XPDialogs.OnUserCancelAction onUserCancelAction) {
        Intrinsics.checkNotNullParameter(platform101XPDialogs, "dialogsManager");
        Intrinsics.checkNotNullParameter(onUserCancelAction, "cancelAction");
        final Platform101XPLogsActionsListener platform101XPLogsActionsListener = new Platform101XPLogsActionsListener() { // from class: com.platform101xp.sdk.internal.logcathelper.Platform101XPUILogSender$showLogs$logsActionsListener$1
            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPLogsActionsListener
            public void onCancelClick() {
                Platform101XPDialogs.OnUserCancelAction.this.onCancelClick();
            }

            @Override // com.platform101xp.sdk.internal.dialogs.Platform101XPLogsActionsListener
            public void onAcceptClick() {
                Context context = this.getContext();
                final Platform101XPUILogSender platform101XPUILogSender = this;
                new Platform101XPLogcatHelper(context, new Platform101XPCollectLogsTask(new Platform101XPCollectLogsTask.OnSendLogsListener() { // from class: com.platform101xp.sdk.internal.logcathelper.Platform101XPUILogSender$showLogs$logsActionsListener$1$onAcceptClick$logcatHelper$1
                    @Override // com.platform101xp.sdk.internal.logcathelper.Platform101XPCollectLogsTask.OnSendLogsListener
                    public void onShowSendLogs() {
                        Intent intent = new Intent();
                        Uri uriForFile = FileProvider.getUriForFile(Platform101XPUILogSender.this.getContext(), Intrinsics.stringPlus(Platform101XPUILogSender.this.getContext().getPackageName(), ".provider"), new File(Platform101XPUILogSender.this.getContext().getCacheDir(), Platform101XPCollectLogsTask.LOGS_ZIP_FILE_NAME));
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", uriForFile);
                        intent.setType("application/zip");
                        intent.setFlags(1);
                        Intent createChooser = Intent.createChooser(intent, "Send logs");
                        List<ResolveInfo> queryIntentActivities = Platform101XPUILogSender.this.getContext().getPackageManager().queryIntentActivities(createChooser, 65536);
                        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…nager.MATCH_DEFAULT_ONLY)");
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            Platform101XPUILogSender.this.getContext().grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
                        }
                        Platform101XPUILogSender.this.getActivity().startActivity(createChooser);
                    }
                }, new AppFilesHelper(this.getContext()))).start("");
            }
        };
        this.activity.runOnUiThread(new Runnable() { // from class: com.platform101xp.sdk.internal.logcathelper.Platform101XPUILogSender$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Platform101XPUILogSender.m156showLogs$lambda0(Platform101XPDialogs.this, platform101XPLogsActionsListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showLogs$lambda-0  reason: not valid java name */
    public static final void m156showLogs$lambda0(Platform101XPDialogs platform101XPDialogs, Platform101XPLogsActionsListener platform101XPLogsActionsListener) {
        Intrinsics.checkNotNullParameter(platform101XPDialogs, "$dialogsManager");
        Intrinsics.checkNotNullParameter(platform101XPLogsActionsListener, "$logsActionsListener");
        platform101XPDialogs.getFactory().getLogsDialog(platform101XPLogsActionsListener).show();
    }
}
