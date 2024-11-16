Feature: Contact Us Page

  Scenario Outline: Validate the Contact Us button
    Given the user opens datacom web application
    When the user validate the "Contact us" page
    Then the "<css>" css element should be "<value>" for "<text>" label

    Examples:
      | css                                       | value                       | text                  |
      | 32px                                      | font-size                   | Contact us            |
      | rgba(0, 10, 20, 1)                        | color                       | Contact us            |
      | \"Montserrat Semi Bold\", sans-serif      | font-family                 | Contact us            |
#
  Scenario:  Successfully filled out the Contact Us page
    Given the user opens datacom web application
    When the user clicks the Contact us button
    And the user fill out all required field
    And the user clicks the "Submit" button
    Then the user should see "Thank you for getting in touch with us" as a "*"