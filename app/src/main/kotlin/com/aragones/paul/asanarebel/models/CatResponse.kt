package com.aragones.paul.asanarebel.models

import android.net.Uri
import com.google.gson.annotations.SerializedNam

data class CatResponse(@SerializedName("current_page") val currentPage: Int,
                       @SerializedName("prev_page_url") val prevPage: Uri?,
                       @SerializedName("next_page_url") val nextPage: Uri?,
                       @SerializedName("data") val catFacts: List<CatFact>)

data class CatFact(@SerializedName("length") val length: Int,
                   @SerializedName("fact") val content: String)


