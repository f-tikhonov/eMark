package kz.sapasoft.emark.app.ui.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kz.sapasoft.emark.app.domain.model.FieldModel

abstract class FieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var _viewCache: HashMap<Int, View>? = null

    fun _clearFindViewByIdCache() {
        _viewCache?.clear()
    }

    fun _findCachedViewById(id: Int): View? {
        if (_viewCache == null) {
            _viewCache = HashMap()
        }
        return _viewCache?.get(id) ?: findViewById<View>(id).also {
            _viewCache?.put(id, it)
        }
    }

    abstract fun getFieldModel(): FieldModel

    abstract fun hasValue(): Boolean

    abstract fun isRequired(): Boolean

    abstract fun setFieldModel(fieldModel: FieldModel)
}