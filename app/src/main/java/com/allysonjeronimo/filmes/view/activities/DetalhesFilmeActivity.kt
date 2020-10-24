package com.allysonjeronimo.filmes.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allysonjeronimo.filmes.R
import com.allysonjeronimo.filmes.model.domain.Filme
import kotlinx.android.synthetic.main.activity_detalhes_filme.*

class DetalhesFilmeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_filme)

        val filme = intent.getSerializableExtra("filme") as Filme
        if(filme != null) tv_titulo.text = filme.titulo
    }
}