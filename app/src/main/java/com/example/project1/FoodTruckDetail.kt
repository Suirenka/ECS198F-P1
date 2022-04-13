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
        val n = truck!!.img + 1;
        binding.imageView.setImageResource(when(n)
        {
            1 -> R.drawable.authentic_street_taco
            2 -> R.drawable.bangin_bowls
            3 -> R.drawable.buckhorn_grill_jpeg
            4 -> R.drawable.hefty_gyros
            5 -> R.drawable.shah_s_halal
            6 -> R.drawable.star_ginger
            else -> throw Exception("n must bet 1 - 6")
        })
        val link = truck!!.link
        binding.urlTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(link))
            startActivity(intent)
        }
    }
}