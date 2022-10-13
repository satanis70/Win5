package com.example.win5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInit {
    fun init(): ApiInterface {
        val apiInterface = Retrofit.Builder()
            .baseUrl(UTIL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        return apiInterface
    }
}