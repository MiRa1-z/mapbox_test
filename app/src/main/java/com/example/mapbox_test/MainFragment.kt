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

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var swipePagerAdapter: SwipePagerAdapter
    private lateinit var viewPager: ViewPager2

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
        Log.d("MainFrag","view")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Page${(position + 1)}"
            Log.d("MainFrag","Map${(position + 1)}")
        }.attach()

        swipePagerAdapter = SwipePagerAdapter(this)
        viewPager.adapter = swipePagerAdapter
    }

    class SwipePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
        override fun getItemCount() = 20

        override fun createFragment(position: Int) = when (position % 2) {
            0 -> Map1Fragment()
            1 -> Map2Fragment()
            else -> Map1Fragment()
        }
    }
}

