package com.test;

import com.drivers.ChromeDriverDirector;
import com.base.CheckoutOrderAsCustomer;
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
    ChromeDriverDirector driverOs;

    @Step("Start application.")
    @BeforeMethod
    public void setup() {
        this.site = dotenv.get("TEST_SITE_URL");
        this.driverOs = new ChromeDriverDirector(dotenv.get("MY_OS"));
        System.setProperty("webdriver.chrome.driver", this.driverOs.pick());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get(this.site);
    }

    @Step("Stop the application.")
    @AfterMethod
    public void close() {
        this.driver.close();
    }
}
