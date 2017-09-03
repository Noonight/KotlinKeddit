package com.noonight.pc.kotlinkeddit.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by PC on 8/31/2017.
 */
interface RedditApi {

    @GET("/top.json")
    fun getTop(
            @Query("after") after: String,
            @Query("limit") limit: String
    ): Call<RedditNewsResponse>
}