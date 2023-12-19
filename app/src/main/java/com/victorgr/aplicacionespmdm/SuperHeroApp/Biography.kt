package com.victorgr.aplicacionespmdm.SuperHeroApp

import com.google.gson.annotations.SerializedName

data class SuperheroImageDetailResponse(@SerializedName("url") val url:String)

data class Biography(
    @SerializedName("full-name") val fullName:String,
    @SerializedName("publisher") val publisher:String
)
