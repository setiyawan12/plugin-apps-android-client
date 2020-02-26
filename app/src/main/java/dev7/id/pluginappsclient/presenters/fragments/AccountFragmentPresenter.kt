package dev7.id.pluginappsclient.presenters.fragments

import dev7.id.pluginappsclient.contracts.fragments.AccountFragmentContract
import dev7.id.pluginappsclient.models.Personal
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.webservices.PluginAPI
import dev7.id.pluginappsclient.webservices.WrappedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountFragmentPresenter (private var view : AccountFragmentContract.View?) : AccountFragmentContract.Interactor {
    private var api = PluginAPI.instance()

    override fun destroy() { view = null }

    override fun fetchMyProfile(token : String) {
        view?.isLoading(true)
        println(token)
        api.myProfile(token).enqueue(object : Callback<WrappedResponse<User>>{
            override fun onFailure(call: Call<WrappedResponse<User>>, t: Throwable) {
                view?.isLoading(false)
                view?.toast(t.message.toString())
                println(t.message)
            }

            override fun onResponse(call: Call<WrappedResponse<User>>, response: Response<WrappedResponse<User>>) {
                if(response.isSuccessful){
                    val data = response.body() as WrappedResponse<User>
                    if(data.status){
                        data.data?.let {
                            view?.retrieveMyProfile(it)
                        }
                    }
                }else{
                    view?.toast("Tidak dapat memuat data user")
                    println(response.code())
                }
                view?.isLoading(false)
            }
        })
    }

    fun updatePersonal(token : String, personal : Personal){
        view?.isLoading(true)
        api.updatePersonal(token, personal).enqueue(object : Callback<WrappedResponse<Personal>>{
            override fun onFailure(call: Call<WrappedResponse<Personal>>, t: Throwable) {
                println(t.message)
                view?.isLoading(false)
                view?.toast(t.message.toString())
            }

            override fun onResponse(call: Call<WrappedResponse<Personal>>, response: Response<WrappedResponse<Personal>>) {
                if(response.isSuccessful){
                    val body = response.body() as WrappedResponse<Personal>
                    if(body.status){
                        body.data?.let {
                            view?.toast("Berhasil update")
                        }
                    }else{
                        view?.toast("Tidak dapat mengupdate profile")
                    }
                }else{
                    view?.toast("Tidak dapat mengupdate profile")
                }
                view?.isLoading(false)
            }

        })
    }

}