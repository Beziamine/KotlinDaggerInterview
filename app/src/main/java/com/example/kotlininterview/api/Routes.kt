package com.example.kotlininterview.api

class Routes {
    companion object {

        const val BASE_URL = "http://178.128.198.168:3001/"

        const val GET_LIST = "api/v1/apps?category_id=1&page_number=0&page_size=50"

        const val GET_LIST_DETAIL = "api/v1/apps/{id}"

        const val HEADER = "Bearer 37fe387a1e92a18c8ebfed8b1c7ea8c84a49ff4fba76946bcf1fe43760cd2a0b"

    }
}