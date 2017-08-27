package com.noonight.pc.kotlinkeddit.features.news

import android.nfc.Tag
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noonight.pc.kotlinkeddit.R
import com.noonight.pc.kotlinkeddit.commons.RedditNewsItem
import com.noonight.pc.kotlinkeddit.commons.adapter.NewsAdapter
import com.noonight.pc.kotlinkeddit.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by PC on 8/18/2017.
 */
class NewsFragment : Fragment() {

    /*private val newsList by lazy {
        news_list                       part 4 remove
    }*/

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        /*return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.news_fragment, container, false)

        val view = container?.inflate(R.layout.news_fragment)
        newsList = view?.findViewById(R.id.news_list) as RecyclerView?
        newsList?.setHasFixedSize(true)                              part 3 remove
        newsList?.layoutManager = LinearLayoutManager(context)*/

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list.setBackgroundColor(0)
        /*newsList.setHasFixedSize(true)                            part 4
        newsList.layoutManager = LinearLayoutManager(context)*/

        initAdapter()

        if (savedInstanceState == null) {
            Log.d(javaClass.simpleName, "${savedInstanceState} from ${javaClass.simpleName}")
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
            (news_list.adapter as NewsAdapter).addNews(news)
            // добалвяет в recycler view новые элементы новостей
        }
    }

    private fun initAdapter() {
        if (news_list.adapter == null)
            news_list.adapter = NewsAdapter()
    }
}