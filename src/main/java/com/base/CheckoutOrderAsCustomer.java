package com.base;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class CheckoutOrderAsCustomer {
    WebDriver driver;
    WebDriverWait wait;
    By email = By.id("email");
    By pass = By.id("pass");
    By click = By.id("send2");
    By link = By.cssSelector(".header.content .link.authorization-link a");

    public CheckoutOrderAsCustomer(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(this.pass).sendKeys(password);
    }

    public void submitLoginForm() {
        driver.findElement(this.click).click();
    }

    public void clickLoginLink() {
        driver.findElement(this.link).click();
    }

    @Step("Login given credentials.")
    public void login(String email, String password) {
        this.clickLoginLink();
        this.setEmail(email);
        this.setPassword(password);
        this.submitLoginForm();
        this.wait.until(
                ExpectedConditions.textMatches(
                        By.cssSelector(".header.content .logged-in"),
                        Pattern.compile(".*Hola*.")
                )
        );
    }

    @Step("Pick product from carrousel.")
    public void pickProduct(Integer minimumPrice, Integer maximumPrice) {
        String query = String
                .format("setTimeout(()=> { [...document.querySelectorAll(\".slick-active .price-wrapper\")].find(item => parseInt(item.innerText.split(\" \")[1]) >= %d && parseInt(item.innerText.split(\" \")[1]) <= %d).parentNode.parentNode.parentNode.parentNode.querySelector(\"button\").click(); }, 1500 );", minimumPrice, maximumPrice);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,870)");
        js.executeScript(query);
        this.wait.until(
                ExpectedConditions.textMatches(
                        By.className("message-success"),
                        Pattern.compile(".*carrito de compras.*")
                )
        );
    }

    @Step("Go checkout page.")
    public void checkout(String site, String relativeCheckoutUrl) {
        driver.get(site + relativeCheckoutUrl);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".opc-progress-bar-item._active")));
        assertThat(driver.getTitle()).contains("Realizar Pedido");
    }
}
