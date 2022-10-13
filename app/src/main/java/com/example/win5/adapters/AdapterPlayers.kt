package com.example.win5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win5.R
import com.example.win5.model.RichestPlayer

class AdapterPlayers(val list: ArrayList<RichestPlayer>): RecyclerView.Adapter<AdapterPlayers.PlayersHolder>() {
    inner class PlayersHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.players_image_item)
        val titleView = itemView.findViewById<TextView>(R.id.title_item_players)
        val conditionView = itemView.findViewById<TextView>(R.id.condition_item_players)
        val descriptionView = itemView.findViewById<TextView>(R.id.players_descriptions_items)

        fun bind(image: String, title: String, condition: String, description: String){
            Glide.with(itemView.context)
                .load(image)
                .override(700,700)
                .into(imageView)
            titleView.text = title
            conditionView.text = "Net Worth: ${condition}"
            descriptionView.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_players, parent, false)
        return PlayersHolder(view)
    }

    override fun onBindViewHolder(holder: PlayersHolder, position: Int) {
        holder.bind(list[position].image, list[position].title, list[position].condition, list[position].description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}