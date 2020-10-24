package com.allysonjeronimo.filmes.view

import com.allysonjeronimo.filmes.model.domain.Filme

interface ListaFilmesContract {
    interface ListaFilmesView{
        fun showListaFilmes(list:List<Filme>)
        fun showError()
    }
    interface ListaFilmesPresenter{
        fun getFilmes()
        fun destroyView()
    }
}