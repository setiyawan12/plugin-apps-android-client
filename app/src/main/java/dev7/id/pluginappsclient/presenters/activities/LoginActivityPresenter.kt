package dev7.id.pluginappsclient.presenters.activities

import android.content.Context
import dev7.id.pluginappsclient.contracts.activities.LoginActivityContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.utilities.PluginUtils
import dev7.id.pluginappsclient.webservices.PluginAPI
<<<<<<< HEAD
=======
import dev7.id.pluginappsclient.webservices.WrappedListResponse
>>>>>>> 1f1522fab87ea84fa498a980ae8cca2c5f5a8c01
import dev7.id.pluginappsclient.webservices.WrappedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
<<<<<<< HEAD

class LoginActivityPresenter(v : LoginActivityContract.View?) : LoginActivityContract.Interactor {
    private var view : LoginActivityContract.View? = v
    private var api = PluginAPI.instance_api()

    override fun validate(id: String, pass: String): Boolean {
=======

class LoginActivityPresenter(view : LoginActivityContract.View?) : LoginActivityContract.Interactor {

    private var view : LoginActivityContract.View? = view
    private var api = PluginAPI.instance()

    override fun validate(id: String, pass: String) : Boolean{
>>>>>>> 1f1522fab87ea84fa498a980ae8cca2c5f5a8c01
        view?.idError(null)
        view?.passwordError(null)
        if(!PluginUtils.isValidId(id)){
            view?.idError("ID Plugin Tidak Valid")
            return false
        }
        if(!PluginUtils.isValidPassword(pass)){
            view?.passwordError("Password tidak valid")
            return false
        }
        return true
    }

<<<<<<< HEAD
    override fun login(member_id: String, password: String, context: Context) {
        view?.isLoading(state = true)
        api.login(member_id, password).enqueue(object : Callback<WrappedResponse<User>>{
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                view?.toast("tidak dapat terhubung ke server")
                println(t.message)
=======
    override fun login(member_id: String, password: String) {
        view?.isLoading(state = true)
        api.login(member_id, password).enqueue(object : Callback<WrappedResponse<User>>{
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
>>>>>>> 1f1522fab87ea84fa498a980ae8cca2c5f5a8c01
            }

            override fun onResponse(
                call: Call<WrappedResponse<User>>,
                response: Response<WrappedResponse<User>>
            ) {
<<<<<<< HEAD
                if (response.isSuccessful){
                    val body = response.body()
                    if (body !=null && body.status.equals("true")){
                        PluginUtils.setToken(context, body.data?.api_token!!)
                        println(body.data?.api_token)
                        view?.toast("Selamat datang ${body.data!!.name}")
                        view?.success()
                    }else{
                        view?.toast("Gagal login. cek username dan password")
                    }

                }else{

                    view?.toast("Ada yang salah, coba lagi nanti")

                }


            }
=======
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

>>>>>>> 1f1522fab87ea84fa498a980ae8cca2c5f5a8c01
        })

    }

    override fun destroy() { view = null }
}