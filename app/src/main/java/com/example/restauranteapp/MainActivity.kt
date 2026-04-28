package com.example.restauranteapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciooo1.Restaurante
import com.example.exerciciooo1.RestauranteAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- O CÓDIGO TEM DE ESTAR AQUI (ANTES DA PRÓXIMA CHAVETA) ---

        val rv = findViewById<RecyclerView>(R.id.recycler_ex4)

        val listaRestaurantes = listOf(
            Restaurante(1, "Tasca do Zé", 4.5, "Portuguesa", "€", R.drawable.got, true),
            Restaurante(2, "Pizza World", 4.2, "Italiana", "€€", R.drawable.got2, false),
            Restaurante(3, "Sushi Bar", 4.8, "Japonesa", "€€€", R.drawable.got, false),
            Restaurante(4, "Burger House", 3.9, "Americana", "€", R.drawable.got2, true),
            Restaurante(5, "Cantina", 4.0, "Italiana", "€€", R.drawable.got, false),
            Restaurante(6, "Tapas n' Go", 4.6, "Espanhola", "€€", R.drawable.got2, true),
            Restaurante(7, "Puro Verde", 4.7, "Vegetariana", "€€", R.drawable.got, false),
            Restaurante(8, "O Grelhado", 4.3, "Portuguesa", "€", R.drawable.got2, false)
        )

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RestauranteAdapter(listaRestaurantes)

    } // Esta chaveta fecha o onCreate
} // Esta chaveta fecha a classe