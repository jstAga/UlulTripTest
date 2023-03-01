package com.example.ulultrip.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ulultrip.data.model.ResultModel
import com.example.ulultrip.databinding.ItemCharacterBinding

class CategoryAdapter :
    PagingDataAdapter<ResultModel, CategoryAdapter.CategoryPagingViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: CategoryPagingViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {

                tvText.text = currChar?.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryPagingViewHolder {
        return CategoryPagingViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class CategoryPagingViewHolder(
        val binding: ItemCharacterBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ResultModel>() {
            override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}