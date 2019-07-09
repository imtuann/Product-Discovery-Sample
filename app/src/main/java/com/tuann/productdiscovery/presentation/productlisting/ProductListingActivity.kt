package com.tuann.productdiscovery.presentation.productlisting

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuann.productdiscovery.R
import com.tuann.productdiscovery.databinding.ActivityProductListingBinding
import com.tuann.productdiscovery.di.ViewModelFactory
import com.tuann.productdiscovery.presentation.common.BaseActivity
import javax.inject.Inject
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.tuann.productdiscovery.presentation.listener.EndlessRecyclerOnScrollListener
import com.tuann.productdiscovery.utils.ext.hideKeyboard

class ProductListingActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ProductListingViewModel

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityProductListingBinding>(this, R.layout.activity_product_listing)
    }
    private val channel = "pv_online"
    private val visitorId = ""
    private val terminal = "CP01"
    private var q = ""
    private var endlessListener: EndlessRecyclerOnScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        handleSearch()
        binding.ivBack.setOnClickListener {
            finish()
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductListingViewModel::class.java)
            .apply {
                setChannel(channel)
                setVisitorId(visitorId)
                setTerminal(terminal)
            }

        viewModel.productsCallback.observe(this, Observer {
            if (it != null) this.handleProductListingDataState(it)
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            loadAgain()
        }
        viewModel.getProducts(q)
    }

    private fun loadAgain() {
        (binding.recyclerView.adapter as? ProductListingAdapter)?.resetData()
        endlessListener?.reset()
        viewModel.getProducts(q)
        binding.etSearch.hideKeyboard()
        binding.etSearch.clearFocus()
    }

    private fun handleSearch() {
        binding.etSearch.clearFocus()
        binding.etSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    q = binding.etSearch.text.toString().trim()
                    loadAgain()
                    return true
                }
                return false
            }
        })
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnClose.visibility =
                    if (binding.etSearch.toString().trim().isNotEmpty()) View.VISIBLE else View.GONE
            }
        })
        binding.btnClose.setOnClickListener {
            binding.etSearch.setText("")
        }
    }

    private fun handleProductListingDataState(state: ProductListingState) {
        when (state) {
            is ProductListingState.Loading -> {
                binding.swipeRefreshLayout.isRefreshing = true
            }
            is ProductListingState.ShowError -> {
                binding.swipeRefreshLayout.isRefreshing = false
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
            is ProductListingState.Success -> {
                binding.swipeRefreshLayout.isRefreshing = false
                (binding.recyclerView.adapter as? ProductListingAdapter)?.addData(state.products)
            }
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = ProductListingAdapter()

        endlessListener = object : EndlessRecyclerOnScrollListener(layoutManager) {
            override fun onLoadMore(currentPage: Int) {
                viewModel.getProducts(q, currentPage)
            }
        }
        binding.recyclerView.addOnScrollListener(endlessListener!!)
    }
}
