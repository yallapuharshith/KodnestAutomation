🚀 Selenium Automation Framework – TestNG + Maven
📌 Project Overview

This project is a Selenium Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven.
It follows industry-standard best practices such as Page Object Model (POM), BaseTest design, TestNG groups, and XML-based execution, making it CI/CD ready.

The framework supports:

Smoke & Regression execution

TestNG XML control

Retry mechanism for flaky tests

Jenkins integration

Clean driver lifecycle management

🛠 Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Design Pattern: Page Object Model (POM)

CI/CD: Jenkins

Browser: Chrome

📂 Project Structure
├── src/main/java
│   └── pages
│       ├── LoginPage.java
│       ├── HomePage.java
│
├── src/test/java
│   └── tests
│       ├── BaseTest.java
│       ├── LoginTest.java
│       ├── HomePageTest.java
│
├── src/test/resources
│   └── testng.xml
│
├── pom.xml
└── README.md

🧱 Framework Design
✅ BaseTest

Centralized WebDriver initialization

Browser setup & teardown

Ensures clean driver lifecycle

✅ Page Object Model (POM)

UI locators and actions are separated from test logic

Improves maintainability and readability

✅ Test Classes

Contain only test logic

No UI locators inside test methods

▶️ How to Run Tests
🔹 Run Using TestNG XML
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml

🔹 Run Specific Groups

Example in testng.xml:

<groups>
    <run>
        <include name="smoke"/>
    </run>
</groups>

🧪 TestNG Groups

smoke → Critical flow tests

regression → Full feature coverage

Example:

@Test(groups = "smoke")
public void validLoginTest() { }

🔁 Retry Mechanism (Flaky Test Handling)

A custom RetryAnalyzer is used to re-execute failed tests automatically.

@Test(retryAnalyzer = Retry.class)
public void unstableTest() { }

⏳ Synchronization Strategy

Explicit Waits are used inside Page classes

Avoids Thread.sleep()

Ensures stable execution in CI environments

⚙️ Jenkins Integration

Jenkins pulls code from GitHub

Executes tests using Maven goals

Uses testng.xml to control execution

Supports Smoke & Regression jobs separately

📊 Reporting

TestNG default reports

Screenshots captured on failure

Can be easily extended to Allure Reports
