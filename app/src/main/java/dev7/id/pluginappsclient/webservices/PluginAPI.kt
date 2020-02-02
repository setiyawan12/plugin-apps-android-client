package dev7.id.pluginappsclient.webservices

import com.google.gson.annotations.SerializedName
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.utilities.PluginUtils
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

class PluginAPI {
    companion object {
        private var retrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        fun instance(): PluginAPIService = getClient().create(PluginAPIService::class.java)

        private fun getClient(): Retrofit {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(PluginUtils.API_ENDPOINT).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
                retrofit!!
            } else {
                retrofit!!
            }
        }
        fun instance_api() : PluginAPIService = getClient().create(PluginAPIService::class.java)
    }
}
interface PluginAPIService {
    @GET("api/users")
    fun users(@Header("Authorization") api_token : String) : Call<WrappedListResponse<User>>

    @FormUrlEncoded
    @POST("api/login")
    fun login(@Field("member_id") member_id : String, @Field("password") password : String) : Call<WrappedResponse<User>>
}



//Izza wis tak gon ganti "data" eben gadi results
//berlaku untuk kelas WrappedResponse dan WrappedListResponse
//Kalo push an ini error saat get users, ganti "data" di bawah sesuai dengan gantiane izza
data class WrappedResponse<T> (
    @SerializedName("message") var message : String?,
    @SerializedName("status") var status : String? ,
    @SerializedName("results") var data : T?
){
    constructor() : this(null, null, null)
}

data class WrappedListResponse<T> (
    @SerializedName("message") var message : String?,
    @SerializedName("status") var status : Boolean?,
    @SerializedName("results") var data : List<T>?
){
    constructor() : this(null, null, null)

}