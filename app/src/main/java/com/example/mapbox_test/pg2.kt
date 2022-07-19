package com.example.mapbox_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mapbox_test.databinding.Page2Binding
import com.mapbox.maps.MapView



class Page2Fragment : Fragment() {

    private lateinit var binding: Page2Binding
    var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Page2Binding.inflate(inflater, container, false)
        return binding.root
    }
}