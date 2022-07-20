package com.example.mapbox_test


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mapbox_test.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.mapbox_test.databinding.Page1Binding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var swipePagerAdapter: SwipePagerAdapter
    private lateinit var viewPager: ViewPager2
    var tab_titles = listOf("最新ニュース","スポーツ","社会・事件","クーポン","エンタメ","気象・災害")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        Log.d("MainFrag","view")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout = binding.tabLayout
        viewPager = binding.pager
        swipePagerAdapter = SwipePagerAdapter(this)
        viewPager.adapter = swipePagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tab_titles[position]
        }.attach()
    }

    class SwipePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
        override fun getItemCount() = 6

        override fun createFragment(position: Int) = when (position % 6) {
            0 -> Page1Fragment()
            1 -> Page2Fragment()
            2 -> Page3Fragment()
            3 -> Page4Fragment()
            4 -> Page5Fragment()
            5 -> Page6Fragment()
            else -> Page1Fragment()
        }
    }
}

class PageFragment : Fragment() {

    private lateinit var binding2: Page1Binding
    var url_lists = listOf("https://www.sakigake.jp/news/list/ccd/akita/","https://www.sakigake.jp/news/list/scd/100001006/","https://www.sakigake.jp/news/list/scd/100001002/","https://www.sakigake.jp/coupon/","https://www.sakigake.jp/ent/","https://www.sakigake.jp/news/list/scd/100001007/")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding2 = Page1Binding.inflate(inflater, container, false)
        val webView: WebView = binding2.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest): Boolean {
                return false
            }
        }
        webView.loadUrl(url_lists[position])
        return binding.root
    }

}
