@smoke
  Feature:F05_hoverCategories | user will hover on main categories
    [Computers, Electronics, Apparel, Digital Downloads, Books, Jewelry, Gift Cards]
    then click on subcategory if exist or click
    Scenario: user could hover on main categories, then click on subcategory if there is subcategory,
      or click on category if there is no subcategory
      Given There are many main categories and User choose one of them
      And user hover selected category
      When user select subcategory if Exist and click on it Or click category if subcategory does not exist

    #Expected result
      Then page clicked will be opened