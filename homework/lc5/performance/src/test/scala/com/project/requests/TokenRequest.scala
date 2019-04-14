package com.project.requests

import com.project.config.{Endpoint, GetUrl}
import io.gatling.core.Predef.{jsonPath, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder

object TokenRequest {

  /**
    * Generate token
    * */
  val generateTokenRequest: HttpRequestBuilder = http("Generate token").
    get(GetUrl.generate_token + Endpoint.generate_token).
    check(status.is(200)).
    check(jsonPath("$.token").saveAs("token"))


  /**
    * Validate token
    * */
  val validateTokenRequest: HttpRequestBuilder = http("Validate Token").
    get(GetUrl.generate_token + Endpoint.validate_token + "${token}").
    check(status.is(200))
    .check(substring("\"status\":\"ok\""))
}
