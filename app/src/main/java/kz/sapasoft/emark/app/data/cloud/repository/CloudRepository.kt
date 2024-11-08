package kz.sapasoft.emark.app.data.cloud.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.data.cloud.rest.ApiService
import kz.sapasoft.emark.app.domain.model.ImageDataModel
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import okhttp3.MultipartBody
import okhttp3.ResponseBody

class CloudRepository(
    apiService: ApiService,
    coroutineDispatcher: CoroutineDispatcher
) : BaseCloudRepository {

    val apIs: ApiService
    private val dispatcher: CoroutineDispatcher

    init {
        apIs = apiService
        dispatcher = coroutineDispatcher
    }

    constructor(
        apiService: ApiService,
        coroutineDispatcher: CoroutineDispatcher?,
        i: Int,
    ) : this(apiService, (if (i and 2 != 0) IO else coroutineDispatcher)!!)

    override suspend fun getImage(str: String?): ResultWrapper<MarkerModel?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            apIs.getImage(true, 600, 600, str, this)
//        )
    }

    override suspend fun getImageData(str: String?): ResultWrapper<out MutableList<ImageDataModel?>?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$getImageData$2`(this, str, null as Continuation<*>?),
//            continuation
//        )
    }

    override suspend fun getMarker(str: String?): ResultWrapper<MarkerModel?>? {
        TODO("Not yet implemented")
    }

    override suspend fun getMarkerList(
        i: Int,
        list: List<String?>?
    ): ResultWrapper<out MutableList<MarkerModel?>?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$getMarkerList$2`(
//                this,
//                GetMarkersRequest(
//                    (i - 1) * RoomDatabase.MAX_BIND_PARAMETER_CNT,
//                    RoomDatabase.MAX_BIND_PARAMETER_CNT,
//                    "VIEW_MarkerEntity",
//                    list,
//                    emptyList<String>()
//                ),
//                null as Continuation<*>?
//            ),
//            continuation
//        )
    }

    override suspend fun getProjectList(i: Int): ResultWrapper<out MutableList<ProjectModel?>?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$getProjectList$2`(this, i, null as Continuation<*>?),
//            continuation
//        )
    }

    override suspend fun getTagList(i: Int): ResultWrapper<out MutableList<TagModel?>?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$getTagList$2`(this, i, null as Continuation<*>?),
//            continuation
//        )
    }

    override suspend fun getTemplateList(list: List<String?>?): ResultWrapper<out MutableList<TemplateModel?>?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$getTemplateList$2`(this, list, null as Continuation<*>?),
//            continuation
//        )
    }

    override suspend fun login(
        str: String?,
        str2: String?,
        str3: String?
    ): ResultWrapper<out ResponseBody?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            apIs.login(str = str, str2 = str2, str3 = str3)
//        )
    }

    override suspend fun saveImage(
        str: String?,
        part: MultipartBody.Part?
    ): ResultWrapper<MarkerModel?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$saveImage$2`(this, str, part, null as Continuation<*>?),
//            continuation
//        )
    }

    override suspend fun saveMarker(markerModelNullable: MarkerModelNullable?): ResultWrapper<MarkerModel?>? {
        return null
//        return safeApiCall(
//            dispatcher,
//            `CloudRepository$saveMarker$2`(this, markerModelNullable, null as Continuation<*>?),
//            continuation
//        )
    }
}
