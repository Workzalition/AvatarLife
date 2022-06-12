package com.platform101xp.sdk.internal;

import android.content.Context;
import android.util.Log;
import com.platform101xp.sdk.internal.Platform101XPEmulatorDetector;
import io.github.dmitrikudrenko.emulatordetector.Callback;
import io.github.dmitrikudrenko.emulatordetector.EmulatorDetector;
import io.github.dmitrikudrenko.emulatordetector.IDetector;
import io.github.dmitrikudrenko.emulatordetector.accelerometer.AccelerometerDetector;
import io.github.dmitrikudrenko.emulatordetector.gyroscope.GyroscopeDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Platform101XPEmulatorDetector.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/platform101xp/sdk/internal/Platform101XPEmulatorDetector;", "", "()V", "detectEmulator", "", "context", "Landroid/content/Context;", "listenerDetector", "Lcom/platform101xp/sdk/internal/Platform101XPEmulatorDetector$ListenerDetector;", "ListenerDetector", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPEmulatorDetector {

    /* compiled from: Platform101XPEmulatorDetector.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/platform101xp/sdk/internal/Platform101XPEmulatorDetector$ListenerDetector;", "", "onSuccess", "", "isEmulator", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public interface ListenerDetector {
        void onSuccess(boolean z);
    }

    public final void detectEmulator(Context context, final ListenerDetector listenerDetector) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listenerDetector, "listenerDetector");
        new EmulatorDetector(new IDetector[]{AccelerometerDetector.builder().setDelay(500).setEventCount(5).build(), GyroscopeDetector.builder().setDelay(500).setEventCount(5).build()}).detect(context, new Callback() { // from class: com.platform101xp.sdk.internal.Platform101XPEmulatorDetector$detectEmulator$1
            public void onError(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "exception");
                Log.d("101XP SDK", exc.getMessage(), exc);
            }

            public void onDetect(boolean z) {
                Platform101XPEmulatorDetector.ListenerDetector.this.onSuccess(z);
            }
        });
    }
}
