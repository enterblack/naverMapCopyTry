package com.example.navermapcopytry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.navermapcopytry.adapter.LocationObjectAdapter

class MainActivity : AppCompatActivity() {
    lateinit var locationObjectRecycler : RecyclerView
    lateinit var locationObjectAdapter : LocationObjectAdapter
    private val testLocationObject = listOf("편의점","병원","식당","카페","약국","추천")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationObjectRecycler = findViewById(R.id.search_location_recycler)
        locationObjectAdapter = LocationObjectAdapter(testLocationObject)
        locationObjectRecycler.adapter = locationObjectAdapter

    }
}