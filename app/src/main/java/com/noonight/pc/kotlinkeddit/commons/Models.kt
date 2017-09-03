package com.noonight.pc.kotlinkeddit.commons

import com.noonight.pc.kotlinkeddit.commons.adapter.AdapterConstants
import com.noonight.pc.kotlinkeddit.commons.adapter.ViewType

/**
 * Created by PC on 8/26/2017.
 */

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>
)

data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}