package com.noonight.pc.kotlinkeddit.api

import retrofit2.Call

/**
 * Created by PC on 9/13/2017.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String) : Call<RedditNewsResponse>
}