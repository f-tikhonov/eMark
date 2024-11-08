/*
package kz.sapasoft.emark.app.ui.settings;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.utils.DateConverter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kz/sapasoft/emark/app/ui/settings/SettingsViewModel$getMarkerDetails$1$1"}, k = 3, mv = {1, 1, 16})
*/
/* compiled from: SettingsViewModel.kt *//*

final class SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final */
/* synthetic *//*
 int $i;
    final */
/* synthetic *//*
 MarkerModel $item;
    final */
/* synthetic *//*
 ArrayList $markers$inlined;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 SettingsViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1(MarkerModel markerModel, int i, Continuation continuation, SettingsViewModel settingsViewModel, ArrayList arrayList) {
        super(2, continuation);
        this.$item = markerModel;
        this.$i = i;
        this.this$0 = settingsViewModel;
        this.$markers$inlined = arrayList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1 settingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1 = new SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1(this.$item, this.$i, continuation, this.this$0, this.$markers$inlined);
        settingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1.p$ = (CoroutineScope) obj;
        return settingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            BaseCloudRepository access$getBaseCloudRepository$p = this.this$0.baseCloudRepository;
            String id2 = this.$item.getId();
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = access$getBaseCloudRepository$p.getMarker(id2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultWrapper resultWrapper = (ResultWrapper) obj;
        if (!(resultWrapper instanceof ResultWrapper.Error) && (resultWrapper instanceof ResultWrapper.Success)) {
            MutableLiveData<Integer> progress = this.this$0.getProgress();
            Integer value = this.this$0.getProgress().getValue();
            if (value == null) {
                Intrinsics.throwNpe();
            }
            int intValue = value.intValue();
            Integer value2 = this.this$0.getProgress().getValue();
            if (value2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(value2, "progress.value!!");
            progress.postValue(Boxing.boxInt(intValue + ((10000 - value2.intValue()) / (this.$markers$inlined.size() - this.$i))));
            this.this$0.insertMarkerEntity((MarkerModel) ((ResultWrapper.Success) resultWrapper).getValue());
            if (this.$i == this.$markers$inlined.size() - 1) {
                this.this$0.getProgressVisibility().postValue(Boxing.boxBoolean(false));
                Calendar instance = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
                Date time = instance.getTime();
                PrefsImpl access$getPrefsImpl$p = this.this$0.prefsImpl;
                DateConverter dateConverter = DateConverter.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(time, "date");
                access$getPrefsImpl$p.setDateDB(dateConverter.dateToString(time, "HH:mm:ss dd.MM.yyyy"));
                this.this$0.setLoadingDate();
            }
        }
        return Unit.INSTANCE;
    }
}
*/
