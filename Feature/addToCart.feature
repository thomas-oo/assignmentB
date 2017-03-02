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
	Scenario: Alternate flow, add additional item to cart
    Given User is on Home Page and logged in
     And User goes to shopping bag
     When User finds the product they want another of
     And User clicks on the product
     And User selects a size 
     And User clicks add to bag
     And User goes to shopping bag
     Then User sees an additional item in bag
     And User sees checkout button
  Scenario: Error flow, user adds to cart without logging in
    Given User is on Home Page and logged out
#     When User Navigates to product page
     When User selects a product
     And User selects a size
     And User clicks add to bag
     And User goes to shopping bag
     Then User sees item in bag
     But User does not see the checkout button
     Then User is prompted to login or create an account
     And User logs in thru the prompt
     And User sees the same item in cart
     And User sees checkout button