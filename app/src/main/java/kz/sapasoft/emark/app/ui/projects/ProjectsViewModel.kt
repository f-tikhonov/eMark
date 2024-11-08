package kz.sapasoft.emark.app.ui.projects

import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics

class ProjectsViewModel @Inject constructor(
    prefsImpl2: PrefsImpl,
    baseCloudRepository2: BaseCloudRepository,
    projectRepository2: ProjectRepository,
    tagRepository2: TagRepository
) : BaseViewModel() {
    private val TAG = javaClass.simpleName

    /* access modifiers changed from: private */
    @JvmField
    val baseCloudRepository: BaseCloudRepository
    private val `error$delegate`: MutableLiveData<ResultWrapper.Error> by lazy {
        MutableLiveData<ResultWrapper.Error>()
    }
    private val `isRefreshing$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    /* access modifiers changed from: private */
    @JvmField
    var pageProject = 0

    /* access modifiers changed from: private */
    @JvmField
    var pageTag = 1

    /* access modifiers changed from: private */
    @JvmField
    val prefsImpl: PrefsImpl

    /* access modifiers changed from: private */
    @JvmField
    val projectRepository: ProjectRepository

    /* access modifiers changed from: private */
    @JvmField
    val projectsAll = ArrayList<ProjectModel>()
    private val `projectsData$delegate`: MutableLiveData<List<ProjectModel>> by lazy {
        MutableLiveData<List<ProjectModel>>()
    }
    private val `searchString$delegate`: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val tagRepository: TagRepository

    /* access modifiers changed from: private */
    @JvmField
    val tagsAll: ArrayList<TagModel> = ArrayList<TagModel>()
    val error: MutableLiveData<ResultWrapper.Error>
        get() = `error$delegate`.value as MutableLiveData<ResultWrapper.Error>
    val projectsData: MutableLiveData<List<ProjectModel>>
        get() = `projectsData$delegate`.value as MutableLiveData<List<ProjectModel>>
    val searchString: MutableLiveData<String>
        get() = `searchString$delegate`.value as MutableLiveData<String>
    val isRefreshing: MutableLiveData<Boolean>
        get() = `isRefreshing$delegate`.value as MutableLiveData<Boolean>

    init {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        Intrinsics.checkParameterIsNotNull(projectRepository2, "projectRepository")
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository")
        prefsImpl = prefsImpl2
        baseCloudRepository = baseCloudRepository2
        projectRepository = projectRepository2
        tagRepository = tagRepository2
        projects
        tags
    }

    /* access modifiers changed from: private */
    fun insertTagEntityList(list: List<TagModel?>?) {
        tagRepository.deleteAll()
        tagRepository.addTagList(list)
    }

    val tags: Unit
        /* access modifiers changed from: private */
        get() {
          //  launchIO(`ProjectsViewModel$getTags$1`(this, null as Continuation<*>?))
        }
    val projects: Unit
        get() {
            if (pageProject == 1) {
                projectsAll.clear()
            }
          //  launchIO(`ProjectsViewModel$getProjects$1`(this, null as Continuation<*>?))
        }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0078, code lost:
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r3, (java.lang.CharSequence) r4, false, 2, (java.lang.Object) null) != false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    fun getFilteredProjects(r13: String?) {
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
        throw UnsupportedOperationException("Method not decompiled: kz.sapasoft.emark.app.ui.projects.ProjectsViewModel.getFilteredProjects(java.lang.String):void")
    }
}
