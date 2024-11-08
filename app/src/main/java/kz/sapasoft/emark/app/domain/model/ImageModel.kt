package kz.sapasoft.emark.app.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageModel(
    @SerializedName("id_image") val idImage: Int?,
    @SerializedName("id_exhibit") val idExhibit: Int?,
    @SerializedName("url") val url: String?
) : Serializable
