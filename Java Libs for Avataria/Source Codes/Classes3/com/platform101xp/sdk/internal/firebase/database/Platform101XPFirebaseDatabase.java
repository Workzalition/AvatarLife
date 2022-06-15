package com.platform101xp.sdk.internal.firebase.database;

import android.app.Activity;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDbManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Platform101XPFirebaseDatabase.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J#\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002JF\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\u0002\u0010#J)\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\u0010'J)\u0010(\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010)\u001a\u00020\u0001¢\u0006\u0002\u0010*R\u001c\u0010\u0002\u001a\u00020\u0003@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u0005@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase;", "", "activity", "Landroid/app/Activity;", "initListener", "Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;", "(Landroid/app/Activity;Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "firebaseDatabase", "Lcom/google/firebase/database/DatabaseReference;", "getInitListener", "()Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;", "setInitListener", "(Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDbManager$InitDbResultListener;)V", "awaitInit", "", "firebaseAction", "Lkotlin/Function0;", "getPreparedTable", "tableName", "", "columnsName", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/google/firebase/database/DatabaseReference;", "init", "readData", "onGetResult", "Lkotlin/Function1;", "Lcom/google/firebase/database/DataSnapshot;", "Lkotlin/ParameterName;", "name", "dataSnapshot", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "readTableData", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeData", "(Ljava/lang/String;[Ljava/lang/String;)V", "writeData", "value", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase {
    public static final Companion Companion = new Companion(null);
    public static final long DATA_READ_TIMEOUT = 2000;
    private Activity activity;
    private DatabaseReference firebaseDatabase;
    private Platform101XPFirebaseDbManager.InitDbResultListener initListener;

    /* compiled from: Platform101XPFirebaseDatabase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/platform101xp/sdk/internal/firebase/database/Platform101XPFirebaseDatabase$Companion;", "", "()V", "DATA_READ_TIMEOUT", "", "sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public Platform101XPFirebaseDatabase(Activity activity, Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(initDbResultListener, "initListener");
        this.activity = activity;
        this.initListener = initDbResultListener;
        try {
            init(initDbResultListener);
        } catch (ClassNotFoundException e) {
            String message = e.getMessage();
            Log.d("101XP SDK", message == null ? e.toString() : message);
        } catch (NoClassDefFoundError e2) {
            String message2 = e2.getMessage();
            Log.d("101XP SDK", message2 == null ? e2.toString() : message2);
        }
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Platform101XPFirebaseDbManager.InitDbResultListener getInitListener() {
        return this.initListener;
    }

    @Inject
    public final void setActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    @Inject
    public final void setInitListener(Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) {
        Intrinsics.checkNotNullParameter(initDbResultListener, "<set-?>");
        this.initListener = initDbResultListener;
    }

    private final void init(Platform101XPFirebaseDbManager.InitDbResultListener initDbResultListener) throws ClassNotFoundException, NoClassDefFoundError {
        initDbResultListener.onInitResult(null);
    }

    private final void awaitInit(Function0<Unit> function0) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new Platform101XPFirebaseDatabase$awaitInit$1(this, function0, null), 2, (Object) null);
    }

    public final void writeData(String str, String[] strArr, Object obj) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(strArr, "columnsName");
        Intrinsics.checkNotNullParameter(obj, "value");
        awaitInit((Function0) new Platform101XPFirebaseDatabase$writeData$1(this, str, strArr, obj));
    }

    public final void readData(String str, String[] strArr, Function1<? super DataSnapshot, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(strArr, "columnsName");
        Intrinsics.checkNotNullParameter(function1, "onGetResult");
        awaitInit((Function0) new Platform101XPFirebaseDatabase$readData$1(function1, this, str, strArr));
    }

    public final void removeData(String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(strArr, "columnsName");
        awaitInit((Function0) new Platform101XPFirebaseDatabase$removeData$1(this, str, strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DatabaseReference getPreparedTable(String str, String[] strArr) {
        DatabaseReference databaseReference = this.firebaseDatabase;
        if (databaseReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseDatabase");
            databaseReference = null;
        }
        DatabaseReference child = databaseReference.child(str);
        Intrinsics.checkNotNullExpressionValue(child, "firebaseDatabase.child(tableName)");
        int i = 0;
        if (!(strArr.length == 0)) {
            int length = strArr.length;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                child = child.child(str2);
                Intrinsics.checkNotNullExpressionValue(child, "res.child(columnName)");
            }
        }
        return child;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readTableData(String str, String[] strArr, Continuation<? super DataSnapshot> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        getPreparedTable(str, strArr).addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase$readTableData$2$1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                Intrinsics.checkNotNullParameter(databaseError, "databaseError");
                Log.d("101XP SDK", databaseError.getMessage());
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl((Object) null));
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                if (dataSnapshot.exists()) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.constructor-impl(dataSnapshot));
                    return;
                }
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl((Object) null));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
