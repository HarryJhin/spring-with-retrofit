package io.github.harryjhin.springwithretrofit

import retrofit2.Call
import retrofit2.http.GET

interface MainClient {

    @GET("/health")
    fun health(): Call<Void>
}