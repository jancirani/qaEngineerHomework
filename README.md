# Cucumber Automation Framework
### Development
Developed Automation Framework Using Maven Project

  - Cucumber Reports
  - Test Execution Recording
  - Failed Test Case Screenshots
 
### Version
JDK - 1.7
Maven-3.0.5


### Installation and Execution

You have to  clone the Maven project in to your Local Machine:

* Running on Different browsers(at present its done for Firefox 42.0)
 - **FireFox Browser** 
 - **Chrome Browser**
 - **IE**
  
Change in the properties file
 /qaEngineerHomeworkTest/src/main/resources/utilities/CONFIG.properties


- First Method through Command Prompt:
```sh
$ git clone [git-repo-url]
$ cd qaEngineerHomework.git
$ mvn clean install
```
- Second Method through Eclipse IDE :
```sh
Right Click pom.xml and run as -->maven install
```
- Third Method through Eclipse IDE :
```sh
Navigatet to /qaEngineerHomeworkTest/src/test/java/testcases/RunCalculatorTest.java Right Click and run as -->JUnint Test
```

**Note:** Your system has to already setup with environment variables for JDK and Maven

### Tags information
I have used 5 tags for the test ukTaxCalculator.feature
- @all -  which runs all tests scenarios
- @withMultipleTestData - this tag is used for multiple test data execution
- @basicRate - this tag is for basic rate scenario  
- @higherRate - this tag is for higher rate scenario
- @additionalRate - this tag is for additional rate scenario

**Note:** In the run file it setup for @all

### Location where to find Test Recordings:
- /qaEngineerHomeworkTest/src/test/java/testsRecordings :
### Location where to find Screenshots:
   Which has one files right now 
1.Failed case
- /qaEngineerHomeworkTest/src/test/resources/screenshots
### Location where to find Test Graphical and HTML Reports:
- /qaEngineerHomeworkTest/target/cucumber/index.html--->Open with webbrowser
- /qaEngineerHomeworkTest/target/cucumber-html-reports/feature-overview.html--->Open with webbrowser
- /qaEngineerHomeworkTest/target/cucumber-html-reports/test-resources-testcases-ukTaxCalculator.feature.html--->Open with webbrowser





### Tech

I have used below technologies and editors:

* [EclipseIDE] - awesome for developing automation framework!
* [Maven Project] - for organising framework structure.
* [Cucumber-JVM] - its a tool that executes plain text functional descriptions as automated tests.
* [Cucumber-JUnit] - to run the tests
* [Slenium Webdriver] - it automates browsers. That's it!
* [Recording Jars] - used recording jar file to record test case execution.
* [JDK] - To develop and run the tests.



### Plugins

Cucumber Framework is currently extended with the following plugins/Jar files

* Cucumber pluging
* Cucumber Reports
* Test Execution Recording


### Todo's

 - Writen 5 test scenarios cases in Gherken language to automate: /qaEngineerHomeworkTest/src/test/resources/todo/ukTaxApplicationMoreScenaiors.feature
 - Cross browser testing is setup and implemented for Firefox 42.0, for Chrome and IE is pending.