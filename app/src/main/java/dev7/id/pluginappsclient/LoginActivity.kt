package dev7.id.pluginappsclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import dev7.id.pluginappsclient.contracts.activities.LoginActivityContract
import dev7.id.pluginappsclient.presenters.activities.LoginActivityPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginActivityContract.View{
    private var presenter = LoginActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun toast(message: String) = Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()

    override fun success() = startActivity(Intent(this@LoginActivity, MainActivity::class.java)).also { finish() }

    override fun isLoading(state: Boolean) { btnLogin.isEnabled = !state }

    override fun idError(err: String?) { inId.error = err }

    override fun passwordError(err: String?) { inPass.error = err }

}
