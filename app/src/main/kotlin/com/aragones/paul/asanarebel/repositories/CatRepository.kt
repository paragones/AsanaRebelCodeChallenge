package com.aragones.paul.asanarebel.repositories

import com.aragones.paul.asanarebel.models.CatResponse
import rx.Observable

interface CatRepository {
    fun catFacts(limit: Int, page: Int): Observable<CatResponse>
}