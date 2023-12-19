package com.victorgr.aplicacionespmdm.SuperHeroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1723778111442384/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperHeroDataResponse>

    @GET("/api/1723778111442384/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>


}