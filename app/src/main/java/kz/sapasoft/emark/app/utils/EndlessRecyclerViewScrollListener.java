package kz.sapasoft.emark.app.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkz/sapasoft/emark/app/utils/EndlessRecyclerViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "currentPage", "", "loading", "", "previousTotalItemCount", "startingPageIndex", "visibleThreshold", "onLoadMore", "", "page", "totalItemsCount", "onScrolled", "view", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "resetValues", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EndlessRecyclerViewScrollListener.kt */
public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
    private int currentPage = 1;
    private boolean loading = true;
    private final LinearLayoutManager mLinearLayoutManager;
    private int previousTotalItemCount;
    private int startingPageIndex = 1;
    private final int visibleThreshold = 4;

    public abstract void onLoadMore(int i, int i2);

    public EndlessRecyclerViewScrollListener(LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkParameterIsNotNull(linearLayoutManager, "mLinearLayoutManager");
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        int findLastVisibleItemPosition = this.mLinearLayoutManager.findLastVisibleItemPosition();
        int itemCount = this.mLinearLayoutManager.getItemCount();
        if (itemCount < this.previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = itemCount;
            if (itemCount == 0) {
                this.loading = true;
            }
        }
        if (this.loading && itemCount > this.previousTotalItemCount) {
            this.loading = false;
            this.previousTotalItemCount = itemCount;
        }
        if (!this.loading && findLastVisibleItemPosition + this.visibleThreshold >= itemCount) {
            int i3 = this.currentPage + 1;
            this.currentPage = i3;
            onLoadMore(i3, itemCount);
            this.loading = true;
        }
    }

    public final void resetValues() {
        this.currentPage = 1;
        this.previousTotalItemCount = 0;
        this.startingPageIndex = 1;
        this.loading = true;
    }
}
