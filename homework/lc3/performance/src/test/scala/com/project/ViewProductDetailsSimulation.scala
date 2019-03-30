package com.project

import io.gatling.core.Predef.Simulation
import com.project.scenarios.ViewProductDetailsScenario._

class ViewProductDetailsSimulation extends Simulation {

  /**
    * Get product by id
    * */
    setUp(getProductByIdSimulation)
}
