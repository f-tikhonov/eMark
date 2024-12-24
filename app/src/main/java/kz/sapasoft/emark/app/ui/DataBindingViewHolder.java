package kz.sapasoft.emark.app.ui;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decompiledapk.databinding.ItemPhotoBinding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkz/sapasoft/emark/app/ui/DataBindingViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataBinding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "onBind", "", "t", "(Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DataBindingViewHolder.kt */
public abstract class DataBindingViewHolder<T> extends RecyclerView.ViewHolder {
    private final ViewDataBinding dataBinding;

    public abstract void onBind(T t);

    public final ViewDataBinding getDataBinding() {
        return this.dataBinding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBindingViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(viewDataBinding, "dataBinding");
        this.dataBinding = viewDataBinding;
    }
}