package com.allysonjeronimo.filmes.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.allysonjeronimo.filmes.R
import com.allysonjeronimo.filmes.model.domain.Filme
import com.allysonjeronimo.filmes.model.mapper.FilmeMapper
import com.allysonjeronimo.filmes.model.network.ApiService
import com.allysonjeronimo.filmes.model.network.response.FilmeResponse
import com.allysonjeronimo.filmes.view.ListaFilmesContract
import com.allysonjeronimo.filmes.view.ListaFilmesPresenter
import com.allysonjeronimo.filmes.view.adapters.FilmeAdapter
import kotlinx.android.synthetic.main.activity_lista_filmes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaFilmesActivity : AppCompatActivity(), ListaFilmesContract.ListaFilmesView, FilmeAdapter.OnClickFilme {

    private lateinit var adapter:FilmeAdapter
    private lateinit var presenter:ListaFilmesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)
        setupToolbar()
        setupRecyclerView()

        presenter = ListaFilmesPresenter(this)
        presenter.getFilmes()
    }

    private fun setupToolbar(){
        setSupportActionBar(tb_main)
    }

    private fun setupRecyclerView(){
        rv_filmes.layoutManager = GridLayoutManager(this,  2)
        adapter = FilmeAdapter(this)
        rv_filmes.adapter = adapter
    }

    override fun showListaFilmes(list: List<Filme>) {
        adapter.setList(list)
    }

    override fun showError(){
        Toast.makeText(this, "Erro ao obter filmes.", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }

    override fun onClick(filme: Filme) {
        val intent = Intent(this, DetalhesFilmeActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }

}