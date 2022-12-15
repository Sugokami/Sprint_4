package UiTests;

import PageObject.BrowserRule;
import PageObject.MainPage;
import PageObject.OrderElements;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import steps.Steps;

import static org.hamcrest.core.StringContains.containsString;
@RunWith(Parameterized.class)
public class CheckCreateOrder {
    private final By orderButton;
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public CheckCreateOrder(By orderButton) {
        this.orderButton = orderButton;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderButtons() {
        return new Object[][]{
                {By.xpath(".//div[2]/button[1]")},
                {By.xpath(".//div[4]/div[2]/div[5]/button")},
        };
        }
    @Test
    public void checkCreateOrderTwoButtons() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        Steps steps = new Steps(browserRule.getDriver());
        steps.open(mainPage.getUrl());
        steps.scroll(orderButton);
        steps.click(orderButton);
        OrderElements objOrderElements = new OrderElements(browserRule.getDriver());
        objOrderElements.fillFirstPage("Катя", "Катина", "Сретенка, 16", "+79031346126");
        objOrderElements.fillSecondPage("10.11.2022", "оставьте у двери");
        steps.waitForLoadAnswers(objOrderElements.getYesButton());
        steps.click(objOrderElements.getYesButton());
        String expectedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(steps.getText(objOrderElements.getOrderIsDone()), containsString(expectedOrderText));

    }
}