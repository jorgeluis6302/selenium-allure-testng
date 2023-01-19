package com.flowbo.test;

import com.flowbo.base.CheckoutOrderAsCustomer;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    CheckoutOrderAsCustomer objCheckout;
    Dotenv dotenv = Dotenv.load();
    String site;

    @Step("Start application.")
    @BeforeMethod
    public void setup() {
        String site = dotenv.get("TEST_SITE_URL");
        this.site = site;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.get(this.site);
    }

    @Step("Stop the application.")
    @AfterMethod
    public void close() {
        this.driver.close();
    }
}
