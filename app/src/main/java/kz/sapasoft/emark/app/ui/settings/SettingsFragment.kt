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
import com.example.decompiledapk.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import kz.sapasoft.emark.app.databinding.FragmentSettingsBinding
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel
import kz.sapasoft.emark.app.utils.MarkerDrawer
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
        return layoutInflater.inflate(R.layout.fragment_settings, viewGroup, false)
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
        textView.text = getString(R.string.nav_item_settings)
        val activity: FragmentActivity? = activity
        if (activity != null) {
            (activity as MainActivity?)?.setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar)
            val activity2: FragmentActivity? = getActivity()
            if (activity2 != null) {
                val supportActionBar: ActionBar? = (activity2 as MainActivity?)?.getSupportActionBar()
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(false)
                }
                (view.findViewById(R.id.iv_circle) as ImageView).setImageDrawable(
                    MarkerDrawer.INSTANCE.makeCircle(
                        InputDeviceCompat.SOURCE_ANY,
                        viewModel.markerSize
                    )
                )
                val seekBar: SeekBar =
                    view.findViewById(R.id.sb_size) as SeekBar
                Intrinsics.checkExpressionValueIsNotNull(seekBar, "sb_size")
                seekBar.setProgress(viewModel.markerSize.toInt() - 20)
                return
            }
            throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
        }
        throw TypeCastException("null cannot be cast to non-null type kz.sapasoft.emark.app.ui.MainActivity")
    }

    private fun setListeners(view: View) {
        (view.findViewById<MaterialButton>(R.id.btn_download) as MaterialButton).setOnClickListener(
            `SettingsFragment$setListeners$1`(this)
        )
        (view.findViewById<SwitchMaterial>(R.id.sw_offline) as SwitchMaterial).setOnCheckedChangeListener(
            `SettingsFragment$setListeners$2`(this)
        )
        (view.findViewById<SeekBar>(R.id.sb_size) as SeekBar).setOnSeekBarChangeListener(
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
