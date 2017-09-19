package com.aragones.paul.asanarebel.schedulers

import rx.Observable

interface ThreadScheduler {
    fun <T> compose(): Observable.Transformer<T, T>
}