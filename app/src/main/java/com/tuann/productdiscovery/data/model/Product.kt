package com.tuann.productdiscovery.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val displayName: String?,
    val color: Color?,
    val promotions: List<Promotion>?,
    val promotionPrices: List<PromotionPrices>?,
    val attributeSet: AttributeSet?,
    val magentoId: Long?,
    val seoInfo: SeoInfo?,
    val sku: String?,
    val name: String?,
    val url: String?,
    val brand: Brand?,
    val status: Status?,
    val images: List<Image>?,
    val price: Price?,
    val productLine: ProductLine?,
    val attributeGroups: List<AttributeGroups>?
) : Parcelable

@Parcelize
data class AttributeGroups(
    val id: String?,
    val name: String?,
    val value: String?,
    val parentId: Long?,
    val priority: Long?
) : Parcelable

@Parcelize
data class Promotion(
    val channel: String?
) : Parcelable

@Parcelize
data class PromotionPrices(
    val channel: String?,
    val terminal: String?,
    val finalPrice: Long?,
    val promotionPrice: Long?
) : Parcelable

@Parcelize
data class Color(
    val code: String?,
    val name: String?
) : Parcelable

@Parcelize
data class AttributeSet(
    val id: Long?,
    val name: String?
) : Parcelable

@Parcelize
data class SeoInfo(
    val metaKeyword: String?,
    val metaTitle: String?,
    val metaDescription: String?,
    val shortDescription: String?,
    val description: String?
) : Parcelable

@Parcelize
data class Brand(
    val code: String?,
    val name: String?
) : Parcelable

@Parcelize
data class Status(
    val code: String?,
    val name: String?
) : Parcelable

@Parcelize
data class Image(
    val url: String?,
    val priority: Int?
) : Parcelable

@Parcelize
data class Price(
    val supplierSalePrice: String?,
    val sellPrice: String?
) : Parcelable

@Parcelize
data class ProductLine(
    val code: String?,
    val name: String?
) : Parcelable