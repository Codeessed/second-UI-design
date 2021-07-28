package com.example.recyclersample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ViewPagerAdapter(val images: List<Pager>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {



     class ViewPagerHolder(itemView: View): RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager,parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val img = images[position]

        val viewPagerImage: androidx.constraintlayout.widget.ConstraintLayout = holder.itemView.findViewById(R.id.viewPagerImage)
        val birthdayText: TextView = holder.itemView.findViewById(R.id.birthdayText)

        birthdayText.text = img.birthdayText
        viewPagerImage.setBackgroundResource(img.variousImage)



    }

    override fun getItemCount(): Int {
        return images.size
    }
}