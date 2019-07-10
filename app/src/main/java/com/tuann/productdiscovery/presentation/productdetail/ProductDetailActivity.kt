package com.tuann.productdiscovery.presentation.productdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.tuann.productdiscovery.R
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.databinding.ActivityProductDetailBinding
import com.tuann.productdiscovery.di.ViewModelFactory
import com.tuann.productdiscovery.presentation.common.BaseActivity
import javax.inject.Inject

class ProductDetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var product: Product

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityProductDetailBinding>(this, R.layout.activity_product_detail)
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ProductDetailViewModel::class.java)
    }

    private var quantity = 1
    private var price = 10420000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = intent.getParcelableExtra(EXTRA_PRODUCT)

        binding.product = product

        updatePrice()
        initProductPhotoViewPager()
        initSameProductRecycleView()

        viewModel.productCallback.observe(this, Observer {
            if (it != null) this.handleProductDataState(it)
        })
        if (product.sku != null) {
            viewModel.getProduct(product.sku!!)
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.btnPlus.setOnClickListener {
            quantity++
            binding.quantity = quantity
        }
        binding.btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                binding.quantity = quantity
            }
        }
    }

    private fun updatePrice() {
        if (product.price?.sellPrice != null) {
            price = product.price?.sellPrice?.toDouble()?.toInt() ?: 10420000
            binding.quantity = quantity
            binding.price = price
        } else {
            binding.quantity = quantity
            binding.price = price
        }
    }

    private fun initTabsInfo() {
        initAttributeProduct()
        binding.tabsInfo.addTab(binding.tabsInfo.newTab().setText(getString(R.string.tab_product_description)))
        binding.tabsInfo.addTab(binding.tabsInfo.newTab().setText(getString(R.string.tab_attribute_product)))
        binding.tabsInfo.addTab(binding.tabsInfo.newTab().setText(getString(R.string.tab_compare_price)))
        binding.tabsInfo.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        binding.descriptionLayout.visibility = View.VISIBLE
                        binding.compareLayout.visibility = View.GONE
                        binding.attributeRecyclerView.visibility = View.GONE
                    }
                    1 -> {
                        binding.descriptionLayout.visibility = View.GONE
                        binding.compareLayout.visibility = View.GONE
                        binding.attributeRecyclerView.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.descriptionLayout.visibility = View.GONE
                        binding.compareLayout.visibility = View.VISIBLE
                        binding.attributeRecyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun initSameProductRecycleView() {
        binding.sameProductRecyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.HORIZONTAL,
            false
        )
        binding.sameProductRecyclerView.adapter = SameProductAdapter()
    }

    private fun initAttributeProduct() {
        product.attributeGroups?.let {
            binding.attributeRecyclerView.layoutManager = LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
            )
            val adapter = AttributeProductAdapter()
            adapter.setData(it)
            binding.attributeRecyclerView.adapter = adapter
        }
    }

    private fun initProductPhotoViewPager() {
        val adapter = ProductPhotoAdapter()
        adapter.setData(product.images ?: emptyList())

        binding.viewPager.adapter = adapter
    }

    private fun handleProductDataState(state: ProductDetailState) {
        when (state) {
            is ProductDetailState.Success -> {
                this.product = state.product
                binding.product = this.product

                updatePrice()
                binding.executePendingBindings()

                initTabsInfo()
            }
            is ProductDetailState.Loading -> {

            }
            is ProductDetailState.ShowError -> {
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val EXTRA_PRODUCT = "extra_product"

        fun newIntent(context: Context, product: Product): Intent =
            Intent(context, ProductDetailActivity::class.java)
                .apply {
                    putExtra(EXTRA_PRODUCT, product)
                }
    }
}