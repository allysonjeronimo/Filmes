package com.allysonjeronimo.filmes.view

import com.allysonjeronimo.filmes.model.mapper.FilmeMapper
import com.allysonjeronimo.filmes.model.network.ApiService
import com.allysonjeronimo.filmes.model.network.response.FilmeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaFilmesPresenter(private var view:ListaFilmesContract.ListaFilmesView?) : ListaFilmesContract.ListaFilmesPresenter{

    override fun getFilmes() {
        ApiService.getInstance()
            .getFilmesPopulares("64b6992542556c6b1102d7c3c7d1abe8")
            .enqueue(object: Callback<FilmeResponse> {

                override fun onResponse(
                    call: Call<FilmeResponse>,
                    response: Response<FilmeResponse>
                ) {
                    if(response.isSuccessful){
                        view?.showListaFilmes(FilmeMapper.responseToDomain(response.body()?.results))
                    }
                    else{
                        view?.showError()
                    }
                }

                override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                    view?.showError()
                }
            })
    }

    override fun destroyView() {
        this.view = null
    }

}