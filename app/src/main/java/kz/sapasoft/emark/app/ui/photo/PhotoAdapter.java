package kz.sapasoft.emark.app.ui.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.databinding.ItemPhotoBinding;
import kz.sapasoft.emark.app.databinding.ItemPhotoFooterBinding;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.ui.DataBindingViewHolder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003\u001f !B%\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u001e\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkz/sapasoft/emark/app/ui/DataBindingViewHolder;", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "items", "Ljava/util/ArrayList;", "listener", "Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter$OnPhotoClickListener;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter$OnPhotoClickListener;Landroid/content/Context;)V", "FOOTER_VIEW", "", "add", "", "list", "", "item", "clear", "deletePhoto", "imageDataModel", "getChangedModelList", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FooterHolder", "OnPhotoClickListener", "SimpleHolder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PhotoAdapter.kt */
public final class PhotoAdapter extends RecyclerView.Adapter<DataBindingViewHolder<ImageDataModel>> {
    private final int FOOTER_VIEW;
    private Context context;
    private ArrayList<ImageDataModel> items;
    /* access modifiers changed from: private */
    public OnPhotoClickListener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter$OnPhotoClickListener;", "", "onAddPhotoClick", "", "onPhotoClick", "imageDataModel", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "onPhotoDeleted", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PhotoAdapter.kt */
    public interface OnPhotoClickListener {
        void onAddPhotoClick();

        void onPhotoClick(ImageDataModel imageDataModel);

        void onPhotoDeleted();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoAdapter(ArrayList arrayList, OnPhotoClickListener onPhotoClickListener, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, onPhotoClickListener, context2);
    }

    public PhotoAdapter(ArrayList<ImageDataModel> arrayList, OnPhotoClickListener onPhotoClickListener, Context context2) {
     //   Intrinsics.checkParameterIsNotNull(arrayList, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkParameterIsNotNull(onPhotoClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.items = arrayList;
        this.listener = onPhotoClickListener;
        this.context = context2;
        this.FOOTER_VIEW = 1;
    }

    public int getItemCount() {
        if (this.items.size() == 0) {
            return 1;
        }
        return this.items.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == this.items.size()) {
            return this.FOOTER_VIEW;
        }
        return super.getItemViewType(i);
    }

    public void onBindViewHolder(DataBindingViewHolder<ImageDataModel> dataBindingViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(dataBindingViewHolder, "holder");
        if (dataBindingViewHolder instanceof SimpleHolder) {
            ImageDataModel imageDataModel = this.items.get(i);
            Intrinsics.checkExpressionValueIsNotNull(imageDataModel, "items[position]");
            dataBindingViewHolder.onBind(imageDataModel);
            return;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
        dataBindingViewHolder.onBind(new ImageDataModel(uuid, (String) null, (ImageDataModel.MetaData) null, (File) null));
    }

    public DataBindingViewHolder<ImageDataModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.FOOTER_VIEW) {
            ItemPhotoFooterBinding inflate = ItemPhotoFooterBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "ItemPhotoFooterBinding.i….context), parent, false)");
            return new FooterHolder(this, inflate);
        }
        ItemPhotoBinding inflate2 = ItemPhotoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "ItemPhotoBinding.inflate….context), parent, false)");
        return new SimpleHolder(this, inflate2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter$SimpleHolder;", "Lkz/sapasoft/emark/app/ui/DataBindingViewHolder;", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "dataBinding", "Landroidx/databinding/ViewDataBinding;", "(Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter;Landroidx/databinding/ViewDataBinding;)V", "onBind", "", "t", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PhotoAdapter.kt */
    public final class SimpleHolder extends DataBindingViewHolder<ImageDataModel> {
        final /* synthetic */ PhotoAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleHolder(PhotoAdapter photoAdapter, ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            Intrinsics.checkParameterIsNotNull(viewDataBinding, "dataBinding");
            this.this$0 = photoAdapter;
        }

        public void onBind(ImageDataModel imageDataModel) {
            Intrinsics.checkParameterIsNotNull(imageDataModel, "t");
            getDataBinding().setVariable(2, imageDataModel);
            getDataBinding().setVariable(3, Boolean.valueOf(imageDataModel.getFile() != null));
            getDataBinding().getRoot().setOnClickListener(new PhotoAdapter$SimpleHolder$onBind$$inlined$with$lambda$1(this, imageDataModel));
            View root = getDataBinding().getRoot();
            Intrinsics.checkExpressionValueIsNotNull(root, "dataBinding.root");
            ((ImageView) root.findViewById(R.id.iv_delete)).setOnClickListener(new PhotoAdapter$SimpleHolder$onBind$$inlined$with$lambda$2(this, imageDataModel));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter$FooterHolder;", "Lkz/sapasoft/emark/app/ui/DataBindingViewHolder;", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "dataBinding", "Landroidx/databinding/ViewDataBinding;", "(Lkz/sapasoft/emark/app/ui/photo/PhotoAdapter;Landroidx/databinding/ViewDataBinding;)V", "onBind", "", "t", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PhotoAdapter.kt */
    public final class FooterHolder extends DataBindingViewHolder<ImageDataModel> {
        final /* synthetic */ PhotoAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FooterHolder(PhotoAdapter photoAdapter, ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            Intrinsics.checkParameterIsNotNull(viewDataBinding, "dataBinding");
            this.this$0 = photoAdapter;
        }

        public void onBind(ImageDataModel imageDataModel) {
            Intrinsics.checkParameterIsNotNull(imageDataModel, "t");
            getDataBinding().getRoot().setOnClickListener(new PhotoAdapter$FooterHolder$onBind$1(this));
        }
    }

    public final List<ImageDataModel> getChangedModelList() {
        Collection arrayList = new ArrayList();
        for (Object next : this.items) {
            if (((ImageDataModel) next).file != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void add(List<ImageDataModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void add(ImageDataModel imageDataModel) {
        Intrinsics.checkParameterIsNotNull(imageDataModel, "item");
        this.items.add(imageDataModel);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public final void deletePhoto(ImageDataModel imageDataModel) {
        this.items.remove(imageDataModel);
        notifyDataSetChanged();
        this.listener.onPhotoDeleted();
    }
}
