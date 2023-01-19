# Selenium-Allure-TestNG

The structure of this project encourages to integrate many frameworks and libraries to work along selenium 
automated tests.

Integrated frameworks/libraries:
- Selenium (Java, Maven)
- TestNG
- Allure

## Setup test requirements 
Depending your OS, [download](https://chromedriver.chromium.org/downloads) the chromedriver executable and paste it in the root path of the project.

Create `.env` file with next environment variables:
```yaml
# OS: windows, linux, mac
MY_OS=

TEST_SITE_URL="https://flow.bo"
# Your flow.bo credentials
TEST_USER_EMAIL="email@example.com"
TEST_USER_PASS="your-password"
```

## Run test.
Locate in the current folder project and run next command instructions.

1. Build cleaner and then test.

_Notice that this command will also generate the `allure-results` folder with all test execution information._
```shell
mvn clean test
```

2. Show generated report with allure.
```
allure serve
```