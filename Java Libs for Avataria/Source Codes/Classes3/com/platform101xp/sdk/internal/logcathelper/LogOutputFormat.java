package com.platform101xp.sdk.internal.logcathelper;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Platform101XPLogOutputFile.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/platform101xp/sdk/internal/logcathelper/LogOutputFormat;", "", "value", "", "(Ljava/lang/String;II)V", "outputFormat", "", "getOutputFormat", "()Ljava/lang/String;", "BRIEF", "PROCESS", "TAG", "RAW", "TIME", "THREADTIME", "LONG", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public enum LogOutputFormat {
    BRIEF(0),
    PROCESS(1),
    TAG(2),
    RAW(3),
    TIME(4),
    THREADTIME(5),
    LONG(6);

    /* compiled from: Platform101XPLogOutputFile.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogOutputFormat.values().length];
            iArr[LogOutputFormat.BRIEF.ordinal()] = 1;
            iArr[LogOutputFormat.LONG.ordinal()] = 2;
            iArr[LogOutputFormat.PROCESS.ordinal()] = 3;
            iArr[LogOutputFormat.RAW.ordinal()] = 4;
            iArr[LogOutputFormat.TAG.ordinal()] = 5;
            iArr[LogOutputFormat.THREADTIME.ordinal()] = 6;
            iArr[LogOutputFormat.TIME.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    LogOutputFormat(int i) {
    }

    public final String getOutputFormat() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "brief";
            case 2:
                return "long";
            case 3:
                return "process";
            case 4:
                return "raw";
            case 5:
                return "tag";
            case 6:
                return "threadtime";
            case 7:
                return "time";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
