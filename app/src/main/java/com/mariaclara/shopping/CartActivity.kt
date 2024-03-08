package com.mariaclara.shopping

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mariaclara.shopping.data.Cart
import com.mariaclara.shopping.ui.CartProductsListAdapter
import com.mariaclara.shopping.utils.formatToPrice

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val bundle: Bundle = intent.extras!!
        val cart = bundle.getSerializable("cart")!!

        val adapter = CartProductsListAdapter(cart as Cart)
        val productsList = findViewById<RecyclerView>(R.id.products_list)
        productsList.layoutManager = LinearLayoutManager(this)
        productsList.adapter = adapter

        setTotals(cart)
    }

    private fun setTotals(cart: Cart) {
        val productsTotal = findViewById<TextView>(R.id.products_total_value)
        val serviceFee = findViewById<TextView>(R.id.service_fee_value)
        val taxesTotal = findViewById<TextView>(R.id.tax_value)
        val total = findViewById<TextView>(R.id.total_value)

        productsTotal.text = cart.productsTotal.formatToPrice()
        serviceFee.text = cart.serviceFee.formatToPrice()
        taxesTotal.text = cart.taxesTotal.formatToPrice()
        total.text = cart.total.formatToPrice()
    }
}