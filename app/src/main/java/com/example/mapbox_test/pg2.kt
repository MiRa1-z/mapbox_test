package com.example.mapbox_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mapbox_test.databinding.Page1Binding
import com.mapbox.maps.MapView



class Page2Fragment : Fragment() {

    private lateinit var binding: Page1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Page1Binding.inflate(inflater, container, false)
        val webView: WebView = binding.webView
        webView.loadUrl("https://www.sakigake.jp/news/list/scd/100001006/")
        return binding.root
    }
}