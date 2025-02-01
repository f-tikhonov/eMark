package kz.sapasoft.emark.app.data.cloud.rest

import kz.sapasoft.emark.app.domain.model.ImageDataModel
import kz.sapasoft.emark.app.domain.model.MarkerModel
import kz.sapasoft.emark.app.domain.model.MarkerModelNullable
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.domain.model.TemplateModel
import kz.sapasoft.emark.app.domain.model.request.GetMarkersRequest
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Query
import retrofit2.http.Url
import kotlin.coroutines.Continuation

interface ApiService {
    @GET("data/getByParent")
    suspend fun getImage(
        @Query("useHints") z: Boolean,
        @Query("width") i: Int,
        @Query("height") i2: Int,
        @Query("queryKey") str: String?,
    ): MarkerModel?

    @POST("data/getByParent")
    suspend fun getImageData(
        @Query("privelege") str: String?,
        @Query("parentType") str2: String?,
        @Query("parentId") str3: String?,
    ): List<ImageDataModel>?

    @POST("marker/getById")
    suspend fun getMarker(
        @Query("id") str: String?,
    ): MarkerModel?

    @POST("marker/getList")
    suspend fun getMarkerList(
        @Body getMarkersRequest: GetMarkersRequest?,
    ): List<MarkerModel>

    @POST("project/getByNamePart")
    suspend fun getProjectList(
        @Query("namePart") namePart: String?,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("light") light: Boolean,
        @Query("calculatePermissions") calculatePermissions: Boolean,
    ): List<ProjectModel>?

    @POST("tag/getByNamePart")
    suspend fun getTagList(
        @Query("namePart") namePart: String?,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): List<TagModel>?

    @POST("markerTemplate/getByIds")
    suspend fun getTemplateList(
        @Query("ids") list: List<String?>?,
    ): List<TemplateModel?>?

    @POST
    suspend fun login(
        @Url url: String,
        @Query("username") username: String,
        @Query("password") password: String,
    ): ResponseBody

    @PUT("data/save")
    @Multipart
    suspend fun saveImage(
        @Query("name") str: String?,
        @Query("descr") str2: String?,
        @Query("contentType") str3: String?,
        @Query("parentType") str4: String?,
        @Query("parentId") str5: String?,
        @Part part: MultipartBody.Part?,
    ): MarkerModel?

    @PUT("marker/save")
    suspend fun saveMarker(
        @Body markerModelNullable: MarkerModelNullable?,
    ): MarkerModel?
}
