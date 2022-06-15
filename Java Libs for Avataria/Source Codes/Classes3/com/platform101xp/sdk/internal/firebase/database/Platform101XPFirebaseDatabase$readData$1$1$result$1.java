package com.platform101xp.sdk.internal.firebase.database;

import com.google.firebase.database.DataSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Platform101XPFirebaseDatabase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/google/firebase/database/DataSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase$readData$1$1$result$1", f = "Platform101XPFirebaseDatabase.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase$readData$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DataSnapshot>, Object> {
    final /* synthetic */ String[] $columnsName;
    final /* synthetic */ String $tableName;
    int label;
    final /* synthetic */ Platform101XPFirebaseDatabase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPFirebaseDatabase$readData$1$1$result$1(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, String str, String[] strArr, Continuation<? super Platform101XPFirebaseDatabase$readData$1$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = platform101XPFirebaseDatabase;
        this.$tableName = str;
        this.$columnsName = strArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Platform101XPFirebaseDatabase$readData$1$1$result$1(this.this$0, this.$tableName, this.$columnsName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DataSnapshot> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.readTableData(this.$tableName, this.$columnsName, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
