package dev7.id.pluginappsclient.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("member_id") var member_id : String?,
    @SerializedName("name") var name : String?,
    @SerializedName("email") var email : String? ,
    @SerializedName("role") var role : String?,
    @SerializedName("avatar") var avatar : String?,
    @SerializedName("status") var status : String?,
    @SerializedName("api_token") var api_token : String?,
    @SerializedName("username") var username: String?,
    @SerializedName("phone") var phone: String?,
    @SerializedName("telegram") var telegram: String?,
    @SerializedName("bio") var bio: String?,
    @SerializedName("github") var github: String?,
    @SerializedName("place_of_birth") var pacle_of_birth: String?,
    @SerializedName("date_of_birth") var date_of_birth: String?
)
    : Parcelable
{
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}
