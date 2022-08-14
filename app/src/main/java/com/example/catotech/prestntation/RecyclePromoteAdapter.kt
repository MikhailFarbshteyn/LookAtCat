package com.example.catotech.prestntation

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catotech.R
import com.example.catotech.data.Cat
import com.squareup.picasso.Picasso


class RecyclePromoteAdapter:RecyclerView.Adapter<RecyclePromoteAdapter.RecyclePromoteViewHolder>() {

    var lst = listOf<Cat>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class RecyclePromoteViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val ivCat = view.findViewById<ImageView>(R.id.image_promote)
        val tvCat = view.findViewById<TextView>(R.id.nameCat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclePromoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_view, parent, false)
        return RecyclePromoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclePromoteViewHolder, position: Int) {
        val cat = lst[position]


        //val image_adress = Uri.parse(element)
        Picasso.get().load(cat.img).into(holder.ivCat)
        holder.tvCat.text = cat.name
    }

    override fun getItemCount(): Int {
        return lst.size
    }
}