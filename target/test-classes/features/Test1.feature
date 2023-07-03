Feature: Testing Amazon.in "About this item" feature

  @smoke
  Scenario: Verifying "About this item" feature for product page is present
    Given user navigates to tutorials ninja website and verify that the url is "https://www.amazon.in/"
    When user clicks on the hamburger menu in the top left corner
    And user scrolls down and then Click on the "TV, Appliances, Electronics" link under Shop by Department section.
    And user clicks on "Televisions" under Tv, Audio & Cameras sub section
    And user scrolls down and filter the results by Brand "Samsung"
    And user sorts the Samsung results with "Price: High to Low"
    And user clicks on the "2." highest priced item
    Then user verifies that "About this item" section is present