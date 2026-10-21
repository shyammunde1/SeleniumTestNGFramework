# Selenium TestNG Automation Framework

A Java-based UI automation framework built with Selenium WebDriver, TestNG, and Maven. The project demonstrates maintainable automation design, reusable components, test reporting, and continuous integration.

## Tech Stack

- **Language:** Java 21
- **Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** ExtentReports and Surefire reports
- **Version Control:** Git and GitHub
- **CI/CD:** GitHub Actions

## Framework Features

- Page Object Model for maintainable page classes
- Reusable page methods and explicit waits
- Centralized configuration with environment-specific properties
- Externalized test data
- Page Object Manager
- TestNG DataProviders and test groups
- Thread-safe WebDriver management for parallel execution
- Retry mechanism for failed tests
- Failure screenshot capture
- ExtentReports integration
- Automated test execution through GitHub Actions
- Test reports and screenshots uploaded as workflow artifacts

## Project Structure

```text
SeleniumTestNGFramework/
├── .github/
│   └── workflows/
│       └── selenium-tests.yml
├── src/
│   └── test/
│       ├── java/
│       │   ├── basepages/
│       │   ├── pages/
│       │   ├── tests/
│       │   ├── listeners/
│       │   ├── retry/
│       │   └── utils/
│       └── resources/
│           ├── environments/
│           └── testdata/
├── testng.xml
├── pom.xml
└── README.md
```

## Prerequisites

- JDK 21
- Maven
- Google Chrome
- Git
- IntelliJ IDEA or another Java IDE

## Running Tests Locally

Run the test suite from the project root:

```bash
mvn clean test
```

## Continuous Integration

GitHub Actions runs the Selenium TestNG tests when changes are pushed to `main` or a pull request targets `main`. The workflow also supports manual execution.

After execution, the workflow uploads the available Surefire reports, TestNG output, and screenshots as downloadable artifacts. Artifacts are retained for seven days.

## Latest Verified Test Results

The verified GitHub Actions run completed successfully:

- **Tests run:** 5
- **Failures:** 0
- **Errors:** 0
- **Skipped:** 0
- **Build status:** SUCCESS

## Repository

[View SeleniumTestNGFramework on GitHub](https://github.com/shyammunde1/SeleniumTestNGFramework)
