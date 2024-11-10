package kz.sapasoft.emark.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("tag")
data class TagModel(
    @PrimaryKey val id: String,
    val createdById: String?,
    val created: Long?,
    val updatedById: String?,
    val updated: Long?,
    val frontData: String?,
    val templateId: String?,
    val name: String?
) : Serializable
