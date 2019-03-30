package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, ProductManager, TokenManager}
import io.gatling.core.Predef.{scenario, _}
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object AddProductToCartScenario {

  // must be added product's id in the end
  var add_item = "/api/cart/add_item/"

  var token: String = TokenManager.getToken()

  /**
    *  Add product to cart
    * */
  val addProductToCartRequest: HttpRequestBuilder = http("Add Product to Cart Request")
    .get(GetUrl.cart_service + add_item + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val addProductToCartScenario: ScenarioBuilder = scenario("Add Product to Cart Scenario")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(addProductToCartRequest)

  val addProductToCartSimulation: PopulationBuilder = addProductToCartScenario
    .inject(rampUsers(PerformanceManager.users_add_product_to_cart) during 3600)
}
