package com.example.project1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project1.databinding.ActivityFoodTruckDetailBinding
import com.example.project1.databinding.ActivityMainBinding
import java.lang.Exception

class FoodTruckDetail : AppCompatActivity() {
    private lateinit var binding: ActivityFoodTruckDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "P1"

        binding = ActivityFoodTruckDetailBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val truck = intent.getParcelableExtra<FoodTruck>("Name")
        binding.TruckNameView.text = truck!!.name
        binding.TimeTextView.text = truck!!.time
        binding.locationTextView.text = truck!!.location
        binding.descriptionTextView.text = truck!!.description
        binding.imageView.setImageResource(truck!!.img)
        val link = truck!!.link
        binding.urlTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(link))
            startActivity(intent)
        }
    }
}