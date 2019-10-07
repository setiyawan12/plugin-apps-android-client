package dev7.id.pluginappsclient.contracts.fragments

import dev7.id.pluginappsclient.models.User

interface DashboardFragmentContract {
    interface View {
        fun attachToRecycler(users : List<User>)
        fun isLoading(state : Boolean)
        fun toast(message : String)
    }
    interface Interactor{
        fun destroy()
        fun allUser()
    }

}