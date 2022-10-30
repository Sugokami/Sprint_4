package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderElements {
    private final By placeholderFirstName = By.xpath(".//div[2]/div[2]/div[1]/input");
    private final By placeholderSecondName = By.xpath(".//div[2]/input");
    private final By placeholderAddress = By.xpath(".//div[3]/input");
    private final By placeholderStation = By.xpath(".//div[2]/div[4]/div/div/input");
    private final By placeholderPhoneNumber = By.xpath(".//div[5]/input");
    private final By stationName = By.xpath(".//div[contains(text(),'бульвар')]");
    private final By nextButton = By.xpath(".//div/div[2]/div[3]/button");
    private final By placeholderWhen = By.xpath("//div[1]/div/input");
    private final By dropdownRentalPeriod = By.className("Dropdown-arrow");
    private final By dropdownRentalPeriodTwoDays = By.xpath(".//div[2]/div[2]/div[2]/div[2]/div[2]");
    private final By checkboxBlackPearlColour = By.xpath(".//div[3]/label[1]");
    private final By placeholderComment = By.xpath(".//div[2]/div[4]/input");
    private final By orderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private final By yesButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private final By orderIsDone = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    private WebDriver driver;

    public OrderElements(WebDriver driver) {

        this.driver = driver;
    }

    public void fillFirstPage(String firstName, String secondName, String address, String phoneNumber) {
        driver.findElement(placeholderFirstName).sendKeys(firstName);
        driver.findElement(placeholderSecondName).sendKeys(secondName);
        driver.findElement(placeholderAddress).sendKeys(address);
        driver.findElement(placeholderStation).click();
        driver.findElement(stationName).click();
        driver.findElement(placeholderPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }
    public void fillSecondPage(String date, String comment) {
       driver.findElement(placeholderWhen).sendKeys(date);
       driver.findElement(dropdownRentalPeriod).click();
       driver.findElement(dropdownRentalPeriodTwoDays).click();
       driver.findElement(checkboxBlackPearlColour).click();
       driver.findElement(placeholderComment).sendKeys(comment);
       driver.findElement(orderButton).click();

    }
    public void fillSecondPageOnlyRequiredFields(String date) {
        driver.findElement(placeholderWhen).sendKeys(date);
        driver.findElement(dropdownRentalPeriod).click();
        driver.findElement(dropdownRentalPeriodTwoDays).click();
        driver.findElement(orderButton).click();

    }
    public void waitForLoadAnswers() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(yesButton));
    }
    public void clickYesButton() {

        driver.findElement(yesButton).click();
    }

    public String getTextOrderIsDone(){
        return driver.findElement(orderIsDone).getText();
    }
}
