package com.kdroid.hypdsample.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.hypdsample.databinding.CategoryChipsViewBinding
import com.kdroid.hypdsample.ui.home.HomeViewModel


class HomeCategoryAdapter(val viewModel: HomeViewModel, private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    inner class ViewHolder(private val binding: CategoryChipsViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: String) {
            binding.tvSubTitle.text = position
        }

        init {
            binding.tvTitle.setOnClickListener { onItemClick?.invoke(adapterPosition) }
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
        val binding: CategoryChipsViewBinding =
            CategoryChipsViewBinding.inflate(layoutInflater, viewGroup, false)
        val view: View = binding.root
        val layoutParams: ViewGroup.LayoutParams = view.layoutParams
        view.layoutParams = layoutParams
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(dataSet[position])

    override fun getItemCount() = dataSet.size


}