package com.project.config

import scalaj.http.Http

import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.parsing.json.JSON

object ProductManager {

  val ids: ListBuffer[String] = getProductIds(TokenManager.getToken)

  /**
    * @return ListBuffer[String]: list of products ids
    * @param token to get access to the service
    * */
  def getProductIds(token: String) : ListBuffer[String] = {
    val response: String = Http(GetUrl.products_service + "/api/products/get_all").cookie("token", token).asString.body
    val json = JSON.parseFull(response)
    val ids: ListBuffer[String] = new ListBuffer[String]()
    json.get.asInstanceOf[List[Map[String, String]]].foreach(product => ids += product.get("_id")
      .toString.replace("Some(", "").replace(")", ""))
    ids
  }

  /**
    * @return String: random product id
    * */
  def getRandomProductId : String = {
    Random.shuffle(ids.toList).head
  }

  /**
    * @return int: random index for product id
    * */
  def getRandomIndexId : Int = {
    val random = new scala.util.Random
    random.nextInt(ids.size - 1)
  }

  /**
    * @return ListBuffer[String]: list of best products ids
    * @param count of products ids to return
    * */
  def getBestProductIds(count: Int) : ListBuffer[String] = {
    var bestIds = new ListBuffer[String]()
    for (i <- 1 to count) {
      val best = getRandomProductId
      bestIds += best
      println(i + " best product: " + best)
    }
    bestIds
  }
}
