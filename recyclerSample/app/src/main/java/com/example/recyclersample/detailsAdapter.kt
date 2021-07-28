package com.example.recyclersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailsAdapter (private var details: List<Details>):RecyclerView.Adapter<DetailsAdapter.DetailsHolder>(){
     class DetailsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var personImage: ImageView =itemView.findViewById(R.id.imageView)
        var name: TextView = itemView.findViewById(R.id.name)
        var date: TextView = itemView.findViewById(R.id.date)
        var daysLeft : TextView = itemView.findViewById(R.id.daysLeft)
        var thinLine : ImageView = itemView.findViewById(R.id.thinLine)
        var calendar : ImageView = itemView.findViewById(R.id.calendar)
        var cake : ImageView = itemView.findViewById(R.id.cake)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_details,parent,false)
        return DetailsHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {

        val currentDetails = details[position]

        holder.personImage.setImageResource(currentDetails.personImage)
        holder.name.text = currentDetails.name
        holder.date.text = currentDetails.date
        holder.daysLeft.text = currentDetails.daysLeft
        holder.thinLine.setImageResource(currentDetails.thinLine)
        holder.calendar.setImageResource(currentDetails.calendar)
        holder.cake.setImageResource(currentDetails.cake)
    }

    override fun getItemCount(): Int {
        return details.size
    }
}