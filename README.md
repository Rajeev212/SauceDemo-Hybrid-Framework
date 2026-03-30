# SauceDemo-Hybrid-Framework

## Project Overview

This project is an **end-to-end Hybrid Test Automation Framework** built using Selenium, Java, and TestNG.
It follows the **Page Object Model (POM)** design pattern and is integrated with **CI/CD using Jenkins**.

The framework automates key user flows of the SauceDemo application such as login, product validation, and cart functionality.

---

##  Application Under Test

* **Website:** SauceDemo
* **URL:** https://www.saucedemo.com/

---

##  Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Version Control:** Git + GitHub
* **CI/CD:** Jenkins
* **Reporting:** Extent Reports

---

## Framework Features

### Core Features

* Page Object Model (POM) implementation
* Reusable utility classes (Waits, Driver Factory)
* Config-based execution (browser, URL, credentials)

### ✅ Advanced Features

* Data-driven testing (Properties/Excel support)
* TestNG Groups (Smoke, Regression)
* Parallel execution using testng.xml
* Cross-browser testing (Chrome, Edge)

### Stability Enhancements

* Explicit Wait utilities
* Retry Analyzer for flaky tests
* Screenshot capture on failure

### Reporting

* Extent Reports with screenshots
* TestNG default reports

### CI/CD Integration

* Jenkins integration with Maven
* Automated test execution via pipeline
* GitHub integration for source control

---

## Project Structure

```
SauceDemo-Hybrid-Framework
│
├── src
│   ├── main/java
│   │   ├── pages
│   │   ├── utils
│   │
│   ├── test/java
│   │   ├── base
│   │   ├── tests
│   │
│   └── test/resources
│       ├── config.properties
│       ├── testng.xml
│
├── reports
├── screenshots
├── pom.xml
└── README.md
```

---

## How to Run the Project

### Run Locally

```bash
mvn clean test
```

### Run Specific Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Jenkins Execution

1. Create a Freestyle Job in Jenkins
2. Connect GitHub repository
3. Add build step:

   ```
   mvn clean test
   ```
4. Trigger build → Tests execute automatically

---

## Reports

* **Extent Report:**

  ```
  /reports/ExtentReport.html
  ```

* **TestNG Report:**

  ```
  /test-output/index.html
  ```

---

## Key Highlights

* Built a scalable automation framework from scratch
* Implemented CI/CD pipeline using Jenkins
* Handled flaky tests using retry mechanism and waits
* Designed reusable and maintainable architecture

---

## Future Enhancements

* Integrate Allure Reports
* Add Docker support
* Parallel execution in Jenkins pipeline
* API testing integration (REST Assured)

---

## Author

**Rajeev Kanda**
QA Automation Engineer

---
