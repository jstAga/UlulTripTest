package com.example.ulultrip.ui.fragments.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ulultrip.core.network.paging.BaseDiffModel
import com.example.ulultrip.core.network.paging.BaseDiffUtil
import com.example.ulultrip.data.model.CategoryModel
import com.example.ulultrip.databinding.ItemCharacterBinding

class CategoryAdapter :
    PagingDataAdapter<CategoryModel, CategoryAdapter.CategoryPagingViewHolder>(diffCallback) {
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
        val diffCallback = object : DiffUtil.ItemCallback<CategoryModel>() {
            override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}