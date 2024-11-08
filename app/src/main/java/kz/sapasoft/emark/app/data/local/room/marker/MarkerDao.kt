package kz.sapasoft.emark.app.data.local.room.marker

import kz.sapasoft.emark.app.domain.model.MarkerModel

interface MarkerDao {
    fun deleteAll()
    fun deleteByProjectId(str: String?)
    fun findAll(i: Int, i2: Int): List<MarkerModel?>?
    fun findByProjectId(str: String?): List<MarkerModel?>?
    fun insertWithReplace(list: List<MarkerModel?>?)
    fun insertWithReplace(markerModel: MarkerModel?)
}
