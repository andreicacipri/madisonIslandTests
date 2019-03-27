
  Feature: Mini-Cart
    Scenario: View product in mini-cart
      Given I open the homepage
      And I search products by "vase"
      And I store the name of the 1st product with add to cart button
     # And I click on the first add to cart button
     # When I expand the mini-cart
      Then the previously stored product name is displayed in mini-cart
