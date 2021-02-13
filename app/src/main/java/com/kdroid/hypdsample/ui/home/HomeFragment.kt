package com.kdroid.hypdsample.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kdroid.hypdsample.databinding.FragmentHomeBinding
import com.kdroid.hypdsample.ui.home.adapter.HomeCategoryAdapter
import com.kdroid.hypdsample.ui.home.adapter.HomeHeaderAdapter
import com.kdroid.hypdsample.ui.home.adapter.PagerAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private val TAG: String = HomeFragment::class.simpleName.toString()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel()::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewManager1 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        val viewManager2 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.incRecView.recyclerView.layoutManager = viewManager1
        binding.incRecCategories.recyclerView.layoutManager = viewManager2
        observeData()
    }

    private fun observeData() {
        homeViewModel.getHeaderData()?.observe(viewLifecycleOwner, { it ->
            binding.incRecView.recyclerView.adapter = HomeHeaderAdapter(homeViewModel, it).apply {
                onItemClick = { Toast.makeText(requireActivity(),"item click $it",Toast.LENGTH_SHORT).show() }
            }
        })
        homeViewModel.getCategory()?.observe(viewLifecycleOwner, { it ->
            binding.incRecCategories.recyclerView.adapter = HomeCategoryAdapter(homeViewModel, it).apply {
                onItemClick = {Toast.makeText(requireActivity(),"item click $it",Toast.LENGTH_SHORT).show() }
            }
        })
        homeViewModel.getBannerImage()?.observe(viewLifecycleOwner, { it ->
            binding.vpBestDeals.adapter = PagerAdapter(requireActivity(), it).apply {

            }
        })
    }
}