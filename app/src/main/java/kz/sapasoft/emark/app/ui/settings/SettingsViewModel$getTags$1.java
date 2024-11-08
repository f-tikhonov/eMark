/*
package kz.sapasoft.emark.app.ui.settings;

import androidx.lifecycle.MutableLiveData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "kz.sapasoft.emark.app.ui.settings.SettingsViewModel$getTags$1", f = "SettingsViewModel.kt", i = {0}, l = {118}, m = "invokeSuspend", n = {"$this$launchIO"}, s = {"L$0"})
*/
/* compiled from: SettingsViewModel.kt *//*

final class SettingsViewModel$getTags$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final */
/* synthetic *//*
 SettingsViewModel this$0;

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    SettingsViewModel$getTags$1(SettingsViewModel settingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SettingsViewModel$getTags$1 settingsViewModel$getTags$1 = new SettingsViewModel$getTags$1(this.this$0, continuation);
        settingsViewModel$getTags$1.p$ = (CoroutineScope) obj;
        return settingsViewModel$getTags$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SettingsViewModel$getTags$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            if (this.this$0.tagsPages == 1) {
                this.this$0.tagRepository.deleteAll();
            }
            BaseCloudRepository access$getBaseCloudRepository$p = this.this$0.baseCloudRepository;
            SettingsViewModel settingsViewModel = this.this$0;
            int access$getTagsPages$p = settingsViewModel.tagsPages;
            settingsViewModel.tagsPages = access$getTagsPages$p + 1;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = access$getBaseCloudRepository$p.getTagList(access$getTagsPages$p, this);
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
            ResultWrapper.Success success = (ResultWrapper.Success) resultWrapper;
            if (!((Collection) success.getValue()).isEmpty()) {
                this.this$0.insertTagEntityList((List) success.getValue());
                this.this$0.getTags();
            } else {
                MutableLiveData<Integer> progress = this.this$0.getProgress();
                Integer value = this.this$0.getProgress().getValue();
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                progress.postValue(Boxing.boxInt(value.intValue() + 100));
            }
        }
        return Unit.INSTANCE;
    }
}
*/
