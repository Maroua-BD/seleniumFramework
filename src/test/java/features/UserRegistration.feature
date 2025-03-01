Feature: User Registration
    I want to check that the user can register in our e-commerce website.
 
 Scenario: User Registration 
 Given the user in the home page
 When I click on register link
 And I entered "<firstname>", "<lastname>", "<email>", "<password>"
 Then The registration page displayed successfully 
 
 Examples: 
     | firstname | lastname | email | password |
     | mar | BN | bn@test.com | 112345 |
     | merve | bn driss  | merve@test.com | 845632 |
     