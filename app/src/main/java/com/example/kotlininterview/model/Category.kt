package com.example.kotlininterview.model

import com.google.gson.annotations.SerializedName

data class Category (

    @SerializedName("category_id") val category_id : Int,
    @SerializedName("parent_category_id") val parent_category_id : String,
    @SerializedName("sort_id") val sort_id : Int,
    @SerializedName("category_name") val category_name : String,
    @SerializedName("image_url") val image_url : String
)