package com.noonight.pc.kotlinkeddit.features.news

import com.noonight.pc.kotlinkeddit.api.RestAPI
import com.noonight.pc.kotlinkeddit.commons.RedditNews
import com.noonight.pc.kotlinkeddit.commons.RedditNewsItem
import rx.Observable

// add in part 5
class NewsManager(private val api: RestAPI = RestAPI()) {
    //fun getNews(limit: String = "10"): Observable<List<RedditNewsItem>> {
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscribe ->
            //val callResponse = api.getNews("", limit)
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                //val news = response.body().data.children.map {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(
                            item.author,
                            item.title,
                            item.num_comments,
                            item.created,
                            item.thumbnail,
                            item.url
                    )
                }
                //subscribe.onNext(news)
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                subscribe.onNext(redditNews)
                subscribe.onCompleted()
            } else {
                subscribe.onError(Throwable(response.message()))
            }
        }
    }
}