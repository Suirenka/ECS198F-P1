package com.example.project1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class foodTruckListRecyclerViewAdapter(private var trucks: List<FoodTruck>)
    : RecyclerView.Adapter<foodTruckListRecyclerViewAdapter.ViewHolder>(){


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val truckNameView: TextView = itemView.findViewById(R.id.truckNameView)
        val truckLocationView: TextView = itemView.findViewById(R.id.truckLocationTextView)
        val truckTimeView: TextView = itemView.findViewById(R.id.truckTimeTextView)
        val truckImgView: ImageView = itemView.findViewById(R.id.truckImgView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.truck_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val truck = trucks[position]
        holder.truckNameView.text = truck.name;
        holder.truckLocationView.text = truck.location;
        holder.truckTimeView.text = truck.time;
        val n = truck.img + 1;
        holder.truckImgView.setImageResource(when(n)
        {
            1 -> R.drawable.authentic_street_taco
            2 -> R.drawable.bangin_bowls
            3 -> R.drawable.buckhorn_grill_jpeg
            4 -> R.drawable.hefty_gyros
            5 -> R.drawable.shah_s_halal
            6 -> R.drawable.star_ginger
            else -> throw Exception("n must bet 1 - 6")
        })
        holder.itemView.setOnClickListener { truckInfo ->
            val intent = Intent(truckInfo.context, FoodTruckDetail::class.java)
            intent.putExtra("Name", truck)
            truckInfo.context.startActivity(intent)
        }

    }

    override fun getItemCount() = trucks.size
}