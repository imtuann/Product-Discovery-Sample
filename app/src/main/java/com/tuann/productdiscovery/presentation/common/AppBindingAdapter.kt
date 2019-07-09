package com.tuann.productdiscovery.presentation.common

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tuann.productdiscovery.R

object AppBindingAdapter {

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_pv)
                    .error(R.drawable.ic_pv)
            )
            .into(view)
    }

    @BindingAdapter("app:setStrikeThrough")
    @JvmStatic
    fun strikeThroughText(view: TextView, content: String) {
        val spannable = SpannableString(content)
        spannable.setSpan(StrikethroughSpan(), 0, content.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        view.setText(spannable)
    }
}