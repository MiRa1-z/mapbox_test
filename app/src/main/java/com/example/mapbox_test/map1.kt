package com.example.mapbox_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mapbox_test.databinding.Map1Binding
import com.mapbox.maps.MapView



class Map1Fragment : Fragment() {

    private lateinit var binding: Map1Binding
    var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Map1Binding.inflate(inflater, container, false)
        mapView = binding.mapView
        mapView?.getMapboxMap()?.loadStyleUri("mapbox://styles/sakigake/cl4ntg75c000615qsmp5tkcom")
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