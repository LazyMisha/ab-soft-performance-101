package com.project.config

import scalaj.http.Http

import scala.util.parsing.json.JSON

object TokenManager {

  /**
    * @return String: token
    * */
  def getToken: String = {
    val response: String = Http(GetUrl.generate_token + Endpoint.generate_token).asString.body
    val json = JSON.parseFull(response)
    val generateToken: String = json.get.asInstanceOf[Map[String, String]]
      .get("token").asInstanceOf[Some[String]].value.toString
    generateToken
  }
}
