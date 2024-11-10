package kz.sapasoft.emark.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("template")
data class TemplateModel(
    @PrimaryKey val id: String,
    val createdById: String,
    val created: Long,
    val updatedById: String,
    val updated: Long,
    val privileges: List<String>,
    val frontData: String,
    val name: String,
    val descr: String,
    val fields: List<FieldModel>,
    val color: String,
    val markerModels: Map<String, String>,
    val markerTypes: List<String>
) : Serializable
