package dev7.id.pluginappsclient.presenters.activities

import dev7.id.pluginappsclient.contracts.activities.LoginActivityContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.utilities.PluginUtils
import dev7.id.pluginappsclient.webservices.PluginAPI
import dev7.id.pluginappsclient.webservices.WrappedListResponse
import dev7.id.pluginappsclient.webservices.WrappedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(view : LoginActivityContract.View?) : LoginActivityContract.Interactor {

    private var view : LoginActivityContract.View? = view
    private var api = PluginAPI.instance()

    override fun validate(id: String, pass: String) : Boolean{
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

    override fun login(member_id: String, password: String) {
        view?.isLoading(state = true)
        api.login(member_id, password).enqueue(object : Callback<WrappedResponse<User>>{
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<WrappedResponse<User>>,
                response: Response<WrappedResponse<User>>
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }

    override fun destroy() { view = null }
}