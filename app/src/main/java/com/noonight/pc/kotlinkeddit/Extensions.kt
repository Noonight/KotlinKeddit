package com.noonight.pc.kotlinkeddit

import org.mockito.Mockito

/**
 * Created by PC on 9/14/2017.
 */

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)