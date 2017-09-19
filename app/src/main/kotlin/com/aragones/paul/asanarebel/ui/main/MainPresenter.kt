package com.aragones.paul.asanarebel.ui.main

import com.aragones.paul.asanarebel.interactors.CatInteractor
import com.aragones.paul.asanarebel.schedulers.ThreadScheduler
import com.aragones.paul.asanarebel.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val interactor: CatInteractor,
                                        scheduler: ThreadScheduler) : BasePresenter<MainView>(scheduler) {

    fun loadData(limit: Int = 1, page: Int = 1) {
        view?.displayLoading()
        interactor.catFacts(limit, page)
                .compose(observeOn())
                .subscribe({
                    view?.hideLoading()
                    view?.displayCatFacts(it.catFacts)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                })
    }

}