package kz.sapasoft.emark.app.core;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkz/sapasoft/emark/app/core/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "launchIO", "", "P", "doOnAsyncBlock", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BaseViewModel.kt */
public abstract class BaseViewModel extends ViewModel {
    public final <P> void launchIO(Function2<? super CoroutineScope, ? super Continuation<? super P>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "doOnAsyncBlock");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new BaseViewModel$launchIO$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key), (CoroutineStart) null, new BaseViewModel$launchIO$2(function2, (Continuation) null), 2, (Object) null);
    }
}
