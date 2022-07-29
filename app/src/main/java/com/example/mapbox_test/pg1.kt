package com.example.mapbox_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.HttpAuthHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.mapbox_test.databinding.Page1Binding


//import com.mapbox.maps.MapView



class Page1Fragment : Fragment() {

    private lateinit var binding: Page1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Page1Binding.inflate(inflater, container, false)
        val webView: WebView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient() {

            override fun onReceivedHttpAuthRequest(
                view: WebView?,
                handler: HttpAuthHandler,
                host: String?,
                realm: String?
            ) {
                handler.proceed("secuser", "aUFgb/3P")
            }

            override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest): Boolean {
                return false
            }
        }
        webView.loadUrl("https://www.sakigake.jp/test/mirai/app/article.jsp?kc=20220729AK0015")
        return binding.root
    }

}