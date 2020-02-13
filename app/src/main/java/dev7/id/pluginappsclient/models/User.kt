package dev7.id.pluginappsclient.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("member_id") var member_id : String? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("email") var email : String? = null ,
    @SerializedName("role") var role : String? = null,
    @SerializedName("avatar") var avatar : String? = null,
    @SerializedName("status") var status : String? = null,
    @SerializedName("api_token") var api_token : String? = null,
    @SerializedName("personal") var personal : Personal? = null


) : Parcelable

@Parcelize
data class Personal (
    @SerializedName("nickname") var nickname: String? = null,
    @SerializedName("nim") var nim: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("telegram") var telegram: String? = null,
    @SerializedName("bio") var bio: String? = null,
    @SerializedName("github") var github: String? = null,
    @SerializedName("place_of_birth") var pacle_of_birth: String? = null,
    @SerializedName("date_of_birth") var date_of_birth: String? = null
) : Parcelable
