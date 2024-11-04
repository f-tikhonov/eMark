package kz.sapasoft.emark.app.ui.map;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.map.MapViewModel$saveImage$1", f = "MapViewModel.kt", i = {0, 1, 1, 1, 1}, l = {140, 147}, m = "invokeSuspend", n = {"$this$launchIO", "$this$launchIO", "compressedImageFile", "requestFile", "body"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: MapViewModel.kt */
final class MapViewModel$saveImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ String $parentId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MapViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapViewModel$saveImage$1(MapViewModel mapViewModel, File file, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mapViewModel;
        this.$file = file;
        this.$parentId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MapViewModel$saveImage$1 mapViewModel$saveImage$1 = new MapViewModel$saveImage$1(this.this$0, this.$file, this.$parentId, continuation);
        mapViewModel$saveImage$1.p$ = (CoroutineScope) obj;
        return mapViewModel$saveImage$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MapViewModel$saveImage$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object invokeSuspend(Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            java.lang.Object r0 = r12.L$3
            okhttp3.MultipartBody$Part r0 = (okhttp3.MultipartBody.Part) r0
            java.lang.Object r0 = r12.L$2
            okhttp3.RequestBody r0 = (okhttp3.RequestBody) r0
            java.lang.Object r0 = r12.L$1
            java.io.File r0 = (java.io.File) r0
            java.lang.Object r0 = r12.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x008a
        L_0x0022:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x002a:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0055
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.CoroutineScope r1 = r12.p$
            id.zelory.compressor.Compressor r4 = id.zelory.compressor.Compressor.INSTANCE
            kz.sapasoft.emark.app.core.App$Companion r13 = kz.sapasoft.emark.app.core.App.Companion
            kz.sapasoft.emark.app.core.App r13 = r13.getInstance()
            r5 = r13
            android.content.Context r5 = (android.content.Context) r5
            java.io.File r6 = r12.$file
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r12.L$0 = r1
            r12.label = r3
            r9 = r12
            java.lang.Object r13 = id.zelory.compressor.Compressor.compress$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r13 != r0) goto L_0x0055
            return r0
        L_0x0055:
            java.io.File r13 = (java.io.File) r13
            okhttp3.RequestBody$Companion r3 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r4 = okhttp3.MediaType.Companion
            java.lang.String r5 = "multipart/form-data"
            okhttp3.MediaType r4 = r4.parse(r5)
            okhttp3.RequestBody r3 = r3.create((java.io.File) r13, (okhttp3.MediaType) r4)
            okhttp3.MultipartBody$Part$Companion r4 = okhttp3.MultipartBody.Part.Companion
            java.lang.String r5 = r13.getName()
            java.lang.String r6 = "data"
            okhttp3.MultipartBody$Part r4 = r4.createFormData(r6, r5, r3)
            kz.sapasoft.emark.app.ui.map.MapViewModel r5 = r12.this$0
            kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository r5 = r5.baseCloudRepository
            java.lang.String r6 = r12.$parentId
            r12.L$0 = r1
            r12.L$1 = r13
            r12.L$2 = r3
            r12.L$3 = r4
            r12.label = r2
            java.lang.Object r13 = r5.saveImage(r6, r4, r12)
            if (r13 != r0) goto L_0x008a
            return r0
        L_0x008a:
            kz.sapasoft.emark.app.data.cloud.ResultWrapper r13 = (kz.sapasoft.emark.app.data.cloud.ResultWrapper) r13
            boolean r0 = r13 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Error
            if (r0 == 0) goto L_0x009a
            kz.sapasoft.emark.app.ui.map.MapViewModel r0 = r12.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getError()
            r0.postValue(r13)
            goto L_0x009c
        L_0x009a:
            boolean r13 = r13 instanceof kz.sapasoft.emark.app.data.cloud.ResultWrapper.Success
        L_0x009c:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.map.MapViewModel$saveImage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
