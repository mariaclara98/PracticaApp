package com.mariaclara.shopping.utils

fun Double.formatToPrice(): String {
    return "$${"%.2f".format(this)}"
}