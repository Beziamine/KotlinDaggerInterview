package com.example.kotlininterview.model

import com.google.gson.annotations.SerializedName

data class App_version (

    @SerializedName("id") val id : Int,
    @SerializedName("total_downloads") val total_downloads : Int,
    @SerializedName("average_ratings") val average_ratings : Int,
    @SerializedName("total_ratings") val total_ratings : Int,
    @SerializedName("version_name") val version_name : String,
    @SerializedName("version_code") val version_code : Int,
    @SerializedName("whats_news_en") val whats_news_en : String,
    @SerializedName("whats_news_ar") val whats_news_ar : String,
    @SerializedName("app_size") val app_size : Double,
    @SerializedName("apk_url") val apk_url : String
)