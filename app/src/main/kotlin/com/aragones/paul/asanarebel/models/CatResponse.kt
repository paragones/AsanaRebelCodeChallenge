package com.aragones.paul.asanarebel.models

import com.google.gson.annotations.SerializedName

data class CatResponse(@SerializedName("data") val catFacts: List<CatFact>)

data class CatFact(@SerializedName("length") val length: Int,
                   @SerializedName("fact") val content: String)


