package com.noonight.pc.kotlinkeddit.features.news

import com.noonight.pc.kotlinkeddit.commons.RedditNewsItem
import rx.Observable

// add in part 5
class NewsManager() {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create { subscribe ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            subscribe.onNext(news)
        }
    }
}