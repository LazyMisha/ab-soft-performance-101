package com.project.simulations

import com.project.config.PerformanceManager
import com.project.scenarios.ProductScenario._
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

object ProductSimulation {

  /**
    *  Get all products
    * */
  val getAllProductsSimulation: PopulationBuilder = getAllProductsScenario
    .inject(rampUsers(PerformanceManager.users_view_all_products) during PerformanceManager.rampUp)

  /**
    * Get product by id
    * */
  val getProductByIdSimulation: PopulationBuilder = getProductByIdScenario
    .inject(rampUsers(PerformanceManager.users_product_details) during PerformanceManager.rampUp)
}
