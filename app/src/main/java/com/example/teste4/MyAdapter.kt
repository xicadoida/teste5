package com.example.aplicationfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teste4.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val listaeventos: ArrayList<Eventos>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem= listaeventos[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.titulo_evento.text= currentItem.heading
        holder.detalhes_evento.text= currentItem.headingtwo
        holder.descricao_evento.text= currentItem.headingthree
    }

    override fun getItemCount(): Int {
        return listaeventos.size
    }



    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        val detalhes_evento: TextView= itemView.findViewById(R.id.detalhes_evento)
        val titleImage: ShapeableImageView= itemView.findViewById(R.id.title_image)
        val titulo_evento: TextView= itemView.findViewById(R.id.titulo_evento)
        val descricao_evento: TextView= itemView.findViewById(R.id.descricao_evento)


    }
}