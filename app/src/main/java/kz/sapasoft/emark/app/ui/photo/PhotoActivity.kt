package kz.sapasoft.emark.app.ui.photo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.android.support.DaggerAppCompatActivity
import kz.sapasoft.emark.app.ui.MainActivity
import kz.sapasoft.emark.app.ui.welcome.WelcomeViewModel
import kz.ss.emark.R
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class PhotoActivity : DaggerAppCompatActivity() {
    private val TAG = javaClass.simpleName
    private val `viewModel$delegate`: PhotoViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PhotoViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: PhotoViewModel
        /* access modifiers changed from: private */
        get() = `viewModel$delegate` as PhotoViewModel

    /* access modifiers changed from: protected */
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_welcome)
        setOnClickListeners()
        setObservers()
    }

    private fun setOnClickListeners() {

        findViewById<MaterialButton>(R.id.btn_start).setOnClickListener {
            // Hide the keyboard
           // Utils.hideKeyboard(it)

            // Access the view model and input fields
            val username = findViewById<TextInputEditText>(R.id.et_username)?.text.toString()
            val password = findViewById<TextInputEditText>(R.id.et_password)?.text.toString()
            val server = findViewById<TextInputEditText>(R.id.et_server)?.text.toString()

            // Perform login action
            viewModel.login(username, password, server)
        }
    }

    private fun setObservers() {
        val lifecycleOwner: LifecycleOwner = this
        viewModel.isRefreshing.observe(lifecycleOwner) { isRefreshing ->
            val startButton = findViewById<MaterialButton>(R.id.btn_start)
            startButton?.isEnabled = isRefreshing?.not() ?: true
        }
        viewModel.loginData.observe(lifecycleOwner) { isLoggedIn ->
            if (isLoggedIn == true) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        viewModel.error.observe(lifecycleOwner) { error ->
            val startButton = findViewById<MaterialButton>(R.id.btn_start)
            val errorMessage = error?.toString() ?: getString(R.string.error)
            startButton?.let {
                Snackbar.make(it, errorMessage, Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}
