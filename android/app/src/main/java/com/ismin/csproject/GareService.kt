package com.ismin.csproject

import retrofit2.Call
import retrofit2.http.*

interface GareService {

    @GET("gares/{titre}?limit=10")
    fun getAllGare(@Path("titre") titre: String): Call<List<Gare>>

    @POST("gares")
    fun createGare(@Body gare: Gare): Call<Gare>

    @PATCH("gares/{titre}")
    fun addFavoris(@Path("titre") titre: String, @Body favoris: Favoris): Call<Gare>


}