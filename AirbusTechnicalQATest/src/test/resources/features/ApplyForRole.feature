Feature: Apply for Role

    As an applicant
    I want to be able search for the Role of Test Manager based in the United Kingdom on the careers portal
    So that I can apply for the role and verify the Start your Application popup is present

//Tags to help identify different tests for Test runner
@GoToPortal
Scenario: Verify user can reach careers portal
    Given the user is on the Careers page
    When the user clicks the explore opportunities button
    Then the user is taken to the careers portal

@SearchRole
Scenario: Verify user can search for a role
    Given the user is on the Careers Portal
    When the user enters the role of Test Manager in the job search field
    And the user has selected United Kingdom from the location dropdown
    Then the user should be able to click on the Test Manager role

@ApplyRole
Scenario: Verify user can apply for a role
    Given the user has searched for the role of Test Manager
    When the user selects the role
    And the user clicks Apply on the right hand pane
    Then the user should see a Start your Application popup