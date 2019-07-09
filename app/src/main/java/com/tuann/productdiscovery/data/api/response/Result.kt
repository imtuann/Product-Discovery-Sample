package com.tuann.productdiscovery.data.api.response

class Result<T>(
    val code: String?,
    val result: T?,
    val extra: Extra?
)

class Extra(
    val totalItems: Int?,
    val page: Int?,
    val pageSize: Int?
)