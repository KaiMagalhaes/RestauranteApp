package com.example.restauranteapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RestauranteAdapter
    private var listaCompleta: List<Restaurante> = emptyList()
    private var filtroAtivo: String = "Todos"
    private var pesquisaAtiva: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listaCompleta = listOf(
            Restaurante(1, "Tasca do Zé", 4.9, "Portuguesa", "5.50€",
                R.drawable.ic_launcher_background, true, "Oferta 1 Caneca Receita"),
            Restaurante(2, "Pizza World", 4.2, "Italiana", "12.00€",
                R.drawable.ic_launcher_background, false),
            Restaurante(3, "Sushi Bar", 4.8, "Japonesa", "25.00€",
                R.drawable.ic_launcher_background, false),
            Restaurante(4, "Burger House", 3.9, "Americana", "9.00€",
                R.drawable.ic_launcher_background, true, "10% de Desconto"),
            Restaurante(5, "Cantina da Vila", 4.0, "Italiana", "15.00€",
                R.drawable.ic_launcher_background, false),
            Restaurante(6, "Tapas n' Go", 4.6, "Espanhola", "18.00€",
                R.drawable.ic_launcher_background, true, "Bebida Grátis"),
            Restaurante(7, "Puro Verde", 4.7, "Vegetariana", "14.00€",
                R.drawable.ic_launcher_background, false),
            Restaurante(8, "O Grelhado", 4.3, "Portuguesa", "8.00€",
                R.drawable.ic_launcher_background, false)
        )

        val rv = findViewById<RecyclerView>(R.id.recycler_main)
        adapter = RestauranteAdapter(listaCompleta)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        val etPesquisa = findViewById<EditText>(R.id.et_pesquisa)
        etPesquisa.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { pesquisaAtiva = s.toString(); aplicarFiltros() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        findViewById<Button>(R.id.btn_todos).setOnClickListener { filtroAtivo = "Todos"; aplicarFiltros() }
        findViewById<Button>(R.id.btn_portuguesa).setOnClickListener { filtroAtivo = "Portuguesa"; aplicarFiltros() }
        findViewById<Button>(R.id.btn_italiana).setOnClickListener { filtroAtivo = "Italiana"; aplicarFiltros() }
        findViewById<Button>(R.id.btn_japonesa).setOnClickListener { filtroAtivo = "Japonesa"; aplicarFiltros() }
        findViewById<Button>(R.id.btn_desconto).setOnClickListener { filtroAtivo = "Desconto"; aplicarFiltros() }
    }

    private fun aplicarFiltros() {
        var resultado = listaCompleta
        if (filtroAtivo == "Desconto") resultado = resultado.filter { it.temDesconto }
        else if (filtroAtivo != "Todos") resultado = resultado.filter { it.tipoComida == filtroAtivo }
        if (pesquisaAtiva.isNotEmpty()) resultado = resultado.filter {
            it.nome.contains(pesquisaAtiva, ignoreCase = true) ||
                    it.tipoComida.contains(pesquisaAtiva, ignoreCase = true)
        }
        adapter.atualizarLista(resultado)
    }
}