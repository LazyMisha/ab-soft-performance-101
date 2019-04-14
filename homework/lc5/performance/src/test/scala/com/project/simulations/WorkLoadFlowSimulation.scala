package com.project.simulations

import com.project.scenarios.WorkLoadFlowScenario._
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

object WorkLoadFlowSimulation {

  val SIMULATION_1: PopulationBuilder = SCENARIO_1
    .inject(rampUsers(840) during 3600)

  val SIMULATION_2: PopulationBuilder = SCENARIO_2
    .inject(rampUsers(80) during 3600)

  val SIMULATION_3: PopulationBuilder = SCENARIO_3
    .inject(rampUsers(80) during 3600)

}
