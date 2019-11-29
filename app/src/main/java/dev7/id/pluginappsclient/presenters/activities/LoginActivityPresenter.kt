package dev7.id.pluginappsclient.presenters.activities

import android.content.Context
import dev7.id.pluginappsclient.contracts.activities.LoginActivityContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.utilities.PluginUtils
import dev7.id.pluginappsclient.webservices.PluginAPI
import dev7.id.pluginappsclient.webservices.WrappedListResponse
import dev7.id.pluginappsclient.webservices.WrappedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class LoginActivityPresenter(v : LoginActivityContract.View?) : LoginActivityContract.Interactor {
    private var view : LoginActivityContract.View? = v
    private var api = PluginAPI.instance_api()

    override fun validate(id: String, pass: String): Boolean {
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

    override fun login(member_id: String, password: String, context: Context) {
        view?.isLoading(state = true)
        api.login(member_id, password).enqueue(object : Callback<WrappedResponse<User>>{
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                view?.toast("tidak dapat terhubung ke server")
                println(t.message)
            }

            override fun onResponse(
                call: Call<WrappedResponse<User>>,
                response: Response<WrappedResponse<User>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body !=null && body.status.equals("true")){
                        PluginUtils.setToken(context, body.data?.api_token!!)
                        println(body.data!!.api_token)
                        view?.toast("Selamat datang ${body.data!!.name}")
                        view?.success()
                    }else{
                        view?.toast("Gagal login. cek username dan password")
                    }

                }else{

                    view?.toast("Ada yang salah, coba lagi nanti")

                }


            }
        })

    }

    override fun destroy() { view = null }
}