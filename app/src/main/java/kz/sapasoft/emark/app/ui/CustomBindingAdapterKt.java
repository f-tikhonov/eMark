package kz.sapasoft.emark.app.ui;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.Config;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.utils.GlideUrlHelper;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0013"}, d2 = {"isRefreshing", "", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "boolean", "", "loadImage", "imageView", "Landroid/widget/ImageView;", "imageDataModel", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "setHtml", "textView", "Landroid/widget/TextView;", "text", "", "visibilityBool", "view", "Landroid/view/View;", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: CustomBindingAdapter.kt */
public final class CustomBindingAdapterKt {
    @BindingAdapter({"image_url"})
    public static final void loadImage(ImageView imageView, ImageDataModel imageDataModel) {
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        Intrinsics.checkParameterIsNotNull(imageDataModel, "imageDataModel");
        if (imageDataModel.getMetadata() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Config.INSTANCE.getDOMAIN());
            sb.append("data/getImage?useHints=true&width=600&height=600&queryKey=");
            ImageDataModel.MetaData metadata = imageDataModel.getMetadata();
            sb.append(URLEncoder.encode(metadata != null ? metadata.getQueryKey() : null, "utf-8"));
            String sb2 = sb.toString();
            RequestManager with = Glide.with(imageView.getContext());
            GlideUrlHelper glideUrlHelper = GlideUrlHelper.INSTANCE;
            Context context = imageView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "imageView.context");
            ((RequestBuilder) with.load((Object) glideUrlHelper.getUrl(sb2, context)).placeholder((int) R.drawable.ic_image)).into(imageView);
            return;
        }
        ((RequestBuilder) Glide.with(imageView.getContext()).load(imageDataModel.getFile()).placeholder((int) R.drawable.ic_image)).into(imageView);
    }

    @BindingAdapter({"set_html"})
    public static final void setHtml(TextView textView, String str) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        if (str != null) {
            textView.setText(Html.fromHtml(str));
        }
    }

    @BindingAdapter({"is_refreshing"})
    public static final void isRefreshing(SwipeRefreshLayout swipeRefreshLayout, boolean z) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(z);
    }

    @BindingAdapter({"visibility_bool"})
    public static final void visibilityBool(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.setVisibility(z ? 0 : 8);
    }
}
