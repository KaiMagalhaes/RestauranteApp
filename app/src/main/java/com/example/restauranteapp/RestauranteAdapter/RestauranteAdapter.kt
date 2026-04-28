package com.example.exerciciooo1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restauranteapp.Restaurante

class RestauranteAdapter(private val lista: List<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    class RestauranteViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val img: ImageView = v.findViewById(R.id.img_restaurante)
        val nome: TextView = v.findViewById(R.id.txt_nome)
        val detalhes: TextView = v.findViewById(R.id.txt_detalhes)
        val layout: View = v.findViewById(R.id.layout_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_restaurante, parent, false)
        return RestauranteViewHolder(v)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val res = lista[position]

        holder.nome.text = res.nome
        holder.detalhes.text = "${res.cozinha} • ${res.preco} • ⭐ ${res.avaliacao}"
        holder.img.setImageResource(res.imagem)

        // Se tiver desconto, muda a cor de fundo (ex: cinza claro)
        if (res.temDesconto) {
            holder.layout.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.layout.setBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount() = lista.size
}