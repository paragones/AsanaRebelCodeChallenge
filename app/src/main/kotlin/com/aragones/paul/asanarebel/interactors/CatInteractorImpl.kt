package com.aragones.paul.asanarebel.interactors

import com.aragones.paul.asanarebel.models.CatResponse
import com.aragones.paul.asanarebel.repositories.CatRepository
import rx.Observable


class CatInteractorImpl(val catRepository: CatRepository) : CatInteractor {

    override fun catFacts(limit: Int, page: Int): Observable<CatResponse> = catRepository.catFacts(limit, page)
}