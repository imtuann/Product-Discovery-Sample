package com.tuann.productdiscovery.data.model

class Product(
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
    val productLine: ProductLine?
)

class Promotion

class PromotionPrices(
    val channel: String?,
    val terminal: String?,
    val finalPrice: Long?,
    val promotionPrice: Long?
)


class Color(
    val code: String?,
    val name: String?
)

class AttributeSet(
    val id: Long?,
    val name: String?
)

class SeoInfo(
    val metaKeyword: String?,
    val metaTitle: String?,
    val metaDescription: String?,
    val shortDescription: String?,
    val description: String?
)

class Brand(
    val code: String?,
    val name: String?
)

class Status(
    val code: String?,
    val name: String?
)

class Image(
    val url: String?,
    val priority: Int?
)

class Price(
    val supplierSalePrice: String?,
    val sellPrice: String?
)

class ProductLine(
    val code: String?,
    val name: String?
)