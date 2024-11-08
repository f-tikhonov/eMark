package kz.sapasoft.emark.app.domain.model

import kz.sapasoft.emark.app.utils.Constants
import java.io.Serializable

data class MarkerModelNullable(
    var id: String? = null,
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
) : Serializable
