Compute a simple division

Narrative:
In order to compute faster
As a super intellectual
I want to use a calculator to divide

Scenario: Divide with '1'
Given divide : the user is on the form page
When I divide with 1
Then I get a division result

Scenario: Divide with '4'
Given divide : the user is on the form page
When I divide with 4
Then I get a division result

Scenario: Divide with '2'
Given divide : the user is on the form page
When I divide with 2
Then I get a division result

Scenario: Divide with '0'
Given divide : the user is on the form page
When I divide with 0
Then I get a division error