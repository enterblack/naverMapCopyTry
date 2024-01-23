package com.example.navermapcopytry

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.navermapcopytry.adapter.LocationObjectAdapter
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity() , OnMapReadyCallback {
    private val locationRequestCode = 1009
    lateinit var locationObjectRecycler : RecyclerView
    lateinit var mapView : MapView
    lateinit var locationObjectAdapter : LocationObjectAdapter
    private val testLocationObject = listOf("편의점","병원","식당","카페","약국","추천")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        locationObjectRecycler = findViewById(R.id.search_location_recycler)
//        locationObjectAdapter = LocationObjectAdapter(testLocationObject)
//        locationObjectRecycler.adapter = locationObjectAdapter
        MapsInitializer.initialize(this)
        checkLocationPermission()
        mapView = findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestLocationPermission()
        }else{
            //그냥 실행
        }

    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),locationRequestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == locationRequestCode){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //권한 허용 할때
            }else{
                //권한 거부 할때
            }
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        val defaultLocation = LatLng(37.7749, -122.4194) // 샌프란시스코의 위도, 경도
        p0.moveCamera(CameraUpdateFactory.newLatLng(defaultLocation))
    }
}