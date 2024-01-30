package com.victorgr.aplicacionespmdm.GiphyApps

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGiphyService {

  /* @GET("/gifs/search?api_key=xxfQthwZMxK0XeXDrKdu6M5TDZGrwc9V&q={name}&limit=25&offset=0&rating=g&lang=en&bundle=messaging_non_clips")
    suspend fun getGiphys(@Path("name") giphyName:String): Response<GiphyDataResponse>*/
    @GET("gifs/search")
    suspend fun getGiphys(
        @Query("api_key") apiKey: String = "xxfQthwZMxK0XeXDrKdu6M5TDZGrwc9V",
        @Query("q") giphyName: String,
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,
        @Query("rating") rating: String = "g",
        @Query("lang") lang: String = "en",
        @Query("bundle") bundle: String = "messaging_non_clips"
    ): Response<GiphyDataResponse>


    @GET("{id}")
    suspend fun getGiphyDetail(@Path("id") giphyId:String): Response<GiphyDetailResponse>

}