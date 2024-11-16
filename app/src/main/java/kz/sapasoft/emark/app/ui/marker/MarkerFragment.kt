package kz.sapasoft.emark.app.ui.marker

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kz.sapasoft.emark.app.databinding.FragmentMarkerBinding
import kz.sapasoft.emark.app.domain.model.*
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.base.DaggerFragmentExtended
import kz.sapasoft.emark.app.ui.custom_views.*
import kz.sapasoft.emark.app.utils.Constants
import kz.ss.emark.R
import pl.aprilapps.easyphotopicker.EasyImage
import java.util.UUID
import javax.inject.Inject

class MarkerFragment : DaggerFragmentExtended(), OnFieldValueChangeListener, OnMarkerTypeChangeListener, OnImageClickListener {

    private val REQUEST_CAMERA_PERMISSION = 1
    private val TAG: String = this::class.java.simpleName
    private val easyImage by lazy { EasyImage() }
    private val localImageList = ArrayList<ImageDataModel>()
    private val mFieldViewList = ArrayList<FieldView>()
    private var mMarkerModel: MarkerModel? = null
    private var mOnMarkerChangeListener: OnMarkerChangeListener? = null
    private var mProjectModel: ProjectModel? = null
    private var mTagList: List<TagModel>? = null
    private var mTemplateList: List<TemplateModel>? = null
    private val viewModel by lazy { easyImage as MarkerViewModel }
    private var rootView: View? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mProjectModel = requireArguments().getSerializable("projectModel") as? ProjectModel
        mMarkerModel = requireArguments().getSerializable("marker") as? MarkerModel
        rootView =  layoutInflater.inflate(com.example.decompiledapk.R.layout.fragment_marker, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllData(mMarkerModel!!, mProjectModel!!.markerTemplateIds)
        initView(view)
        setListeners(view)
        setObservers()
    }

    private fun initView(view: View) {
        (view.findViewById(R.id.tv_toolbar) as TextView).text = getString(R.string.marker)
        (activity as? MainActivity)?.setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar)
        if (mMarkerModel?.status == null) {
            (view.findViewById(R.id.btn_save) as MaterialButton).visibility = View.GONE
        }
    }

    private fun setListeners(view: View) {
        (view.findViewById(R.id.btn_save) as MaterialButton).setOnClickListener {
            // Save button logic
        }
    }

    private fun setObservers() {
        // Set observers for ViewModel data
    }

    private fun drawMainList(list: List<TemplateModel>) {
        val markerTypeView = rootView?.findViewById(R.id.view_marker_type) as MarkerTypeView
        val templateId = mMarkerModel?.templateId ?: list.first().id
        markerTypeView.setData(list, templateId, this)

        rootView?.findViewById<MarkerIdentifierView>(R.id.view_marker_identifier)?.let { view ->
            (view as MarkerIdentifierView).setData(mMarkerModel?.generalId ?: "", this)
        }

        rootView?.findViewById<MarkerModelView>(R.id.view_marker_model)?.let { view ->
            (view as MarkerModelView).setData(mMarkerModel?.markerModel ?: "")
        }

        (rootView?.findViewById<MarkerDepthView>(R.id.view_marker_depth) as MarkerDepthView).setData(null, this)
        (rootView?.findViewById<MarkerPhotoView>(R.id.view_marker_photo) as MarkerPhotoView).setListeners(this, this)
    }

    private fun drawFieldList(list: List<FieldModel>) {
        (rootView?.findViewById<LinearLayout>(R.id.ll_additional_fields) as LinearLayout).removeAllViews()
        mFieldViewList.clear()
        list.forEach { field ->
            val fieldView = drawField(field)
            mFieldViewList.add(fieldView)
            (rootView?.findViewById<LinearLayout>(R.id.ll_additional_fields) as LinearLayout).addView(fieldView)
        }
    }

    private fun drawField(fieldModel: FieldModel): FieldView {
        val context = requireContext()
        return when (fieldModel.valueType) {
            Constants.FieldTypes.DOUBLE -> FieldViewDouble(context, fieldModel, this)
            Constants.FieldTypes.TEXT -> FieldViewText(context, fieldModel, this)
            Constants.FieldTypes.TAG -> FieldViewSpinner(context, fieldModel, mTagList ?: emptyList(), this)
            Constants.FieldTypes.DATE -> FieldViewDate(context, fieldModel, this)
            Constants.FieldTypes.LONG -> FieldViewLong(context, fieldModel, this)
            Constants.FieldTypes.BOOL -> FieldViewSpinner(context, fieldModel, mTagList ?: emptyList(), this)
            else -> FieldViewText(context, fieldModel, this)
        }
    }

    override fun onAddPhotoClick() {
        if (checkCameraPermission()) {
          //  easyImage.openCameraForImage(this)
        } else {
            requestCameraPermission()
        }
    }

    private fun checkCameraPermission() = ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0

    private fun requestCameraPermission() {
        requestPermissions(arrayOf("android.permission.CAMERA"), REQUEST_CAMERA_PERMISSION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        EasyImage.handleActivityResult(requestCode, resultCode, data, requireActivity()) { images ->
//            // Handle images
//        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CAMERA_PERMISSION && grantResults.firstOrNull() != 0) {
            Snackbar.make(
                rootView?.findViewById<Toolbar>(R.id.toolbar) ?: return,
                getString(R.string.permission_camera_needed),
                BaseTransientBottomBar.LENGTH_INDEFINITE
            ).show()
        }
    }

    private fun constructNewMarkerModel(): MarkerModel {
        val markerModel = mMarkerModel ?: throw UninitializedPropertyAccessException("mMarkerModel")
        val projectModel = mProjectModel ?: throw UninitializedPropertyAccessException("mProjectModel")

        val markerModelCopy = markerModel.copy(
            projectIds = arrayListOf(projectModel.id),
            markerModel = (rootView?.findViewById<MarkerModelView>(R.id.view_marker_model) as MarkerModelView).markerModel,
            markerType = (rootView?.findViewById<MarkerTypeView>(R.id.view_marker_type) as MarkerTypeView).markerType,
            templateId = (rootView?.findViewById<MarkerTypeView>(R.id.view_marker_type) as MarkerTypeView).templateId,
            depth = (rootView?.findViewById<MarkerDepthView>(R.id.view_marker_depth) as MarkerDepthView).getValue(),
            idLocal = markerModel.idLocal ?: UUID.randomUUID().toString(),
            fields = mFieldViewList.map { it.getFieldModel() }
        )
        return markerModelCopy
    }

    override fun onMarkerTypeChange(templateModel: TemplateModel) {
        drawFieldList(templateModel.fields)
        mMarkerModel?.fields?.let {
            //fillFields(it)
        }
    }

    private fun checkMainHasChanges(): Boolean {
        val newMarkerModel = (rootView?.findViewById<MarkerModelView>(R.id.view_marker_model) as MarkerModelView).markerModel
        val currentMarkerModel = mMarkerModel?.markerModel
        val newDepth = (rootView?.findViewById<MarkerDepthView>(R.id.view_marker_depth) as MarkerDepthView).getValue()
        val currentDepth = mMarkerModel?.depth
        return newMarkerModel != currentMarkerModel || newDepth != currentDepth
    }

    private fun checkFieldsHasChanges(): Boolean {
        return mFieldViewList.any { fieldView ->
            mMarkerModel?.fields?.find { it.id == fieldView.getFieldModel().id }?.toString() != fieldView.getFieldModel().toString()
        }
    }

    private fun checkAllRequiredFilled(): Boolean {
        return (rootView?.findViewById<MarkerDepthView>(R.id.view_marker_depth) as MarkerDepthView).hasValue() &&
                mFieldViewList.all { !it.isRequired() || it.hasValue() }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        if (mMarkerModel?.status != null) {
            inflater.inflate(R.menu.marker_menu, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete_local -> {
                viewModel.deleteLocal(mMarkerModel!!)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun newInstance(projectModel: ProjectModel, markerModel: MarkerModel, onMarkerChangeListener: OnMarkerChangeListener?): MarkerFragment {
            return MarkerFragment().apply {
                arguments = bundleOf(
                    "projectModel" to projectModel,
                    "marker" to markerModel
                )
                mOnMarkerChangeListener = onMarkerChangeListener
            }
        }
    }

    override fun onFieldValueChange() {
        (rootView?.findViewById<MaterialButton>(R.id.btn_save) as MaterialButton).isEnabled =
            checkMainHasChanges() || checkFieldsHasChanges()
    }
}