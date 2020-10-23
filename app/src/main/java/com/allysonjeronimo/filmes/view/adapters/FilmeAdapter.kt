package com.allysonjeronimo.filmes.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allysonjeronimo.filmes.R
import com.allysonjeronimo.filmes.model.domain.Filme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_filme.view.*

class FilmeAdapter(var list:List<Filme> = mutableListOf<Filme>()) : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    @JvmName("setFilmes")
    fun setList(list:List<Filme>){
        if(list.isNotEmpty()){
            this.list = list
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = list?.get(position)
        holder.bind(filme)
    }

    override fun getItemCount(): Int = list?.size ?: 0

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNome = itemView.tv_nome
        val ivPoster = itemView.iv_poster

        fun bind(filme:Filme){
            tvNome.text = filme.titulo
            Picasso.get().load("https://image.tmdb.org/t/p/w185/${filme.poster}").into(ivPoster)
        }
    }
}