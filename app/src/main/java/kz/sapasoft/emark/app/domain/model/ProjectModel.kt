package kz.sapasoft.emark.app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("project")
data class ProjectModel(
    @PrimaryKey var id: String,
    val markerTemplateIds: List<String>,
    val name: String,
    val regionName: String
) : Serializable
