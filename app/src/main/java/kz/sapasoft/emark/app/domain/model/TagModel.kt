package kz.sapasoft.emark.app.domain.model

import java.io.Serializable

data class TagModel(
    val id: String,
    val createdById: String?,
    val created: Long?,
    val updatedById: String?,
    val updated: Long?,
    val frontData: String?,
    val templateId: String?,
    val name: String?
) : Serializable
