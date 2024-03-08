package com.mariaclara.shopping.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mariaclara.shopping.R
import com.mariaclara.shopping.utils.formatToPrice
import com.squareup.picasso.Picasso

class CartProductViewHolder(itemView: View) : ViewHolder(itemView) {

    private val productImage: ImageView = itemView.findViewById(R.id.product_image)
    private val productName: TextView = itemView.findViewById(R.id.product_name)
    private val productPrice: TextView = itemView.findViewById(R.id.product_price)
    private val productQuantity: TextView = itemView.findViewById(R.id.product_quantity)
    private val productTotal: TextView = itemView.findViewById(R.id.product_total)

    fun setProductImage(imageURL: String) {
        Picasso.get().load(imageURL).into(productImage)
    }

    fun setProductName(name: String) {
        productName.text = name
    }

    fun setProductPriceAndQuantity(price: Double, quantity: Int) {
        productPrice.text = price.formatToPrice()
        productQuantity.text = quantity.toString()
        productTotal.text = (price * quantity).formatToPrice()
    }
}