Project Overview

This repository contains a complete Selenium automation testing framework built using Java, Selenium WebDriver, TestNG, Maven, following the Page Object Model (POM) design pattern.
The framework supports functional, regression, and negative testing with reusable utilities and reporting support.

Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Design Pattern: Page Object Model (POM)

Browser: Google Chrome

Version Control: Git & GitHub

Project Structure
project-root/
│
├── src/
│   ├── base/
│   │   └── Base.java
│
│   ├── listener/
│   │   └── Listener.java
│
│   ├── pages/
│   │   ├── Login.java
│   │   ├── Home.java
│   │   ├── MentorHome.java
│   │   ├── Logout.java
│   │   ├── Wrong.java
│   │   └── Signup.java
│
│   ├── testcase/
│   │   ├── LoginTest.java
│   │   ├── SignupTest.java
│   │   └── MentorTest.java
│
│   ├── utility/
│   │   ├── ExcelUtility.java
│   │   └── ScreenshotUtil.java
│
├── screenshots/
│   │   └── (Captured failure screenshots)
│
├── reports/
│   │   └── (TestNG execution reports)
│
├── pom.xml
├── testng.xml
└── README.md

Folder Description
🔹 base

Base.java

Responsible for:

WebDriver initialization

Browser configuration

Wait strategies

Application URL setup

🔹 listener

Listener.java

Implements TestNG listeners to:

Track test execution status

Capture screenshots on failure using ScreenshotUtil

Log test results

🔹 pages

Page Object classes representing application pages:

Login.java – Login functionality

Home.java – Home page validations

MentorHome.java – Mentor dashboard actions

Logout.java – Logout operations

Wrong.java – Negative / invalid login scenarios

Signup.java – User registration flow

🔹 testcase

Contains TestNG test classes

Executes test scenarios using Page Object methods

🔹 utility

Reusable helper classes:

ExcelUtility.java

Reads test data from Excel files

Supports data-driven testing

ScreenshotUtil.java

Captures screenshots during test failures

Stores screenshots in the screenshots/ directory

🔹 screenshots

Automatically stores screenshots captured on test failures

🔹 reports

Stores TestNG execution reports after test runs

 Prerequisites

Java JDK 8 or above

Maven

Google Chrome

ChromeDriver (compatible version)

IDE (Eclipse / IntelliJ)

Setup Instructions

Clone the Repository

git clone https://github.com/your-username/your-repo-name.git


Import Project

Open IDE

Import as Maven Project

Install Dependencies

mvn clean install


Configure URL & Browser

Update application URL in Base.java

Running Tests
Run via TestNG XML
mvn test


OR

Right-click testng.xml

Select Run As → TestNG Suite

 Important Files
🔹 pom.xml

Manages project dependencies:

Selenium

TestNG

Apache POI

WebDriverManager (if used)

🔹 testng.xml

Controls:

Test execution order

Parallel execution

Listener configuration

 Reports & Screenshots

Reports: reports/

Failure Screenshots: screenshots/

 Best Practices Followed

Page Object Model (POM)

Clean separation of concerns

Reusable utilities

Listener-based failure handling

Maintainable and scalable framework

 Future Enhancements

Extent Reports integration

Cross-browser testing

CI/CD pipeline (Jenkins / GitHub Actions)

Dockerized execution

 Author

Akash A J
SDET | Automation Tester

