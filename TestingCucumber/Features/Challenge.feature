Feature: Checking DOM
Scenario: Checking the challengeing DOM page in the internet Herokuapp
Given User launch the browser
When User opens the URL "https://the-internet.herokuapp.com/challenging_dom"
And Check page title should be "Challenging DOM"
When user clicks on Blue button check the operation of the blue button
And user clicks on Red button chech the operation of the red button
And user clicks on green button check the operation of the green button
And get table data
When user click on edit link 
And user clicks on delete link
Then user shouldnot able to see the deleted row
And Check the old answers& Refresh the page observe the new anwers 






