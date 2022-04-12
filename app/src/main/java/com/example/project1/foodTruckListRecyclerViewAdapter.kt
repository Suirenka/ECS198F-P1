package com.example.project1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class foodTruckListRecyclerViewAdapter(private var trucks: List<FoodTruck>)
    : RecyclerView.Adapter<foodTruckListRecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val truckNameView: TextView = itemView.findViewById(R.id.truckNameView)
        val truckLocationView: TextView = itemView.findViewById(R.id.truckLocationTextView)
        val truckTimeView: TextView = itemView.findViewById(R.id.truckTimeTextView)

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


    }

    override fun getItemCount() = trucks.size
}