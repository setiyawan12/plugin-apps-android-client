package dev7.id.pluginappsclient.contracts.activities

import android.content.Context

interface LoginActivityContract {
    interface View {
        fun toast(message : String)
        fun success(token : String)
        fun isLoading(state : Boolean)
        fun idError(err : String?)
        fun passwordError(err : String?)
        fun notConect()
    }

    interface Interactor {
        fun validate(id : String, pass : String) : Boolean
        fun login(member_id : String, pass : String)
        fun destroy()
    }
}