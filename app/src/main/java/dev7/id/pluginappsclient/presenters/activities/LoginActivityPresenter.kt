package dev7.id.pluginappsclient.presenters.activities

import dev7.id.pluginappsclient.contracts.activities.LoginActivityContract
import dev7.id.pluginappsclient.utilities.PluginUtils

class LoginActivityPresenter(var view : LoginActivityContract.View?) : LoginActivityContract.Interactor {
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

    override fun login(id: String, pass: String) {

    }

    override fun destroy() { view = null }
}