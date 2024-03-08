package com.mariaclara.shopping.data

import java.io.Serializable

data class Cart(
    val productsQuantities: MutableMap<Product, Int> = mutableMapOf(),
    val serviceFee: Double = 2.0,
    val taxRate: Double = 12.0,
) : Serializable {

    fun addProduct(product: Product) {
        val currentQuantity = productsQuantities[product] ?: 0
        productsQuantities[product] = currentQuantity + 1
    }

    fun removeProduct(product: Product) {
        val currentQuantity = productsQuantities[product] ?: 0
        if (currentQuantity > 1) {
            productsQuantities[product] = currentQuantity - 1
        } else if (currentQuantity == 1) {
            productsQuantities.remove(product)
        }
    }

    fun getProductQuantity(product: Product): Int {
        return productsQuantities[product] ?: 0
    }

    val productsTotal: Double
        get() {
            return productsQuantities
                .map { (product, quantity) -> product.price * quantity }
                .sum()
        }

    val taxesTotal: Double
        get() {
            return (productsTotal + serviceFee) * taxRate / 100
        }

    val total: Double
        get() {
            return productsTotal + taxesTotal
        }
}
