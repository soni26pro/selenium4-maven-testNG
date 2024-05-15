![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo has example codes with Selenium 4 features.
- Websites used for testing is:
  [here](http://the-internet.herokuapp.com/)
- This repo uses `Maven` as build tool and `TestNG` testing framework to run the tests.

# Selenium Automation Scenarios

This repository contains code examples for automating various web interactions using Selenium WebDriver.

## Test Method Covered:

1. **Selecting a value from a table:**
    - How to select a specific value from a table on a web page.

2. **Ticking and unticking checkboxes using Selenium:**
    - Demonstrates how to interact with checkboxes, including ticking and unticking them.

3. **Right-clicking using Selenium:**
    - Implementing code snippets to simulate right-clicking on elements.

4. **Drag and drop using Selenium:**
    - Code examples for performing drag and drop operations with Selenium WebDriver.

5. **Logging in and logging out using Selenium:**
    - Automation of the login and logout process for a web application.

6. **Passing multiple test data values using DataProvider:**
    - Utilizing DataProvider to pass multiple test data values to automated tests.

7. **Mouse hovering an element using Selenium:**
    - Examples of how to hover over elements on a web page.

8. **Downloading a file using Selenium:**
    - Code to automate file downloads during testing.

9. **Uploading files using Selenium:**
    - Demonstrating automation of the file upload process in web forms.

10. **Pressing keys using Selenium:**
    - Simulating key presses using Selenium WebDriver.

11. **Working with multiple Tab windows in Selenium:**
    - Code examples for interacting with multiple tab windows in a web browser.

12. **Working with iFrames using Selenium:**
    - Snippets for testing interactions within iframes on a web page.

13. **Double-clicking using Selenium WebDriver:**
    - Code to perform double-click operations on elements.

14. **Checking for Chrome-generated logs during Selenium tests:**
    - How to access and analyze Chrome-generated logs during test execution.

Each scenario includes working code examples to help you understand and implement these functionalities in your Selenium test suite.

Feel free to explore the code and adapt it to your specific testing needs!

## How to run the Tests?

- There are 2 ways to run the tests, those are as follows:
  ### 1. TestNG:
    - Right-Click on the `test-suite\testng-wepApp.xml` and select `Run ...\test-suite\testng-webApp.xml`
  ### 2. Maven:
    - To run the tests in headless mode update the value for `headless` property variable to `true`

      `mvn clean install -Dsuite-xml=test-suite\testng-wepApp.xml -Dheadless=true`

    - To run the tests without headless mode(to see the test running in browser) update the value for headless property
      variable to
      `false`

      `mvn clean install -Dsuite-xml=test-suite\testng-wepApp.xml -Dheadless=false`


### Running Selenium Grid on local and running tests using Selenium Grid

- Start the Selenium Grid in local using the `docker-compose-seleniumgrid.yml` file.
- Run the following command:
  `docker-compose -f docker-compose-seleniumgrid.yml up -d`

  This will start the selenium grid which can be access using `http://localhost:4444`.

    - To run the tests on Selenium Grid using `TestNG`:

      Right click on `test-suite\testng-seleniumgrid-webApp.xml` and
      select `Run test-suite\testng-seleniumgrid-webApp.xml`

    - To run the tests on Selenium Grid using `Maven`:

      `mvn clean install -Dsuite-xml=test-suite\testng-seleniumgrid-webApp.xml`

- Stopping the Selenium Grid:

  `docker-compose -f docker-compose-seleniumgrid.yml down`



 
 
