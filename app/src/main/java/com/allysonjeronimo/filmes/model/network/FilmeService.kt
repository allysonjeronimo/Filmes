package com.allysonjeronimo.filmes.model.network

import com.allysonjeronimo.filmes.model.network.response.FilmeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeService {

    @GET("movie/popular")
    fun getFilmesPopulares(@Query("api_key") apiKey:String) : Call<FilmeResponse>

}