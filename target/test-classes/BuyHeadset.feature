Feature: Buy Latest Top Deal Headset in Amazon

  Scenario: Navigation of Mobile Link is successful
    Given browser is launched, Mobile Navigation link is clicked successfully.

  Scenario: Validation Menu Display after clicking Mobile Hyperlink
    Given browser is launched, Mobile Navigation link is clicked successfully.
    Then SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.

  Scenario: Accessory Menu Click Validation
    Given browser is launched, Mobile Navigation link is clicked successfully.
    Then SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.
    When Accessories Menu is clicked
    Then Headsset should be displayed

  Scenario: Headset Menu Click Validation
    Given browser is launched, Mobile Navigation link is clicked successfully.
    Then SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.
    When Accessories Menu is clicked
    Then Headset sub menu is clicked to move on to headset section

  Scenario: Top Deal Headset is selected
    Given browser is launched, Mobile Navigation link is clicked successfully.
    Then SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.
    When Accessories Menu is clicked
    Then Headset sub menu is clicked to move on to headset section
    When TopDeal Headset is clicked
    Then Topdeal Headset is selected

  Scenario: Top Deal Headset is added to the cart
    Given browser is launched, Mobile Navigation link is clicked successfully.
    Then SmartPhones, Accessories and Motorola razr menus are displayed when clicking Mobiles button and SmartPhones menu is selected by default.
    When Accessories Menu is clicked
    Then Headset sub menu is clicked to move on to headset section
    When TopDeal Headset is clicked
    Then Topdeal Headset is selected
    When Add to cart is clicked
    Then Add to cart is selected to purchase the headset
