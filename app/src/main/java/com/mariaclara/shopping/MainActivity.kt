package com.mariaclara.shopping

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mariaclara.shopping.data.Cart
import com.mariaclara.shopping.data.Product
import com.mariaclara.shopping.ui.ProductsListAdapter

class MainActivity : AppCompatActivity() {
    private val cart = Cart()
    private val products = listOf(
        Product(
            id = 1,
            name = "Banana",
            price = 0.5,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/bananas/banana.jpg"
        ),
        Product(
            id = 2,
            name = "Apple",
            price = 0.3,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/apples-pears/cox-apples.jpg"
        ),
        Product(
            id = 3,
            name = "Orange",
            price = 0.4,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/citrus-fruits/blood-orange.jpg"
        ),
        Product(
            id = 4,
            name = "Pineapple",
            price = 1.5,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/other-popular-fruits/pineapple.jpg"
        ),
        Product(
            id = 5,
            name = "Strawberry",
            price = 0.2,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/fresh-berries/strawberries.jpg"
        ),
        Product(
            id = 6,
            name = "Grapes",
            price = 0.8,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/grapes/green-seedless-grape.jpg"
        ),
        Product(
            id = 7,
            name = "Watermelon",
            price = 2.0,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/melon/watermelon.jpg"
        ),
        Product(
            id = 8,
            name = "Peach",
            price = 0.6,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/stone-fruits/flat-peach.jpg"
        ),
        Product(
            id = 9,
            name = "Pear",
            price = 0.7,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/apples-pears/comice-pear.jpg"
        ),
        Product(
            id = 10,
            name = "Cherry",
            price = 0.3,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/stone-fruits/black-cherry.jpg"
        ),
        Product(
            id = 11,
            name = "Kiwi",
            price = 0.5,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/other-popular-fruits/kiwi.jpg"
        ),
        Product(
            id = 12,
            name = "Mango",
            price = 1.0,
            pictureURL = "https://www.fruitandveg.co.uk/uploads/products/stone-fruits/mango-fair-trade.jpg"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ProductsListAdapter(
            products,
            cart,
            this::onAddProductToCart,
            this::onRemoveProductFromCart
        )
        val productsList = findViewById<RecyclerView>(R.id.products_list)
        productsList.adapter = adapter
        productsList.layoutManager = LinearLayoutManager(this)

        val checkoutButton = findViewById<Button>(R.id.checkout_button)
        checkoutButton.setOnClickListener { onCheckout() }
    }

    private fun onAddProductToCart(product: Product) {
        cart.addProduct(product)
    }

    private fun onRemoveProductFromCart(product: Product) {
        cart.removeProduct(product)
    }

    private fun onCheckout() {
        val intent = Intent(this, CartActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putSerializable("cart", cart)
            putExtras(bundle)
        }
        startActivity(intent)
    }
}