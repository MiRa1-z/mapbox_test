package com.example.mapbox_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mapbox_test.databinding.Map2Binding
import com.mapbox.maps.MapView



class Map2Fragment : Fragment() {

    private lateinit var binding: Map2Binding
    var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
//        super.onCreate(savedInstanceState)



    ): View {
        // Inflate the layout for this fragment
        binding = Map2Binding.inflate(inflater, container, false)
        mapView = binding.mapView
        mapView?.getMapboxMap()?.loadStyleUri("mapbox://styles/sakigake/cl4npt6vz003u15quka1zc4r6")
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}