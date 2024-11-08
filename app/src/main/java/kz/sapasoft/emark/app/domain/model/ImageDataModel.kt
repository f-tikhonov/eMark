package kz.sapasoft.emark.app.domain.model

import java.io.File
import java.io.Serializable

data class ImageDataModel(
    var id: String,
    var localIdParent: String? = null,
    var metadata: MetaData? = null,
    var file: File? = null
) : Serializable {

    data class MetaData(
        var parentId: String? = null,
        var queryKey: String? = null
    )
}