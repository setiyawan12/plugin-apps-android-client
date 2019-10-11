package dev7.id.pluginappsclient.contracts.fragments

import dev7.id.pluginappsclient.models.User

interface AccountFragmentContract {
    interface View {
        fun toast(message : String)
        fun retrieve_user(user : User)
    }

    interface Interactor {
        fun getUser(token : String)
        fun destroy()

    }
}