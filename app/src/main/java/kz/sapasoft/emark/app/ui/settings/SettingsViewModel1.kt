package kz.sapasoft.emark.app.ui.settings

import android.content.Context
import androidx.lifecycle.MutableLiveData
import kz.sapasoft.emark.app.core.BaseViewModel
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import kz.ss.emark.R
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.jvm.internal.Intrinsics

class SettingsViewModel @Inject constructor(
    prefsImpl2: PrefsImpl,
    context2: Context,
    baseCloudRepository2: BaseCloudRepository,
    projectRepository2: ProjectRepository,
    tagRepository2: TagRepository,
    templateRepository2: TemplateRepository,
    markerRepository2: MarkerRepository
) : BaseViewModel() {
    private val TAG = javaClass.simpleName

    /* access modifiers changed from: private */
    @JvmField
    val baseCloudRepository: BaseCloudRepository
    private val context: Context
    private val `dateDb$delegate`: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val `loadButtonEnabled$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    val markerRepository: MarkerRepository

    /* access modifiers changed from: private */
    var markersPages: Int
    private val `offlineMode$delegate`: Lazy<*> = lazy(`SettingsViewModel$offlineMode$2`.INSTANCE)

    /* access modifiers changed from: private */
    @JvmField
    val prefsImpl: PrefsImpl
    private val `progress$delegate`: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val `progressVisibility$delegate`: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /* access modifiers changed from: private */
    val projectRepository: ProjectRepository

    /* access modifiers changed from: private */
    var projectsPages: Int

    /* access modifiers changed from: private */
    @JvmField
    val tagRepository: TagRepository

    /* access modifiers changed from: private */
    @JvmField
    var tagsPages: Int

    /* access modifiers changed from: private */
    val templateRepository: TemplateRepository
    val dateDb: MutableLiveData<String>
        get() = `dateDb$delegate`.value as MutableLiveData<String>
    val loadButtonEnabled: MutableLiveData<Boolean>
        get() = `loadButtonEnabled$delegate`.value as MutableLiveData<Boolean>
    val offlineMode: MutableLiveData<Boolean>
        get() = `offlineMode$delegate`.value as MutableLiveData<Boolean>
    val progress: MutableLiveData<Int>
        get() = `progress$delegate`.value as MutableLiveData<Int>
    val progressVisibility: MutableLiveData<Boolean>
        get() = `progressVisibility$delegate`.value as MutableLiveData<Boolean>

    init {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl")
        Intrinsics.checkParameterIsNotNull(context2, "context")
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository")
        Intrinsics.checkParameterIsNotNull(projectRepository2, "projectRepository")
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository")
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository")
        Intrinsics.checkParameterIsNotNull(markerRepository2, "markerRepository")
        prefsImpl = prefsImpl2
        context = context2
        baseCloudRepository = baseCloudRepository2
        projectRepository = projectRepository2
        tagRepository = tagRepository2
        templateRepository = templateRepository2
        markerRepository = markerRepository2
        setLoadingDate()
        offlineMode.postValue(java.lang.Boolean.valueOf(prefsImpl.offline))
        prefsImpl.dateDB
        progressVisibility.postValue(false)
        projectsPages = 1
        tagsPages = 1
        markersPages = 1
    }

    fun setOfflineMode(z: Boolean) {
        prefsImpl.offline = z
        loadButtonEnabled.postValue(java.lang.Boolean.valueOf(z))
    }

    /* access modifiers changed from: private */
    fun setLoadingDate() {
        val str: String
        if (prefsImpl.dateDB == null) {
            str = ""
        } else {
            str = context.resources.getString(
                R.string.download_date_x, *arrayOf<Any>(
                    prefsImpl.dateDB!!
                )
            )
            Intrinsics.checkExpressionValueIsNotNull(
                str,
                "context.resources.getStr…x, prefsImpl.getDateDB())"
            )
        }
        dateDb.postValue(str)
    }

    fun downloadAllDataFromServer() {
        projectsPages = 1
        tagsPages = 1
        markersPages = 1
        progress.postValue(0)
        progressVisibility.postValue(true)
        projectList
        tags
    }

    val projectList: Unit
        /* access modifiers changed from: private */
        get() {
         //   launchIO(`SettingsViewModel$getProjectList$1`(this, null as Continuation<*>?))
        }
    val templateList: Unit
        /* access modifiers changed from: private */
        get() {
           // launchIO(`SettingsViewModel$getTemplateList$1`(this, null as Continuation<*>?))
        }
    val tags: Unit
        /* access modifiers changed from: private */
        get() {
          //  launchIO(`SettingsViewModel$getTags$1`(this, null as Continuation<*>?))
        }
    val markerList: Unit
        /* access modifiers changed from: private */
        get() {
           // launchIO(`SettingsViewModel$getMarkerList$1`(this, null as Continuation<*>?))
        }
    val markerDetails: Unit
        /* access modifiers changed from: private */
        get() {
            var i: Int
            val arrayList: ArrayList<*> = ArrayList<Any?>()
            var i2 = 1
            while (true) {
                i = 0
                if (i2 <= 0) {
                    break
                }
                val i3 = i2 + 1
                val findAll: Collection<*> = markerRepository.findAll(i2)
                i2 = if (!findAll.isEmpty()) {
                    arrayList.addAll(findAll as Collection<Nothing>)
                    i3
                } else {
                    0
                }
            }
            for (next in arrayList) {
                val i4 = i + 1
                if (i < 0) {
                    throw IndexOutOfBoundsException("")
                }
//                launchIO<Unit>(
//                    `SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1`(
//                        next as MarkerModel,
//                        i,
//                        null as Continuation<*>?,
//                        this,
//                        arrayList
//                    )
//                )
                i = i4
            }
        }

    /* access modifiers changed from: private */
    fun insertProjectEntityList(list: List<ProjectModel?>?) {
        projectRepository.addProjectList(list)
    }

    /* access modifiers changed from: private */
    fun insertTagEntityList(list: List<TagModel?>?) {
        tagRepository.addTagList(list)
    }

    /* access modifiers changed from: private */
    fun insertTemplateEntityList(list: List<TemplateModel?>?) {
        templateRepository.addWithReplace(list)
    }

    /* access modifiers changed from: private */
    fun insertMarkerEntityList(list: List<MarkerModel?>?) {
        markerRepository.addWithReplace(list)
    }

    /* access modifiers changed from: private */
    fun insertMarkerEntity(markerModel: MarkerModel?) {
        markerRepository.addWithReplace(markerModel)
    }

    fun saveMarkerSize(f: Float) {
        prefsImpl.markerSize = f
    }

    val markerSize: Float
        get() = prefsImpl.markerSize
}
