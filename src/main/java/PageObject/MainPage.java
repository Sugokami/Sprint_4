package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By firstQuestionButton = By.xpath(".//div[@id='accordion__heading-0']");
    private final By firstQuestionAnswer = By.xpath(".//p[contains(text(),'Сутки')]");
    private final By secondQuestionButton = By.xpath(".//div[@id='accordion__heading-1']");
    private final By secondQuestionAnswer = By.xpath(".//p[contains(text(),'один заказ — один самокат')]");
    private final By thirdQuestionButton = By.xpath(".//div[@id='accordion__heading-2']");
    private final By thirdQuestionAnswer = By.xpath(".//p[contains(text(),'Отсчёт времени аренды')]");
    private final By topOrderButton = By.xpath(".//div[2]/button[1]");
    private final By bottomOrderButton = By.xpath(".//div[4]/div[2]/div[5]/button");

    private WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {

        driver.get(url);
    }

    public void scroll() {
        WebElement element = driver.findElement(firstQuestionButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForLoadAnswers() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(firstQuestionButton));
    }

    public void clickFirstQuestionButton() {
        driver.findElement(firstQuestionButton).click();
    }

    public String getTextFirstQuestionAnswer() {
        String text = driver.findElement(firstQuestionAnswer).getText();
        return text;
    }

    public void clickSecondQuestionButton() {

        driver.findElement(secondQuestionButton).click();
    }

    public String getTextSecondQuestionAnswer() {
        String text = driver.findElement(secondQuestionAnswer).getText();
        return text;
    }

    public void clickThirdQuestionButton() {

        driver.findElement(thirdQuestionButton).click();
    }

    public String getTextThirdQuestionAnswer() {
        return driver.findElement(thirdQuestionAnswer).getText();
    }
    public void clickTopCreateOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    public void clickBottomCreateOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}

