package com.example.restauranteapp

data class Restaurante(
    val id: Int,
    val nome: String,
    val avaliacao: Double,
    val cozinha: String,
    val preco: String,
    val imagem: Int,
    val temDesconto: Boolean
)