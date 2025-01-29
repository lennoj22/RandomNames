package com.example.randomnames.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(
    @SerializedName("id")
    var id : Id? = Id(),
    @SerializedName("name")
    var name : Name? = Name()
) : Serializable