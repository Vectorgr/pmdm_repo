package com.victorgr.aplicacionespmdm.GiphyApps

import com.google.gson.annotations.SerializedName

data class GiphyDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: GiphyImageResponse,
    @SerializedName("import_datetime") val import_datetime: String,
    @SerializedName("username") val username: String
)
