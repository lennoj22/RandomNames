package com.example.randomnames.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RandomNameResponse (
    @SerializedName("results")
    var results : List<Results>
) : Serializable