package com.aragones.paul.asanarebel.rest

import com.aragones.paul.asanarebel.models.CatResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface CatRest {
    @GET("facts")
    fun catFacts(@Query("limit") limit: Int, @Query("page") page: Int): Observable<CatResponse>
}