"Cars.com Homework Repository" - see README.md file for formated version of this document

TEST CASE TITLE : "Search Button"

HOW TO TEST:
This feature tests 'Search Button' to ensure users are able to perform searches based on pre-defined criteria.
In addition, to validate that users are able to modify their searches after selecting those criterias and able to see details of the defined searches.
Details of the project code can be found in its respective folder and files.
Scenarios are written in Gherkin format in 'searchButton.feature' file.
The stepDefinitions are writen in Java and Selenium in 'searchButton.java' class.
POM design patterns is followed and locators are located inside pageObjects folder and in separate java class.
Reusable Java and Selenium methods are written in separate WebDriverUtility.java.

FRAMEWORK STRUCTURE:
#BDD - Cucumber - Maven POM.xml - Java - Selenium
com.cars.hw/src/main/java/
#Base.java - to delcare Properties, WebDriver and log4j logger
#pageObjects - POM folder to store locators
#WebDriverUtility.java - resuable java methods for autmation
com.cars.hw/src/test/java/
#TestRunner.java - @CucumberOptions #stepDefinitions:
*****initializer.java for @Before and @After hooks to initialize browser and tear it down
*****searchButton.java detailed java and selenium methods for scenarios
com.cars.hw/src/test/resources/
#Features
*****searchButton.feature - scenarios for test case
#InputData
*****log4j.properties - log4j logger to add logger info on each step defnition
*****projectProp.properties - To separate these values for -> ('URL' , 'Browser' , 'ImplicitWait' , 'PageLoadTimeOut') and store them as (key & value) #screenshots folder - to store screenshots taken during test run
