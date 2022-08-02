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
            tab.text = position.toString() //tab_titles[position]
        }.attach()
    }

    class SwipePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
        override fun getItemCount() = 20

        override fun createFragment(position: Int) = when (position % 15) {
            0 -> Page1Fragment()
            1 -> Page1Fragment()
            2 -> Page1Fragment()
            3 -> Page1Fragment()
            4 -> Page1Fragment()
            5 -> Page1Fragment()
            6 -> Page1Fragment()
            7 -> Page1Fragment()
            8 -> Page1Fragment()
            9 -> Page1Fragment()
            10 -> Page1Fragment()
            11 -> Page1Fragment()
            12 -> Page1Fragment()
            13 -> Page1Fragment()
            14 -> Page1Fragment()
            else -> Page1Fragment()
        }
    }
}
