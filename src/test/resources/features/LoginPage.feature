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
    Then User should be able to see error message "<errorMessage>"
    
    Examples:
    | username        | password    | errorMessage
    | jtest@email.com | a    	    |  Warning: No match for E-Mail Address and/or Password. # valid username, invalid password
    | jtest           | test123     |  Warning: No match for E-Mail Address and/or Password. # invalid username, valid password
    | jtest           | a           |  Warning: No match for E-Mail Address and/or Password. # invalid username, invalid password