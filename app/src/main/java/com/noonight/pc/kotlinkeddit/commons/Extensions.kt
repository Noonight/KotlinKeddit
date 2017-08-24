@file:JvmName("ExtensionsUtils")

package com.noonight.pc.kotlinkeddit.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by PC on 8/18/2017.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}