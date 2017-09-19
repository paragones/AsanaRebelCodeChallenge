package com.aragones.paul.asanarebel.repositories

import com.aragones.paul.asanarebel.models.CatResponse
import com.aragones.paul.asanarebel.rest.CatRest
import rx.Observable
import rx.schedulers.Schedulers

class CatRepositoryImpl(val catRest: CatRest) : CatRepository {

    override fun catFacts(limit: Int, page: Int): Observable<CatResponse> {
        return catRest.catFacts(limit, page)
                .subscribeOn(Schedulers.io())
    }
}