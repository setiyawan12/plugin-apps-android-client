package dev7.id.pluginappsclient.presenters.fragments

import dev7.id.pluginappsclient.contracts.fragments.DashboardFragmentContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.webservices.PluginAPI
import dev7.id.pluginappsclient.webservices.WrappedListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardFragmentPresenter(private var view : DashboardFragmentContract.View?) : DashboardFragmentContract.Interactor {
    private var api = PluginAPI.instance()

    override fun allUser(api_token: String) {
        view?.isLoading(true)
        api.users(api_token).enqueue(object : Callback<WrappedListResponse<User>>{
            override fun onFailure(call: Call<WrappedListResponse<User>>, t: Throwable) {
                view?.isLoading(false)
                view?.toast(t.message.toString())
            }

            override fun onResponse(call: Call<WrappedListResponse<User>>, response: Response<WrappedListResponse<User>>) {
                if(response.isSuccessful){
                    val data = response.body() as WrappedListResponse<User>
                    data.data?.let {
                        view?.attachToRecycler(it)
                    }
                }else{
                    view?.toast("Something went wrong")
                }
                view?.isLoading(false)
            }
        })
    }

    override fun destroy() { view = null }

}