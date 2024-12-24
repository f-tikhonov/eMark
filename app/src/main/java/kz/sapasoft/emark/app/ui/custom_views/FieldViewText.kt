package kz.sapasoft.emark.app.ui.custom_views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import com.example.decompiledapk.R
import com.google.android.material.textview.MaterialTextView
import kz.sapasoft.emark.app.domain.model.FieldModel
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener

class FieldViewText @JvmOverloads constructor(
    context: Context,
    private var mField: FieldModel,
    listener: OnFieldValueChangeListener,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FieldView(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_field_text, this)
        findViewById<MaterialTextView>(R.id.tv_title).text = mField.name
        findViewById<EditText>(R.id.et_text).apply {
            setText(mField.textValue)
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    // listener.onFieldValueChange(mField)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // No action needed here
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    listener.onFieldValueChange()
                }
            })
        }
    }

    override fun getFieldModel(): FieldModel {
        val editText = findViewById<EditText>(R.id.et_text)
        mField.textValue = editText.text.toString()
        return mField
    }

    override fun setFieldModel(field: FieldModel) {
        mField = field.copy()
        findViewById<EditText>(R.id.et_text).setText(mField.textValue)
    }

    override fun isRequired(): Boolean {
        return mField.required ?: false
    }

    override fun hasValue(): Boolean {
        val editText = findViewById<EditText>(R.id.et_text)
        return editText.text.isNotEmpty()
    }
}