Feature: The Guardian News validation scenarios.

Background: User is News page.
When User enters application url.
Then News Page is launched.



Scenario: First News Artical is valid.
When User copy the First News Title
And User Searches that Artical in Google search Engine
Then Two or more articles should be displayed.