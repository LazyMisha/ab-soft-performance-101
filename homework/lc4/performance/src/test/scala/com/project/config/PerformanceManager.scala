package com.project.config

object PerformanceManager {

   /**
    * 1
    * Open Home Page
    * 1000
    *
    * 2
    * View All products
    * 1400
    *
    * 3
    * View Product Details
    * 1800
    *
    * 4
    * Add Product to cart 400 (now 320 due to checkout simulation 80)
    * 320
    *
    * 5
    * View Cart
    * 240
    *
    * 6
    * Checkout
    * 80
    * */

  val users_home_page: Int = Integer.getInteger("users", 1000).toInt
  val users_view_all_products: Int = Integer.getInteger("users", 1400).toInt
  val users_product_details: Int = Integer.getInteger("users", 1800).toInt
  val users_add_product_to_cart: Int = Integer.getInteger("users", 320).toInt
  val users_view_cart: Int = Integer.getInteger("users", 240).toInt
  val users_checkout: Int = Integer.getInteger("users", 80).toInt

  val rampUp: Int = Integer.getInteger("rampup", 3600).toInt
  val throughput: Int = Integer.getInteger("throughput", 100).toInt
}
