package com.tuann.productdiscovery.presentation.productlisting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.data.repository.ProductRepository
import com.tuann.productdiscovery.utils.rx.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ProductListingViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _productsCallback = MutableLiveData<ProductListingState>()
    val productsCallback: MutableLiveData<ProductListingState> = _productsCallback

    private lateinit var channel: String
    private lateinit var visitorId: String
    private lateinit var terminal: String
    fun setChannel(channel: String) {
        this.channel = channel
    }

    fun setVisitorId(visitorId: String) {
        this.visitorId = visitorId
    }

    fun setTerminal(terminal: String) {
        this.terminal = terminal
    }

    fun getProducts(
        q: String,
        page: Int = 1
    ) {
        _productsCallback.value = ProductListingState.Loading
        repository.getProducts(channel, visitorId, q, terminal, page)
            .subscribeOn(schedulerProvider.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Product>> {
                override fun onSuccess(t: List<Product>) {
                    _productsCallback.value = ProductListingState.Success(t)
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    _productsCallback.value = ProductListingState.ShowError(e.toString())
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}