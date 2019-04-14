package com.project.config

object Endpoint {

  /**
    * Authentication service
    * */
  var generate_token = "/api/auth/generate_token"
  var validate_token = "/api/auth/validate_token/"

  /**
    * Cart service
    * */
  var checkout = "/api/cart/checkout"
  var get_items = "/api/cart/get_items"
  var add_item = "/api/cart/add_item/" // must be added product's id in the end

  /**
    * Product service
    * */
  var get_all_products = "/api/products/get_all"
  var get_product_by_id = "/api/products/get_product/" // must be added product's id in the end

}
