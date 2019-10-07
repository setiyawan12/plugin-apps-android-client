package dev7.id.pluginappsclient.models

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("image") var image : String? = null
)