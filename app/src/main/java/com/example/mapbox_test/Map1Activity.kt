//package com.example.mapbox_test
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.mapbox_test.databinding.ActivityMap1Binding
//
//import com.mapbox.maps.MapView
//import com.mapbox.maps.Style
//
//var mapView: MapView? = null
//private lateinit var binding: ActivityMap1Binding
//
//class Map1Activity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMap1Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//        mapView = binding.mapView
//        mapView?.getMapboxMap()?.loadStyleUri("mapbox://styles/sakigake/cl4ntg75c000615qsmp5tkcom")
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
//}