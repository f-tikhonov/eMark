package kz.sapasoft.emark.app.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.InputDeviceCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import kz.sapasoft.emark.app.databinding.FragmentSettingsBinding
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel
import kz.sapasoft.emark.app.utils.MarkerDrawer
import kz.ss.emark.R
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class SettingsFragment : DaggerFragmentExtended() {

    private val TAG: String
    private var `_$_findViewCache`: HashMap<*, *>? = null
    private val `viewModel$delegate`: SettingsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(SettingsViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: SettingsViewModel
        /* access modifiers changed from: private */
        get() = `viewModel$delegate` as SettingsViewModel

    private fun setObservers() {}
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
       // this.`_$_findViewCache`!![Integer.valueOf(i)] = findViewById
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
        val fragmentSettingsBinding: FragmentSettingsBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater,
                R.layout.fragment_settings,
                viewGroup,
                false
            ) as FragmentSettingsBinding
        Intrinsics.checkExpressionValueIsNotNull(fragmentSettingsBinding, "binding")
        fragmentSettingsBinding.setLifecycleOwner(this)
        fragmentSettingsBinding.setViewModel(viewModel)
        return fragmentSettingsBinding.getRoot()
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
        textView.text = getString(R.string.nav_item_settings)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)?.setSupportActionBar(`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.toolbar) as Toolbar)
            val activity2: FragmentActivity? = getActivity()
            if (activity2 != null) {
                val supportActionBar: ActionBar? = (activity2 as MainActivity?)?.getSupportActionBar()
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false)
                }
                (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.iv_circle) as ImageView).setImageDrawable(
                    MarkerDrawer.INSTANCE.makeCircle(
                        InputDeviceCompat.SOURCE_ANY,
                        viewModel.markerSize
                    )
                )
                val seekBar: SeekBar =
                    `_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.sb_size) as SeekBar
                Intrinsics.checkExpressionValueIsNotNull(seekBar, "sb_size")
                seekBar.setProgress(viewModel.markerSize.toInt() - 20)
                return
            }
            throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
        }
        throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
    }

    private fun setListeners() {
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.btn_download) as MaterialButton).setOnClickListener(
            `SettingsFragment$setListeners$1`(this)
        )
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.sw_offline) as SwitchMaterial).setOnCheckedChangeListener(
            `SettingsFragment$setListeners$2`(this)
        )
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.sb_size) as SeekBar).setOnSeekBarChangeListener(
            `SettingsFragment$setListeners$3`(this)
        )
    }

    companion object {

        fun newInstance(): Fragment {
            val settingsFragment = SettingsFragment()
            settingsFragment.arguments = Bundle()
            return settingsFragment
        }
    }
}
