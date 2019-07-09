package com.tuann.productdiscovery.data.api.response.mapper

import com.tuann.productdiscovery.data.api.response.*
import com.tuann.productdiscovery.data.api.response.PriceResponse
import com.tuann.productdiscovery.data.model.*

fun List<ProductResponse>.toProducts(): List<Product> = map {
    it.toProduct()
}

fun ProductResponse.toProduct(): Product = Product(
    displayName,
    color?.toColor(),
    promotions?.toPromotions(),
    promotionPrices?.toPromotionPrices(),
    attributeSet?.toAttributeSet(),
    magentoId,
    seoInfo?.toSeoInfo(),
    sku,
    name,
    url,
    brand?.toBrand(),
    status?.toStatus(),
    images?.toImages(),
    price?.toPrice(),
    productLine?.toProductLine()
)

fun List<PromotionResponse>.toPromotions(): List<Promotion> = map { it.toPromotion() }

fun PromotionResponse.toPromotion(): Promotion = Promotion()

fun List<PromotionPricesResponse>.toPromotionPrices(): List<PromotionPrices> = map {
    it.toPromotionPrice()
}

fun PromotionPricesResponse.toPromotionPrice(): PromotionPrices = PromotionPrices(
    channel, terminal, finalPrice, promotionPrice
)

fun ColorResponse.toColor(): Color = Color(
    code, name
)

fun AttributeSetResponse.toAttributeSet(): AttributeSet = AttributeSet(
    id, name
)

fun SeoInfoResponse.toSeoInfo(): SeoInfo = SeoInfo(
    metaKeyword, metaTitle, metaDescription, shortDescription, description
)

fun BrandResponse.toBrand(): Brand = Brand(
    code, name
)

fun StatusResponse.toStatus(): Status = Status(
    code, name
)

fun ImageResponse.toImage(): Image = Image(
    url, priority
)

fun List<ImageResponse>.toImages(): List<Image> = map {
    it.toImage()
}

fun ProductLineResponse.toProductLine(): ProductLine = ProductLine(
    code, name
)

fun PriceResponse.toPrice(): Price = Price(
    supplierSalePrice, sellPrice
)