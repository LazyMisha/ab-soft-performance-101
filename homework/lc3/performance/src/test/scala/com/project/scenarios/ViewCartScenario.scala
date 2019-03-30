package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, TokenManager}
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ViewCartScenario {

  var get_items = "/api/cart/get_items"

  /**
    *  Get all items from cart
    * */
  val getItemsRequest: HttpRequestBuilder = http("Get Items Request")
    .get(GetUrl.cart_service + get_items)
    .check(status is 200)

  val getItemsScenario: ScenarioBuilder = scenario("Get Items Scenario")
    .exec(addCookie(Cookie("token", TokenManager.getToken()).withDomain("localhost")))
    .exec(getItemsRequest)

  val getItemsSimulation: PopulationBuilder = getItemsScenario
    .inject(rampUsers(PerformanceManager.users_view_cart) during 3600)
}
