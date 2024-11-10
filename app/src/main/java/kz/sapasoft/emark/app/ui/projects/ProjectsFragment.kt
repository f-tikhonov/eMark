package kz.sapasoft.emark.app.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.decompiledapk.R
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.map.MapFragment
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter.OnProjectClickListener
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class ProjectsFragment : DaggerFragmentExtended(), OnProjectClickListener {
    private val TAG: String
    private var `_$_findViewCache`: HashMap<*, *>? = null
    private val `adapter$delegate`: ProjectsAdapter by lazy {
        ProjectsAdapter(ArrayList(), this)
    }
    private val `viewModel$delegate`: ProjectsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ProjectsViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val adapter: ProjectsAdapter
        /* access modifiers changed from: private */
        get() = `adapter$delegate` as ProjectsAdapter
    val viewModel: ProjectsViewModel
        /* access modifiers changed from: private */
        get() = `viewModel$delegate` as ProjectsViewModel

    /* synthetic */ override fun onDestroyView() {
        super.onDestroyView()
        `_$_clearFindViewByIdCache`()
    }

    init {
        val simpleName = javaClass.simpleName
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName")
        TAG = simpleName
    }

    override fun onCreateView(
        layoutInflater: LayoutInflater,
        viewGroup: ViewGroup?,
        bundle: Bundle?
    ): View {
        return layoutInflater.inflate(R.layout.fragment_projects, viewGroup, false)
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        Intrinsics.checkParameterIsNotNull(view, "view")
        super.onViewCreated(view, bundle)
        initView(view)
        setObservers()
        setListeners(view)
    }

    private fun initView(view: View) {
        val textView = view.findViewById(R.id.tv_toolbar) as TextView
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar")
        textView.text = getString(R.string.nav_item_main)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)!!.setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar)
            val activity2: FragmentActivity? = getActivity()
            if (activity2 != null) {
                val supportActionBar: ActionBar = (activity2 as MainActivity?)!!.getSupportActionBar()!!
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false)
                }
                initRecyclerView(view)
                view.findViewById<SwipeRefreshLayout>(R.id.swipe).setOnRefreshListener(
                    `ProjectsFragment$initView$1`(this)
                )
                return
            }
            throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
        }
        throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
    }

    private fun initRecyclerView(view: View) {
        val linearLayoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView =
            view.findViewById(R.id.rv_main_home) as RecyclerView
        recyclerView.setLayoutManager(linearLayoutManager)
        view.findViewById<RecyclerView>(R.id.rv_main_home).addItemDecoration(
            DividerItemDecoration(
                context, linearLayoutManager.getOrientation()
            )
        )
        val recyclerView2: RecyclerView =
            view.findViewById(R.id.rv_main_home) as RecyclerView
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_main_home")
        recyclerView2.setAdapter(adapter)
    }

    private fun setObservers() {
        val viewModel = viewModel
        viewModel.searchString.observe(
            viewLifecycleOwner,
            `ProjectsFragment$setObservers$$inlined$with$lambda$1`<Any?>(viewModel, this)
        )
        viewModel.projectsData.observe(
            viewLifecycleOwner,
            `ProjectsFragment$setObservers$$inlined$with$lambda$2`<Any?>(this)
        )
        viewModel.error.observe(
            viewLifecycleOwner,
            `ProjectsFragment$setObservers$$inlined$with$lambda$3`<Any?>(this)
        )
    }

    private fun setListeners(view: View) {
        view.findViewById<TextView>(R.id.tv_retry).setOnClickListener(
            `ProjectsFragment$setListeners$1`(this)
        )
    }

    override fun onProjectClick(projectModel: ProjectModel) {
        Intrinsics.checkParameterIsNotNull(projectModel, "projectModel")
        getChildFragmentClickListener().onFragmentAdd(
            MapFragment.Companion.newInstance(
                projectModel,
                null,
                MapFragment()
            )
        )
    }

    companion object {
        fun newInstance(): Fragment {
            val projectsFragment = ProjectsFragment()
            projectsFragment.arguments = Bundle()
            return projectsFragment
        }
    }
}
