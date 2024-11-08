package kz.sapasoft.emark.app.domain.model

import java.io.Serializable

data class ProjectModel(
    var id: String,
    val markerTemplateIds: List<String>,
    val name: String,
    val regionName: String
) : Serializable
