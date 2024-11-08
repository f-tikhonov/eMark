package kz.sapasoft.emark.app.ui.photo

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.button.MaterialButton
import dagger.android.support.DaggerAppCompatActivity
import kz.sapasoft.emark.app.di.builder.ActivityBuilder_BindPhotoActivity
import kz.ss.emark.R
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class PhotoActivity : DaggerAppCompatActivity() {
    private val TAG = javaClass.simpleName
    private var `_$_findViewCache`: HashMap<*, *>? = null
    private val `viewModel$delegate`: PhotoViewModel by lazy {
        TODO()
        //PhotoViewModel()
    }

    @JvmField
    @Inject
    var viewModelFactory: ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory? = null
    val viewModel: PhotoViewModel
        /* access modifiers changed from: private */
        get() = `viewModel$delegate` as PhotoViewModel

    fun `_$_clearFindViewByIdCache`() {
        val hashMap = `_$_findViewCache`
        hashMap?.clear()
    }

    fun `_$_findCachedViewById`(i: Int): View {
        if (`_$_findViewCache` == null) {
            `_$_findViewCache` = HashMap<Any?, Any?>()
        }
        val view = `_$_findViewCache`!![Integer.valueOf(i)] as View?
        if (view != null) {
            return view
        }
        val findViewById = findViewById<View>(i)
        //`_$_findViewCache`!![Integer.valueOf(i)] = findViewById
        return findViewById
    }

    fun getViewModelFactory(): ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory? {
        val factory: ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory? = viewModelFactory
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory")
        }
        return factory
    }

    fun setViewModelFactory(factory: ActivityBuilder_BindPhotoActivity.PhotoActivitySubcomponent.Factory?) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>")
        viewModelFactory = factory
    }

    /* access modifiers changed from: protected */
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_welcome)
        setOnClickListeners()
        setObservers()
    }

    private fun setOnClickListeners() {
        (`_$_findCachedViewById`(kz.sapasoft.emark.app.R.id.btn_start) as MaterialButton).setOnClickListener(
            `PhotoActivity$setOnClickListeners$1`(this)
        )
    }

    private fun setObservers() {
        val lifecycleOwner: LifecycleOwner = this
        viewModel.isRefreshing.observe(lifecycleOwner, `PhotoActivity$setObservers$1`<Any?>(this))
        viewModel.loginData.observe(lifecycleOwner, `PhotoActivity$setObservers$2`<Any?>(this))
        viewModel.error.observe(lifecycleOwner, `PhotoActivity$setObservers$3`<Any?>(this))
    }
}
