package dev7.id.pluginappsclient.presenters.fragments

import dev7.id.pluginappsclient.contracts.fragments.VpAccountInfoContract

class VpAccountInfoPresenter(private var view : VpAccountInfoContract.View?) : VpAccountInfoContract.Interactor {
    //jaga-jaga mbokan nambah maning
    override fun destroy() { view = null }
}