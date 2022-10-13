package com.example.win5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win5.R
import com.example.win5.model.League

class AdapterLeague(val list: ArrayList<League>): RecyclerView.Adapter<AdapterLeague.LeagueHolder>() {

    inner class LeagueHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val imageView = itemView.findViewById<ImageView>(R.id.league_image_item)
        val titleView = itemView.findViewById<TextView>(R.id.title_item_league)
        val descriptionView = itemView.findViewById<TextView>(R.id.teams_descriptions_items)

        fun bind(image: String, title:String, description:String){
            Glide.with(itemView.context)
                .load(image)
                .override(700,700)
                .into(imageView)
            titleView.text = title
            descriptionView.text = description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_leagues, parent, false)
        return LeagueHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueHolder, position: Int) {
        holder.bind(list[position].image, list[position].title, list[position].description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}