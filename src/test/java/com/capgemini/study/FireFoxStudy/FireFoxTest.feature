@GlobalFeatureHook
Feature: Test fire fox webdriver and see why it opens two windows

@Firefox
Scenario: Open a firefox webdriver and get github url
Given When I create a fireboxdriver object
And geturl for github
Then Window is open and close

@Chrome
Scenario: Open Chrome webdriver for github
Given When I create a chromedriver object
And geturl for github
Then Window is open and close
