package com.project.scenarios

import com.project.config.ProductManager
import com.project.requests.HomePageRequest.getProductByIdHomePageRequest
import com.project.scenarios.TokenScenario.validateTokenScenario
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object HomePageScenario {

  /**
    * Home Page
    * */
  val homePageScenario: ScenarioBuilder = scenario("Open Home Page Scenario")
    .exec(validateTokenScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .foreach(ProductManager.getBestProductIds(5), "id") {
      exec(getProductByIdHomePageRequest)
    }
}
