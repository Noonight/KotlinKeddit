package com.noonight.pc.kotlinkeddit.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noonight.pc.kotlinkeddit.R
import com.noonight.pc.kotlinkeddit.commons.adapter.NewsAdapter
import com.noonight.pc.kotlinkeddit.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by PC on 8/18/2017.
 */
class NewsFragment : Fragment() {

    //private var newsList: RecyclerView? = null

    /*private val newsList by lazy {
        news_list                       part 4 remove
    }*/

    override fun onCreateView(inflater: LayoutInflater
                              , container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        //val view = inflater.inflate(R.layout.news_fragment, container, false)

        /*val view = container?.inflate(R.layout.news_fragment)
        newsList = view?.findViewById(R.id.news_list) as RecyclerView?
        newsList?.setHasFixedSize(true)                              part 3 remove
        newsList?.layoutManager = LinearLayoutManager(context)*/

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        /*newsList.setHasFixedSize(true)                            part 4
        newsList.layoutManager = LinearLayoutManager(context)*/
    }

    private fun initAdapter() {
        if (news_list.adapter == null)
            news_list.adapter == NewsAdapter()
    }
}