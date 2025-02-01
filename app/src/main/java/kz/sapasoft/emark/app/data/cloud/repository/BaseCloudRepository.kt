package kz.sapasoft.emark.app.data.cloud.repository

import kz.sapasoft.emark.app.data.cloud.ResultWrapper
import kz.sapasoft.emark.app.domain.model.ImageDataModel
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import kotlin.coroutines.Continuation

interface BaseCloudRepository {
    suspend fun getImage(queryKey: String): ResultWrapper<MarkerModel?>

    suspend fun getImageData(
        str: String?,
    ): ResultWrapper<List<ImageDataModel>?>

    suspend fun getMarker(str: String?): ResultWrapper<MarkerModel?>

    suspend fun getMarkerList(
        i: Int,
        list: List<String?>,
    ): ResultWrapper<List<MarkerModel>>

    suspend fun getProjectList(
        i: Int,
    ): ResultWrapper<List<ProjectModel>?>

    suspend fun getTagList(
        i: Int,
    ): ResultWrapper<List<TagModel>?>

    suspend fun getTemplateList(
        list: List<String?>?,
    ): ResultWrapper<List<TemplateModel?>?>

    suspend fun login(
        url: String,
        username: String,
        password: String,
    ): ResultWrapper<ResponseBody>

    suspend fun saveImage(
        str: String?,
        part: MultipartBody.Part?,
    ): ResultWrapper<MarkerModel?>

    suspend fun saveMarker(
        markerModelNullable: MarkerModelNullable?,
    ): ResultWrapper<MarkerModel?>
}
