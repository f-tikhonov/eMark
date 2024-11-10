package kz.sapasoft.emark.app.ui.about

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
import dagger.android.support.DaggerFragment
import kz.sapasoft.emark.app.databinding.FragmentAboutBinding
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel
import kz.ss.emark.R
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics
class AboutFragment : DaggerFragment() {
    private val TAG: String
    private var `_$_findViewCache`: HashMap<*, *>? = null
    private val `viewModel$delegate`: AboutViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AboutViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun setListeners() {}
    private fun setObservers() {}
    fun `_$_clearFindViewByIdCache`() {
        val hashMap = `_$_findViewCache`
        hashMap?.clear()
    }

    fun `_$_findCachedViewById`(i: Int): View? {
        if (`_$_findViewCache` == null) {
            `_$_findViewCache` = HashMap<Any?, Any?>()
        }
        val view = `_$_findViewCache`!![Integer.valueOf(i)] as View?
        if (view != null) {
            return view
        }
        val view2 = getView() ?: return null
        val findViewById = view2.findViewById<View>(i)
       // `_$_findViewCache`!![Integer.valueOf(i)] = findViewById
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
        val fragmentAboutBinding: FragmentAboutBinding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater,
            R.layout.fragment_about,
            viewGroup,
            false
        ) as FragmentAboutBinding
        Intrinsics.checkExpressionValueIsNotNull(fragmentAboutBinding, "binding")
        return fragmentAboutBinding.getRoot()
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        Intrinsics.checkParameterIsNotNull(view, "view")
        super.onViewCreated(view, bundle)
        initView()
        setObservers()
        setListeners()
    }

    private fun initView() {
        val textView = `_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.tv_toolbar) as TextView?
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar")
        textView!!.text = getString(R.string.nav_item_about)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)?.setSupportActionBar(`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.toolbar) as Toolbar?)
            val activity2: FragmentActivity? = getActivity()
            if (activity2 != null) {
                val supportActionBar: ActionBar? = (activity2 as MainActivity?)?.getSupportActionBar()
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false)
                    return
                }
                return
            }
            throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
        }
        throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
    }

    companion object {
        fun newInstance(): Fragment {
            val aboutFragment = AboutFragment()
            aboutFragment.arguments = Bundle()
            return aboutFragment
        }
    }
}
