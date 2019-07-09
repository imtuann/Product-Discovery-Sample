package com.tuann.productdiscovery.presentation.productlisting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tuann.productdiscovery.R
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.databinding.ItemProductBinding

class ProductListingAdapter : RecyclerView.Adapter<ProductListingAdapter.ProductViewHolder>() {
    private val data = ArrayList<Product>()

    fun addData(items: List<Product>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_product,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    fun resetData() {
        data.clear()
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(product: Product) {
            binding.product = product
        }
    }
}