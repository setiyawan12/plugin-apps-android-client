package dev7.id.pluginappsclient.contracts.activities

interface LoginActivityContract {
    interface View {
        fun toast(message : String)
        fun success()
        fun isLoading(state : Boolean)
        fun idError(err : String?)
        fun passwordError(err : String?)
    }

    interface Interactor {
        fun validate(id : String, pass : String) : Boolean
        fun login(id : String, pass : String)
        fun destroy()
    }
}