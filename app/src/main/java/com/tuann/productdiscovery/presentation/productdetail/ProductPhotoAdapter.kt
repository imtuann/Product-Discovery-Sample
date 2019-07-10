package com.tuann.productdiscovery.presentation.productdetail

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.tuann.productdiscovery.data.model.Image

internal class ProductPhotoAdapter : PagerAdapter() {

    private var images = ArrayList<Image>()

    fun setData(items: List<Image>) {
        images.clear()
        images.addAll(items)
        notifyDataSetChanged()
    }

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val imageView = ImageView(collection.context)
        Glide.with(imageView)
            .load(images[position].url)
            .centerCrop()
            .into(imageView)
        collection.addView(imageView)
        return imageView
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}