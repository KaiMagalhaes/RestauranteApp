package com.example.restauranteapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private var lista: List<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagem: ImageView = view.findViewById(R.id.img_restaurante)
        val nome: TextView = view.findViewById(R.id.tv_nome)
        val avaliacao: TextView = view.findViewById(R.id.tv_avaliacao)
        val tipo: TextView = view.findViewById(R.id.tv_tipo)
        val preco: TextView = view.findViewById(R.id.tv_preco)
        val desconto: TextView = view.findViewById(R.id.tv_desconto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_restaurante, parent, false)  // ← row_restaurante!
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val r = lista[position]
        holder.imagem.setImageResource(r.imagem)
        holder.nome.text = r.nome
        holder.avaliacao.text = "⭐ Rating: ${r.avaliacao}"
        holder.tipo.text = "🍽️ Tipo de cozinha: ${r.tipoComida}"
        holder.preco.text = "💰 Preço médio: ${r.preco}"

        if (r.temDesconto) {
            holder.desconto.visibility = View.VISIBLE
            holder.desconto.text = "🎉 ${r.desconto}"
            holder.itemView.setBackgroundColor(Color.parseColor("#FFF9C4"))
        } else {
            holder.desconto.visibility = View.GONE
            holder.itemView.setBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount() = lista.size

    fun atualizarLista(novaLista: List<Restaurante>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}