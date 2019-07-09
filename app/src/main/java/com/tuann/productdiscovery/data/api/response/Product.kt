package com.tuann.productdiscovery.data.api.response

class ProductResponse(
    val displayName: String?,
    val color: ColorResponse?,
    val promotions: List<PromotionResponse>?,
    val promotionPrices: List<PromotionPricesResponse>?,
    val attributeSet: AttributeSetResponse?,
    val magentoId: Long?,
    val seoInfo: SeoInfoResponse?,
    val sku: String?,
    val name: String?,
    val url: String?,
    val brand: BrandResponse?,
    val status: StatusResponse?,
    val images: List<ImageResponse>?,
    val price: PriceResponse?,
    val productLine: ProductLineResponse?
)

class PromotionResponse

class PromotionPricesResponse(
    val channel: String?,
    val terminal: String?,
    val finalPrice: Long?,
    val promotionPrice: Long?
)

class ColorResponse(
    val code: String?,
    val name: String?
)

class AttributeSetResponse(
    val id: Long?,
    val name: String?
)

class SeoInfoResponse(
    val metaKeyword: String?,
    val metaTitle: String?,
    val metaDescription: String?,
    val shortDescription: String?,
    val description: String?
)

class BrandResponse(
    val code: String?,
    val name: String?
)

class StatusResponse(
    val code: String?,
    val name: String?
)

class ImageResponse(
    val url: String?,
    val priority: Int?
)

class PriceResponse(
    val supplierSalePrice: String?,
    val sellPrice: String?
)

class ProductLineResponse(
    val code: String?,
    val name: String?
)