package com.example.ulultrip.ui.fragments.tours.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ulultrip.data.model.TourModel
import com.example.ulultrip.databinding.ItemTourBinding

class ToursAdapter(val onItemClick: (TourModel) -> Unit) :
    PagingDataAdapter<TourModel, ToursAdapter.TourModelPagingViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: TourModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourModelPagingViewHolder {
        return TourModelPagingViewHolder(
            ItemTourBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class TourModelPagingViewHolder(
        private val binding: ItemTourBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TourModel) {
            with(binding) {
                tvTitle.text = model.title
                tvPrice.text = model.price.toString()
                tvGuide.text = model.guide.get_initials
                tvDesc.text = model.description
                tvComplexity.text = model.complexity
                tvDuration.text = model.duration
                tvId.text = model.id.toString()
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<TourModel>() {
            override fun areItemsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}