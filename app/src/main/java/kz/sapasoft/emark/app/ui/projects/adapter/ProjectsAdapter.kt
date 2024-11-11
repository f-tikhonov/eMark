package kz.sapasoft.emark.app.ui.projects.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.decompiledapk.R
import kz.sapasoft.emark.app.domain.model.ProjectModel

class ProjectsAdapter(
    private var items: ArrayList<ProjectModel> = ArrayList(),
    private val listener: OnProjectClickListener
) : RecyclerView.Adapter<ProjectsAdapter.SimpleHolder>() {

    interface OnProjectClickListener {
        fun onProjectClick(projectModel: ProjectModel)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        val projectModel = items[position]
        holder.bind(projectModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
        return SimpleHolder(view)
    }

    fun add(list: List<ProjectModel>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    inner class SimpleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val projectName: TextView = itemView.findViewById(R.id.tv_name_item)
        private val projectDescription: TextView = itemView.findViewById(R.id.tv_year)

        fun bind(projectModel: ProjectModel) {
            projectName.text = projectModel.name
            projectDescription.text = projectModel.regionName

            itemView.setOnClickListener {
                listener.onProjectClick(projectModel)
            }
        }
    }
}