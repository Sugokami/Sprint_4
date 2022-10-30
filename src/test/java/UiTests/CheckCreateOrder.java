package UiTests;

import PageObject.BrowserRule;
import PageObject.MainPage;
import PageObject.OrderElements;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.StringContains.containsString;

public class CheckCreateOrder {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkCreateOrderTopButtonOrderAllFields() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.clickTopCreateOrderButton();
        OrderElements objOrderElements = new OrderElements(browserRule.getDriver());
        objOrderElements.fillFirstPage("Катя", "Катина", "Сретенка, 16", "+79031346126");
        objOrderElements.fillSecondPage("10.11.2022", "оставьте у двери");
        objOrderElements.waitForLoadAnswers();
        objOrderElements.clickYesButton();
        String expectedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(objOrderElements.getTextOrderIsDone(), containsString(expectedOrderText));

    }

    @Test
    public void checkCreateOrderBottomButtonOrderOnlyRequiredFields() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.scroll();
        mainPage.clickBottomCreateOrderButton();
        OrderElements objOrderElements = new OrderElements(browserRule.getDriver());
        objOrderElements.fillFirstPage("Иван", "Петров", "Открытое шоссе, 1", "89031346126");
        objOrderElements.fillSecondPageOnlyRequiredFields("10.12.2022");
        objOrderElements.waitForLoadAnswers();
        objOrderElements.clickYesButton();
        String expectedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(objOrderElements.getTextOrderIsDone(), containsString(expectedOrderText));

    }
}