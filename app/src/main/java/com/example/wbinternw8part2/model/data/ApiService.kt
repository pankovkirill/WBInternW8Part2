package com.example.wbinternw8part2.model.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("api/all.json")
    fun getDataAsync(): Deferred<List<DataModel>>
}