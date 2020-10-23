package com.allysonjeronimo.filmes.model.mapper

import com.allysonjeronimo.filmes.model.domain.Filme
import com.allysonjeronimo.filmes.model.network.response.FilmeResponse
import com.allysonjeronimo.filmes.model.network.response.FilmeResult

class FilmeMapper{
    companion object{
        fun responseToDomain(filmesResult:List<FilmeResult>?) : List<Filme>{
            return filmesResult?.map{
                Filme(it.id, it.originalTitle, it.posterPath)
            } ?: mutableListOf<Filme>()
        }
    }
}