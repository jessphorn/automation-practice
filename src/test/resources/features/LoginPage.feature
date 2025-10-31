Feature: Login to Poco Mega Store

Background:
    Given User is on Poco Mega Store login page "https://ecommerce-playground.lambdatest.io/index.php?route=account/login"
    
    @ValidCredentials
    Scenario: Login with valid credentials
    
    When User enters username as "jtest@email.com" and password as "test123"
    Then User should be able to login successfully and the My Account page opens
      
    @InvalidCredentials
    Scenario Outline: Login with invalid credentials 
    
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see errorMessage "<errorMessage>"
    
    Examples:
    | username        | password    | errorMessage                                         | 
    | ctest@email.com | a    	    | Warning: No match for E-Mail Address and/or Password.| # valid username, invalid password
    | abcde           | test123     | Warning: No match for E-Mail Address and/or Password.| # invalid username, valid password
    | fghijkl         | a           | Warning: No match for E-Mail Address and/or Password.| # invalid username, invalid password
    |                 | test123     | Warning: No match for E-Mail Address and/or Password.| # missing username
    | etest@email.com |             | Warning: No match for E-Mail Address and/or Password.| # missing password
    
    @TooManyLoginAttempts
    Scenario: Attempt to login with invalid credentials 5 times to get locked out
    
    When User enters username as "jtest" and password as "test" 5 times
    Then User should be able to see errorMessage "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."