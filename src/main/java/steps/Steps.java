package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {
    private final WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    public Steps open(String url) {
        driver.get(url);
        return this;
    }

    public Steps click(By element) {
        driver.findElement(element).click();
        return this;
    }
    public String getText(By element) {
        String txt = driver.findElement(element).getText();
        return txt;
    }
    public Steps scroll(By element) {
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", (webElement));
        return this;
    }
    public Steps waitForLoadAnswers(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }
}
