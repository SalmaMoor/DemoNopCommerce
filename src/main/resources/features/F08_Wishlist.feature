@smoke
  Feature: F08_Wishlist.feature | user can add product to wishlist

    #First Scenario:
    Scenario:user could add products to wishlist
      When user click on wishlist button of product 'HTC One M8 Android L 5.0 Lollipop'
    #Expected result
      Then success message 'The product has been added to your wishlist' with green background color

    #Second Scenario:
    Scenario: user could check his wishlist
      When user click on wishlist button of product 'HTC One M8 Android L 5.0 Lollipop'
      Then success message 'The product has been added to your wishlist' with green background color
      And wait until this success message with green color to disappear
      When  click on 'Wishlist' button on the top of the page
    #Expected result
      Then Quantity value should bigger than 0
