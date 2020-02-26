package dev7.id.pluginappsclient.contracts.fragments

import dev7.id.pluginappsclient.models.User

interface AccountFragmentContract {
    interface Interactor {
        fun destroy()
        fun fetchMyProfile(token : String)
    }
    interface View {
        fun isLoading(state : Boolean)
        fun toast(message : String)
        fun retrieveMyProfile(user : User?)
    }
}