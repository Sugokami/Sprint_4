package PageObject;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";
     private WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public MainPage open() {
        driver.get(url);
        return this;
    }

}
