package kz.sapasoft.emark.app.ui.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.MarkerModelSync;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.map.MapViewModel$getMarkerEntityList$1", f = "MapViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MapViewModel.kt */
final class MapViewModel$getMarkerEntityList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $projectId;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ MapViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapViewModel$getMarkerEntityList$1(MapViewModel mapViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mapViewModel;
        this.$projectId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        MapViewModel$getMarkerEntityList$1 mapViewModel$getMarkerEntityList$1 = new MapViewModel$getMarkerEntityList$1(this.this$0, this.$projectId, continuation);
        mapViewModel$getMarkerEntityList$1.p$ = (CoroutineScope) obj;
        return mapViewModel$getMarkerEntityList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MapViewModel$getMarkerEntityList$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            List<MarkerModelSync> findByProjectId = this.this$0.markerSyncRepository.findByProjectId(this.$projectId);
            Collection arrayList2 = new ArrayList();
            for (Object next : this.this$0.markerRepository.findByProjectId(this.$projectId)) {
                MarkerModel markerModel = (MarkerModel) next;
                Iterator it = findByProjectId.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Boxing.boxBoolean(Intrinsics.areEqual((Object) ((MarkerModelSync) obj2).getId(), (Object) markerModel.getId())).booleanValue()) {
                        break;
                    }
                }
                if (Boxing.boxBoolean(obj2 == null).booleanValue()) {
                    arrayList2.add(next);
                }
            }
            arrayList.addAll((List) arrayList2);
            Iterable<MarkerModelSync> iterable = findByProjectId;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (MarkerModelSync model : iterable) {
                arrayList3.add(model.toModel());
            }
            arrayList.addAll((List) arrayList3);
            this.this$0.getMarkerModelListData().postValue(arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
