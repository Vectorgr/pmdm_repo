package com.victorgr.aplicacionespmdm.GiphyApps

import com.google.gson.annotations.SerializedName

data class GiphyDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("data") val data: List<GiphyItemResponse>
)
data class GiphyItemResponse(
    @SerializedName("id") val giphyId: String,
    @SerializedName("title") val title: String,
    @SerializedName("import_datetime") val import_datetime: String,
    @SerializedName("username") val username: String,
    @SerializedName("images") val images: GiphyImageResponse
)
data class GiphyImageResponse(@SerializedName("original") val original: GiphyUrlResponse)
data class GiphyUrlResponse(@SerializedName("url") val url: String)
