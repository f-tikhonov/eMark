package kz.sapasoft.emark.app.ui.projects;

import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.ResultWrapper;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020)J\b\u0010,\u001a\u00020)H\u0002J\u0016\u0010-\u001a\u00020)2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0 H\u0002R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R'\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u000f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b!\u0010\u0012R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\u001cj\b\u0012\u0004\u0012\u00020'`\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lkz/sapasoft/emark/app/ui/projects/ProjectsViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "projectRepository", "Lkz/sapasoft/emark/app/data/local/room/project/ProjectRepository;", "tagRepository", "Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;", "(Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;Lkz/sapasoft/emark/app/data/local/room/project/ProjectRepository;Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "error", "Landroidx/lifecycle/MutableLiveData;", "Lkz/sapasoft/emark/app/data/cloud/ResultWrapper$Error;", "getError", "()Landroidx/lifecycle/MutableLiveData;", "error$delegate", "Lkotlin/Lazy;", "isRefreshing", "", "isRefreshing$delegate", "pageProject", "", "pageTag", "projectsAll", "Ljava/util/ArrayList;", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "Lkotlin/collections/ArrayList;", "projectsData", "", "getProjectsData", "projectsData$delegate", "searchString", "getSearchString", "searchString$delegate", "tagsAll", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "getFilteredProjects", "", "filter", "getProjects", "getTags", "insertTagEntityList", "tagModelList", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProjectsViewModel.kt */
public final class ProjectsViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public final BaseCloudRepository baseCloudRepository;
    private final Lazy error$delegate = LazyKt.lazy(ProjectsViewModel$error$2.INSTANCE);
    private final Lazy isRefreshing$delegate = LazyKt.lazy(ProjectsViewModel$isRefreshing$2.INSTANCE);
    /* access modifiers changed from: private */
    public int pageProject;
    /* access modifiers changed from: private */
    public int pageTag = 1;
    /* access modifiers changed from: private */
    public final PrefsImpl prefsImpl;
    /* access modifiers changed from: private */
    public final ProjectRepository projectRepository;
    /* access modifiers changed from: private */
    public final ArrayList<ProjectModel> projectsAll = new ArrayList<>();
    private final Lazy projectsData$delegate = LazyKt.lazy(ProjectsViewModel$projectsData$2.INSTANCE);
    private final Lazy searchString$delegate = LazyKt.lazy(ProjectsViewModel$searchString$2.INSTANCE);
    private final TagRepository tagRepository;
    /* access modifiers changed from: private */
    public final ArrayList<TagModel> tagsAll = new ArrayList<>();

    public final MutableLiveData<ResultWrapper.Error> getError() {
        return (MutableLiveData) this.error$delegate.getValue();
    }

    public final MutableLiveData<List<ProjectModel>> getProjectsData() {
        return (MutableLiveData) this.projectsData$delegate.getValue();
    }

    public final MutableLiveData<String> getSearchString() {
        return (MutableLiveData) this.searchString$delegate.getValue();
    }

    public final MutableLiveData<Boolean> isRefreshing() {
        return (MutableLiveData) this.isRefreshing$delegate.getValue();
    }

    @Inject
    public ProjectsViewModel(PrefsImpl prefsImpl2, BaseCloudRepository baseCloudRepository2, ProjectRepository projectRepository2, TagRepository tagRepository2) {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        Intrinsics.checkParameterIsNotNull(projectRepository2, "projectRepository");
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository");
        this.prefsImpl = prefsImpl2;
        this.baseCloudRepository = baseCloudRepository2;
        this.projectRepository = projectRepository2;
        this.tagRepository = tagRepository2;
        getProjects();
        getTags();
    }

    /* access modifiers changed from: private */
    public final void insertTagEntityList(List<TagModel> list) {
        this.tagRepository.deleteAll();
        this.tagRepository.addTagList(list);
    }

    /* access modifiers changed from: private */
    public final void getTags() {
        launchIO(new ProjectsViewModel$getTags$1(this, (Continuation) null));
    }

    public final void getProjects() {
        if (this.pageProject == 1) {
            this.projectsAll.clear();
        }
        launchIO(new ProjectsViewModel$getProjects$1(this, (Continuation) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0078, code lost:
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, false, 2, (java.lang.Object) null) != false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getFilteredProjects(String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "filter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.util.ArrayList<kz.sapasoft.emark.app.domain.model.ProjectModel> r0 = r12.projectsAll
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r0.next()
            r3 = r2
            kz.sapasoft.emark.app.domain.model.ProjectModel r3 = (kz.sapasoft.emark.app.domain.model.ProjectModel) r3
            java.lang.String r4 = r3.getName()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r6 = "Locale.ROOT"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            if (r4 == 0) goto L_0x0088
            java.lang.String r4 = r4.toLowerCase(r5)
            java.lang.String r5 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.util.Locale r8 = java.util.Locale.ROOT
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r6)
            java.lang.String r8 = r13.toLowerCase(r8)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r5)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = 0
            r10 = 2
            r11 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r4 != 0) goto L_0x0081
            java.lang.String r3 = r3.getRegionName()
            java.util.Locale r4 = java.util.Locale.ROOT
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = r3.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.util.Locale r4 = java.util.Locale.ROOT
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            java.lang.String r4 = r13.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r3 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (boolean) r9, (int) r10, (java.lang.Object) r11)
            if (r3 == 0) goto L_0x0082
            goto L_0x0081
        L_0x007b:
            kotlin.TypeCastException r13 = new kotlin.TypeCastException
            r13.<init>(r7)
            throw r13
        L_0x0081:
            r9 = 1
        L_0x0082:
            if (r9 == 0) goto L_0x0014
            r1.add(r2)
            goto L_0x0014
        L_0x0088:
            kotlin.TypeCastException r13 = new kotlin.TypeCastException
            r13.<init>(r7)
            throw r13
        L_0x008e:
            java.util.List r1 = (java.util.List) r1
            androidx.lifecycle.MutableLiveData r13 = r12.getProjectsData()
            r13.postValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.projects.ProjectsViewModel.getFilteredProjects(java.lang.String):void");
    }
}
