package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, TokenManager}
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ViewAllProductsScenario {

  var get_all_products = "/api/products/get_all"

  /**
    *  Get all products
    * */
  val getProductsRequest: HttpRequestBuilder = http("Get All Products Request")
    .get(GetUrl.products_service + get_all_products)
    .check(status is 200)

  val getProductsScenario: ScenarioBuilder = scenario("Get All Products Scenario")
    .exec(addCookie(Cookie("token", TokenManager.getToken()).withDomain("localhost")))
    .exec(getProductsRequest)

  val getProductsSimulation: PopulationBuilder = getProductsScenario
    .inject(rampUsers(PerformanceManager.users_view_all_products) during 3600)
}
