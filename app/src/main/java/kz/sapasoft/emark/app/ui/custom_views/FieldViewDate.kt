package kz.sapasoft.emark.app.ui.custom_views

import android.app.DatePickerDialog
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import kz.sapasoft.emark.app.R
import kz.sapasoft.emark.app.domain.model.FieldModel
import kz.sapasoft.emark.app.ui.marker.OnFieldValueChangeListener
import kz.sapasoft.emark.app.utils.DateConverter
import java.util.*

class FieldViewDate @JvmOverloads constructor(
    context: Context,
    field: FieldModel,
    private val listener: OnFieldValueChangeListener,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FieldView(context, attrs, defStyleAttr) {

    private val dialogListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateInMillis = calendar.timeInMillis
        mField.dateValue = dateInMillis
        val textView: TextView = findViewById(R.id.tv_text)
        textView.text = DateConverter.millisToString(dateInMillis, "dd.MM.yyyy")
        listener.onFieldValueChange()
    }

    private var mField: FieldModel = field.copy()

    init {
        LayoutInflater.from(context).inflate(R.layout.view_field_date, this as LinearLayout, true)

        findViewById<TextView>(R.id.tv_title).text = mField.name
        findViewById<TextView>(R.id.tv_text).apply {
            text = DateConverter.millisToString(mField.dateValue, "dd.MM.yyyy")

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

        findViewById<LinearLayout>(R.id.ll_root).setOnClickListener {
            val calendar = Calendar.getInstance().apply {
                timeInMillis = mField.dateValue ?: System.currentTimeMillis()
            }
            DatePickerDialog(
                context, dialogListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun getFieldModel(): FieldModel {
        mField.dateValue = DateConverter.stringToMillis(
            findViewById<TextView>(R.id.tv_text).text.toString(),
            "dd.MM.yyyy"
        )
        return mField
    }

    override fun setFieldModel(fieldModel: FieldModel) {
        mField = fieldModel.copy()
        findViewById<TextView>(R.id.tv_text).text = DateConverter.millisToString(mField.dateValue, "dd.MM.yyyy")
    }

    override fun isRequired(): Boolean {
        return mField.required ?: false
    }

    override fun hasValue(): Boolean {
        return !findViewById<TextView>(R.id.tv_text).text.isNullOrEmpty()
    }
}