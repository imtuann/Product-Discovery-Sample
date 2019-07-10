package com.tuann.productdiscovery.presentation.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tuann.productdiscovery.R
import com.tuann.productdiscovery.databinding.ItemSameProductBinding

class SameProductAdapter : RecyclerView.Adapter<SameProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_same_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    }

    inner class ProductViewHolder(private val binding: ItemSameProductBinding) : RecyclerView.ViewHolder(binding.root)
}