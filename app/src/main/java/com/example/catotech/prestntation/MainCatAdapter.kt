package com.example.catotech.prestntation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.catotech.R
import com.example.catotech.data.Cat
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class MainCatAdapter:RecyclerView.Adapter<MainCatAdapter.MainCatViewHolder>() {


    var onCatlickListener: ((Cat) -> Unit)? = null
    var lst = listOf<Cat>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class MainCatViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val main_cat = view.findViewById<ImageView>(R.id.main_cat_view)
        val like = view.findViewById<ImageView>(R.id.i_like)
        val dont_like = view.findViewById<ImageView>(R.id.i_dont_like)
        val likes = view.findViewById<TextView>(R.id.like_numbers)
        val heart = view.findViewById<ImageView>(R.id.heart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.current_cat, parent, false)
        return MainCatViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainCatViewHolder, position: Int) {
        val cat = lst[position]
        holder.likes.text = cat.likes.toString()
        Picasso.get().load(cat.img).into(holder.main_cat)
        val heart_sign = if (cat.liked) R.drawable.ic_baseline_like_pressed_24 else R.drawable.ic_baseline_like_not_pressed_24
            holder.heart.setImageResource(heart_sign)
        holder.heart.setOnClickListener { onCatlickListener?.invoke(cat) }
    }



override fun getItemCount(): Int {
    return lst.size
}
}

