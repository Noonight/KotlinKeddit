package com.noonight.pc.kotlinkeddit.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by PC on 8/31/2017.
 */
open class RxBaseFragment() : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}