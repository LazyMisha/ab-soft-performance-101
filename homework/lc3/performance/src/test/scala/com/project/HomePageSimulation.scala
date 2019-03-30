package com.project

import com.project.scenarios.HomePageScenario._
import io.gatling.core.Predef.Simulation

class HomePageSimulation extends Simulation {

  /**
    * Home Page
    * */
    setUp(getProductByIdSimulation1, getProductByIdSimulation2
      , getProductByIdSimulation3, getProductByIdSimulation4
      , getProductByIdSimulation5)
}
