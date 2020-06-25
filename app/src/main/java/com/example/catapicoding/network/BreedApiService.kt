package com.example.catapicoding.network

import Breed
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BreedApiService {
    @GET("breeds")
    fun getAllBreeds() : Observable<List<Breed>>

    companion object {
        fun create(): BreedApiService {

            val BASE_URL = "https://api.thecatapi.com/v1/"
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(BreedApiService::class.java)
        }
    }
}