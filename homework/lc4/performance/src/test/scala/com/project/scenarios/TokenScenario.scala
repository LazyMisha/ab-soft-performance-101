package com.project.scenarios

import com.project.requests.TokenRequest._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object TokenScenario {

  val validateTokenScenario: ScenarioBuilder = scenario("Validate Token Scenario")
    .exec(generateTokenRequest)
    .exec(validateTokenRequest)
}
