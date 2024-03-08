package com.mariaclara.shopping.ui

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mariaclara.shopping.R
import com.mariaclara.shopping.utils.formatToPrice
import com.squareup.picasso.Picasso

class ProductViewHolder(itemView: View) : ViewHolder(itemView) {
    private val productImage: ImageView = itemView.findViewById(R.id.product_image)
    private val productName: TextView = itemView.findViewById(R.id.product_name)
    private val productPrice: TextView = itemView.findViewById(R.id.product_price)
    private val addProductToCartButton: Button = itemView.findViewById(R.id.buy_button)

    private val productCartQuantity: TextView = itemView.findViewById(R.id.product_cart_quantity)
    private val changeQuantitiesButtons: View = itemView.findViewById(R.id.product_quantity_buttons)
    private val decreaseQuantityButton: Button =
        itemView.findViewById(R.id.decrease_product_quantity_button)
    private val increaseQuantityButton: Button =
        itemView.findViewById(R.id.increase_product_quantity_button)

    private var cartQuantity: Int = 0;

    fun setProductImage(productImageURL: String) {
        Picasso.get().load(productImageURL).into(productImage)
    }

    fun setProductName(name: String) {
        productName.text = name
    }

    fun setProductPrice(price: Double) {
        productPrice.text = price.formatToPrice()
    }

    fun setOnIncrementProductQuantityButtonClick(onClickAction: () -> Unit) {
        val increaseQuantityActions = { _: View ->
            onClickAction()
            setProductQuantity(cartQuantity + 1)
        }

        addProductToCartButton.setOnClickListener(increaseQuantityActions)
        increaseQuantityButton.setOnClickListener(increaseQuantityActions)
    }

    fun setOnDecrementProductQuantityButtonClick(onClickAction: () -> Unit) {
        decreaseQuantityButton.setOnClickListener {
            onClickAction()
            setProductQuantity(cartQuantity - 1)
        }
    }

    fun setProductQuantity(quantity: Int) {
        cartQuantity = quantity
        productCartQuantity.text = quantity.toString()
        changeQuantitiesButtons.visibility = if (quantity > 0) View.VISIBLE else View.GONE
        addProductToCartButton.visibility = if (quantity > 0) View.GONE else View.VISIBLE
    }
}