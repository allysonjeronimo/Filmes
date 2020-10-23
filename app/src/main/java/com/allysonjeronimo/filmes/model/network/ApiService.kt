package com.allysonjeronimo.filmes.model.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {

    companion object{
        private var instance:FilmeService? = null
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun getInstance() : FilmeService{
            if(instance == null){

                // MoshiConverter permite realizar o parser do retorno da API
                // se forma mais fácil

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

                instance = retrofit.create(FilmeService::class.java)
            }

            return instance!!
        }
    }


}