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
    RecyclerView.Adapter<RestauranteAdapter.ResViewHolder>() {

    class ResViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgRestaurante = v.findViewById<ImageView>(R.id.img_res)
        val txtNome = v.findViewById<TextView>(R.id.txt_nome_res)
        val txtInfo = v.findViewById<TextView>(R.id.txt_infos_res)
        val layoutItem = v.findViewById<View>(R.id.layout_item_restaurante)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_restaurante, parent, false)
        return ResViewHolder(v)
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {
        val res = lista[position]
        holder.txtNome.text = res.nome
        holder.txtInfo.text = "${res.cozinha} | ${res.preco} | ⭐ ${res.avaliacao}"
        holder.imgRestaurante.setImageResource(res.imagem)

        if (res.temDesconto) {
            holder.layoutItem.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.layoutItem.setBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount() = lista.size
}