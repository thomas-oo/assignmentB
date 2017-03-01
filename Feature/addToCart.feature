Feature: Place product in shopping cart
As a consumer
I want place a product "product name" in the shopping cart
So that I can purchase the product "product name" later on

  Scenario: Successful add to cart with login
    Given User is on Home Page and logged in
     When User Navigates to product page
      And User selects a product
      And User selects a size
      And User clicks add to bag
      And User goes to shopping bag
     Then User sees item in bag
      And User sees checkout button