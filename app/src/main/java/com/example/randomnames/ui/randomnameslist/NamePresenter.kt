package com.example.randomnames.ui.randomnameslist

import com.example.randomnames.api.ApiService
import com.example.randomnames.contract.NameContract
import com.example.randomnames.models.RandomNameResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NamePresenter(private val view: NameContract.View, private val apiService: ApiService) : NameContract.Presenter {
    override fun fetchUsers() {
        apiService.getRandomName().enqueue(object : Callback<RandomNameResponse> {
            override fun onResponse(call: Call<RandomNameResponse>, response: Response<RandomNameResponse>) {
                if (response.isSuccessful) {
                    view.showUsers(response.body()?.results ?: emptyList())
                } else {
                    view.showError("Failed to retrieve data")
                }
            }

            override fun onFailure(call: Call<RandomNameResponse>, t: Throwable) {
                view.showError(t.message ?: "Unknown error")
            }
        })
    }
}