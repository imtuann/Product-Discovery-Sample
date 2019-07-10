package com.tuann.productdiscovery.presentation.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tuann.productdiscovery.R
import com.tuann.productdiscovery.data.model.AttributeGroups
import com.tuann.productdiscovery.databinding.ItemAttributeBinding

class AttributeProductAdapter : RecyclerView.Adapter<AttributeProductAdapter.AttributeViewHolder>() {
    private val data = ArrayList<AttributeGroups>()

    fun setData(items: List<AttributeGroups>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        return AttributeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_attribute,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    inner class AttributeViewHolder(private val binding: ItemAttributeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: AttributeGroups) {
            binding.attribute = item
            binding.position = adapterPosition
        }
    }
}
