package com.project.config

import scalaj.http.Http

import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.util.parsing.json.JSON

object ProductManager {

  def getProductIds(token: String) : ListBuffer[String] = {
    val response: String = Http(GetUrl.products_service + "/api/products/get_all").cookie("token", token).asString.body
    val json = JSON.parseFull(response)
    val ids: ListBuffer[String] = new ListBuffer[String]()
    json.get.asInstanceOf[List[Map[String, String]]].foreach(product => ids += product.get("_id").toString.replace("Some(", "").replace(")", ""))
    ids
  }

  def getRandomProductId(token: String) : String = {
    val ids: ListBuffer[String] = getProductIds(token)
    Random.shuffle(ids.toList).head
  }

  def addProductToCart(token: String): Unit = {
    val product: String = getRandomProductId(token)
    Http(GetUrl.cart_service + "/api/cart/add_item/" + product).cookie("token", token).asString.body
  }
}
