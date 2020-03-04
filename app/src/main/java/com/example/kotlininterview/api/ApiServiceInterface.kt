package com.example.kotlininterview.api

import com.example.kotlininterview.model.Model
import com.example.kotlininterview.model.ModelDetail
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET(Routes.GET_LIST)
    fun getList(@Header("Authorization") Authorization: String): Observable<List<Model>>

    @GET(Routes.GET_LIST_DETAIL)
    fun getListDetail(@Header("Authorization") Authorization: String, @Path("id") id: String): Observable<ModelDetail>


    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Routes.BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}