package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void waitForNumberOfElements(By locator, int numberOfElements) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        } catch (TimeoutException ex) {
            Assert.fail("Колличество элементов на стртанице не соответсвует твоим ожидания");
        }
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}