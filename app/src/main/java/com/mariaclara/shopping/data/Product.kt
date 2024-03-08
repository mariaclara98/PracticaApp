package com.mariaclara.shopping.data

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val pictureURL: String
) : Serializable
