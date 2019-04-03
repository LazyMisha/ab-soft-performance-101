package com.project.requests

import com.project.config.{Endpoint, GetUrl, ProductManager}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ProductRequest {

  /**
    *  Get all products
    * */
  val getProductsRequest: HttpRequestBuilder = http("Get All Products Request")
    .get(GetUrl.products_service + Endpoint.get_all_products)
    .check(status is 200)

  /**
    * Get product by id
    * */
  val getProductByIdRequest: HttpRequestBuilder = http("Get Product by ID Request")
    .get(GetUrl.products_service + Endpoint.get_product_by_id + ProductManager.getRandomProductId)
    .check(status is 200)
}
