package kz.sapasoft.emark.app.domain.model

import java.io.Serializable

data class PhotoModel(
    var id: String,
    val markerTemplateIds: List<String>? = null,
    val url: String? = null,
    val regionName: String? = null
) : Serializable
