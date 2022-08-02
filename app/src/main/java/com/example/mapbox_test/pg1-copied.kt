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
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mapbox_test.databinding.Page1Binding
import org.dom4j.Node
import org.dom4j.io.SAXReader
import java.io.File
import java.io.FileWriter

//import com.mapbox.maps.MapView



//class Page1Fragment : Fragment() {
//
//    private lateinit var binding: Page1Binding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Instantiate the RequestQueue.
//        //val queue = Volley.newRequestQueue(getActivity()!!.getApplicationContext())
//        val url = "https://www.sakigake.jp/rss/news/akita.xml"
//
//        val kids = arrayListOf<Node>()
//
//        val doc = SAXReader().read(File(url))
//        val nodes = doc.selectNodes("/item/link")
//        for(node in nodes){
//                    kids.add(node)
//        }
//
//        // Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener<String> { response ->
//                // Display the first 500 characters of the response string.
////                textView.text = response //"Response is: ${response.substring(0, 500)}"
////                val doc = SAXReader().read(response)
////                val nodes = doc.selectNodes("/item/link")
////                for(node in nodes){
//////                    kids.add(node)
////                }
//                val y= 0
//            },
//            Response.ErrorListener {
//                val x =0
//            })
//
//        // Add the request to the RequestQueue.
//        //queue.add(stringRequest)
//
//        // Inflate the layout for this fragment
//        binding = Page1Binding.inflate(inflater, container, false)
//        val webView: WebView = binding.webView
//        webView.settings.javaScriptEnabled = true
//        webView.webViewClient = object: WebViewClient() {
//
//            override fun onReceivedHttpAuthRequest(
//                view: WebView?,
//                handler: HttpAuthHandler,
//                host: String?,
//                realm: String?
//            ) {
//                handler.proceed("secuser", "aUFgb/3P")
//            }
//
//            override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest): Boolean {
//                return false
//            }
//        }
//        val range = (0..30)
//        val url2 = kids[0]
//        //webView.loadUrl("https://www.sakigake.jp/test/mirai/app/article.jsp?kc=20220729AK0015")
//        webView.loadUrl(url2.toString())
//        return binding.root
//    }
//
//}
