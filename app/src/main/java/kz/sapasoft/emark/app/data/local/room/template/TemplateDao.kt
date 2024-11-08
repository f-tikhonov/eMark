package kz.sapasoft.emark.app.data.local.room.template

import kz.sapasoft.emark.app.domain.model.TemplateModel

interface TemplateDao {
    fun deleteAll()
    fun findById(str: String?): List<TemplateModel?>?
    fun insert(list: List<TemplateModel?>?)
}
