package com.project

import io.gatling.core.Predef.Simulation
import com.project.scenarios.ViewCartScenario._

class ViewCartSimulation extends Simulation {

  /**
    *  Get all items from cart
    * */
    setUp(getItemsSimulation)
}
