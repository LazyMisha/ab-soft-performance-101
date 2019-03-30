package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, ProductManager, TokenManager}
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ViewProductDetailsScenario {

  // must be added product's id in the end
  var get_product_by_id = "/api/products/get_product/"

  var token: String = TokenManager.getToken()

  /**
    * Get product by id
    * */
  val getProductByIdRequest: HttpRequestBuilder = http("Get Product by ID Request")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario: ScenarioBuilder = scenario("Get Product by ID Scenario")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(getProductByIdRequest)

  val getProductByIdSimulation: PopulationBuilder = getProductByIdScenario
    .inject(rampUsers(PerformanceManager.users_product_details) during 3600)
}
