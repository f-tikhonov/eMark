package kz.sapasoft.emark.app.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FieldModel(
    @SerializedName("createdById") val createdById: String?,
    @SerializedName("created") val created: Long?,
    @SerializedName("updatedById") val updatedById: String?,
    @SerializedName("updated") val updated: Long?,
    @SerializedName("privileges") val privileges: String?,
    @SerializedName("frontData") val frontData: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("descr") val descr: String?,
    @SerializedName("required") val required: Boolean?,
    @SerializedName("readonly") val readonly: Boolean?,
    @SerializedName("fieldWidget") val fieldWidget: String?,
    @SerializedName("valueType") val valueType: String?,
    @SerializedName("textValue") var textValue: String?,
    @SerializedName("longValue") var longValue: Long?,
    @SerializedName("doubleValue") var doubleValue: Double?,
    @SerializedName("boolValue") var boolValue: String?,
    @SerializedName("tagTemplateId") val tagTemplateId: String?,
    @SerializedName("tagValue") var tagValue: TagModel?,
    @SerializedName("dateValue") var dateValue: Long?
) : Serializable