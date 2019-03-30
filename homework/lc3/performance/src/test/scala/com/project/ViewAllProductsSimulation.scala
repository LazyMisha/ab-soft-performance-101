package com.project

import io.gatling.core.Predef.Simulation
import com.project.scenarios.ViewAllProductsScenario._

class ViewAllProductsSimulation extends Simulation {

  /**
    *  Get all products
    * */
    setUp(getProductsSimulation)
}
