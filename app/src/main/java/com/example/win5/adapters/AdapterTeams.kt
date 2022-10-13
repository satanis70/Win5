package com.example.win5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win5.R
import com.example.win5.model.PopularTeam
import com.example.win5.model.PopularTeamsModel

class AdapterTeams(val teamsList: ArrayList<PopularTeam>): RecyclerView.Adapter<AdapterTeams.TeamsHolder>() {

    inner class TeamsHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.teams_image_item)
        val titleView = itemView.findViewById<TextView>(R.id.title_item_teams)
        val descriptionView = itemView.findViewById<TextView>(R.id.teams_descriptions_items)
        fun bind(image: String, title: String, description: String){
            Glide.with(itemView.context)
                .load(image)
                .override(700,700)
                .into(imageView)
            titleView.text = title
            descriptionView.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_teams, parent, false)
        return TeamsHolder(view)
    }

    override fun onBindViewHolder(holder: TeamsHolder, position: Int) {
            holder.bind(teamsList[position].image, teamsList[position].title, teamsList[position].description)

    }

    override fun getItemCount(): Int {
        return teamsList.size
    }
}