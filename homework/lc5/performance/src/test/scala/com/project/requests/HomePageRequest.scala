package com.project.requests

import com.project.config.{Endpoint, GetUrl}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object HomePageRequest {

  /**
    * Get random product details for Home Page
    * */
  val getProductByIdHomePageRequest: HttpRequestBuilder = http("Home Page Request")
    .get(GetUrl.products_service + Endpoint.get_product_by_id + "${id}")
    .check(status is 200)
    .check(substring("\"_id\":"))
    .check(substring("\"description\":"))
    .check(substring("\"inStock\":"))
    .check(substring("\"index\":"))
    .check(substring("\"price\":"))
    .check(substring("\"registered\":"))
    .check(substring("\"status\":\"ok\""))
}
