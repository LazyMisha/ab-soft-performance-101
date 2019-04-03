package com.project.simulations

import com.project.config.PerformanceManager
import com.project.scenarios.HomePageScenario.homePageScenario
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

object HomePageSimulation {

  /**
    * Home Page
    * */
  val homePageSimulation: PopulationBuilder = homePageScenario
    .inject(rampUsers(PerformanceManager.users_view_all_products) during PerformanceManager.rampUp)
}
