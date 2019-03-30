package com.project

import io.gatling.core.Predef.Simulation
import com.project.scenarios.HomePageScenario._
import com.project.scenarios.ViewAllProductsScenario._
import com.project.scenarios.ViewProductDetailsScenario._
import com.project.scenarios.AddProductToCartScenario._
import com.project.scenarios.ViewCartScenario._
import com.project.scenarios.CheckoutScenario._

class AllSimulation extends Simulation {

  setUp(
    /**Home Page*/
    getProductByIdSimulation1, getProductByIdSimulation2
    , getProductByIdSimulation3, getProductByIdSimulation4
    , getProductByIdSimulation5

    /**View All Products*/
    , getProductsSimulation

    /**View Product Details*/
    , getProductByIdSimulation

    /**Add Product to cart*/
    , addProductToCartSimulation

    /**View Cart*/
    , getItemsSimulation

    /**Checkout*/
    , checkoutSimulation)
}
