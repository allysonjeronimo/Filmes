package com.allysonjeronimo.filmes.model.network.response

import com.squareup.moshi.Json

data class FilmeResult(
    @field:Json(name="id")
    val id:Long,
    @field:Json(name="poster_path")
    val posterPath:String?,
    @field:Json(name="original_title")
    val originalTitle:String
)