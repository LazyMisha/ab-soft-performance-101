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
    .check(substring("\"_id\":"))
    .check(substring("\"description\":"))
    .check(substring("\"inStock\":"))
    .check(substring("\"index\":"))
    .check(substring("\"price\":"))
    .check(substring("\"registered\":"))
    .check(jsonPath("$["+ ProductManager.getRandomIndexId +"]._id").saveAs("productId"))

  /**
    * Get product by id
    * */
  val getProductByIdRequest: HttpRequestBuilder = http("Get Product by ID Request")
    .get(GetUrl.products_service + Endpoint.get_product_by_id + "${productId}")
    .check(status is 200)
    .check(substring("\"_id\":"))
    .check(substring("\"description\":"))
    .check(substring("\"inStock\":"))
    .check(substring("\"index\":"))
    .check(substring("\"price\":"))
    .check(substring("\"registered\":"))
    .check(substring("\"status\":\"ok\""))
}
