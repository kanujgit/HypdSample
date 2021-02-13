package com.kdroid.hypdsample.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kdroid.hypdsample.databinding.HeaderChipsViewBinding
import com.kdroid.hypdsample.ui.home.HomeViewModel


class HomeHeaderAdapter(val viewModel: HomeViewModel, private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<HomeHeaderAdapter.ViewHolder>() {
    var onItemClick: ((Int) -> Unit)? = null

    inner class ViewHolder(private val binding: HeaderChipsViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: String) {
            binding.tvTitle.text = position
        }

        init {
            binding.tvTitle.setOnClickListener { onItemClick?.invoke(adapterPosition) }
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val layoutInflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
        val binding: HeaderChipsViewBinding =
            HeaderChipsViewBinding.inflate(layoutInflater, viewGroup, false)
        val view: View = binding.root
        val layoutParams: ViewGroup.LayoutParams = view.layoutParams
        layoutParams.width = (viewGroup.width * 0.6).toInt()
        view.layoutParams = layoutParams
//        ViewGroup.LayoutParams layoutParams = itemView . getLayoutParams ();
//        layoutParams.height = (int)(parent.getHeight() * 0.3);
//        itemView.setLayoutParams(layoutParams)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(dataSet[position])

    override fun getItemCount() = dataSet.size


}