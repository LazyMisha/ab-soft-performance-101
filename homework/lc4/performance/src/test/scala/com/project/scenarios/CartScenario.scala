package com.project.scenarios

import com.project.requests.CartRequest._
import com.project.scenarios.TokenScenario.validateTokenScenario
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object CartScenario {

  /**
    *  Add product to cart
    * */
  val addProductToCartScenario: ScenarioBuilder = scenario("Add Product to Cart Scenario")
    .exec(validateTokenScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(addProductToCartRequest)

  /**
    *  Get all items from cart
    * */
  val getItemsScenario: ScenarioBuilder = scenario("Get Items from Cart Scenario")
    .exec(addProductToCartScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getItemsRequest)

  /**
    *  Checkout
    * */
  val checkoutScenario: ScenarioBuilder = scenario("Checkout Scenario")
    .exec(getItemsScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(checkoutRequest)
}
