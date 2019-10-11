package dev7.id.pluginappsclient.presenters.fragments

import dev7.id.pluginappsclient.contracts.fragments.AccountFragmentContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.webservices.PluginAPI

class AccountFragmentPresenter(var view : AccountFragmentContract.View?) : AccountFragmentContract.Interactor {
    private var api = PluginAPI.instance()

    override fun getUser(token: String) {
        val user = User().apply {
            member_id = "PLGN190001"
            name = "Prieyudha Akadita S"
            avatar = "https://www.memecomic.id/data/editor/images/11849381_414814442052346_1644709691_n.jpg"
            status = "active"
            email = "ydhnwb@gmail.com"
            role = "Anggota"
        }
        view?.retrieve_user(user)
    }

    override fun destroy() { view = null}
}