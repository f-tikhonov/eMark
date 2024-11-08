package kz.sapasoft.emark.app.domain.model

import com.google.gson.annotations.SerializedName

data class EdgeModel(
    @SerializedName("markerId") val markerId: String,
    @SerializedName("lineId") val lineId: String
)