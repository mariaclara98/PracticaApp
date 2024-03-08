package com.mariaclara.shopping.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariaclara.shopping.R
import com.mariaclara.shopping.data.Cart
import com.mariaclara.shopping.data.Product

class ProductsListAdapter(
    private val products: List<Product>,
    private val cart: Cart,
    private val onIncrementProductCartQuantity: (Product) -> Unit,
    private val onDecrementProductCartQuantity: (Product) -> Unit,
) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_card, viewGroup, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.setProductImage(product.pictureURL)
        holder.setProductName(product.name)
        holder.setProductPrice(product.price)
        holder.setProductQuantity(cart.getProductQuantity(product))
        holder.setOnIncrementProductQuantityButtonClick {
            onIncrementProductCartQuantity(product)
        }
        holder.setOnDecrementProductQuantityButtonClick {
            onDecrementProductCartQuantity(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}