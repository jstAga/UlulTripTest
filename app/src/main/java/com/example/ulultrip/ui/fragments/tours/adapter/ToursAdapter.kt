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
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {

                tvTitle.text = currChar?.title
                tvPrice.text = currChar?.price.toString()
                tvGuide.text = currChar?.guide?.get_initials
                tvDesc.text = currChar?.description
                tvComplexity.text = currChar?.complexity
                tvDuration.text = currChar?.duration
                tvId.text = currChar?.id.toString()
            }
        }
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
        val binding: ItemTourBinding,
    ) : RecyclerView.ViewHolder(binding.root)

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