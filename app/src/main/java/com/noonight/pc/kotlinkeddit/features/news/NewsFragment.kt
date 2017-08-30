package com.noonight.pc.kotlinkeddit.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noonight.pc.kotlinkeddit.R
import com.noonight.pc.kotlinkeddit.commons.RedditNewsItem
import com.noonight.pc.kotlinkeddit.commons.RxBaseFragment
import com.noonight.pc.kotlinkeddit.commons.adapter.NewsAdapter
import com.noonight.pc.kotlinkeddit.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment() {


    private val newsManager by lazy {
        NewsManager()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list.setBackgroundColor(999)
        /*newsList.setHasFixedSize(true)                            part 4
        newsList.layoutManager = LinearLayoutManager(context)*/

        initAdapter()

        if (savedInstanceState == null) {
            // добалвяет в recycler view новые элементы новостей
            /*Log.d(javaClass.simpleName, "${savedInstanceState} from ${javaClass.simpleName}")
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..100) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }
            (news_list.adapter as NewsAdapter).addNews(news)*/
            requestNews()
        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            retrievedNews -> (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                        },
                        {
                            e -> Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null)
            news_list.adapter = NewsAdapter()
    }
}