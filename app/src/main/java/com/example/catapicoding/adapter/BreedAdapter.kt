package com.example.catapicoding.adapter

import Breed
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catapicoding.R

class BreedAdapter(val breedList : List<Breed>) : RecyclerView.Adapter<BreedAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.text_breed_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_breed, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return breedList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breed = breedList[position]
        holder.name.text = breed.name
    }
}