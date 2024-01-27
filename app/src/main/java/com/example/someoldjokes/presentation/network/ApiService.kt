package com.example.someoldjokes.presentation.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/top-headlines?country=in&apiKey=825072de5533404c9818e9f0d80ea4a2")
    suspend fun getSomeData(): Response<Model>
}