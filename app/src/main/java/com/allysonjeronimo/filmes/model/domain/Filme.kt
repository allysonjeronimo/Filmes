package com.allysonjeronimo.filmes.model.domain

data class Filme(val id:Long, val titulo:String, val poster:String?) {
    override fun toString() = titulo
}