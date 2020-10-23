package com.allysonjeronimo.filmes.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.allysonjeronimo.filmes.R
import com.allysonjeronimo.filmes.model.domain.Filme
import com.allysonjeronimo.filmes.model.mapper.FilmeMapper
import com.allysonjeronimo.filmes.model.network.ApiService
import com.allysonjeronimo.filmes.model.network.FilmeService
import com.allysonjeronimo.filmes.model.network.response.FilmeResponse
import com.allysonjeronimo.filmes.view.adapters.FilmeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var adapter:FilmeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupRecyclerView()
        getFilmes()
    }

    private fun setupToolbar(){
        setSupportActionBar(tb_main)
    }

    private fun setupRecyclerView(){
        rv_filmes.layoutManager = GridLayoutManager(this,  2)
        adapter = FilmeAdapter()
        rv_filmes.adapter = adapter
    }

    private fun showError(){
        Toast.makeText(this, "Erro ao obter filmes.", Toast.LENGTH_SHORT).show()
    }

    private fun getFilmes(){
        ApiService.getInstance()
            .getFilmesPopulares("64b6992542556c6b1102d7c3c7d1abe8")
            .enqueue(object:Callback<FilmeResponse>{

                override fun onResponse(
                    call: Call<FilmeResponse>,
                    response: Response<FilmeResponse>
                ) {
                    if(response.isSuccessful){
                        adapter?.setList(FilmeMapper.responseToDomain(response.body()?.results))
                    }
                    else{
                        showError()
                    }
                }

                override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                    showError()
                }
            })
    }

}