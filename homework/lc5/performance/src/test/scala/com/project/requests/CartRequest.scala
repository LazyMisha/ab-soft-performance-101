package com.project.requests

import com.project.config.{Endpoint, GetUrl}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object CartRequest {

  /**
    *  Add product to cart
    * */
  val addProductToCartRequest: HttpRequestBuilder = http("Add Product to Cart Request")
    .get(GetUrl.cart_service + Endpoint.add_item + "${productId}")
    .check(status is 200)
    .check(substring("{\"message\":\"Product added to cart\",\"status\":\"ok\"}"))

  /**
    *  Get all items from cart
    * */
  val getItemsRequest: HttpRequestBuilder = http("Get Items from Cart Request")
    .get(GetUrl.cart_service + Endpoint.get_items)
    .check(status is 200)
    .check(substring("\"cart_items\":"))
    .check(substring("\"status\":\"ok\""))

  /**
    *  Checkout
    * */
  val checkoutRequest: HttpRequestBuilder = http("Checkout Request")
    .get(GetUrl.cart_service + Endpoint.checkout)
    .check(status is 200)
    .check(substring("\"status\":\"ok\""))
}
