package kz.sapasoft.emark.app.domain.model.request

data class GetMarkersRequest(
    val offset: Int,
    val limit: Int,
    val privilege: String,
    val projectIds: List<String>,
    val lineIds: List<String>
)