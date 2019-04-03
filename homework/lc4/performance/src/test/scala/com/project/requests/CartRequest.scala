package com.project.requests

import com.project.config.{Endpoint, GetUrl, ProductManager}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object CartRequest {

  /**
    *  Add product to cart
    * */
  val addProductToCartRequest: HttpRequestBuilder = http("Add Product to Cart Request")
    .get(GetUrl.cart_service + Endpoint.add_item + ProductManager.getRandomProductId)
    .check(status is 200)

  /**
    *  Get all items from cart
    * */
  val getItemsRequest: HttpRequestBuilder = http("Get Items from Cart Request")
    .get(GetUrl.cart_service + Endpoint.get_items)
    .check(status is 200)

  /**
    *  Checkout
    * */
  val checkoutRequest: HttpRequestBuilder = http("Checkout Request")
    .get(GetUrl.cart_service + Endpoint.checkout)
    .check(status is 200)
}
