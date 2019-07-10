package com.tuann.productdiscovery.presentation.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuann.productdiscovery.data.model.Product
import com.tuann.productdiscovery.data.repository.ProductRepository
import com.tuann.productdiscovery.utils.rx.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _productCallback = MutableLiveData<ProductDetailState>()
    val productCallback: LiveData<ProductDetailState> = _productCallback

    fun getProduct(sku: String) {
        _productCallback.value = ProductDetailState.Loading
        repository.getProduct(sku)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(object : SingleObserver<Product> {
                override fun onSuccess(t: Product) {
                    _productCallback.value = ProductDetailState.Success(t)
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    _productCallback.value = ProductDetailState.ShowError(e.toString())
                }
            })
    }
}