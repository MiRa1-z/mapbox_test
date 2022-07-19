package com.example.mapbox_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mapbox_test.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mapbox_test.databinding.Map2Binding
import com.google.android.material.tabs.TabLayoutMediator
import com.mapbox.maps.MapView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    var mapView: MapView? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//
//
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        mapView = binding.mapView
//        mapView?.getMapboxMap()?.loadStyleUri("mapbox://styles/sakigake/cl4npt6vz003u15quka1zc4r6")
//
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//        mapView?.onStart()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        mapView?.onStop()
//    }
//
//    override fun onLowMemory() {
//        super.onLowMemory()
//        mapView?.onLowMemory()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mapView?.onDestroy()
//    }

}
