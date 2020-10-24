package com.allysonjeronimo.filmes.model.domain

import java.io.Serializable

data class Filme(val id:Long, val titulo:String, val poster:String?) : Serializable{
    override fun toString() = titulo
}