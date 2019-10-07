package dev7.id.pluginappsclient.utilities

import android.content.Context
import android.content.Context.MODE_PRIVATE

class PluginUtils {
    companion object {
        var API_ENDPOINT = "https://plugin-apps-server.herokuapp.com/"

        fun getToken(c : Context) : String {
            val s = c.getSharedPreferences("USER", MODE_PRIVATE)
            val token = s?.getString("TOKEN", "UNDEFINED")
            return token!!
        }

        fun setToken(context: Context, token : String){
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().apply {
                putString("TOKEN", token)
                apply()
            }
        }

        fun clearToken(context: Context){
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().clear().apply()
        }

        fun isValidPassword(password : String) = password.length > 8
        fun isValidId(id : String) : Boolean {
            return if (!id.startsWith("PLGN")){ false }else{ id.length == 10 }
        }
    }
}