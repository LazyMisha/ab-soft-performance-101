package com.project.scenarios

import com.project.scenarios.TokenScenario.validateTokenScenario
import com.project.requests.ProductRequest._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.{Cookie, addCookie}

object ProductScenario {

  /**
    *  Get all products
    * */
  val getAllProductsScenario: ScenarioBuilder = scenario("Get All Products Scenario")
    .exec(validateTokenScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getProductsRequest)

  /**
    * Get product by id
    * */
  val getProductByIdScenario: ScenarioBuilder = scenario("Get Product by ID Scenario")
    .exec(validateTokenScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getProductByIdRequest)
}
