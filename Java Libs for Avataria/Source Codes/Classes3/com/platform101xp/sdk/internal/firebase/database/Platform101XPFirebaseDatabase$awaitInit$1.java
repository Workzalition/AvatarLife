package com.platform101xp.sdk.internal.firebase.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Platform101XPFirebaseDatabase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.platform101xp.sdk.internal.firebase.database.Platform101XPFirebaseDatabase$awaitInit$1", f = "Platform101XPFirebaseDatabase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\BuzzerFelix\Downloads\Avataria Source Code\classes3.dex */
public final class Platform101XPFirebaseDatabase$awaitInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $firebaseAction;
    int label;
    final /* synthetic */ Platform101XPFirebaseDatabase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Platform101XPFirebaseDatabase$awaitInit$1(Platform101XPFirebaseDatabase platform101XPFirebaseDatabase, Function0<Unit> function0, Continuation<? super Platform101XPFirebaseDatabase$awaitInit$1> continuation) {
        super(2, continuation);
        this.this$0 = platform101XPFirebaseDatabase;
        this.$firebaseAction = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Platform101XPFirebaseDatabase$awaitInit$1(this.this$0, this.$firebaseAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Platform101XPFirebaseDatabase platform101XPFirebaseDatabase = this.this$0;
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            Intrinsics.checkNotNullExpressionValue(reference, "getInstance().reference");
            platform101XPFirebaseDatabase.firebaseDatabase = reference;
            this.$firebaseAction.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
