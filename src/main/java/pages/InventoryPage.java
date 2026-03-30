package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class InventoryPage {

    WebDriver driver;
    WaitUtils wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    // Locators
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By pageTitle = By.className("title");

    // Actions
    public void addItemToCart() {
        wait.waitForClickable(addToCartBtn).click();
    }

    public void goToCart() {
        wait.waitForClickable(cartIcon).click();
    }

    public String getPageTitle() {
        return wait.waitForVisibility(pageTitle).getText();
    }
}