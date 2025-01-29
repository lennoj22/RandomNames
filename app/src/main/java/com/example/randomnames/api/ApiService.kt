package com.example.randomnames.api

import com.example.randomnames.models.RandomNameResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/?results=10")
    fun getRandomName(): Call<RandomNameResponse>
}