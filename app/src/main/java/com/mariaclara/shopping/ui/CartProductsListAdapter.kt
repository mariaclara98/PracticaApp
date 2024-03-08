package com.mariaclara.shopping.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariaclara.shopping.R
import com.mariaclara.shopping.data.Cart

class CartProductsListAdapter(private val cart: Cart) :
    RecyclerView.Adapter<CartProductViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CartProductViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_product_card, viewGroup, false)
        return CartProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        val (product, quantity) = cart.productsQuantities.toList()[position]
        holder.setProductImage(product.pictureURL)
        holder.setProductName(product.name)
        holder.setProductPriceAndQuantity(product.price, quantity)
    }

    override fun getItemCount(): Int {
        return cart.productsQuantities.size
    }
}