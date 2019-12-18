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
        supportActionBar?.hide()
        presenter = LoginActivityPresenter(this)
        dologin()



    }


    private fun dologin(){
        btnLogin.setOnClickListener{
            val  i = etId.text.toString().trim()
            val p = etPass.text.toString().trim()
            if (i.isNotEmpty() && p.isNotEmpty()){
                if (p.length > 6){
                    presenter.login(i, p, this@LoginActivity)
                }else{
                    toast("password harus lebih dari 6 karakter")
                }
            }else{
                toast("tolong isikan semua kolom")
            }

        }
    }



    override fun toast(message: String) = Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()

    override fun success() = startActivity(Intent(this@LoginActivity, MainActivity::class.java)).also { finish() }

    override fun isLoading(state: Boolean) { btnLogin.isEnabled = !state }

    override fun idError(err: String?) { inId.error = err }

    override fun passwordError(err: String?) { inPass.error = err }

    override fun notConect() {
        btnLogin.isEnabled = true
    }


}


