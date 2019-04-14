package com.project.scenarios

import com.project.requests.CartRequest._
import com.project.requests.ProductRequest._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object WorkLoadFlowScenario {

  /**
    * SCENARIO - 1
    *
    * */
  val SCENARIO_1 : ScenarioBuilder = scenario(
    "Home Page -> All Products -> Product Details")
    .exec(HomePageScenario.homePageScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getProductsRequest)
    .exec(getProductByIdRequest)

  /**
    * SCENARIO - 2
    *
    * */
  val SCENARIO_2 : ScenarioBuilder = scenario(
    "Home Page -> All Products two times -> Product Details two times")
    .exec(HomePageScenario.homePageScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    .exec(getProductsRequest)
    .exec(getProductByIdRequest)

  /**
    * SCENARIO - 3
    *
    * */
  val SCENARIO_3 : ScenarioBuilder = scenario(
    "Home Page -> All Products -> Product Details - Add five Products to Cart -> View Cart - Checkout")
    .exec(HomePageScenario.homePageScenario)
    .exec(addCookie(Cookie("token","${token}").withDomain("localhost")))
    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    /** add first product to cart*/
    .exec(addProductToCartRequest)
    .exec(getItemsRequest)
    .exec(getProductByIdRequest)

    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    /** add second product to cart*/
    .exec(addProductToCartRequest)
    .exec(getItemsRequest)
    .exec(getProductByIdRequest)

    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    /** add third product to cart*/
    .exec(addProductToCartRequest)
    .exec(getProductByIdRequest)

    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    /** add fourth product to cart*/
    .exec(addProductToCartRequest)
    .exec(getProductByIdRequest)

    .exec(getProductsRequest)
    .exec(getProductByIdRequest)
    /** add fifth product to cart*/
    .exec(addProductToCartRequest)
    .exec(getProductByIdRequest)

    .exec(getItemsRequest)
    .exec(checkoutRequest)

}
