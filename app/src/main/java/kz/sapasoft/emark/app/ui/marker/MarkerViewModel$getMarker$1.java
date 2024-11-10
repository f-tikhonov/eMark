/*
package kz.sapasoft.emark.app.ui.marker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kz.sapasoft.emark.app.domain.model.MarkerModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, d2 = {"getMarker", "", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.marker.MarkerViewModel", f = "MarkerViewModel.kt", i = {0, 0}, l = {62}, m = "getMarker", n = {"this", "markerModel"}, s = {"L$0", "L$1"})
*/
/* compiled from: MarkerViewModel.kt *//*

final class MarkerViewModel$getMarker$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    */
/* synthetic *//*
 Object result;
    final */
/* synthetic *//*
 MarkerViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    MarkerViewModel$getMarker$1(MarkerViewModel markerViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = markerViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMarker((MarkerModel) null, this);
    }
}
*/
