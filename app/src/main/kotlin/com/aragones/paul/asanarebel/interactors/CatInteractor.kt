package com.aragones.paul.asanarebel.interactors

import com.aragones.paul.asanarebel.models.CatResponse
import rx.Observable

interface CatInteractor {
    fun catFacts(limit: Int, page: Int): Observable<CatResponse>
}