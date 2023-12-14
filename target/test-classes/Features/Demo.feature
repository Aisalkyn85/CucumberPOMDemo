Feature: A cucumber pom demo

  Scenario Outline: Login with the <username> and <password>
    Given the user launches the NOPAdmin url
    Then the user verifies the logo
    When the user enters "<username>" in email webedit
    And the user enters "<password>" in password webedit
    Then the user clicks on login button
    Then the user verifies the homepage logo
    And the user finally logouts the application

    Examples:
    |username|password|
    #|vignesh |user123 |
    |admin@yourstore.com|admin|
