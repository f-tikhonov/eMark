package kz.sapasoft.emark.app.domain.model

import java.io.Serializable
import kz.sapasoft.emark.app.utils.Constants

data class MarkerModel(
    var id: String,
    var updated: Long? = null,
    var templateId: String? = null,
    var markerId: String? = null,
    var markerModel: String? = null,
    var color: String? = null,
    var passiveId: String? = null,
    var projectIds: List<String>? = null,
    var depth: Double? = null,
    var location: List<Double>? = null,
    var fields: List<FieldModel>? = null,
    var generalId: String? = null,
    var markerType: String? = null,
    var idLocal: String? = null,
    var status: Constants.MarkerStatus = Constants.MarkerStatus.NORMAL
) : Serializable {

    fun toNullable(): MarkerModelNullable {
        return MarkerModelNullable(
            id, updated, templateId, markerId, markerModel, color, passiveId,
            projectIds, depth, location, fields, generalId, markerType, idLocal, status
        )
    }

    fun toSync(): MarkerModelSync {
        return MarkerModelSync(
            id, updated, templateId, markerId, markerModel, color, passiveId,
            projectIds, depth, location, fields, generalId, markerType, idLocal, status
        )
    }
}