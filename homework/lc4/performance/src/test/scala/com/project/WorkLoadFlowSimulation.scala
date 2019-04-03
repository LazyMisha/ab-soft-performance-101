package com.project

import com.project.simulations.{CartSimulation, HomePageSimulation, ProductSimulation}
import io.gatling.core.Predef.Simulation

class WorkLoadFlowSimulation extends Simulation {

  setUp(
    /**
      * Open Home Page
      * */
    HomePageSimulation.homePageSimulation

    /**
      * View All products
      * */
    , ProductSimulation.getAllProductsSimulation

    /**
      * View Product Details
      * */
    , ProductSimulation.getProductByIdSimulation

    /**
      * Add Product to cart
      * */
    , CartSimulation.addProductToCartSimulation

    /**
      * View Cart
      * */
    , CartSimulation.getItemsFromCartSimulation

    /**
      * Checkout
      * */
    , CartSimulation.checkoutSimulation)
}
