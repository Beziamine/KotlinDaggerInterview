package com.example.kotlininterview.model

import com.google.gson.annotations.SerializedName

data class App_images (

    @SerializedName("id") val id : Int,
    @SerializedName("order_id") val order_id : Int,
    @SerializedName("image_url") val image_url : String
)