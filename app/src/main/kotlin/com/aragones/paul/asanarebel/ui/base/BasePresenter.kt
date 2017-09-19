package com.aragones.paul.asanarebel.ui.base

import com.aragones.paul.asanarebel.schedulers.ThreadScheduler
import rx.Observable

abstract class BasePresenter<T>(protected var scheduler: ThreadScheduler) {
    protected var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }

    protected fun <T> observeOn(): Observable.Transformer<T, T> {
        return scheduler.compose<T>()
    }
}