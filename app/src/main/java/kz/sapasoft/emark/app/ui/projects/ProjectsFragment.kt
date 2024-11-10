package kz.sapasoft.emark.app.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kz.sapasoft.emark.app.databinding.FragmentProjectsBinding
import kz.sapasoft.emark.app.domain.model.ProjectModel
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.map.MapFragment
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter
import kz.sapasoft.emark.app.ui.projects.adapter.ProjectsAdapter.OnProjectClickListener
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel
import kz.ss.emark.R
import java.util.ArrayList
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class ProjectsFragment : DaggerFragmentExtended(), OnProjectClickListener {
    private val TAG: String
    private var `_$_findViewCache`: HashMap<*, *>? = null
    private val `adapter$delegate`: ProjectsAdapter by lazy {
            ProjectsAdapter(emptyList<ProjectModel>() as ArrayList<ProjectModel>?, this)
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

    override fun `_$_clearFindViewByIdCache`() {
        val hashMap = this.`_$_findViewCache`
        hashMap?.clear()
    }

    override fun `_$_findCachedViewById`(i: Int): View? {
        if (this.`_$_findViewCache` == null) {
            this.`_$_findViewCache` = HashMap<Any?, Any?>()
        }
        val view = this.`_$_findViewCache`!![Integer.valueOf(i)] as View?
        if (view != null) {
            return view
        }
        val view2 = getView() ?: return null
        val findViewById = view2.findViewById<View>(i)
      //  this.`_$_findViewCache`!![Integer.valueOf(i)] = findViewById
        return findViewById
    }

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
    ): View? {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater")
        val fragmentProjectsBinding: FragmentProjectsBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater,
                R.layout.fragment_projects,
                viewGroup,
                false
            ) as FragmentProjectsBinding
        Intrinsics.checkExpressionValueIsNotNull(fragmentProjectsBinding, "binding")
        fragmentProjectsBinding.setLifecycleOwner(this)
        fragmentProjectsBinding.setViewModel(viewModel)
        return fragmentProjectsBinding.getRoot()
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        Intrinsics.checkParameterIsNotNull(view, "view")
        super.onViewCreated(view, bundle)
        initView()
        setObservers()
        setListeners()
    }

    private fun initView() {
        val textView = `_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.tv_toolbar) as TextView
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar")
        textView.text = getString(R.string.nav_item_main)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)!!.setSupportActionBar(`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.toolbar) as Toolbar)
            val activity2: FragmentActivity? = getActivity()
            if (activity2 != null) {
                val supportActionBar: ActionBar = (activity2 as MainActivity?)!!.getSupportActionBar()!!
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false)
                }
                initRecyclerView()
                (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.swipe) as SwipeRefreshLayout).setOnRefreshListener(
                    `ProjectsFragment$initView$1`(this)
                )
                return
            }
            throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
        }
        throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView =
            `_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.rv_main_home) as RecyclerView
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_main_home")
        recyclerView.setLayoutManager(linearLayoutManager)
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.rv_main_home) as RecyclerView).addItemDecoration(
            DividerItemDecoration(
                context, linearLayoutManager.getOrientation()
            )
        )
        val recyclerView2: RecyclerView =
            `_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.rv_main_home) as RecyclerView
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

    private fun setListeners() {
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.tv_retry) as TextView).setOnClickListener(
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
