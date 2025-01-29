# Elit Electronicts Automation Project

This project automates the testing of the https://ee.ge website’s login, search and add to cart functionality using Selenium and POM (Page Object Model). The framework supports UI automation, and the tests are written in Java using TestNG.
Also project checks status code of Api, andpoint https://reqres.in/api/users?page=2 using RestAssured.


## Project Structure

"src
  /main
    /java  - (Utility classes, configurations)
      /ge.example - Basepage - Contains base test class and test classes.
        /pages  -  Contains page object classes for different pages of the ee.ge website.
        /utils  -  ConfigReader, DriverManager, TestListener(Contains TestNG configuration files),Utils(for logs)
        
  /test
    /java
      /ge.example - BaseTest - Contains BaseTest Contains TestNG configuration files.
        /pages  - UsersApiPage for Api class and method
        /tests  - LoginTests conteins all test cases Contains TestNG configuration files.
        
      
/config  - Configuration files, test data
/reports - Test execution reports"



## Prerequisites

- Java 8 or higher
- Maven
- IntelliJ IDEA or any other preferred IDE
  

## Setup
  
  1.Clone the repository:
  
'''sh
git clone <repository-url>
''' 
  
  2.Navigate to the project directory:
cd <project-directory>
  3.Install dependencies:
'mvn clean install'


## Running Tests

To run the tests, use the following command:
'mvn test'
