package com.platform101xp.sdk.internal.firebase.database;

import com.google.firebase.database.DataSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform101XPFirebaseDatabase.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase$readData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String[] $columnsName;
    final /* synthetic */ Function1<DataSnapshot, Unit> $onGetResult;
    final /* synthetic */ String $tableName;
    final /* synthetic */ Platform101XPFirebaseDatabase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Platform101XPFirebaseDatabase$readData$1(Function1<? super DataSnapshot, Unit> function1, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, String str, String[] strArr) {
        super(0);
        this.$onGetResult = function1;
        this.this$0 = platform101XPFirebaseDatabase;
        this.$tableName = str;
        this.$columnsName = strArr;
    }

    /* compiled from: Platform101XPFirebaseDatabase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase$readData$1$1", f = "Platform101XPFirebaseDatabase.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase$readData$1$1 */
    /* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String[] $columnsName;
        final /* synthetic */ Function1<DataSnapshot, Unit> $onGetResult;
        final /* synthetic */ String $tableName;
        int label;
        final /* synthetic */ Platform101XPFirebaseDatabase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super DataSnapshot, Unit> function1, Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, String str, String[] strArr, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onGetResult = function1;
            this.this$0 = platform101XPFirebaseDatabase;
            this.$tableName = str;
            this.$columnsName = strArr;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$onGetResult, this.this$0, this.$tableName, this.$columnsName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull((long) Platform101XPFirebaseDatabase.DATA_READ_TIMEOUT, new Platform101XPFirebaseDatabase$readData$1$1$result$1(this.this$0, this.$tableName, this.$columnsName, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            this.$onGetResult.invoke((DataSnapshot) obj);
            return Unit.INSTANCE;
        }
    }

    public final void invoke() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new AnonymousClass1(this.$onGetResult, this.this$0, this.$tableName, this.$columnsName, null), 2, (Object) null);
    }
}
