package dev7.id.pluginappsclient.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("member_id") var member_id : String?,
    @SerializedName("name") var name : String?,
    @SerializedName("email") var email : String? ,
    @SerializedName("role") var role : String?,
    @SerializedName("avatar") var avatar : String?,
    @SerializedName("status") var status : String?
) {
    constructor() : this(null, null, null, null, null, null)
}