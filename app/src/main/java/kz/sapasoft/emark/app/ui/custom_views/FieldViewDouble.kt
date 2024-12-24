package kz.sapasoft.emark.app.ui.custom_views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.decompiledapk.R
import kz.sapasoft.emark.app.domain.model.FieldModel
import kz.sapasoft.emark.app.domain.model.TagModel
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener

class FieldViewDouble @JvmOverloads constructor(
    context: Context,
    private var field: FieldModel,
    listener: OnFieldValueChangeListener,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FieldView(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_field_double, this)

        findViewById<EditText>(R.id.et_text).apply {
            setText(doubleToString(field.doubleValue))
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

        findViewById<TextView>(R.id.tv_title)?.let {
            it.text = field.name
        }
    }

    override fun getFieldModel(): FieldModel {
        val editText = findViewById<EditText>(R.id.et_text)
        field.doubleValue = stringToDouble(editText.text.toString())
        return field
    }

    override fun setFieldModel(field: FieldModel) {
        this.field.copy(
            name = field.name,
            required = field.required,
            doubleValue = field.doubleValue
        )
        findViewById<EditText>(R.id.et_text).setText(doubleToString(field.doubleValue))
    }

    private fun stringToDouble(string: String): Double? {
        return string.takeIf { it.isNotBlank() }?.toDoubleOrNull()
    }

    private fun doubleToString(double: Double?): String {
        return double?.toString() ?: ""
    }

    override fun isRequired(): Boolean {
        return field.required ?: false
    }

    override fun hasValue(): Boolean {
        val text = findViewById<EditText>(R.id.et_text).text
        return !text.isNullOrEmpty()
    }
}