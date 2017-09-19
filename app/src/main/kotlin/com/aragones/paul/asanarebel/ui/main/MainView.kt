package com.aragones.paul.asanarebel.ui.main

import com.aragones.paul.asanarebel.models.CatFact

interface MainView {
    fun displayCatFacts(catFacts: List<CatFact>)
    fun displayError()
    fun displayLoading()
    fun hideLoading()
}