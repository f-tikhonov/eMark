package kz.sapasoft.emark.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("template")
data class TemplateModel(
    @PrimaryKey val id: String = "",
    val createdById: String = "",
    val created: Long = 0L,
    val updatedById: String? = "",
    val updated: Long = 0L,
    val privileges: List<String>? = emptyList(),
    val frontData: String = "",
    val name: String = "",
    val descr: String = "",
    val fields: List<FieldModel> = emptyList(),
    val color: String = "",
    val markerModels: Map<String, String> = emptyMap(),
    val markerTypes: List<String> = emptyList()
) : Serializable
