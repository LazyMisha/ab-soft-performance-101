package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, ProductManager, TokenManager}
import com.project.scenarios.AddProductToCartScenario.token
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object CheckoutScenario {

  var checkout = "/api/cart/checkout"

  // must be added product's id in the end
  var add_item = "/api/cart/add_item/"

  var token: String = TokenManager.getToken()

  /**
    *  Checkout
    * */
  val addProductToCartRequest: HttpRequestBuilder = http("Add Product to Cart Request")
    .get(GetUrl.cart_service + add_item + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val addProductToCartScenario: ScenarioBuilder = scenario("Add Product to Cart Scenario")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(addProductToCartRequest)

  val checkoutRequest: HttpRequestBuilder = http("Checkout Request")
    .get(GetUrl.cart_service + checkout)
    .check(status is 200)

  val checkoutScenario: ScenarioBuilder = scenario("Checkout Scenario")
    .exec(addProductToCartScenario)
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(checkoutRequest)

  val checkoutSimulation: PopulationBuilder = checkoutScenario
    .inject(rampUsers(PerformanceManager.users_checkout) during 3600)

}
