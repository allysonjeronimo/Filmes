package com.allysonjeronimo.filmes.model.network.response

import com.squareup.moshi.Json

data class FilmeResponse (
    @field:Json(name="results") val results:List<FilmeResult>?
)