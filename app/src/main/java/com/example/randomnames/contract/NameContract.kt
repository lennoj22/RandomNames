package com.example.randomnames.contract

import com.example.randomnames.models.Results

interface NameContract {

    interface View {
        fun showUsers(users: List<Results>)
        fun showError(message: String)
    }

    interface Presenter {
        fun fetchUsers()
    }
}