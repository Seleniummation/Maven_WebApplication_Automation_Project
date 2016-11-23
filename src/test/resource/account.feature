Feature: Login

  Background:

    Given User is on amazon homepage
    
            Scenario: As an existing user, I want to sign in with valid credentials, so i can view products

              When I select account tab on homepage
              And Fill in "email" and "password" credential
              And Submit sign in form
              Then Sign in page displays customers username
