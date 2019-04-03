package com.project.simulations

import com.project.config.PerformanceManager
import com.project.scenarios.CartScenario._
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

object CartSimulation {

  /**
    *  Add product to cart
    * */
  val addProductToCartSimulation: PopulationBuilder = addProductToCartScenario
    .inject(rampUsers(PerformanceManager.users_add_product_to_cart) during PerformanceManager.rampUp)

  /**
    *  Get all items from cart
    * */
  val getItemsFromCartSimulation: PopulationBuilder = getItemsScenario
    .inject(rampUsers(PerformanceManager.users_view_cart) during PerformanceManager.rampUp)

  /**
    *  Checkout
    * */
  val checkoutSimulation: PopulationBuilder = checkoutScenario
    .inject(rampUsers(PerformanceManager.users_checkout) during PerformanceManager.rampUp)
}
