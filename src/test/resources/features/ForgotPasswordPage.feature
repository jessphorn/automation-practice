Feature: Retrieve Forgotten Password 

Background:
    Given User is on Poco Mega Store Forgot Password page "https://ecommerce-playground.lambdatest.io/index.php?route=account/forgotten"
    
    @ValidAccount
    Scenario: User requests password reset with valid email address
    
    When User enters email address as "jtest@email.com"
    Then User should be able to see message "An email with a confirmation link has been sent your email address."
    
    @InvalidAccount
    Scenario: User requests password reset with invalid email address
    When User enters email address as "jtest"
    Then User should be able to see message "Warning: The E-Mail Address was not found in our records, please try again!"