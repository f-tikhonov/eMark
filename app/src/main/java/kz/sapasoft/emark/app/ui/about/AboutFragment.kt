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
import com.example.decompiledapk.R
import dagger.android.support.DaggerFragment
import kz.sapasoft.emark.app.databinding.FragmentAboutBinding
import kz.sapasoft.emark.app.ui.MainActivity
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
        return layoutInflater.inflate(R.layout.fragment_about, viewGroup, false)
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        Intrinsics.checkParameterIsNotNull(view, "view")
        super.onViewCreated(view, bundle)
        initView(view)
        setObservers()
        setListeners()
    }

    private fun initView(view: View) {
        val textView = view.findViewById(R.id.tv_toolbar) as TextView?
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_toolbar")
        textView!!.text = getString(R.string.nav_item_about)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)?.setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar?)
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
