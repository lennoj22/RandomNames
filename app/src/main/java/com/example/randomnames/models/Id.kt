package com.example.randomnames.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Id(
    @SerializedName("name")
    var name  : String? = null,
    @SerializedName("value")
    var value : String? = null
) : Serializable

