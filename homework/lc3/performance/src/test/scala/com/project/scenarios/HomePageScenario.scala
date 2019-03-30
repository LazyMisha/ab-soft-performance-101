package com.project.scenarios

import com.project.config.{GetUrl, PerformanceManager, ProductManager, TokenManager}
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object HomePageScenario {

  // must be added product's id in the end
  var get_product_by_id = "/api/products/get_product/"

  var token: String = TokenManager.getToken()

  /**
    * Home Page
    * */
  val get_product_by_id_request1: HttpRequestBuilder = http("Open Home Page Request 1")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario1: ScenarioBuilder = scenario("Open Home Page Scenario 1")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(get_product_by_id_request1)

  val getProductByIdSimulation1: PopulationBuilder = getProductByIdScenario1
    .inject(rampUsers(PerformanceManager.users_home_page) during 3600)

  /***/

  val get_product_by_id_request2: HttpRequestBuilder = http("Open Home Page Request 2")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario2: ScenarioBuilder = scenario("Open Home Page Scenario 2")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(get_product_by_id_request2)

  val getProductByIdSimulation2: PopulationBuilder = getProductByIdScenario2
    .inject(rampUsers(PerformanceManager.users_home_page) during 3600)


  /***/

  val get_product_by_id_request3: HttpRequestBuilder = http("Open Home Page Request 3")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario3: ScenarioBuilder = scenario("Open Home Page Scenario 3")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(get_product_by_id_request3)

  val getProductByIdSimulation3: PopulationBuilder = getProductByIdScenario3
    .inject(rampUsers(PerformanceManager.users_home_page) during 3600)


  /***/

  val get_product_by_id_request4: HttpRequestBuilder = http("Open Home Page Request 4")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario4: ScenarioBuilder = scenario("Open Home Page Scenario 4")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(get_product_by_id_request4)

  val getProductByIdSimulation4: PopulationBuilder = getProductByIdScenario4
    .inject(rampUsers(PerformanceManager.users_home_page) during 3600)


  /***/

  val get_product_by_id_request5: HttpRequestBuilder = http("Open Home Page Request 5")
    .get(GetUrl.products_service + get_product_by_id + ProductManager.getRandomProductId(token))
    .check(status is 200)

  val getProductByIdScenario5: ScenarioBuilder = scenario("Open Home Page Scenario 5")
    .exec(addCookie(Cookie("token", token).withDomain("localhost")))
    .exec(get_product_by_id_request5)

  val getProductByIdSimulation5: PopulationBuilder = getProductByIdScenario5
    .inject(rampUsers(PerformanceManager.users_home_page) during 3600)

}
