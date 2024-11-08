package kz.sapasoft.emark.app.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginModel(
    @SerializedName("status") val status: Int,
    @SerializedName("error") val error: String?,
    @SerializedName("message") val message: String?
) : Serializable
