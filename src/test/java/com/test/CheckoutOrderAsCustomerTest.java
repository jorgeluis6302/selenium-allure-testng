package com.test;

import com.base.CheckoutOrderAsCustomer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class CheckoutOrderAsCustomerTest extends BaseTest {
    CheckoutOrderAsCustomer objCheckout;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority=0, description="Pre-checkout as Customer")
    @Description("Do pre-checkout as customer.")
    public void testPreCheckout() {
        String email = dotenv.get("TEST_USER_EMAIL");
        String pass = dotenv.get("TEST_USER_PASS");
        String relativeCheckoutUrl = "/checkout";
        Integer minimumPrice = 100;
        Integer maximumPrice = 600;
        objCheckout = new CheckoutOrderAsCustomer(driver, wait);
        objCheckout.login(email, pass);
        objCheckout.pickProduct(minimumPrice, maximumPrice);
        objCheckout.checkout(this.site, relativeCheckoutUrl);
    }
}
