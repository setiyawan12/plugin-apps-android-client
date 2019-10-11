package dev7.id.pluginappsclient.presenters.fragments

import dev7.id.pluginappsclient.contracts.fragments.VpAccountMainContract

class VpAccountMainPresenter(private var view : VpAccountMainContract.View?) : VpAccountMainContract.Interactor{
    override fun destroy() { view = null }
}